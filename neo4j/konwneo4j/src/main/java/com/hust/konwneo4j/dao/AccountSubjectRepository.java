package com.hust.konwneo4j.dao;

import com.hust.konwneo4j.entity.AccountSubject;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface AccountSubjectRepository extends Neo4jRepository {

    @Query("match(a:AccountSubject) where a.code = :#{#account.code} and a.name = :#{#account.name} return a")
    AccountSubject findAccount(@Param("account") AccountSubject account);

    AccountSubject findByName(@Param("name") String name);
}
