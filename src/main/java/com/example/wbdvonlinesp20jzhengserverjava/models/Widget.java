package com.example.wbdvonlinesp20jzhengserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Integer id;

    private String type = "Heading";
    private String text = "Widget Text";
    private String src;
    private int widgetOrder;
    private int size = 1;
    private String title = "Heading Widget";
    private String ListType = "Unordered";

    @ManyToOne
    @JsonIgnore
    private Topic topic;

//    private int width, height;
//    private String ccsClass;
//    private String style;
//    private String value;


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(int widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getListType() {
        return ListType;
    }

    public void setListType(String listType) {
        ListType = listType;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
