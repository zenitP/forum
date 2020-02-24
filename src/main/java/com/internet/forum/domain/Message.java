package com.internet.forum.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_message_pk")
        private Long id;

        private String text;
        private String tag;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id_FK")
        private User author;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "topic_id_FK")
        private Topic topic;

        public Topic getTopic() {
            return topic;
        }

        public void setTopic(Topic topic) {
            this.topic = topic;
        }

        private String date;

        private String filename;


        public Message() {

        }

        public Message(String text, String tag, User user, Topic top) {

            this.topic = top;
            this.text = text;
            this.tag = tag;
            this.author = user;
        }


        public String getAuthorName(){
            return author != null ? author.getUsername() : "<none>";
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }


        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

}
