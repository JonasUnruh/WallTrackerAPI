package com.tornado.mawalltracker.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "boulder", schema = "public")
@Entity
@Data
public class Boulder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer difficulty;

    @ManyToOne
    @JoinColumn(name="route_setter_id", referencedColumnName = "id")
    private RouteSetter routeSetterId;

    @ManyToOne
    @JoinColumn(name="location_id", referencedColumnName = "id")
    private Location locationId;


    public Boulder(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boulder boulder = (Boulder) o;
        return Objects.equals(id, boulder.id) && Objects.equals(difficulty, boulder.difficulty) && Objects.equals(routeSetterId, boulder.routeSetterId) && Objects.equals(locationId, boulder.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, difficulty, routeSetterId, locationId);
    }
}
