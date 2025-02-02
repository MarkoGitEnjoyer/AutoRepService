package Database;

import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Garage {
    private Protocol_Garage Protocol;
    private ArrayList<Vehicle> Vehicles;


    public Garage(Protocol_Garage Protocol, HashMap<Integer, Queue<Vehicle>> Vehicles){
        this.Protocol = Protocol;
        this.Vehicles = new ArrayList<Vehicle>();
        for (HashMap.Entry<Integer, Queue<Vehicle>> entry : Vehicles.entrySet()) {
            Queue<Vehicle> queue = entry.getValue();
            for (Vehicle vehicle : queue) {
                this.Vehicles.add(vehicle);
            }
        }
    }
    public void start() {
        if (Vehicles.isEmpty()) {
            System.out.println("No vehicles to process.");
            return;
        }

        int index = 0;
        while (index < Vehicles.size()) {
            Vehicle currentVehicle = Vehicles.get(index);
            System.out.println(currentVehicle.getName() + " is now being fixed");

            try {
                Thread.sleep(1000);
                for (int time = currentVehicle.getRepairTime(); time > 0; time--) {
                    System.out.println("Time remaining: " + time + " seconds");
                    Thread.sleep(1000);
                }
                Protocol.fixed(currentVehicle);
                index++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("All vehicles processed.");
    }

}
