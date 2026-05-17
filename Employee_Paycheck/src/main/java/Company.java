import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Company {
    private List<Employee> employeeList;

    public Company() {
        this.employeeList = new ArrayList<>();
    }

    public void hire(String id, String name, String jobTitle,
                     LocalDate dateOfEmployment,double salary){
        if (searchEmployee(id)!=-1) return;

        employeeList.add(new Employee(id,name,jobTitle,
                dateOfEmployment,salary));

    }
    public void fire(String id){
        int i=searchEmployee(id);
        if (i!=-1) employeeList.remove(i);
    }
    public void pay(String id){
        int i=searchEmployee(id);
        if (i!=-1) employeeList.get(i).addPaycheck(LocalDate.now());
    }
    public void increaseSalary(String id, double newSalary){
        int i=searchEmployee(id);
        if (i!=-1) employeeList.get(i).setSalary(newSalary);

    }
    public double averageSalary(String jobTitle){
        List <Employee> employees=getEmployees(jobTitle);
        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);

    }
    public double averageSalary(LocalDate start, LocalDate end){
        List<Employee> employeeStream = employeeList
                .stream().filter(e ->
                        e.getDateOfEmployment().isAfter(start) && e.getDateOfEmployment().isBefore(end)).toList();
        return employeeStream.stream().mapToDouble(Employee::getSalary).average().orElse(0);

    }

    private int searchEmployee(String id){
        for (int i = 0; i < employeeList.size(); i++) {
             if (employeeList.get(i).getId().equals(id)) return i;

        }
        return -1;

    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeList);
    }

    public List<Employee> getEmployees(String jobTitle) {
        return employeeList.stream().filter(e->e.getJobTitle().equals(jobTitle)).toList();
    }

}
