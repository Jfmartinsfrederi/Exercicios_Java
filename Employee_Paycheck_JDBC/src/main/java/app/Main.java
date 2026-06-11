package app;

import database.DatabaseInitializer;
import model.Employee;
import persistence.BancoEmployees;
import persistence.BancoPaychecks;
import repository.EmployeeRepository;
import service.EmployeeQueryService;
import service.HiringService;
import service.PayrollService;
import service.SalaryService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Repositório
        EmployeeRepository repository = new EmployeeRepository();
        BancoEmployees bancoEmployees = new BancoEmployees();
        BancoPaychecks bancoPaychecks=new BancoPaychecks();
        DatabaseInitializer.createTable();
        // Serviços
        HiringService hiringService = new HiringService(bancoEmployees);
        PayrollService payrollService = new PayrollService(bancoPaychecks,
                bancoEmployees);
        SalaryService salaryService = new SalaryService(bancoPaychecks,
                bancoEmployees);
        EmployeeQueryService queryService = new EmployeeQueryService(bancoEmployees);

        // Contratações
        hiringService.hire(
                "1",
                "João Silva",
                "Developer",
                LocalDate.of(2020, 1, 10),
                5000.00
        );

        hiringService.hire(
                "2",
                "Maria Souza",
                "Developer",
                LocalDate.of(2021, 3, 15),
                6500.00
        );

        hiringService.hire(
                "3",
                "Pedro Santos",
                "Manager",
                LocalDate.of(2018, 7, 1),
                12000.00
        );

        hiringService.hire(
                "4",
                "Ana Costa",
                "Developer",
                LocalDate.of(2022, 5, 20),
                5500.00
        );

        // Geração de holerites
        payrollService.pay("1");
        payrollService.pay("2");
        payrollService.pay("3");
        payrollService.pay("4");

        // Aumento salarial
        salaryService.increaseSalary("1", 5800.00);

        // Novo holerite após aumento
        payrollService.pay("1");

        // Listar funcionários por cargo
        System.out.println("=== Developers ===");
        for (Employee employee : queryService.getEmployees("Developer")) {
            System.out.println(employee.getId() + " - " + employee.getName()
                    + " - Salary: " + employee.getSalary());
        }

        // Média salarial dos holerites por cargo
        System.out.println("\n=== Average model.Paycheck Salary (Developer) ===");
        System.out.printf("US$ %.2f%n",
                salaryService.averageSalary("Developer"));

        // Média salarial dos holerites por período de contratação
        System.out.println("\n=== Average model.Paycheck Salary (Employees hired between 2019 and 2022) ===");
        System.out.printf("US$ %.2f%n",
                salaryService.averageSalary(
                        LocalDate.of(2019, 1, 1),
                        LocalDate.of(2022, 12, 31)
                ));

        // Tempo de serviço
        System.out.println("\n=== Years of Service ===");
        for (Employee employee : queryService.getEmployees("Developer")) {
            System.out.println(employee.getName() + ": "
                    + employee.getYearsOfService() + " years");
        }

        // Demissão
        hiringService.fire("4");

        // Listagem após demissão
        System.out.println("\n=== Developers After Firing Ana ===");
        for (Employee employee : queryService.getEmployees("Developer")) {
            System.out.println(employee.getId() + " - " + employee.getName());
        }

        // Buscar funcionário específico
        System.out.println("\n=== Find model.Employee 1 ===");
        bancoEmployees.findById("1")
                .ifPresent(System.out::println);

        hiringService.fire("1");

        hiringService.fire("1");

        hiringService.fire("2");

        hiringService.fire("3");

        hiringService.fire("4");


    }
}

