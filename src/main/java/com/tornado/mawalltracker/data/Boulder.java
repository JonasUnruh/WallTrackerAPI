package com.tornado.mawalltracker.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Table(name = "boulder", schema = "public")
@Entity
@Data
public class Boulder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer difficulty;

    public Boulder(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boulder boulder = (Boulder) o;
        return id.equals(boulder.id) && difficulty.equals(boulder.difficulty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, difficulty);
    }
}
