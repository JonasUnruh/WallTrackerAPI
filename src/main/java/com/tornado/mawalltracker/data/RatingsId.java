package com.tornado.mawalltracker.data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RatingsId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", referencedColumnName = "id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boulder_Id", referencedColumnName = "id")
    private Boulder boulderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_Id", referencedColumnName = "id")
    private Location locationId;

    public RatingsId() {
    }

    public RatingsId(User userId, Boulder boulderId, Location locationId) {
        this.userId = userId;
        this.boulderId = boulderId;
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingsId ratingsId = (RatingsId) o;
        return Objects.equals(userId, ratingsId.userId) && Objects.equals(boulderId, ratingsId.boulderId) && Objects.equals(locationId, ratingsId.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, boulderId, locationId);
    }
}
