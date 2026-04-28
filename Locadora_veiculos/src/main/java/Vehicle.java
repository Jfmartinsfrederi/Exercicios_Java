public abstract sealed class Vehicle implements Reportable permits Car,Motorcicle,Truck{
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract double calculateRentalPrice(int days);

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
