import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class SalaryService {
    private final Repository<String, Employee> repository;

    public SalaryService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void increaseSalary(String id, double salary) {
        Objects.requireNonNull(id, "id must be not null");
        if (id.isBlank()) throw new IllegalArgumentException("id must be not blank");
        Employee e = repository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Employee not found"));
        ;
        e.setSalary(salary);
    }

    public double averageSalary(String jobTitle) {
        Objects.requireNonNull(jobTitle);
        if (jobTitle.isBlank()) {
            throw new IllegalArgumentException("Job title must not be blank.");
        }
        return repository.getEmployees().values().stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .flatMap(e -> StreamSupport
                        .stream(Spliterators.spliteratorUnknownSize(e.iteratorPaycheck(),
                                        Spliterator.ORDERED),
                                false
                        )).mapToDouble(Paycheck::getSalary).average().orElse(0);


    }

    public double averageSalary(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);

        return repository.getEmployees().values().stream()
                .filter(e -> e.getDateOfEmployment().isAfter(start))
                .filter(e -> e.getDateOfEmployment().isBefore(end))
                .flatMap(e -> StreamSupport
                        .stream(Spliterators.spliteratorUnknownSize(e.iteratorPaycheck()
                                        , Spliterator.ORDERED)
                                , false
                        )).mapToDouble(Paycheck::getSalary).average().orElse(0);
    }


}
