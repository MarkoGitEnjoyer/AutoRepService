package Database;

import Vehicles.Vehicle;

import java.util.ArrayList;

public class DB {
    private ArrayList<Vehicle> Vehicles;

    public DB()
    {
        Vehicles = new ArrayList<>();
    }
    public DB(ArrayList<Vehicle> vehicles) {
        Vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle)
    {
        Vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return Vehicles;
    }
}
