package com.tornato.WallTrackerRestAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    //Todo UniqueConstrain Funktioniert noch nicht!
    //@Column(
    //        nullable = false,
    //       unique = true
    //)

    @Column(unique = true)
    private String emailId;

    @JsonIgnore
    private String password;
}
