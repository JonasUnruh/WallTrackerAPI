package com.tornado.mawalltracker.data;


import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "address")
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;
    private Integer postalcode;
    private String country;

    public Address(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(postalcode, address.postalcode) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, postalcode, country);
    }
}

