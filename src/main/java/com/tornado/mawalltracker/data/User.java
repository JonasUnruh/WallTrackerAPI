package com.tornado.mawalltracker.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Table(name = "user", schema = "public")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_Id", referencedColumnName = "id")
    private Address addressId;


    //private Date dob;
    //private Integer age;
    //private Boolean owner;
/*
    @OneToMany
    @JoinColumn()
    private List<Ratings> ratings;*/

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(addressId, user.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, addressId);
    }
}