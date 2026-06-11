package customer;

import dto.CustomerDto;
import exception.EntityAlreadyExistsException;

import java.util.NoSuchElementException;
import java.util.Objects;

public class RegisterCustomerService {
    private final CustomerDao repo;

    public RegisterCustomerService(CustomerDao repo) {
        this.repo = repo;
    }

    public void register(String plate, String phone, Customer.VehicleType type){
        Objects.requireNonNull(plate,"Plate must be not null");
        Objects.requireNonNull(phone,"Phone must be not null");
        Objects.requireNonNull(type,"Vehicle type must be not null");
        if (plate.isBlank()) throw new IllegalArgumentException("Plate must be not blank");
        if (phone.isBlank()) throw new IllegalArgumentException("Phone must be not blank");
        if (repo.findOne(plate).isPresent())
            throw new EntityAlreadyExistsException("Customer já cadastrado");

        repo.save(new CustomerDto(plate,phone,type.name()));

    }

}
