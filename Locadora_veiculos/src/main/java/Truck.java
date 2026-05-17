public final class Truck extends Vehicle implements InsuranceService {
    private double dailyRate;

    public Truck(String brand, String model, double dailyRate) {
        super(brand, model);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalPrice(int days) {
        return (days*dailyRate)+50;
    }

    @Override
    public double calculaeInsurance() {
        return 150;
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
