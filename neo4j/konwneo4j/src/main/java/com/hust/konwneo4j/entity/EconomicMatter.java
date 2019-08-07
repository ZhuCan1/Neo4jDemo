package com.hust.konwneo4j.entity;


import org.neo4j.ogm.annotation.*;

import java.util.List;
//经济事项
@NodeEntity(label = "EconomicMatter")
public class EconomicMatter {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "code")
    private String code;

    @Property(name = "name")
    private String name;


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

}
