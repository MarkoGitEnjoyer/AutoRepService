package Vehicles;

public class Motorcycle extends Vehicle{
    public Motorcycle(String name) {
        super(name);
    }

    @Override
    public void fixed() {
        System.out.println("Motorcycle:"+name+" wheels were fixed");
    }

    public static Motorcycle create(String name) {
        return new Motorcycle(name);
    }

    @Override
    public int getRepairTime() {
        return 3;
    }
}
