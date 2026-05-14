import java.time.LocalDate;
import java.util.Objects;

public class HiringService {
    private final Company company;

    public HiringService(Company company) {
        this.company = company;
    }

    public void hire(String id, String name, String jobTitle,
                     LocalDate dateOfEmployment, double salary) {

        Objects.requireNonNull(id, "Id must not be null.");
        Objects.requireNonNull(name, "Name must not be null.");
        Objects.requireNonNull(jobTitle, "Job title must not be null.");
        Objects.requireNonNull(dateOfEmployment,
                "Date of employment must not be null.");

        if (id.isBlank()) {
            throw new IllegalArgumentException("Id must not be blank.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }

        if (jobTitle.isBlank()) {
            throw new IllegalArgumentException(
                    "Job title must not be blank.");
        }

        if (salary <= 0) {
            throw new IllegalArgumentException(
                    "Salary must be greater than zero.");
        }

        company.hire(id, name, jobTitle, dateOfEmployment, salary);
    }

    public void fire(String id) {
        Objects.requireNonNull(id, "Id must not be null.");

        if (id.isBlank()) {
            throw new IllegalArgumentException("Id must not be blank.");
        }

        company.fire(id);
    }
}