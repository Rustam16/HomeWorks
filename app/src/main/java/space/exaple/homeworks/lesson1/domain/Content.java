package space.exaple.homeworks.lesson1.domain;

import java.util.Objects;

public class Content {

    private int id;
    private String name;
    private double coast;

    public Content(int id, String name, double coast) {
        this.id = id;
        this.name = name;
        this.coast = coast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return id == content.id &&
                Double.compare(content.coast, coast) == 0 &&
                Objects.equals(name, content.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coast);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }
}
