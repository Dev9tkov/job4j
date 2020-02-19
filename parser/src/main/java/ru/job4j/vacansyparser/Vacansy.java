package ru.job4j.vacansyparser;

import java.util.Objects;

/**
 * @author Ilya Devyatkov
 * @since 14.02.2020
 */
public class Vacansy {
    private String name;
    private String text;
    private String link;

    public Vacansy(String name, String text, String link) {
        this.name = name;
        this.text = text;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacansy vacansy = (Vacansy) o;
        return Objects.equals(name, vacansy.name)
                && Objects.equals(text, vacansy.text)
                && Objects.equals(link, vacansy.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text, link);
    }

    @Override
    public String toString() {
        return "Vacansy{"
                + "name='" + name + '\''
                + ", text='" + text + '\''
                + ", link='" + link + '\''
                + '}';
    }
}
