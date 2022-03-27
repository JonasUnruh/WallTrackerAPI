package com.tornato.WallTrackerRestAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(nullable = true)
    private Double ratingsMean;

    public Long getBoulderId() {
        return boulderId;
    }

    public void setBoulderId(Long boulderId) {
        this.boulderId = boulderId;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public RouteSetter getRouteSetter() {
        return routeSetter;
    }

    public void setRouteSetter(RouteSetter routeSetter) {
        this.routeSetter = routeSetter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getRatingsMean() {
        return ratingsMean;
    }

    public void setRatingsMean(Double ratingsMean) {
        this.ratingsMean = ratingsMean;
    }
}
