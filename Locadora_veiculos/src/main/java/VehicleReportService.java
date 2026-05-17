public class VehicleReportService <T extends Reportable> {
    private Exporter exporter;
    private Formatter<T> vehicleFormatter;

    public VehicleReportService(Exporter exporter, Formatter<T> vehicleFormatter) {
        this.exporter = exporter;
        this.vehicleFormatter = vehicleFormatter;
    }
    public void createReport(T[] elements,String destination){
        final String formatted=vehicleFormatter.format(elements);
        exporter.export(formatted,destination);
    }
}
