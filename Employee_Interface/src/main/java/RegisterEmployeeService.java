public class RegisterEmployeeService {
    private final Repository<Employee> repository;


    public RegisterEmployeeService(Repository<Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee e){
        if (e == null) throw new IllegalArgumentException("Employee não pode ser nulo.");
        if (e.getId() == null || e.getId().isBlank()) {
            throw new IllegalArgumentException("ID inválido.");
        }
        if (repository.findByID(e.getId())!=null) return;
        repository.saveEntity(e);
    }
}
