import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private LocalDate payday;
    private double salary;

    public Paycheck(LocalDate payday, double salary) {
        this.payday = payday;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paycheck)) return false;
        Paycheck that = (Paycheck) o;
        return Double.compare(that.salary, salary) == 0 &&
                payday.equals(that.payday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payday, salary);
    }
}
