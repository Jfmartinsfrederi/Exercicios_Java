import persistence.InMemoryEmployeeRepository;
import service.EmployeeRegistrationService;
import service.EmployeeReportService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        InMemoryEmployeeRepository inMemoryEmployeeRepository = new InMemoryEmployeeRepository();
        EmployeeRegistrationService employeeRegistration = new EmployeeRegistrationService(inMemoryEmployeeRepository);
        EmployeeReportService employeeReport = new EmployeeReportService(inMemoryEmployeeRepository);
        // Ordem exemplo
        employeeRegistration.register(
                "12312312312",
                "David A. Huffman",
                LocalDate.parse("1925-08-09"),
                7000.0,
                null
        );

        employeeRegistration.register(
                "21321321313",
                "Edsger Wybe Dijkstra",
                LocalDate.parse("1930-05-11"),
                1520.0,
                "12312312312"
        );

        employeeRegistration.register(
                "54654654654",
                "Grace Murray Hopper",
                LocalDate.parse("1906-12-09"),
                432.0,
                "21321321313"
        );

        employeeRegistration.register(
                "32132132131",
                "Augusta Ada Byron",
                LocalDate.parse("1852-11-27"),
                3000.0,
                "12312312312"
        );

        employeeRegistration.register(
                "45645645646",
                "Alan Mathison Turing",
                LocalDate.parse("1912-06-23"),
                780.0,
                "32132132131"
        );

        employeeRegistration.register(
                "65465465464",
                "John von Neumann",
                LocalDate.parse("1903-12-28"),
                300.00,
                "45645645646"
        );

        employeeRegistration.register(
                "90219021902",
                "Donald Ervin Knuth",
                LocalDate.parse("1938-01-10"),
                432.0,
                "45645645646"
        );


        System.out.println(employeeReport.reportOf("12312312312"));

        System.out.println(employeeReport.reportOf("32132132131"));

    }
}
/* Ordem começo
employeeRegistration.register(
                "12312312312",
                "David A. Huffman",
                LocalDate.parse("1925-08-09"),
                7000.0,
                null
        );

        employeeRegistration.register(
                "32132132131",
                "Augusta Ada Byron",
                LocalDate.parse("1852-11-27"),
                3000.0,
                "12312312312"
        );

        employeeRegistration.register(
                "21321321313",
                "Edsger Wybe Dijkstra",
                LocalDate.parse("1930-05-11"),
                1520.0,
                "12312312312"
        );

        employeeRegistration.register(
                "45645645646",
                "Alan Mathison Turing",
                LocalDate.parse("1912-06-23"),
                780.0,
                "32132132131"
        );

        employeeRegistration.register(
                "90219021902",
                "Donald Ervin Knuth",
                LocalDate.parse("1938-01-10"),
                432.0,
                "45645645646"
        );

        employeeRegistration.register(
                "54654654654",
                "Grace Murray Hopper",
                LocalDate.parse("1906-12-09"),
                432.0,
                "21321321313"
        );

        employeeRegistration.register(
                "65465465464",
                "John von Neumann",
                LocalDate.parse("1903-12-28"),
                300.00,
                "45645645646"
        );*/