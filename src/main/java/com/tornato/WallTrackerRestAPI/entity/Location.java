package com.tornato.WallTrackerRestAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @Column(nullable = false)
    private String locationName;

}
