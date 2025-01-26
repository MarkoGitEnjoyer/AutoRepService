package Vehicles;

public class Truck extends Vehicle {


    public Truck(String name) {
        super(name);
    }

    @Override
    public void fixed() {
        System.out.println("Truck:"+name+" front windows were fixed");

    }

    @Override
    public int getRepairTime() {
        return 10;
    }
}
