public class FindEmployeeService {
    private final Repository<Employee> repository;

    public FindEmployeeService(Repository<Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id){

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID inválido.");
        }


        return repository.findByID(id);
    }

}
