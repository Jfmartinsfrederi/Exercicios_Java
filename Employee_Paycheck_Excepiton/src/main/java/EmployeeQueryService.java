import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeQueryService {
    private final Company company;

    public EmployeeQueryService(Company company) {
        this.company = company;
    }



    public List<Employee> getEmployees(String jobTitle){
        Objects.requireNonNull(jobTitle);
        if (jobTitle.isBlank()) {
            throw new IllegalArgumentException("Job title must not be blank.");
        }
        return company.getEmployees().stream()
                .filter(e-> e.getJobTitle().equals(jobTitle))
                .toList();

    }



}
