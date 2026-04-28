import java.time.LocalDate;

public final class FullTimeEmployee extends Employee {

    private double monthSalary;

    public FullTimeEmployee(String id, String name,
                            String jobTitle, LocalDate dateOfEmployment, double monthSalary) {
        super(id, name, jobTitle, dateOfEmployment);

        if (monthSalary <= 0) {
            throw new IllegalArgumentException("Salário inválido");
        }

        this.monthSalary = monthSalary;
    }

    @Override
    public double getSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double salary){
        if (salary>0) monthSalary=salary;

    }

}