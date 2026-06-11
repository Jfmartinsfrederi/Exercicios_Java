package service;

import model.Employee;
import model.Paycheck;
import repository.RepositoryEmployees;
import repository.RepositoryPaychecks;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class SalaryService {
    private final RepositoryPaychecks<String, Paycheck> repositoryPaychecks;
    private final RepositoryEmployees<String, Employee> repositoryEmployees;

    public SalaryService(RepositoryPaychecks<String, Paycheck> repositoryPaychecks,
                         RepositoryEmployees<String, Employee> repositoryEmployees) {
        this.repositoryPaychecks = repositoryPaychecks;
        this.repositoryEmployees =repositoryEmployees;
    }

    public void increaseSalary(String id, double salary) {
        Objects.requireNonNull(id, "id must be not null");
        if (id.isBlank()) throw new IllegalArgumentException("id must be not blank");
        Employee e = repositoryEmployees.findById(id).orElseThrow(() ->
                new NoSuchElementException("model.Employee not found"));

        e.setSalary(salary);
        repositoryEmployees.update(e);
    }

    public double averageSalary(String jobTitle) {
        Objects.requireNonNull(jobTitle);
        if (jobTitle.isBlank()) {
            throw new IllegalArgumentException("Job title must not be blank.");
        }
        return repositoryEmployees.getEmployees().values().stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .flatMapToDouble(e -> repositoryPaychecks.getPaychecksByEmployee(e.getId())
                        .stream().mapToDouble(Paycheck::getSalary)).average().orElse(0);



    }

    public double averageSalary(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);

        return repositoryEmployees.getEmployees().values().stream()
                .filter(e -> e.getDateOfEmployment().isAfter(start))
                .filter(e -> e.getDateOfEmployment().isBefore(end))
                .flatMapToDouble(e -> repositoryPaychecks.getPaychecksByEmployee(e.getId())
                .stream().mapToDouble(Paycheck::getSalary)).average().orElse(0);
    }


}
