package com.github.sawafrolov.itemfinder.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "box")
public class BoxEntity {
    private int id;
    private Integer containedIn;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CONTAINED_IN", nullable = true)
    public Integer getContainedIn() {
        return containedIn;
    }

    public void setContainedIn(Integer containedIn) {
        this.containedIn = containedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxEntity boxEntity = (BoxEntity) o;
        return id == boxEntity.id &&
                Objects.equals(containedIn, boxEntity.containedIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, containedIn);
    }
}
