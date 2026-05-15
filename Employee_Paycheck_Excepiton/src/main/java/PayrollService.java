import java.time.LocalDate;
import java.util.Objects;

public class PayrollService {

    //TODO aqui você faz a inversão de dependência para EmployeeRepository, ao invés de Company.
    private final Company company;

    public PayrollService(Company company) {
        this.company = company;
    }

    public void pay(String id){
        Objects.requireNonNull(id,"id must be not null");
        Employee e = company.findEmployeeById(id);  //TODO o repo poderia retornar Optional<Employee>
        e.addPaycheck(LocalDate.now()); //TODO e se ele não encontrar, você toma um nullpointer aqui. É nesse caso que entra o Optional, que evita a chamada direta a um potencial null.
    }
}
