package org.company.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.company.user.domain.entities.Courier;
import org.company.user.error.exception.DuplicateRecordException;
import org.company.user.error.exception.RecordNotFoundException;
import org.company.user.mapper.CourierMapper;
import org.company.user.model.dto.CourierDto;
import org.company.user.model.request.CreateCourierRequest;
import org.company.user.model.request.CreateUserRequest;
import org.company.user.repository.CourierRepository;
import org.company.user.security.RoleConstants;
import org.company.user.service.CourierService;
import org.company.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final UserService userService;
    private final CourierRepository courierRepository;

    @Override
    public CourierDto createCourier(CreateCourierRequest requestData) {

        requestData.setUsername(requestData.getUsername().toLowerCase());

        boolean userExist = userService.checkUserExist(requestData.getUsername().toLowerCase());

        if (userExist) {
            throw DuplicateRecordException.of("courier/user already exist");
        }

        var createUserRequest = CreateUserRequest.builder()
                .firstName(requestData.getFirstName())
                .lastName(requestData.getLastName())
                .username(requestData.getUsername())
                .password(requestData.getPassword())
                .enabled(Boolean.TRUE)
                .userClientRoles(List.of(RoleConstants.ROLE_CLIENT_USER_COURIER))
                .userRealmRoles(List.of(RoleConstants.ROLE_REALM_USER_COURIER))
                .build();

        userService.createUser(createUserRequest);

        var newEntity = CourierMapper.toCourierEntity(requestData);
        courierRepository.save(newEntity);

        return CourierMapper.toCourierDto(newEntity);
    }

    @Override
    public CourierDto findCourier(String username) {
        Courier courier = courierRepository.findByUsername(username).orElseThrow(() -> RecordNotFoundException.of("Courier does not exist"));
        return CourierMapper.toCourierDto(courier);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourierDto> findAllCouriers() {
        return courierRepository.findAll()
                .stream()
                .map(CourierMapper::toCourierDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeCourier(String username) {
        Courier courier = courierRepository.findByUsername(username)
                .orElseThrow(() -> RecordNotFoundException.of("courier does not exist"));
        userService.removeUser(username);
        courierRepository.deleteById(courier.getId());

    }

    @Override
    public CourierDto info() {
        String username = userService.currentLoggedUser();
        var courier = courierRepository
                .findByUsername(username)
                .orElseThrow(() -> RecordNotFoundException.of("courier does not exist"));
        return CourierMapper.toCourierDto(courier);
    }
}
