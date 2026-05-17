import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee employee=new Employee("123","jjjj","jjjj",10, LocalDate.now().minusYears(7));
        FakeEmployeeRepository fakeEmployeeRepository= new FakeEmployeeRepository();
        RegisterEmployeeService registerEmployeeService= new RegisterEmployeeService(fakeEmployeeRepository);
        FindEmployeeService findEmployeeService= new FindEmployeeService(fakeEmployeeRepository);
        registerEmployeeService.register(employee);
        findEmployeeService.findById(employee.getId());
    }



}
