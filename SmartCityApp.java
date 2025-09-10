import java.time.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Single-file Java 8 demo that showcases:
 * - Lambdas & Method References
 * - Default & Static methods in interfaces
 * - Streams, forEach, Collectors (groupingBy, partitioningBy, summarizingDouble)
 * - Functional & Marker interfaces
 * - Easy extensibility for new transport services
 */
public class SmartCityApp {

    // ==========================
    //  Core Domain Models
    // ==========================
    enum ServiceType { BUS, METRO, TAXI, FERRY, AMBULANCE }

    static class Schedule {
        private final String routeId;
        private final String from;
        private final String to;
        private final LocalTime departure;
        private final double baseFare;
        private final boolean peak;

        public Schedule(String routeId, String from, String to, LocalTime departure, double baseFare, boolean peak) {
            this.routeId = routeId;
            this.from = from;
            this.to = to;
            this.departure = departure;
            this.baseFare = baseFare;
            this.peak = peak;
        }
        public String getRouteId() { return routeId; }
        public String getFrom() { return from; }
        public String getTo() { return to; }
        public LocalTime getDeparture() { return departure; }
        public double getBaseFare() { return baseFare; }
        public boolean isPeak() { return peak; }

        @Override public String toString() {
            return String.format("[%s %s→%s dep %s fare ₹%.2f %s]", routeId, from, to, departure, baseFare, peak?"PEAK":"OFF");
        }
    }

    static class PassengerTrip {
        final String passengerId;
        final String routeId;
        final String serviceName;
        final boolean peak;
        final double fareCollected;
        final double distanceKm;

        PassengerTrip(String passengerId, String routeId, String serviceName, boolean peak, double fareCollected, double distanceKm) {
            this.passengerId = passengerId;
            this.routeId = routeId;
            this.serviceName = serviceName;
            this.peak = peak;
            this.fareCollected = fareCollected;
            this.distanceKm = distanceKm;
        }
    }

    // ==========================
    //  Interfaces
    // ==========================

    /** Marker interface to denote services that can bypass traffic rules. */
    interface EmergencyService {}

    /**
     * Functional interface for fare calculation per trip.
     */
    @FunctionalInterface
    interface FareCalculator {
        double calculateFare(Schedule schedule, double distanceKm);
        default FareCalculator andThen(Function<Double, Double> after) {
            Objects.requireNonNull(after);
            return (s, d) -> after.apply(calculateFare(s, d));
        }
    }

    /** Geo utilities with static helpers. */
    interface GeoUtils {
        static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
            // Haversine (km)
            double R = 6371.0;
            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lon2 - lon1);
            double a = Math.sin(dLat/2)*Math.sin(dLat/2)
                    + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                    * Math.sin(dLon/2)*Math.sin(dLon/2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            return R * c;
        }
    }

    /** TransportService base interface */
    interface TransportService {
        String getName();
        ServiceType getType();
        List<Schedule> getLiveSchedules();
        FareCalculator getFareCalculator();

        default void printServiceDetails() {
            System.out.println("Service: " + getName() + " (" + getType() + ")");
            getLiveSchedules().forEach(System.out::println); // Method reference
        }

        /** Default utility to compute fare given schedule & distance */
        default double computeFare(Schedule s, double distanceKm) {
            return getFareCalculator().calculateFare(s, distanceKm);
        }

        /** Default: non-emergency */
        default boolean isEmergency() { return this instanceof EmergencyService; }

        /** Static helper to sort by earliest departure */
        static Comparator<Schedule> earliestDeparture() {
            return Comparator.comparing(Schedule::getDeparture); // Method reference
        }
    }

    // ==========================
    //  Service Implementations
    // ==========================

    static class BusService implements TransportService {
        private final String name;
        private final List<Schedule> schedules;
        private final FareCalculator fareCalc;
        BusService(String name, List<Schedule> schedules) {
            this.name = name;
            this.schedules = schedules;
            // Lambda: base fare + per-km * 2.5, peak +10%
            this.fareCalc = (s, d) -> {
                double fare = s.getBaseFare() + d * 2.5;
                return s.isPeak()? fare * 1.10 : fare;
            };
        }
        public String getName() { return name; }
        public ServiceType getType() { return ServiceType.BUS; }
        public List<Schedule> getLiveSchedules() { return schedules; }
        public FareCalculator getFareCalculator() { return fareCalc; }
    }

    static class MetroService implements TransportService {
        private final String name;
        private final List<Schedule> schedules;
        private final FareCalculator fareCalc;
        MetroService(String name, List<Schedule> schedules) {
            this.name = name;
            this.schedules = schedules;
            // Lambda: flat base + per-km * 1.5, off-peak -10%
            this.fareCalc = (s, d) -> {
                double fare = s.getBaseFare() + d * 1.5;
                return s.isPeak()? fare : fare * 0.90;
            };
        }
        public String getName() { return name; }
        public ServiceType getType() { return ServiceType.METRO; }
        public List<Schedule> getLiveSchedules() { return schedules; }
        public FareCalculator getFareCalculator() { return fareCalc; }
    }

    static class TaxiService implements TransportService {
        private final String name;
        private final List<Schedule> schedules;
        private final FareCalculator fareCalc;
        TaxiService(String name, List<Schedule> schedules) {
            this.name = name;
            this.schedules = schedules;
            // Lambda: base + 10 per-km, surge 20% at peak
            this.fareCalc = (s, d) -> {
                double fare = s.getBaseFare() + d * 10.0;
                return s.isPeak()? fare * 1.20 : fare;
            };
        }
        public String getName() { return name; }
        public ServiceType getType() { return ServiceType.TAXI; }
        public List<Schedule> getLiveSchedules() { return schedules; }
        public FareCalculator getFareCalculator() { return fareCalc; }
    }

    static class AmbulanceService implements TransportService, EmergencyService {
        private final String name;
        private final List<Schedule> schedules;
        AmbulanceService(String name, List<Schedule> schedules) {
            this.name = name;
            this.schedules = schedules;
        }
        public String getName() { return name; }
        public ServiceType getType() { return ServiceType.AMBULANCE; }
        public List<Schedule> getLiveSchedules() { return schedules; }
        public FareCalculator getFareCalculator() {
            // Not used for emergencies; return zero fare
            return (s, d) -> 0.0;
        }
        @Override public void printServiceDetails() {
            System.out.println("EMERGENCY PRIORITY → " + getName());
            TransportService.super.printServiceDetails();
        }
    }

    // Example of easy expansion: just implement the interface
    static class FerryService implements TransportService {
        private final String name;
        private final List<Schedule> schedules;
        FerryService(String name, List<Schedule> schedules) {
            this.name = name; this.schedules = schedules; }
        public String getName() { return name; }
        public ServiceType getType() { return ServiceType.FERRY; }
        public List<Schedule> getLiveSchedules() { return schedules; }
        public FareCalculator getFareCalculator() {
            // Lambda: base + per-km * 3.0
            return (s, d) -> s.getBaseFare() + d * 3.0;
        }
    }

    // ==========================
    //  Demo Data
    // ==========================
    static List<Schedule> sampleBus() {
        return Arrays.asList(
            new Schedule("B101", "Central", "TechPark", LocalTime.of(8,15), 10, true),
            new Schedule("B102", "Central", "Airport",  LocalTime.of(8,45), 12, true),
            new Schedule("B103", "Central", "Museum",   LocalTime.of(9, 5), 8,  false)
        );
    }
    static List<Schedule> sampleMetro() {
        return Arrays.asList(
            new Schedule("M201", "Central", "TechPark", LocalTime.of(8,10), 15, true),
            new Schedule("M202", "Central", "Airport",  LocalTime.of(8,30), 18, true),
            new Schedule("M203", "OldTown", "Central",  LocalTime.of(9, 0), 10, false)
        );
    }
    static List<Schedule> sampleTaxi() {
        return Arrays.asList(
            new Schedule("T301", "Central", "TechPark", LocalTime.of(8, 5), 30, true),
            new Schedule("T302", "Central", "Airport",  LocalTime.of(8,20), 35, true),
            new Schedule("T303", "Central", "Museum",   LocalTime.of(8,50), 25, false)
        );
    }
    static List<Schedule> sampleAmbulance() {
        return Arrays.asList(
            new Schedule("A401", "Hospital", "Airport", LocalTime.of(8, 0), 0, true)
        );
    }
    static List<Schedule> sampleFerry() {
        return Arrays.asList(
            new Schedule("F501", "Pier1", "Pier2", LocalTime.of(10, 0), 20, false)
        );
    }

    // ==========================
    //  Real-Time Flow Simulation
    // ==========================
    public static void main(String[] args) {
        // Register services
        List<TransportService> services = new ArrayList<>();
        services.add(new BusService("CityBus", sampleBus()));
        services.add(new MetroService("MetroLine", sampleMetro()));
        services.add(new TaxiService("GoTaxi", sampleTaxi()));
        services.add(new AmbulanceService("CityAmbulance", sampleAmbulance()));
        services.add(new FerryService("RiverFerry", sampleFerry())); // easy expansion

        // 1) Passenger books a trip → Lambda filters and sorts available services.
        String origin = "Central", destination = "Airport";
        double estimatedDistance = GeoUtils.calculateDistance(28.6139,77.2090,28.5562,77.1000); // Delhi CP→Airport approx

        Comparator<Schedule> byEarliest = TransportService.earliestDeparture();
        // Filtering by origin/destination and sorting by earliest departure then lowest fare
        List<Schedule> matching = services.stream()
            .flatMap(svc -> svc.getLiveSchedules().stream()
                .map(sc -> new AbstractMap.SimpleEntry<>(svc, sc)))
            .filter(e -> e.getValue().getFrom().equals(origin) && e.getValue().getTo().equals(destination))
            .sorted(Comparator
                .comparing((AbstractMap.SimpleEntry<TransportService, Schedule> e) -> e.getValue().getDeparture())
                .thenComparing(e -> e.getValue().getBaseFare()))
            .map(Map.Entry::getValue) // method ref alternative: Map.Entry::getValue
            .collect(Collectors.toList());

        System.out.println("\n== Best matches for trip Central → Airport ==");
        matching.forEach(System.out::println); // forEach + method ref

        // Pick the earliest schedule across services
        Optional<AbstractMap.SimpleEntry<TransportService, Schedule>> chosen = services.stream()
            .flatMap(svc -> svc.getLiveSchedules().stream().map(sc -> new AbstractMap.SimpleEntry<>(svc, sc)))
            .filter(e -> e.getValue().getFrom().equals(origin) && e.getValue().getTo().equals(destination))
            .min(Comparator.comparing((AbstractMap.SimpleEntry<TransportService, Schedule> e) -> e.getValue().getDeparture()));

        if (!chosen.isPresent()) {
            System.out.println("No matching services found.");
            return;
        }

        TransportService chosenService = chosen.get().getKey();
        Schedule chosenSchedule = chosen.get().getValue();
        double fare = chosenService.computeFare(chosenSchedule, estimatedDistance);
        System.out.println("\nBooked → " + chosenService.getName() + " " + chosenSchedule + ", computed fare ₹" + String.format("%.2f", fare));

        // 2) Dashboard updates live → ForEach displays current active services.
        System.out.println("\n== Live Dashboard ==");
        // Emergency services shown first
        services.stream()
            .sorted(Comparator.comparing((TransportService s) -> !s.isEmergency())) // emergency first
            .forEach(TransportService::printServiceDetails); // method ref to default method

        // Simulate trips for revenue report
        List<PassengerTrip> trips = new ArrayList<>();
        Random rnd = new Random(42);
        for (TransportService svc : services) {
            for (Schedule sc : svc.getLiveSchedules()) {
                double dist = 5 + rnd.nextInt(16); // 5-20 km
                double collected = svc.computeFare(sc, dist);
                trips.add(new PassengerTrip("P"+rnd.nextInt(1000), sc.getRouteId(), svc.getName(), sc.isPeak(), collected, dist));
            }
        }

        // 3) Revenue reports generated → Collectors group and summarize data.
        System.out.println("\n== Revenue by Route (groupingBy + summarizingDouble) ==");
        Map<String, DoubleSummaryStatistics> revenueByRoute = trips.stream()
            .collect(Collectors.groupingBy(t -> t.routeId, Collectors.summarizingDouble(t -> t.fareCollected)));
        revenueByRoute.forEach((route, stats) ->
            System.out.println(route + " → count=" + stats.getCount() + ", total=₹" + String.format("%.2f", stats.getSum()) +
                               ", avg=₹" + String.format("%.2f", stats.getAverage())));

        System.out.println("\n== Peak vs Non-Peak Revenue (partitioningBy) ==");
        Map<Boolean, Double> revenueByPeak = trips.stream()
            .collect(Collectors.partitioningBy(t -> t.peak, Collectors.summingDouble(t -> t.fareCollected)));
        System.out.println("PEAK: ₹" + String.format("%.2f", revenueByPeak.get(true)) +
                           ", OFF-PEAK: ₹" + String.format("%.2f", revenueByPeak.get(false)));

        System.out.println("\n== Top-used Routes (by trip count) ==");
        List<Map.Entry<String, Long>> topRoutes = trips.stream()
            .collect(Collectors.groupingBy(t -> t.routeId, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(5)
            .collect(Collectors.toList());
        topRoutes.forEach(e -> System.out.println(e.getKey() + " → trips=" + e.getValue()));

        // 4) System expansion is trivial — FerryService already added; demonstrate fare calc
        System.out.println("\n== Ferry Fare Example ==");
        TransportService ferry = services.stream().filter(s -> s.getType()==ServiceType.FERRY).findFirst().get();
        Schedule f = ferry.getLiveSchedules().get(0);
        double ferryFare = ferry.computeFare(f, 12.0);
        System.out.println(ferry.getName() + " " + f + ": fare for 12 km = ₹" + String.format("%.2f", ferryFare));

        // 5) Emergency scenario → detect and prioritize
        System.out.println("\n== Emergency Dispatch ==");
        List<TransportService> emergencies = services.stream()
            .filter(s -> s instanceof EmergencyService)
            .collect(Collectors.toList());
        if (emergencies.isEmpty()) System.out.println("No emergency services available.");
        else emergencies.forEach(TransportService::printServiceDetails);
    }
}