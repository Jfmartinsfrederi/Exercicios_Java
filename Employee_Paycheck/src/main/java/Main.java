import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Company company=new Company();
        company.hire("1","1","pedra", LocalDate.now(),10);
        company.hire("2","1","pedra", LocalDate.now(),50);
        company.hire("3","1","fogo", LocalDate.now().minusYears(5),100);
        System.out.println(company.getEmployees());
        System.out.println(company.getEmployees("pedra"));
        company.fire("2");
        System.out.println(company.getEmployees());
        System.out.println(company.averageSalary("fogo"));
        System.out.println(company.averageSalary(LocalDate.now().minusDays(10),LocalDate.now().plusDays(10)));
        company.pay("1");
        company.increaseSalary("1",200);
        System.out.println(company.averageSalary("pedra"));
        System.out.println(company.averageSalary(LocalDate.now().minusDays(1000000),LocalDate.now().plusDays(10)));





    }
}
