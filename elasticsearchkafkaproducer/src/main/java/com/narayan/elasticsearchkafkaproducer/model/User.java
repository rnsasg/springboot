package com.narayan.elasticsearchkafkaproducer.model;
public class User {
    int id;
    String name;
    String pdate;
    public User() {
        super();
    }
    public User(int id, String name, String pdate) {
        super();
        this.id = id;
        this.name = name;
        this.pdate = pdate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPdate() {
        return pdate;
    }
    public void setPdate(String pdate) {
        this.pdate = pdate;
    }
}
