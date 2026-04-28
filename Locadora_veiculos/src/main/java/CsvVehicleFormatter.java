import java.util.StringJoiner;

public class CsvVehicleFormatter <T extends Reportable> implements Formatter <T>{
    @Override
    public String format(T[] elements) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (T element : elements) {
            final Reportable reportable= (Reportable) element;
            final String[] content=reportable.reportContent();
            stringJoiner.add(String.join(",",content));

        }
        return stringJoiner.toString();
    }
}
