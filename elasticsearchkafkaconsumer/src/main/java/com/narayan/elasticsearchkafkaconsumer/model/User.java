package com.narayan.elasticsearchkafkaconsumer.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import com.google.gson.Gson;

@Document(indexName = "kafkauser")
public class User {
    @Id
    int id;
    @Field(type = FieldType.Text, name = "name")
    String name;
    @Field(type = FieldType.Date, name = "pdate")
    Date pdate;
    public User() {
        super();
    }
    public User(int id, String name, Date pdate) {
        super();
        this.id = id;
        this.name = name;
        this.pdate = pdate;
    }
    public Date getPdate() {
        return pdate;
    }
    public void setPdate(Date pdate) {
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
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

