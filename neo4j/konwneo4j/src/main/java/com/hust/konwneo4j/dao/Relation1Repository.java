package com.hust.konwneo4j.dao;

import com.hust.konwneo4j.entity.EconomicMatter;
import com.hust.konwneo4j.entity.Purpose;
import com.hust.konwneo4j.entity.RelationMatterAndPurpose;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface Relation1Repository extends Neo4jRepository{

    @Query("match (m:EconomicMatter) - [r:of] -> (p:Purpose) where m.code = :#{#matter.code} and m.name = :#{#matter.name} and p.content = :#{#purpose.content} and p.name = :#{#purpose.name} return r")
    RelationMatterAndPurpose getRelationMatterAndPurpose(@Param("matter")EconomicMatter matter, @Param("purpose")Purpose purpose);

    //只有content
    @Query("match (m:EconomicMatter) - [r:of] -> (p:Purpose) where m.code = :#{#matter.code} and m.name = :#{#matter.name} and p.content = :#{#purpose.content} return r")
    RelationMatterAndPurpose getRelationMatterAndPurpose2(@Param("matter")EconomicMatter matter, @Param("purpose")Purpose purpose);
}
