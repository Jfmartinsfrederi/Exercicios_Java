package persistence;

import exception.EntityAlreadyExistsException;
import model.Consultant;
import model.Employee;

import java.util.*;

public class InMemoryEmployeeRepository implements Repository<String, Employee> {
    private final Map<String,Employee> repository= new TreeMap<>();


    @Override
    public void save(Employee e) {
        final String id=e.getId();
        if (repository.containsKey(id)) throw new EntityAlreadyExistsException("Employe already exists");
        repository.put(id,e);
    }

    @Override
    public void update(Employee e) {
        final String id=e.getId();
        isRegistredId(id);
        repository.replace(id,e);
    }

    private void isRegistredId(String id) {
        if (!repository.containsKey(id)) throw new NoSuchElementException("Employee not registered");
    }

    @Override
    public void remove(String id) {
        isRegistredId(id);
        repository.remove(id);

    }

    @Override
    public List<Employee> findById(String id) {
        Employee e = Optional.ofNullable(repository.get(id))
                .orElseThrow(() ->
                        new NoSuchElementException("Employee not registered"));

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