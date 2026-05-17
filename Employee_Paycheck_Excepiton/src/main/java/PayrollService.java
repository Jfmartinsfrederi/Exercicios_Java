import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class PayrollService {
    private final Repository<String,Employee> repository;

    public PayrollService(Repository<String,Employee> repository) {
        this.repository = repository;
    }

    public void pay(String id){
        Objects.requireNonNull(id,"id must be not null");
        Employee e = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Entity not found"));
       e.addPaycheck(LocalDate.now());
    }
}
