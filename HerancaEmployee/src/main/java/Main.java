import java.time.LocalDate;

public class Main {
    static void main(String[] args) {
        Employee[] funcionarios = {
                new FullTimeEmployee("1","João","Dev", LocalDate.now(), 3000),
                new PerHourEmployee("2","Maria","Tester", LocalDate.now(), 50, 40)
        };

        for (Employee e : funcionarios) {
            System.out.println(e.getSalary()); // 🔥 funciona pra todos
        }
    }
}
