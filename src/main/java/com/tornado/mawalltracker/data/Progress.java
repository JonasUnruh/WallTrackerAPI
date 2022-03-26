package com.tornado.mawalltracker.data;

import lombok.Data;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Data
@Table(name = "progress")
public class Progress {

    @EmbeddedId
    private ProgressId progressId;

    private String completion_state;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    public Progress() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Progress progress = (Progress) o;
        return Objects.equals(progressId, progress.progressId) && Objects.equals(completion_state, progress.completion_state) && Objects.equals(date, progress.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progressId, completion_state, date);
    }
}


