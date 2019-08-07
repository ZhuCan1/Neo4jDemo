package com.hust.konwneo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "contains")
public class RelationPurposeAndAccount {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Purpose startNode;

    @EndNode
    private AccountSubject endNode;

    @Property
    private String relation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purpose getStartNode() {
        return startNode;
    }

    public void setStartNode(Purpose startNode) {
        this.startNode = startNode;
    }

    public AccountSubject getEndNode() {
        return endNode;
    }

    public void setEndNode(AccountSubject endNode) {
        this.endNode = endNode;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
