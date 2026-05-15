import java.time.LocalDate;
import java.util.Objects;

public class SalaryService {
    private final Company company;

    public SalaryService(Company company) {
        this.company = company;
    }

    public void increaseSalary(String id, double salary) {
        Objects.requireNonNull(id,"id must be not null");
        Employee e = company.findEmployeeById(id);
        e.setSalary(salary);
    }

    public double averageSalary(String jobTitle) {
        Objects.requireNonNull(jobTitle);
        if (jobTitle.isBlank()) {
            throw new IllegalArgumentException("Job title must not be blank.");
        }
        return company.getEmployees().stream()
                .filter(e->e.getJobTitle().equals(jobTitle))
                .mapToDouble( Employee::getSalary)
                .average()
                .orElse(0);
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);

        //TODO tá quase certo. Você considerou só o salário atual de cada, mas na verdade, tem que considerar todos os paychecks de todos os employees, pois eles podem ter sido promovidos (é aqui que entrar o flatMap)
        return company.getEmployees().stream()
                .filter(e ->
                        e.getDateOfEmployment().isAfter(start)
                                && e.getDateOfEmployment().isBefore(end)) // TODO quebrar esse filter em dois filters, para evitar o &&
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }


}
