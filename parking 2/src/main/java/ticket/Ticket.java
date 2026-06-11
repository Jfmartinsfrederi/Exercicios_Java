package ticket;

import customer.Customer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class Ticket {
    private UUID uuid;
    private Customer customer;
    private LocalDateTime entry;
    private LocalDateTime exit;

    public Ticket(Customer customer) {
        this.uuid= UUID.randomUUID();
        this.customer = customer;
        this.entry=LocalDateTime.now().minusHours(40).minusMinutes(30);
    }

    public Ticket(UUID uuid, Customer customer, LocalDateTime entry) {
        this.uuid = uuid;
        this.customer = customer;
        this.entry = entry;
    }

    public void exit(){
        this.exit=LocalDateTime.now();
    }

    public int parkingDuration(){
        Objects.requireNonNull(exit,"Car must be exit for calculate");
        return (int) Math.ceil(Duration.between(entry,exit).toMinutes()/60.0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(uuid, ticket.uuid)
                && Objects.equals(customer, ticket.customer)
                && Objects.equals(entry, ticket.entry)
                && Objects.equals(exit, ticket.exit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, customer, entry, exit);
    }

    @Override
    public String toString() {
        return """
                UUID: %s
                %s
                %s | %s
                """.formatted(uuid,customer,
                entry.toString(),exit.toString());
    }

    public UUID getUuid() {
        return uuid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getEntry() {
        return entry;
    }

    public LocalDateTime getExit() {
        return exit;
    }
}
