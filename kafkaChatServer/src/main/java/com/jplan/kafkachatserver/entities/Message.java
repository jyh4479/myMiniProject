package com.jplan.kafkachatserver.entities;

import java.io.Serializable;

public class Message implements Serializable {
    private String author;
    private String content;
    private String timestamp;
    private Long from;

    public Message() {
    }

    public Message(String author, String content, Long from) {
        this.author = author;
        this.content = content;
        this.from = from;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
