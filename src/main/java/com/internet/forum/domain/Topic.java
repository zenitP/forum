package com.internet.forum.domain;

import javax.persistence.*;

@Entity
@Table(name = "topic")
public class Topic{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_topic_pk")
    private Long id;

    @Column(name = "name")
    private String name;

    public Topic() {

    }

    public Topic(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
