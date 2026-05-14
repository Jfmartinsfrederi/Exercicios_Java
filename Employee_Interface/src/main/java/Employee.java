import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee {
    private final String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployement;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployement) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployement = dateOfEmployement;
    }

    public double getYearsOfService(){
        return  Period.between(dateOfEmployement,LocalDate.now()).getYears();

    }

    public double calculateBonus() {
        double bonusPercentage = 0.05;
        if (getYearsOfService() >= 5)
            bonusPercentage += 0.1;
        return salary * bonusPercentage;
    }


    public String getId() {
        return id;
    }

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
}
