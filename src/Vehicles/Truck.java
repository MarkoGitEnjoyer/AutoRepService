package Vehicles;

public class Truck extends Vehicle {


    public Truck(String name) {
        super(name);
    }

    @Override
    public void fixed() {
        System.out.println("Truck:"+name+" front windows were fixed");

    }

    public static Truck create(String name) {
        return new Truck(name);
    }

    @Override
    public int getRepairTime() {
        return 10;
    }
}
