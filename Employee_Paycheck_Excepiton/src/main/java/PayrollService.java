import java.time.LocalDate;
import java.util.Objects;

public class PayrollService {
    private final Company company;

    public PayrollService(Company company) {
        this.company = company;
    }

    public void pay(String id){
        Objects.requireNonNull(id,"id must be not null");
        Employee e = company.findEmployeeById(id);
        e.addPaycheck(LocalDate.now());
    }
}
