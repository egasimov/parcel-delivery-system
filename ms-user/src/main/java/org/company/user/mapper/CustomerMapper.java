package org.company.user.mapper;

import org.company.user.domain.CustomerLevel;
import org.company.user.domain.entities.Customer;
import org.company.user.model.dto.CustomerDto;
import org.company.user.model.request.CreateCustomerRequest;

public class CustomerMapper {

    public static CustomerDto toCustomerDto(Customer entity) {
        CustomerDto dto = CustomerDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .birthDate(entity.getBirthDate())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .customerLevel(entity.getCustomerLevel().getName())
                .orderCount(entity.getOrderCount())
                .build();

        return dto;
    }

    public static Customer toCustomerEntity(CreateCustomerRequest request){
        var entity = new Customer();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setUsername(request.getUsername());
        entity.setBirthDate(request.getBirthDate());
        entity.setAddress(request.getAddress());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setCustomerLevel(CustomerLevel.SIMPLE);
        entity.setOrderCount(0);

        return entity;
    }
}
