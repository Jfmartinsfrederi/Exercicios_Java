public final class Motorcicle extends Vehicle {
    private double dailyRate;

    public Motorcicle(String brand, String model, double dailyRate) {
        super(brand, model);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return (days*dailyRate)*0.9;
    }

    @Override
    public String toString() {
         return """
                %s %s""".formatted(getBrand(),getModel());
    }
    public String[] reportContent() {
        return new String[]{getBrand(),getModel()};
    }
}
