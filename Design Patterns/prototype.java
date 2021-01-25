  
import java.util.Hashtable;
abstract class Vehicle implements Cloneable {
    private Integer vehicleId;
    private String type;

    abstract void printInfo();

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
class Bike extends Vehicle{
    public Bike(){
        setVehicleId(1);
        setType("Bike");
    }
    @Override
    void printInfo() {
        System.out.println("This is a Bike!");
    }
}
class Truck extends Vehicle{
    public Truck(){
        setVehicleId(2);
        setType("Truck");
    }
    @Override
    void printInfo() {
        System.out.println("This is a Truck!");
    }
}
class prototype {
    private static Hashtable<Integer, Vehicle> vehicleHashtable = new Hashtable<>();

    public static Vehicle getVehicle(Integer vehicleId){
        Vehicle vehicle = vehicleHashtable.get(vehicleId);
        return (Vehicle) vehicle.clone();
    }

    public static void loadCache(){
        Bike bike = new Bike();
        Truck truck = new Truck();

        vehicleHashtable.put(bike.getVehicleId(), bike);
        vehicleHashtable.put(truck.getVehicleId(), truck);
    }

    public static void main(String[] args) {
        loadCache();

        Vehicle clonedBike =  getVehicle(1);
        Vehicle clonedTruck =  getVehicle(2);

        System.out.println("Cloned vehicle type: " + clonedBike.getType());
        System.out.println("Cloned vehicle type: " + clonedTruck.getType());
    }
}
