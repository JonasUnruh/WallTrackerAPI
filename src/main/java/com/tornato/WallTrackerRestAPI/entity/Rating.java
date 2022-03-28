package com.tornato.WallTrackerRestAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingsId;

    @Column(nullable = true)
    private Integer rating;

    @Column(nullable = true, columnDefinition = "Text")
    private String review;

    @ManyToOne(optional = false)
    @JoinColumn(name = "boulder_id")
    private Boulder boulder;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;


}
