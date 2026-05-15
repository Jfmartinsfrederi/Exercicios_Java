import java.time.LocalDate;
import java.util.*;

//TODO se for utilizar os services, não precisa do Company mais.
//TODO defina uma interface EmployeeRepository e uma classe FakeEmployeeRepository (que vai guardar as coisas num map estático)
public class Company {

    private final Map<String, Employee> employeeMap;

    public Company() {
        this.employeeMap = new TreeMap<>();
    }

    public void hire(String id, String name, String jobTitle,
                    LocalDate dateOfEmployment, double salary) {

        Objects.requireNonNull(id, "Id must not be null.");

        if (employeeMap.containsKey(id)) {
            throw new EntityAlreadyExistsException(
                    "Employee is already registered.");
        }

        employeeMap.put(id,
                new Employee(id, name, jobTitle,
                        dateOfEmployment, salary));
    }

    public void fire(String id) {
        findEmployeeById(id);
        employeeMap.remove(id);
    }

    public Employee findEmployeeById(String id) {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            throw new EntityNotFoundException("Employee is not registered.");
        }
        return employee;
    }

    public boolean containsEmployee(String id) {
        return employeeMap.containsKey(id);
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }




}


