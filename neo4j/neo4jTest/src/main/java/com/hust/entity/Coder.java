package com.hust.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@NodeEntity
public class Coder {
    /**
     * neo4j 生成的id
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 属性，name
     */
    private String name;

    private String sex;

    private String hobby;

    private String flag;

}
