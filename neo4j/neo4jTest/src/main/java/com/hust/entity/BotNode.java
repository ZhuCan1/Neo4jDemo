package com.hust.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "Bot")
@Data
public class BotNode {

    @Id
    @GeneratedValue
    private Long id; //id
    @Property(name = "name")
    private String name;//名
    @Property(name = "kind")
    private String kind;//类
    @Property(name = "weight")
    private long weight;//权重



}
