package ru.job4j.tracker;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс для тестов над Hibernate
 * @author Ilya Devyatkov
 * @since 27.05.2020
 */

@Entity
@Table(name = "items")
public class ItemHBR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public ItemHBR() {
    }

    public ItemHBR(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemHBR itemHBR = (ItemHBR) o;
        return Objects.equals(id, itemHBR.id) &&
                Objects.equals(name, itemHBR.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + '}';
    }
}

