package com.github.sawafrolov.itemfinder.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
public class ItemEntity {
    private int id;
    private Integer containedIn;
    private String color;

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

    @Basic
    @Column(name = "COLOR", nullable = true, length = 100)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return id == that.id &&
                Objects.equals(containedIn, that.containedIn) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, containedIn, color);
    }
}
