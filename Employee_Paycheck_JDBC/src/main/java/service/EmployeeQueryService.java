package service;

import model.Employee;
import repository.RepositoryEmployees;

import java.util.List;
import java.util.Objects;

public class EmployeeQueryService {
    private final RepositoryEmployees<String,Employee> repositoryEmployees;

    public EmployeeQueryService(RepositoryEmployees<String,Employee> repositoryEmployees) {
        this.repositoryEmployees = repositoryEmployees;
    }



    public List<Employee> getEmployees(String jobTitle){
        Objects.requireNonNull(jobTitle);
        if (jobTitle.isBlank()) {
            throw new IllegalArgumentException("Job title must not be blank.");
        }
        return repositoryEmployees.getEmployees().values().stream()
                .filter(e->e.getJobTitle().equals(jobTitle)).toList();

    }



}
