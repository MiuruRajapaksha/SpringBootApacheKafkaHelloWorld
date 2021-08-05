package com.javainuse.model;

import lombok.Data;

@Data
public class Message {
    private int id;
    private String title;
    private String message;

    public Message(int id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }

    public Message(){}

}

