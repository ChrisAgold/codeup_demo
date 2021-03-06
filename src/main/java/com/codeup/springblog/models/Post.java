package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name ="posts" )
public class Post {
    @ManyToOne
    @JoinColumn (name = "owner_id")
private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 225, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", length = 3000, nullable = false)
    private String body;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}