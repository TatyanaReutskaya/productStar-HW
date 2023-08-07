package com.hw.service;

import com.hw.models.Athlet;
import com.hw.models.AthletsParser;
import com.hw.models.Distance;
import com.hw.models.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ResultsProcessor {
    @Autowired
    private AthletsParser athletsParser;
    private List<Athlet> athlets;
    @PostConstruct
    private void init() {
        athlets = athletsParser.returnSetOfAthlets();
    }
    public List<Athlet> showAll(){
        return athlets;
    }
    public List<Athlet> getFastests(int q, Gender gender, Distance distance){
        return athlets.stream().filter(athlet ->(athlet.getGender()==gender)&&(athlet.getMapOfResult().containsKey(distance))).
                        sorted(Comparator.comparing(athlet -> athlet.getMapOfResult().get(distance))).
                        limit(q).collect(Collectors.toList());
    }
    public int test(int a, int b) {
        return a+b;
    }
}
