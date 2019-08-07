package com.hust.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "BotRelation")//type为关系名称,可以使用@JsonProperty("喜欢")
// 自定义关系名，但传参时也要使用这个
public class BotRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private BotNode startNode;

    @EndNode
    private BotNode endNode;

    @Property
//    @Relationship(direction = "OUTGOING")设置关系方向的注解,默认开始指向结尾
    private String relation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BotNode getStartNode() {
        return startNode;
    }

    public void setStartNode(BotNode startNode) {
        this.startNode = startNode;
    }

    public BotNode getEndNode() {
        return endNode;
    }

    public void setEndNode(BotNode endNode) {
        this.endNode = endNode;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
