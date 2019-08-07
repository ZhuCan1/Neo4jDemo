package com.hust.konwneo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "of")
    public class RelationMatterAndPurpose {
        @Id
        @GeneratedValue
        private Long id;

        @StartNode
        private EconomicMatter startNode;

        @EndNode
        private Purpose endNode;

        @Property
        private String relation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EconomicMatter getStartNode() {
        return startNode;
    }

    public void setStartNode(EconomicMatter startNode) {
        this.startNode = startNode;
    }

    public Purpose getEndNode() {
        return endNode;
    }

    public void setEndNode(Purpose endNode) {
        this.endNode = endNode;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
