public class FindEmployeeService {
    private Repository<Employee> repository;

    public FindEmployeeService(Repository<Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id){
        return repository.findByID(id);
    }
}
