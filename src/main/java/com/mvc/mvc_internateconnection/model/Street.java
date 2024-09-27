package com.mvc.mvc_internateconnection.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Component
@NoArgsConstructor
@Entity
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    //@ManyToMany()
    @ManyToMany(mappedBy = "streets", fetch = FetchType.EAGER)
    private Set<City> cities;
    //private List<City> cities;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
