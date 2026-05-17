import java.time.LocalDate;
import java.util.Objects;

public class HiringService {
    private final Repository<String,Employee> repository;

    public HiringService(Repository<String,Employee> repository) {
        this.repository = repository;
    }

    public void hire(String id, String name, String jobTitle,
                     LocalDate dateOfEmployment, double salary) {
        Objects.requireNonNull(dateOfEmployment,"Date of employment must be not null");

        isValidString(id,name,jobTitle);

        if (salary <= 0) throw new IllegalArgumentException(
                    "Salary must be greater than zero.");

        Employee e=new Employee(id, name, jobTitle, dateOfEmployment, salary);
        repository.save(e);
    }

    public void fire(String id) {
        isValidString(id);

        repository.remove(id);
    }

    private void isValidString(String... values){
        for (String value : values) {
            Objects.requireNonNull(value,"Value must be not null");
            if (value.isBlank()) throw new IllegalArgumentException("Value must be not blank");

        }


    }

}