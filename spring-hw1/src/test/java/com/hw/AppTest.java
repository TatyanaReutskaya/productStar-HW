package com.hw;

import com.hw.config.SpringConfig;
import com.hw.service.ResultsProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AppTest {
    @Autowired
    private ResultsProcessor resultsProcessor;
    @Test
    public void points() {
        Assert.assertEquals(14,resultsProcessor.points());
    }
}
