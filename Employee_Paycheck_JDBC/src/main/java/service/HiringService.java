package service;

import model.Employee;
import repository.RepositoryEmployees;

import java.time.LocalDate;
import java.util.Objects;

public class HiringService {
    private final RepositoryEmployees<String, Employee> repositoryEmployees;

    public HiringService(RepositoryEmployees<String,Employee> repositoryEmployees) {
        this.repositoryEmployees = repositoryEmployees;
    }

    public void hire(String id, String name, String jobTitle,
                     LocalDate dateOfEmployment, double salary) {
        Objects.requireNonNull(dateOfEmployment,"Date of employment must be not null");

        isValidString(id,name,jobTitle);

        if (salary <= 0) throw new IllegalArgumentException(
                    "Salary must be greater than zero.");

        Employee e=new Employee(id, name, jobTitle, dateOfEmployment, salary);
        repositoryEmployees.save(e);
    }

    public void fire(String id) {
        isValidString(id);

        repositoryEmployees.remove(id);
    }

    private void isValidString(String... values){
        for (String value : values) {
            Objects.requireNonNull(value,"Value must be not null");
            if (value.isBlank()) throw new IllegalArgumentException("Value must be not blank");

        }


    }

}