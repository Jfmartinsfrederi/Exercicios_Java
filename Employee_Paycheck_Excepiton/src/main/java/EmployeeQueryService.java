import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeQueryService {
    private final Repository<String,Employee> repository;

    public EmployeeQueryService(Repository<String,Employee> repository) {
        this.repository = repository;
    }



    public List<Employee> getEmployees(String jobTitle){
        Objects.requireNonNull(jobTitle);
        if (jobTitle.isBlank()) {
            throw new IllegalArgumentException("Job title must not be blank.");
        }
        return repository.getEmployees().values().stream()
                .filter(e->e.getJobTitle().equals(jobTitle)).toList();

    }



}
