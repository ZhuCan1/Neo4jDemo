package com.hust.repository;

import com.hust.entity.BotNode;
import com.hust.entity.BotRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BotRepository extends Neo4jRepository {

    BotNode findByName(String name);

    @Query("match(b:Bot{name:{name}})delete b")
    BotNode deleteByname(@Param("name") String name);

    @Query("match(b:Bot)return b")
    List<BotNode> findAllBotNode();

    List<BotNode> findByKind(@Param("kind") String kind);




}
