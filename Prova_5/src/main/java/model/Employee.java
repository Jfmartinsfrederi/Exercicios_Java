package model;

import java.time.LocalDate;
import java.util.Objects;

//TODO everything fine here in domain.
public abstract sealed class Employee permits Reseller, Consultant {
    private final String id;
    private final String name;
    private final LocalDate birthDate;
    private final double soldValue;

    public Employee(String id, String name, LocalDate birthDate, double soldValue) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
    }

    public abstract double getCommission();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSoldValue() {
        return soldValue;
    }

    @Override
    public String toString() {
        return """
                [%s] %s | Birthday: %s | Amount in sales: US$%.2f | Commission: US$%.2f""".formatted(id, name, birthDate, soldValue, getCommission());
    }
}
