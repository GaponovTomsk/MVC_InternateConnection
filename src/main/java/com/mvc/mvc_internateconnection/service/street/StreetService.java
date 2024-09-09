package com.mvc.mvc_internateconnection.service.street;

import com.mvc.mvc_internateconnection.model.Street;

public interface StreetService {
   Street save(Street street);
    Street read(long id);
    Street modify(Street street);
    void delete(long id);
}
