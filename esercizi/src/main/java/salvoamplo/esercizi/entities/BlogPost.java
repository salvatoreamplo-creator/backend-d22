package salvoamplo.esercizi.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue
    private UUID id;

    private String category;
    private String title;

    private String cover;

    @Column(length = 5000)
    private String content;

    private int readingTime;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public BlogPost() {
    }

    public BlogPost(String category, String title, String content, int readingTime, Author author) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readingTime = readingTime;
        this.author = author;
        this.cover = "https://picsum.photos/200/300";
    }

    public UUID getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(int readingTime) {
        this.readingTime = readingTime;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
