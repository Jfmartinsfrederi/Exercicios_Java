package customer;

import dto.CustomerDto;

import java.util.Optional;

public interface CustomerDao {
    void save(CustomerDto customerDto);
    Optional<CustomerDto> findOne(String plate);

}
