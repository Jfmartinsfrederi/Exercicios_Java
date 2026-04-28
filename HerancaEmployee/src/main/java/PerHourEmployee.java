import java.time.LocalDate;

public final class PerHourEmployee extends Employee {

    private double hourlyRate;
    private int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle,
                           LocalDate dateOfEmployment, double hourlyRate, int workedHour) {

        super(id, name, jobTitle, dateOfEmployment);

        if (hourlyRate <= 0 || workedHour <= 0) {
            throw new IllegalArgumentException("Dados inválidos");
        }

        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double getSalary() {
        return hourlyRate * workedHour;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate>0) this.hourlyRate = hourlyRate;
    }

    public void setWorkedHour(int workedHour) {
        if (workedHour>0) this.workedHour = workedHour;
    }
}