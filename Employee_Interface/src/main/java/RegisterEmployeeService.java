public class RegisterEmployeeService {
    private Repository<Employee> repository;


    public RegisterEmployeeService(Repository<Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee e){
        if (repository.findByID(e.getId())!=null) return;
        repository.saveEntity(e);
    }
}
