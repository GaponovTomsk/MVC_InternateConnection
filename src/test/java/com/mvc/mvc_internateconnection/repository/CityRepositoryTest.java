package com.mvc.mvc_internateconnection.repository;

import com.mvc.mvc_internateconnection.model.City;
import com.mvc.mvc_internateconnection.model.Street;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;


    @BeforeEach
    void setUp() {
        //Метод срабатывает перед запуском теста
    }

    @AfterEach
    void tearDown() {
        //Метод срабатывает после завершения теста
    }

    @Test
    @DisplayName("search City For Name together Street")
    void findCityByNameWithStreets() {
        Optional<City> rostov = cityRepository.findCityByNameWithStreets("Rostov");


        assertTrue(rostov.isPresent());
        assertEquals("Rostov",rostov.get().getName());
        assertEquals(2,rostov.get().getStreets().size());

        Street street = new Street();
        street.setName("Lenina");

        assertTrue(rostov.get().getStreets().contains(street));

    }
}