package com.tornado.mawalltracker.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
//    private Date dob;
    private Integer age;
    private Boolean owner;
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
        return id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && age.equals(user.age) && owner.equals(user.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, owner);
    }
}