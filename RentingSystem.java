// abstract class 
public abstract class RentingSystem{
    //properties or variables for the abstract class 
    protected String vehicleNumber;
    protected String model;
    protected double baseRate;
//constructor 
    public RentingSystem(String vehicleNumber, String model, double baseRate) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.baseRate = baseRate;
    }
    //used getters and setters to access the variables and modify them
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public String getModel(){
        return model;

    }
    public double getBaseRate(){
        return baseRate;
    }
    public String setVehicleNumber(String vehicleNumber){
        this.vehicleNumber=vehicleNumber;
        return vehicleNumber;
    }
    public String setModel(String model){
        this.model=model;
        return model;
    }
    public double setBaseRate(double baseRate){
        this.baseRate=baseRate;
        return baseRate;
    }

}
