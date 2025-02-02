import Database.DB;
import Database.Garage;
import Database.Protocol_Garage;
import Vehicles.Car;
import Vehicles.Motorcycle;
import Vehicles.Truck;
import Vehicles.Vehicle;

import java.util.Scanner;

public class MainScreen {
    private Scanner scanner = new Scanner(System.in);
    private DB manager = new DB();

    private static Protocol_Garage protocolGarage = new Protocol_Garage() {
        @Override
        public void fixed(Vehicle v) {
            v.fixed();
        }
    };

    public  void start() {
        while (true) {
            System.out.println("Please choose the type of vehicle:");
            System.out.println("(1) - Motorcycle\n(2) - Car\n(3) - Truck\n(-1) - Exit");

            int vehicleType = scanner.nextInt();
            if (vehicleType == -1) {
                break;
            }
            System.out.print("Enter the vehicle name: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            manager.build(vehicleType, name);
        }
        Garage g = new Garage(protocolGarage, manager.getVehicles());
        System.out.println("Starting to fix vehicles\n");
        g.start();
    }



}
