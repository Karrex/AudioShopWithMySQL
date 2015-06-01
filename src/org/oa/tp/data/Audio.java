package org.oa.tp.data;

/**
 * Created by Eugene on 02.06.2015.
 */
public class Audio {
    private final long id;
    private final String name;
    private final long authorId;
    private final int duration;
    private int price;
    private long genreId;
    private Author author;
    private Genre genre;

    public Audio(long id, String name, long authorId, int duration, int price, long genreId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.duration = duration;
        this.price = price;
        this.genreId = genreId;
    }

    public Audio(String name, long authorId, int duration, int price, long genreId) {
        id = 0;
        this.name = name;
        this.authorId = authorId;
        this.duration = duration;
        this.price = price;
        this.genreId = genreId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAuthorId() {
        return authorId;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", duration=" + duration +
                ", price=" + price +
                ", genreId=" + genreId +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}