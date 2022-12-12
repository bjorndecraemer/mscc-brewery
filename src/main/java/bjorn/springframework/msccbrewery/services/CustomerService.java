package bjorn.springframework.msccbrewery.services;

import bjorn.springframework.msccbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
