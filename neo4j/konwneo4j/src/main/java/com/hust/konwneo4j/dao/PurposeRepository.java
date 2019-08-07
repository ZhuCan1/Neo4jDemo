package com.hust.konwneo4j.dao;

import com.hust.konwneo4j.entity.EconomicMatter;
import com.hust.konwneo4j.entity.Purpose;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurposeRepository extends Neo4jRepository {

    @Query("match(p:Purpose) where p.name = :#{#purpose.name} and p.content = :#{#purpose.content} return p")
    Purpose findPurpose(@Param("purpose")Purpose purpose);



    List<Purpose> findByContent(@Param("content") String content);

}
