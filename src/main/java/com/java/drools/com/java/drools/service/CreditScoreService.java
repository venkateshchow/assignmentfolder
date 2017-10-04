package com.java.drools.com.java.drools.service;

import com.java.drools.entity.CreditScore;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    private final KieContainer kieContainer;

    @Autowired
    public CreditScoreService(KieContainer kieContainer){
        this.kieContainer = kieContainer;
    }

    public CreditScore getCreditScore(CreditScore creditScore){

        KieSession kieSession = kieContainer.newKieSession("rulesSession");
      //  System.out.println("in service: " +creditScore.getScore());
        kieSession.insert(creditScore);
        kieSession.fireAllRules();
        kieSession.dispose();
        return creditScore;


    }

}
