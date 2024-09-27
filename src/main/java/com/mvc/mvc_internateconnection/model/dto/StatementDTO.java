package com.mvc.mvc_internateconnection.model.dto;

import com.mvc.mvc_internateconnection.model.TariffType;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class StatementDTO {
    private String city;
    private String street;
    private String house;
    private String fullName;
    private String phone;
    private String email;
    private TariffType tariffType;
}
