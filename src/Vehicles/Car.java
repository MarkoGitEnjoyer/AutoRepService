package Vehicles;

public class Car extends Vehicle{
    public Car(String name) {
        super(name);
    }

    @Override
    public void fixed() {
        System.out.println("Car:"+name+" rear windows were fixed");
    }

    public static Car create(String name) {
        return new Car(name);
    }

    @Override
    public int getRepairTime() {
        return 5;
    }
}
