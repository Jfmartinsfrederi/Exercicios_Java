package persistence;

import exception.EntityAlreadyExistsException;
import model.Consultant;
import model.Employee;

import java.util.*;

public class InMemoryEmployeeRepository implements Repository<String, Employee> {
    private final Map<String, Employee> repository = new TreeMap<>();

    @Override
    public void save(Employee e) {
        final String id = e.getId();
        if (repository.containsKey(id))
            throw new EntityAlreadyExistsException("Employe already exists");
        repository.put(id, e);
    }

    @Override
    public void update(Employee e) {
        final String id = e.getId();
        existId(id);
        repository.replace(id, e);
    }

    //TODO nome do método não bate com o que ele faz.
    private void existId(String id) {
        if (!repository.containsKey(id)) throw new NoSuchElementException("Employee not registered");
    }

    @Override
    public void remove(String id) {
        existId(id);
        repository.remove(id);
    }


    //TODO na verdade aqui você precisa remontar o objeto (procurar todos os filhos dele recursivamente).
    @Override
    public List<Employee> findById(String id) {
        Employee e = Optional.ofNullable(repository.get(id)).orElseThrow();

        List<Employee> employees = new ArrayList<>();
        employees.add(e);

        if (e instanceof Consultant) {
            List<Employee> reserva = new ArrayList<>(((Consultant) e).getEmployees());
            for (Employee r : reserva) {
                employees.addAll(this.findById(r.getId()));

            }
        }
        return employees;
    }
}
