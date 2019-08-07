package com.hust.konwneo4j.controller;

import com.hust.konwneo4j.dao.*;
import com.hust.konwneo4j.entity.*;
import com.hust.konwneo4j.util.knowledge.ExcelFile;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    @Autowired
    private EconomicMatterRepository economicMatterRepository;

    @Autowired
    private PurposeRepository purposeRepository;

    @Autowired
    private AccountSubjectRepository accountSubjectRepository;


    @Autowired
    private Relation1Repository relation1Repository;

    @Autowired
    private Relation2Repository relation2Repository;

    @RequestMapping("saveRelation")
    @ResponseBody
    public String saveRelation() throws Exception {
        List<TestEntity> list = ExcelFile.getFromExcel();
        for (int i = 0; i < list.size(); i++) {
            TestEntity testEntity = list.get(i);
            EconomicMatter economicMatter = testEntity.getEconomicMatter();
            Purpose purpose = testEntity.getPurpose();
            AccountSubject accountSubject = testEntity.getAccountSubject();
            EconomicMatter findEconomic = null;
            if (StringUtils.isNotBlank(economicMatter.getCode()) && StringUtils.isNotBlank(economicMatter.getName())) {
                findEconomic = economicMatterRepository.findMatter(economicMatter);
            } else {
                findEconomic = null;
            }
            Purpose findPurpose = null;
            if (StringUtils.isNotBlank(purpose.getContent())) {
                if (StringUtils.isNotBlank(purpose.getName())) {
                    findPurpose = purposeRepository.findPurpose(purpose);
                } else {
                    System.out.println("Purpose:" + purpose.getContent());
                    if (purposeRepository.findByContent(purpose.getContent()).size() > 0){
                        findPurpose = purposeRepository.findByContent(purpose.getContent()).get(0);
                    }else {
                        findPurpose = null;
                    }

                }
            } else {
                findPurpose = null;
            }

            AccountSubject findAccount = null;
            if (StringUtils.isNotBlank(accountSubject.getName())) {
                if (StringUtils.isNotBlank(accountSubject.getCode())) {
                    findAccount = accountSubjectRepository.findAccount(accountSubject);
                } else {
                    findAccount = accountSubjectRepository.findByName(accountSubject.getName());
                }
            }

            if (StringUtils.isBlank(economicMatter.getCode()) && StringUtils.isBlank(economicMatter.getName())) {
                economicMatter = null;
            }
            if (StringUtils.isBlank(purpose.getCode()) && StringUtils.isBlank(purpose.getName())
                    && StringUtils.isBlank(purpose.getContent()) && StringUtils.isBlank(purpose.getIsUse())) {
                purpose = null;
            }

            if (StringUtils.isBlank(accountSubject.getCode()) && StringUtils.isBlank(accountSubject.getName())) {
                accountSubject = null;
            }

            RelationMatterAndPurpose relation1 = new RelationMatterAndPurpose();
            RelationPurposeAndAccount relation2 = new RelationPurposeAndAccount();
            if (findEconomic != null) {
                relation1.setStartNode(findEconomic);
            } else if (economicMatter == null) {
                relation1.setStartNode(null);
            } else {
                economicMatter = (EconomicMatter) economicMatterRepository.save(economicMatter);
                relation1.setStartNode(economicMatter);
            }

            if (findPurpose != null) {
                relation1.setEndNode(findPurpose);
                relation2.setStartNode(findPurpose);
            } else if (purpose == null) {
                relation1.setEndNode(null);
                relation2.setStartNode(null);
            } else {
                purpose = (Purpose) purposeRepository.save(purpose);
                relation1.setEndNode(purpose);
                relation2.setStartNode(purpose);
            }

            if (findAccount != null) {
                relation2.setEndNode(findAccount);
            } else if (accountSubject == null) {
                relation2.setEndNode(null);
            } else {
                accountSubject = (AccountSubject) accountSubjectRepository.save(accountSubject);
                relation2.setEndNode(accountSubject);
            }
            relation1.setRelation("属于");
            relation2.setRelation("包含");
            RelationMatterAndPurpose r1 = null;
            System.out.println("i=" + i + "..." + JSONObject.fromObject(relation1));

            if (relation1.getStartNode() != null && relation1.getEndNode() != null) {
                if (StringUtils.isNotBlank(relation1.getEndNode().getContent())) {
                    if (StringUtils.isNotBlank(relation1.getEndNode().getName())) {
                        r1 = relation1Repository.getRelationMatterAndPurpose(relation1.getStartNode(), relation1.getEndNode());
                    } else {
                        r1 = relation1Repository.getRelationMatterAndPurpose2(relation1.getStartNode(), relation1.getEndNode());
                    }
                }
            }

            System.out.println("r1=" + r1);
            if (r1 == null) {
                if (relation1.getStartNode() != null && relation1.getEndNode() != null) {
                    relation1Repository.save(relation1);
                }
            }
            RelationPurposeAndAccount r2 = null;
            if (relation2.getStartNode() != null && relation2.getEndNode() != null) {
                if (StringUtils.isNotBlank(relation2.getStartNode().getContent())) {
                    if (StringUtils.isNotBlank(relation2.getStartNode().getName())) {
                        r2 = relation2Repository.getRelationPurposeAndAccount(relation2.getStartNode(), relation2.getEndNode());
                    } else {
                        r2 = relation2Repository.getRelationPurposeAndAccount2(relation2.getStartNode(), relation2.getEndNode());
                    }
                }
            }
            System.out.println("r2=" + r2);
            if (r2 == null) {
                if (relation2.getStartNode() != null && relation2.getEndNode() != null) {
                    relation2Repository.save(relation2);
                }
            }
        }
        return "ok";
    }
}
