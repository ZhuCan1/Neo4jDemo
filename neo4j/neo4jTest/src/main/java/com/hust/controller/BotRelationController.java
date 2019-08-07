package com.hust.controller;

import com.hust.entity.BotNode;
import com.hust.entity.BotRelation;
import com.hust.repository.BotRelationRepository;
import com.hust.repository.BotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/botRelation")
public class BotRelationController {

    @Autowired
    private BotRelationRepository botRelationRepository;

    @Autowired
    private BotRepository botRepository;

    @RequestMapping("getByname")
    private BotRelation getRelationByName(@RequestParam(value = "name1")String name1,@RequestParam(value = "name2")String name2){
        BotNode botNode1 = botRepository.findByName(name1);
        BotNode botNode2 = botRepository.findByName(name2);
        BotRelation botRelation = new BotRelation();

        botRelation.setStartNode(botNode1);
        botRelation.setEndNode(botNode2);
        botRelation.setRelation("领导");
        BotRelation botRelation1 =  (BotRelation) botRelationRepository.save(botRelation);
        if (botRelation1 != null){
            return botRelation1;
        }else {
            return null;
        }
    }
}
