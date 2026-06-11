package service;

import exception.EntityNotFoundException;
import model.Employee;
import model.Paycheck;
import repository.RepositoryEmployees;
import repository.RepositoryPaychecks;

import java.time.LocalDate;
import java.util.Objects;

public class PayrollService {
    private final RepositoryPaychecks<String, Paycheck> repositoryPaychecks;
    private final RepositoryEmployees<String, Employee> repositoryEmployees;

    public PayrollService(RepositoryPaychecks<String, Paycheck> repositoryPaychecks,
                          RepositoryEmployees<String, Employee> repositoryEmployees) {
        this.repositoryPaychecks = repositoryPaychecks;
        this.repositoryEmployees =repositoryEmployees;
    }

    public void pay(String id){
        Objects.requireNonNull(id,"id must be not null");
        Employee e = repositoryEmployees.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Entity not found"));
        repositoryPaychecks.add(id,new Paycheck(LocalDate.now(),e.getSalary()));
    }
}
