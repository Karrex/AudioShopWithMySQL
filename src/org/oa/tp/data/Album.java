package org.oa.tp.data;

/**
 * Created by Eugene on 02.06.2015.
 */
public class Album {
    private final int id;
    private String name;
    private int year;

    public Album(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Album(String name, int year) {
        id = 0;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}