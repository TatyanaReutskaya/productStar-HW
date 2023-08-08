package com.hw.service;

import com.hw.dao.ResultParser;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class ResultsProcessor {
    private final ResultParser resultParser;
    @Autowired
    public ResultsProcessor(ResultParser resultParser) {
        this.resultParser = resultParser;
    }
    private Map<Integer,String> key;
    private Map<Integer,String> answer;
    @Value("#{${points}}")
    private Map<Integer,Integer> points;
    @PostConstruct
    private void init() {
        key = resultParser.getKey();
        answer = resultParser.getAnswer();
    }
    public int points(){
        int point=0, defPoint=0, sumPoint=0;
        int count = 1;
        while(count<= answer.size()) {
            point=points.getOrDefault(count,defPoint);
            if (point!=defPoint) {
                defPoint=point;
            }
            if (key.get(count).equals(answer.get(count))) {
                sumPoint+=point;
            }
            count++;
        }
        return sumPoint;
    }

}
