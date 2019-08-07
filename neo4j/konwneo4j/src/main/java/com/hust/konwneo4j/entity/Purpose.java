package com.hust.konwneo4j.entity;

import org.neo4j.ogm.annotation.*;

//用途
@NodeEntity(label = "Purpose")
public class Purpose {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "code")
    private String code;

    @Property(name = "name")
    private String  name;

    @Property(name = "content")
    private String content;

    @Property(name = "isUse")
    private String isUse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

}
