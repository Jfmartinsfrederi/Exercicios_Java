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

    public void register(String id, String name, LocalDate birthDate, double soldValue, String consultorId) {
        Objects.requireNonNull(id, "Id must be not null" + id);

        if (id.isBlank()) throw new IllegalArgumentException("Id must be not blank");

        //TODO credo!
        for (Object obj : new Object[]{name, birthDate}) {
            Objects.requireNonNull(obj, "Valor não pode ser nulo" + obj);
        }

        Employee employee = new Reseller(id, name, birthDate, soldValue);
        repository.save(employee);

        if (consultorId != null) {
            List<Employee> list = repository.findById(consultorId);
            Employee promovido = list.getFirst();
            list.remove(promovido); // TODO aqui ainda não dá para saber se precisa promover

            if (!(promovido instanceof Consultant)) {

                //TODO mais bonito criar uma sobrecarga de construtor em Consultant que receba um Reseller
                Consultant consultor = new Consultant(promovido.getId(), promovido.getName(),
                        promovido.getBirthDate(), promovido.getSoldValue());

                //TODO não entendi para que esse for.
                for (Employee employee1 : list) {
                    consultor.addEmployee(employee1);
                }

                consultor.addEmployee(employee);

                //TODO se você removeu lá em cima, aqui é create, certo?
                repository.update(consultor);


            }
            else {
                //TODO dá para melhorar o código para não precisar colocar isso em um else.
                ((Consultant) promovido).addEmployee(employee);
                repository.update(promovido);
            }


        }


    }


}


