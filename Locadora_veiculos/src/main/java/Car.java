public final class Car extends Vehicle implements Reportable{
    private double dailyRate;

    public Car(String brand, String model, double dailyRate) {
        super(brand, model);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return days*dailyRate;
    }

    @Override
    public String toString() {
        return """
                %s %s""".formatted(getBrand(),getModel());
    }

    @Override
    public String[] reportContent() {
        return new String[]{getBrand(),getModel()};
    }
}
