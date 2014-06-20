package ru.grey.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by stravin on 17.06.2014.
 */
@Entity
@Table(name = "genre")
public class Genre extends BaseEntity implements Serializable {
    static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    public Genre() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
