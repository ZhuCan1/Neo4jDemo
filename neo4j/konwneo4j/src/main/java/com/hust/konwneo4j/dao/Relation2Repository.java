package com.hust.konwneo4j.dao;

import com.hust.konwneo4j.entity.AccountSubject;
import com.hust.konwneo4j.entity.Purpose;
import com.hust.konwneo4j.entity.RelationPurposeAndAccount;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface Relation2Repository extends Neo4jRepository {

    @Query("match (p:Purpose) - [r:contains] -> (a:AccountSubject) where p.code = :#{#purpose.code} and p.name = :#{#purpose.name} and p.content = :#{#purpose.content} and a.name = :#{#account.name}  return r")
    RelationPurposeAndAccount getRelationPurposeAndAccount(@Param("purpose") Purpose purpose, @Param("account")AccountSubject account);

    //只有content
    @Query("match (p:Purpose) - [r:contains] -> (a:AccountSubject) where p.content = :#{#purpose.content} and a.name = :#{#account.name}  return r")
    RelationPurposeAndAccount getRelationPurposeAndAccount2(@Param("purpose") Purpose purpose, @Param("account")AccountSubject account);
}
