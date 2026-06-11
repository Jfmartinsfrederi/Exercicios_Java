package customer;

import java.util.Objects;

public class Customer {
    private final String plate;
    private String phone;
    public enum VehicleType {CAR,MOTORCYCLE}
    private VehicleType type;

    public Customer(String plate, String phone, VehicleType type) {
        this.plate = plate;
        this.phone = phone;
        this.type = type;
    }

    public static VehicleType transformEnum (String type){
        if (type.equals("CAR")) return VehicleType.CAR;
        if (type.equals("MOTORCYCLE")) return VehicleType.MOTORCYCLE;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(plate, customer.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plate);
    }

    @Override
    public String toString() {
        return """
                %s | %s | %s
                """.formatted(plate,phone,type);
    }

    public String getPlate() {
        return plate;
    }

    public String getPhone() {
        return phone;
    }

    public VehicleType getType() {
        return type;
    }
}
