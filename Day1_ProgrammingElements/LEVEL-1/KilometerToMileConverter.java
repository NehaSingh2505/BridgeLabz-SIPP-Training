
public class KilometerToMileConverter {

    public static void main(String[] args) {
        double distanceInKilometers = 10.8;
        double conversionFactor = 1.6;

        double distanceInMiles = convertToMiles(distanceInKilometers, conversionFactor);

        System.out.println("The distance " + distanceInKilometers + " km in miles is " + distanceInMiles);
    }

    public static double convertToMiles(double kilometers, double factor) {
        return kilometers * factor;
    }
}
