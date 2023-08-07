package com.hw;

import com.hw.config.SpringConfig;
import com.hw.models.Distance;
import com.hw.models.Gender;
import com.hw.service.ResultsProcessor;
import com.hw.models.Athlet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResultsProcessor resultsProcessor = context.getBean("resultsProcessor", ResultsProcessor.class);
        List<Athlet> allFast = resultsProcessor.getFastests(7, Gender.FEMAIL, Distance.TEN);
        allFast.forEach(System.out::println);
        //resultsProcessor.showAll().forEach(System.out::println);

    }
}
