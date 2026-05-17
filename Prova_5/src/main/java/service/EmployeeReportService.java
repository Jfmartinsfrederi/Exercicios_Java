package service;

import model.Consultant;
import model.Employee;
import model.Reseller;
import persistence.Repository;

import java.util.*;


public class EmployeeReportService {
    private final Repository<String, Employee> repository;

    public EmployeeReportService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public String reportOf(String id) {
        Objects.requireNonNull(id, "Id must not be null");
        if (id.isBlank()) {
            throw new IllegalArgumentException("Id must not be blank");
        }

        StringBuilder sb = new StringBuilder();
        List<Employee> employeeList=repository.findById(id);
        Employee employee=employeeList.getFirst();
        append(employee,0,sb);

        return sb.toString();
    }

    private void append(Employee employee, int level, StringBuilder sb) {
        sb.append("\t".repeat(level));
        sb.append(employee).append("\n");

        if (employee instanceof Consultant consultant) {
            for (Employee subordinate : consultant.getEmployees()) {
                Employee realSubordinate=repository.findById(subordinate.getId()).getFirst();
                append(realSubordinate, level + 1, sb);
            }
        }
    }

}


