package com.mvc.mvc_internateconnection.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(name = "statements")
@Entity

public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String street;
    private String house;
    private String fio;
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private TariffType tariffType;




    public Statement(String city, String street, String house, String fio, TariffType tariff) {
        this.city = city;
        this.street = street;
        this.house = house;
        tariffType = tariff;
        this.fio = fio;
        localDateTime = LocalDateTime.now();
    }
}


