package com.fev.app.WebApplication.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fev.app.WebApplication.user.User;


import javax.persistence.*;


@Entity
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    /*
     * User can have multiple cars
     * fetch = lazy, not retrieve the user unless asked for
     * @JsonIgnore to avoid infinite recursive
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Car() {
    }

    public Car(Integer id, User user, String content) {
        super();
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", content=" + content + "]";
    }


}
