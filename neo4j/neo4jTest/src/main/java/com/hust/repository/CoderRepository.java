package com.hust.repository;


import com.hust.entity.Coder;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderRepository extends Neo4jRepository {

    /*
	 CoderRepositiory 继承 GraphRepository类，实现增删查改
	 实现自己的接口：通过名字查询Coder（可以是单个节点，也可以是一组节点List集合）
	 spring-data-neo4j 支持方法命名约定查询 findBy{Coder的属性名}
	 findBy后面的属性名一定要在Coder节点实体类里存在，否则会报错
	 */
    Coder findByName(@Param("name") String name);

}
