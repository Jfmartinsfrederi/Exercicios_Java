public class Main {
    public static void main(String[] args) {
        Vehicle[] fleet= new Vehicle[30];
        String car,truck,motorcicle;
        for (int i = 0; i < 30; i+=3) {
            car="Car"+i;
            fleet[i]=new Car("Car",car,100*(i+1));
            motorcicle="Motorcicle"+(i+1);
            fleet[i+1]=new Motorcicle("Motorcicle",motorcicle,100*(i+1));
            truck="Truck"+(i+2);
            fleet[i+2]=new Truck("Truck",truck,100*(i+1));

        }
        double sum=0;
        for (Vehicle vehicle : fleet) {

            System.out.printf("""
                    %s - Rental:%.2f
                    """,vehicle,vehicle.calculateRentalPrice(5));

            if (vehicle instanceof InsuranceService) System.out.printf("Insurance: %.2f\n",((InsuranceService) vehicle).calculaeInsurance());
            sum+= vehicle.calculateRentalPrice(5);

        }
        System.out.println(sum);
        Formatter <Vehicle> formatter= new CsvVehicleFormatter<>();
        Exporter exporter=new ConsoleExporter();
        VehicleReportService vehicleReportService=new VehicleReportService<>(exporter,formatter);
        vehicleReportService.createReport(fleet,null);


    }
}
