import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;
    private List<Paycheck> paycheckList;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double salary) {

        if (!isValidEmployee(id, name, jobTitle, dateOfEmployment, salary)) {
            throw new IllegalArgumentException("Funcionário inválido");
        }

        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
        this.salary = salary;
        this.paycheckList = new ArrayList<>();
    }
    private boolean isValidEmployee(String id, String name,
                                    String jobTitle, LocalDate dateOfEmployment, double salary) {
        return id != null && name != null && jobTitle != null && dateOfEmployment != null && salary > 0;
    }

    public double getYearsOfService() {
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public void addPaycheck(LocalDate payday) {
        paycheckList.add(new Paycheck(payday, salary));

    }

    public void removePaycheck(Paycheck paycheck) {
        paycheckList.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaycheck() {
        return paycheckList.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return name;
    }


    public void setSalary(double salary) {

        if (salary < this.salary) throw new IllegalArgumentException("We don't reduce salaries");
        else this.salary = salary;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }




}
    

