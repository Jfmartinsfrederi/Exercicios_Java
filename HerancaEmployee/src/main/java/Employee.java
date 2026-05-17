import java.time.LocalDate;

public sealed abstract class Employee permits FullTimeEmployee, PerHourEmployee {

    private String id;
    private String name;
    private String jobTitle;
    private LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {

        if (!isValidEmployee(id,name,jobTitle,dateOfEmployment)) {
            throw new IllegalArgumentException("Funcionário inválido");
        }

        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    private boolean isValidEmployee(String id, String name,
                                    String jobTitle, LocalDate dateOfEmployment) {
        return id != null && name != null && jobTitle != null && dateOfEmployment != null;
    }

    public abstract double getSalary();

    public String getId() { return id; }
    public String getName() { return name; }
}