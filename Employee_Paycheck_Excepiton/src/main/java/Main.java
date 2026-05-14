import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        HiringService hiringService = new HiringService(company);
        PayrollService payrollService = new PayrollService(company);
        SalaryService salaryService = new SalaryService(company);
        EmployeeQueryService queryService = new EmployeeQueryService(company);

        // Contratando funcionários
        hiringService.hire(
                "1",
                "João",
                "Developer",
                LocalDate.of(2023, 1, 10),
                5000.0
        );

        hiringService.hire(
                "2",
                "Maria",
                "Developer",
                LocalDate.of(2022, 6, 15),
                6500.0
        );

        hiringService.hire(
                "3",
                "Carlos",
                "Manager",
                LocalDate.of(2021, 3, 20),
                9000.0
        );

        // Registrando pagamentos
        payrollService.pay("1");
        payrollService.pay("2");
        payrollService.pay("3");

        // Aumentando salário
        salaryService.increaseSalary("1", 7000.0);

        // Listando todos os funcionários
        System.out.println("Todos os funcionários:");
        System.out.println(company.getEmployees());

        // Listando funcionários por cargo
        System.out.println("\nDevelopers:");
        System.out.println(queryService.getEmployees("Developer"));

        // Média salarial por cargo
        System.out.println("\nMédia salarial dos Developers:");
        System.out.println(salaryService.averageSalary("Developer"));

        // Média salarial por período de contratação
        System.out.println("\nMédia salarial entre 2022 e 2024:");
        System.out.println(
                salaryService.averageSalary(
                        LocalDate.of(2022, 1, 1),
                        LocalDate.of(2024, 12, 31)
                )
        );

        // Tempo de serviço do funcionário 1
        Employee employee = company.findEmployeeById("1");
        System.out.println("\nAnos de serviço de João:");
        System.out.println(employee.getYearsOfService());

        // Demitindo um funcionário
        hiringService.fire("3");

        // Lista final
        System.out.println("\nFuncionários após demissão:");
        System.out.println(company.getEmployees());
    }
}