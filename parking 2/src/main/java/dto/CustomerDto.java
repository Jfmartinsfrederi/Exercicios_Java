package dto;

import customer.Customer;

public record CustomerDto(String plate, String phone, String type) {
    public static Customer fromDto(CustomerDto customerDto){
        return new Customer(customerDto.plate(), customerDto.phone(), Customer.transformEnum(customerDto.type));
    }
}
