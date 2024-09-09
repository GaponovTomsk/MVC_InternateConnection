package com.mvc.mvc_internateconnection.service.street;

import com.mvc.mvc_internateconnection.model.Street;
import com.mvc.mvc_internateconnection.repository.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class StreetServiceImpl implements StreetService {

    private StreetRepository streetRepository;

    @Override
    public Street save(Street street) {
        streetRepository.save(street);
        return street;
    }

    @Override
    public Street read(long id) {
        Optional<Street> streetOptional  = streetRepository.findById(id);
        return streetOptional.isPresent() ? streetOptional.get() : null;
    }

    @Override
    public Street modify(Street street) {
        return streetRepository.save(street);
    }

    @Override
    public void delete(long id) {
        streetRepository.deleteById(id);
    }
}
