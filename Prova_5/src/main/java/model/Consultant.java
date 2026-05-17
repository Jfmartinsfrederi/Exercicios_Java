package model;

import exception.EntityAlreadyExistsException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> employees;

    public Consultant(String id, String name, LocalDate birthDate, double soldValue) {
        super(id, name, birthDate, soldValue);
        this.employees = new LinkedHashSet<>();
    }

    public void addEmployee(Employee e) {
        if (employees.contains(e)) throw new EntityAlreadyExistsException("Entity already exisists");
        employees.add(e);


    }


    @Override
    public double getCommission() {
        return getSoldValue() * 0.15 + employees.stream()
                .mapToDouble(Employee::getCommission).sum() * 0.3;


    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);


    }

}
