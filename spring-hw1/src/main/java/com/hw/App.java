package com.hw;

import com.hw.config.SpringConfig;
import com.hw.dao.ResultParser;
import com.hw.service.ResultsProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResultsProcessor processor = context.getBean("resultsProcessor", ResultsProcessor.class);
        System.out.println(processor.points());
    }
}
