package com.mvc.mvc_internateconnection.service.city;

import com.mvc.mvc_internateconnection.model.City;
import com.mvc.mvc_internateconnection.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Override
    public City save(City city) {
        cityRepository.save(city);
        return city;
    }

    @Override
    public City read(long id) {
       Optional<City> cityOptional  = cityRepository.findById(id);
       return cityOptional.orElse(null);
    }

    @Override
    public City modify(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City findCityByName(String cityName) {
        Optional<City> cityOptional = cityRepository.findCityByNameWithStreets(cityName);
        return cityOptional.orElse(null);
    }
}
