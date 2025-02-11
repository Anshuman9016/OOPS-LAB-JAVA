class Vehicle {
    protected String brand;
    protected String model;
    protected double price;

    public Vehicle(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: " + price);
    }
}

class Car extends Vehicle {
    protected int seatingCapacity;
    protected String fuelType;

    public Car(String brand, String model, double price, int seatingCapacity, String fuelType) {
        super(brand, model, price);
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Capacity: " + seatingCapacity + ", Fuel Type: " + fuelType);
    }
}

class ElectricCar extends Car {
    protected int batteryCapacity;
    protected double chargingTime;

    public ElectricCar(String brand, String model, double price, int seatingCapacity, String fuelType, int batteryCapacity, double chargingTime) {
        super(brand, model, price, seatingCapacity, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh, Charging Time: " + chargingTime + " hours");
    }
}

class Motorcycle extends Vehicle {
    protected int engineCapacity;
    protected String type;

    public Motorcycle(String brand, String model, double price, int engineCapacity, String type) {
        super(brand, model, price);
        this.engineCapacity = engineCapacity;
        this.type = type;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + "cc, Type: " + type);
    }
}

public class EXP5Q3 {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 30000, 5, "Petrol");
        ElectricCar electricCar = new ElectricCar("Tesla", "Model 3", 45000, 5, "Electric", 75, 8);
        Motorcycle motorcycle = new Motorcycle("Yamaha", "R15", 2000, 155, "Sport");
        
        System.out.println("Car Details:");
        car.displayDetails();
        
        System.out.println("\nElectric Car Details:");
        electricCar.displayDetails();
        
        System.out.println("\nMotorcycle Details:");
        motorcycle.displayDetails();
    }
}
