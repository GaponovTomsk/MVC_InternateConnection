package com.mvc.mvc_internateconnection.service.city;

import com.mvc.mvc_internateconnection.model.City;

public interface CityService {
    City save(City city);
    City read(long id);
    City modify(City city);
    void delete(long id);
    City findCityByName (String cityName);
}
