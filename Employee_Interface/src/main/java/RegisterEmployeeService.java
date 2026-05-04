public class RegisterEmployeeService {
    private Repository<Employee> repository; // TODO make it final


    public RegisterEmployeeService(Repository<Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee e) {
        //TODO validate id
        if (repository.findByID(e.getId()) != null) return;
        //TODO add any additional business rules here.
        repository.saveEntity(e);
    }
}
