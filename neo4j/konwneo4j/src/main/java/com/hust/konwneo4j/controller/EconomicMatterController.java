package com.hust.konwneo4j.controller;

import com.hust.konwneo4j.dao.EconomicMatterRepository;
import com.hust.konwneo4j.entity.EconomicMatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("matter")
public class EconomicMatterController {

    @Autowired
    private EconomicMatterRepository economicMatterRepository;


    @RequestMapping(value = "save",method = RequestMethod.POST)
    public EconomicMatter saveEconomicMatter(@RequestBody EconomicMatter economicMatter){
        EconomicMatter e = (EconomicMatter)economicMatterRepository.save(economicMatter);
        if (e != null){
            return e;
        }else {
            return null;
        }
    }
}
