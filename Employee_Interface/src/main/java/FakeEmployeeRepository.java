public class FakeEmployeeRepository implements Repository <Employee>{
    private Employee[] employees;
    private int numEmployes;

    public FakeEmployeeRepository() {
        this.employees = new Employee[100];
        this.numEmployes = 0;
    }

    @Override
    public void saveEntity(Employee entity) {
        employees[numEmployes++]= entity;
    }


    @Override
    public Employee findByID(String id) {
        for (int i = 0; i < numEmployes; i++) {
            Employee employee = employees[i];
            if (employee.getId().equals(id))
                return employee;
        }
        return null;
    }
}
