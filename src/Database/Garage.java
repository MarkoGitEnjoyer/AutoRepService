package Database;

import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Garage {
    private Protocol_Garage Protocol;
    private ArrayList<Vehicle> Vehicles;
    private ScheduledExecutorService exec;

    public Garage(Protocol_Garage Protocol,ArrayList<Vehicle>Vehicles){
        this.Protocol = Protocol;
        this.Vehicles = Vehicles;
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
