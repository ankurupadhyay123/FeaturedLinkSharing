package com.ttn.beans;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ankur on 7/9/2017.
 */
@Entity
@Component
public class ResourceRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Resources resources;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private User user;

    @Column(nullable = false)
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
