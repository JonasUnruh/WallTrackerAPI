package com.tornado.mawalltracker.data;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "ratings")
public class Ratings {

    @EmbeddedId
    private RatingsId ratingsId;

    private Integer rating;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Ratings() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratings ratings = (Ratings) o;
        return Objects.equals(ratingsId, ratings.ratingsId) && Objects.equals(rating, ratings.rating) && Objects.equals(date, ratings.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingsId, rating, date);
    }
}
