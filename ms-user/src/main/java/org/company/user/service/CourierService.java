package org.company.user.service;

import org.company.user.model.dto.CourierDto;
import org.company.user.model.request.CreateCourierRequest;

import java.util.List;

public interface CourierService {
    CourierDto createCourier(CreateCourierRequest requestData);

    CourierDto findCourier(String username);

    List<CourierDto> findAllCouriers();

    void removeCourier(String username);

    CourierDto info();

}
