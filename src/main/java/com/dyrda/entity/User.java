package com.dyrda.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Segiy on 28.07.2016.
 */

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;

    private Integer age;

    @Column(name = "isAdmin")
    private boolean admin;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    private Integer page;


    public User() {
    }

    public User(long userId, String userName, int userAge, boolean admin, Date createdDate) {
        this.id = userId;
        this.name = userName;
        this.age = userAge;
        this.admin = admin;
        this.createdDate = createdDate;
    }

    public User(String name, int age, boolean admin) {
        this.name = name;
        this.age = age;
        this.admin = admin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "User{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", age=" + age +
                  ", admin=" + admin +
                  '}';
    }
}
