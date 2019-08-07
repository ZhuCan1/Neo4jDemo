package com.hust.controller;

import com.hust.entity.BotNode;
import com.hust.entity.Coder;
import com.hust.repository.BotRepository;
import com.hust.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bot")
public class BotController {

    @Autowired
    private BotRepository botRepository;

    @RequestMapping("getByName")
    private BotNode getBotByName(@RequestParam(value = "name")String name){
        return botRepository.findByName(name);
    }

    @RequestMapping("deleteByName")
    private BotNode deleteBotByName(@RequestParam(value = "name")String name){
        return botRepository.deleteByname(name);
    }

    @RequestMapping("getBotByKind")
    private List<BotNode> getBotByKind(@RequestParam(value = "kind")String kind){

        return botRepository.findByKind(kind);
    }

    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    private BotNode saveBot(@RequestBody BotNode botNode){
        BotNode result = (BotNode) botRepository.save(botNode);
        if (result != null){
           return botNode;
        }
        return null;
    }

    @RequestMapping(value = "findAll" ,method = RequestMethod.GET)
    private List<BotNode> findAll(){
        List<BotNode> result = botRepository.findAllBotNode();
        if (result != null){
            return result;
        }
        return null;
    }
}
