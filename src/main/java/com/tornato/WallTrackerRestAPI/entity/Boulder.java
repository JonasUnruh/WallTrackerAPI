package com.tornato.WallTrackerRestAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boulder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boulderId;

    @Column(nullable = false)
    private Integer difficulty;

    @ManyToOne(optional = false)
    @JoinColumn(name = "routeSetter_id")
    private RouteSetter routeSetter;
}
