package org.company.user.mapper;

import org.company.user.domain.entities.Courier;
import org.company.user.model.dto.CourierDto;
import org.company.user.model.request.CreateCourierRequest;

public class CourierMapper {

    public static CourierDto toCourierDto(Courier entity) {
        CourierDto dto = CourierDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .birthDate(entity.getBirthDate())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .rating(entity.getRating())
                .busy(entity.getBusy())
                .build();

        return dto;
    }

    public static Courier toCourierEntity(CreateCourierRequest request){
        var entity = new Courier();
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setUsername(request.getUsername());
        entity.setBirthDate(request.getBirthDate());
        entity.setAddress(request.getAddress());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setBusy(Boolean.FALSE);
        entity.setRating(0);

        return entity;
    }
}
