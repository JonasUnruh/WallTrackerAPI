package com.tornato.WallTrackerRestAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteSetter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long routeSetterId;

    //Todo UniqueConstrain
    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "routeSetter_id", referencedColumnName = "routeSetterId")
    private List<Boulder> boulder;
    */

}
