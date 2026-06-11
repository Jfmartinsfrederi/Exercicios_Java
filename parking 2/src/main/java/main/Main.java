package main;

import customer.Customer;
import customer.RegisterCustomerService;
import persistence.CustomerDaoImpl;
import persistence.DatabaseBuilder;
import persistence.EntryTicketDtoImpl;
import persistence.PeriodCostDaoImpl;
import ticket.RegisterEntryService;
import ticket.RegisterExitService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseBuilder databaseBuilder = new DatabaseBuilder();
        databaseBuilder.createTables();
        databaseBuilder.populateDatabase();

        CustomerDaoImpl customerDaoImpl =new CustomerDaoImpl();
        EntryTicketDtoImpl entryTicketDtoImpl = new EntryTicketDtoImpl();
        PeriodCostDaoImpl periodCostDaoImpl= new PeriodCostDaoImpl();

        RegisterCustomerService registerCustomerService=new RegisterCustomerService(customerDaoImpl);
        RegisterEntryService registerEntryService=new RegisterEntryService(customerDaoImpl,
                entryTicketDtoImpl);
        RegisterExitService registerExitService=new RegisterExitService(customerDaoImpl,
                entryTicketDtoImpl,
                periodCostDaoImpl);

        System.out.println(registerExitService.register("POO0007"));

        System.out.println(registerExitService.register("POO0015"));

        registerCustomerService.register("123","123456", Customer.VehicleType.CAR);

        registerEntryService.register("123");

        System.out.println(registerExitService.register("123"));

        registerCustomerService.register(
                "ABC1234",
                "16999999999",
                Customer.VehicleType.MOTORCYCLE
        );

        System.out.println("Cliente cadastrado!");


        registerEntryService.register("ABC1234");

        System.out.println("Entrada registrada!");





        double fee = registerExitService.register("ABC1234");

        System.out.println("Saída registrada!");
        System.out.println("Valor pago: R$ " + fee);



    }
}
