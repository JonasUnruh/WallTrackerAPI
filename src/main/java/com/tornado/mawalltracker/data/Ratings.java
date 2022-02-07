package com.tornado.mawalltracker.data;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "ratings")
public class Ratings {

    @Id
    private Integer id;

    private Integer rating;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User byUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne
    @JoinColumn(name = "boulder_id", referencedColumnName = "id")
    private Boulder boulder;

    public Ratings() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratings ratings = (Ratings) o;
        return id.equals(ratings.id) && byUser.equals(ratings.byUser) && rating.equals(ratings.rating) && boulder.equals(ratings.boulder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, byUser, rating, boulder);
    }
}
