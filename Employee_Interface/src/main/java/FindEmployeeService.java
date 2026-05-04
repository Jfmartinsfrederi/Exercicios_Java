public class FindEmployeeService {
    private Repository<Employee> repository; // TODO make it final

    public FindEmployeeService(Repository<Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id){
        //TODO validate id
        //TODO add any additional business rules here.
        return repository.findByID(id);
    }
}
