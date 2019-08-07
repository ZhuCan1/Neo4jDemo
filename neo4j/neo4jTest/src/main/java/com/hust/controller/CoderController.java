package com.hust.controller;

import com.hust.entity.Coder;
import com.hust.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coder")
public class CoderController {

    @Autowired
    private CoderRepository coderRepository;

    @RequestMapping("get")
    private Coder getCoderByName(@RequestParam(value = "name")String name){
        return coderRepository.findByName(name);
    }

    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    private Coder saveCoder(@RequestBody Coder coder){
        Coder result = (Coder) coderRepository.save(coder);
        if (result != null){
           return coder;
        }
        return null;
    }
}
