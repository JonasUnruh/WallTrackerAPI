package com.tornado.mawalltracker.data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProgressId  implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", referencedColumnName = "id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boulder_Id", referencedColumnName = "id")
    private Boulder boulderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_Id", referencedColumnName = "id")
    private Location locationId;

    public ProgressId() {
    }

    public ProgressId(User userId, Boulder boulderId, Location locationId) {
        this.userId = userId;
        this.boulderId = boulderId;
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressId progressId = (ProgressId) o;
        return Objects.equals(userId, progressId.userId) && Objects.equals(boulderId, progressId.boulderId) && Objects.equals(locationId, progressId.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, boulderId, locationId);
    }
}
