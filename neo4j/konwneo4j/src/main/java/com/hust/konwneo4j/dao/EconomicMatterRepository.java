package com.hust.konwneo4j.dao;

import com.hust.konwneo4j.entity.EconomicMatter;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface EconomicMatterRepository extends Neo4jRepository {

    @Query("match(m:EconomicMatter) where m.code = :#{#matter.code} and m.name = :#{#matter.name} return m")
    EconomicMatter findMatter(@Param("matter")EconomicMatter matter);

    EconomicMatter findByCode(@Param("code")String code);
}
