package com.java.drools.com.java.drools.controller;

import com.java.drools.com.java.drools.service.CreditScoreService;
import com.java.drools.entity.CreditScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class CreditScoreController {

    private final CreditScoreService creditScoreService;

    @Autowired
    public CreditScoreController(CreditScoreService creditScoreService){
        this.creditScoreService = creditScoreService;
    }

    @RequestMapping(value = "/getStatus", method = RequestMethod.GET, produces = "application/json")
    public CreditScore getMessage(@RequestParam(required = true) int score){

        CreditScore creditScore = new CreditScore();
        creditScore.setScore(score);
        return creditScoreService.getCreditScore(creditScore);
    }

}

