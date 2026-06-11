package repository;

import exception.EntityAlreadyExistsException;
import exception.EntityNotFoundException;
import model.Employee;

import java.util.*;

public class EmployeeRepository implements RepositoryEmployees<String,Employee> {
    private static final Map<String, Employee> employeeMap=new TreeMap<>();

    @Override
    public void save(Employee e) {
        String id= e.getId();
        if (employeeMap.containsKey(id)) throw new EntityAlreadyExistsException("model.Employee already exists");
        employeeMap.put(id,e);

    }

    @Override
    public void update(Employee e) {
        String id= e.getId();
        isRegistredId(id);
        employeeMap.replace(id,e);

    }

    private static void isRegistredId(String id) {
        if (!(employeeMap.containsKey(id))) throw new EntityNotFoundException("model.Employee is not registred");
    }

    @Override
    public void remove(String id) {
        isRegistredId(id);
        employeeMap.remove(id);

    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(employeeMap.get(id));
    }

    public Map<String,Employee> getEmployees(){
        return Collections.unmodifiableMap(employeeMap);
    }
}
