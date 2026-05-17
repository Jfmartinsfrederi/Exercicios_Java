package service;

import model.Consultant;
import model.Employee;
import model.Reseller;
import persistence.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class EmployeeRegistrationService {
    private final Repository<String, Employee> repository;

    public EmployeeRegistrationService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(String id, String name, LocalDate birthDate,
                         double soldValue, String consultorId) {
        Objects.requireNonNull(id, "Id must be not null" + id);
        if (id.isBlank()) throw new IllegalArgumentException("Id must be not blank");
        if (soldValue < 0) throw new IllegalArgumentException("Sold value must not be negative");
        Objects.requireNonNull(birthDate);
        isValidString(name);
        Employee employee = new Reseller(id, name, birthDate, Math.abs(soldValue));
        repository.save(employee);
        if (consultorId != null) {
            List<Employee> list = repository.findById(consultorId);
            Employee promovido = list.getFirst();
            list.remove(promovido);
            if (!(promovido instanceof Consultant)) {
                Consultant consultor = new Consultant(promovido.getId(), promovido.getName(),
                        promovido.getBirthDate(), promovido.getSoldValue());
                for (Employee employeeAtualizarLista : list) {

                    consultor.addEmployee(employeeAtualizarLista);
                }

                consultor.addEmployee(employee);

                repository.update(consultor);


            } else {
                ((Consultant) promovido).addEmployee(employee);
                repository.update(promovido);
            }


        }


    }

    private void isValidString(String string) {
        Objects.requireNonNull(string, "Value must be not null");
        if (string.isBlank()) throw new IllegalArgumentException("Value must not be blank");

    }


}


