package Database;

import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Truck;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DB {
    private HashMap<Integer, Queue<Vehicle>> vehicles;

    public DB() {
        vehicles = new HashMap<>();
        vehicles.put(1, new LinkedList<>());
        vehicles.put(2, new LinkedList<>());
        vehicles.put(3, new LinkedList<>());
    }

    public void build(int type, String model) {
        Vehicle vehicle = switch (type) {
            case 1 -> Motorcycle.create(model);
            case 2 -> Car.create(model);
            case 3 -> Truck.create(model);
            default -> null;
        };
        if (vehicle != null) {
            vehicles.get(type).offer(vehicle);
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    public HashMap<Integer,Queue<Vehicle>> getVehicles() {
        return vehicles;
    }
}
