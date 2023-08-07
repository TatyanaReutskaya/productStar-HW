package com.hw;

import com.hw.config.SpringConfig;
import com.hw.models.Athlet;
import com.hw.models.Distance;
import com.hw.models.Gender;
import com.hw.service.ResultsProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AppTest {
    @Autowired
    private ResultsProcessor resultsProcessor;
    private DateFormat dateFormat;
    private Athlet a1;
    private Athlet a2;
    private Athlet a3;
    private Athlet a4;
    private Athlet a5;
    private Athlet a6;
    private Athlet a7;
    private Athlet a8;
    private Athlet a9;
    private Athlet a10;
    @Before
    public void setup() throws ParseException {
        dateFormat = new SimpleDateFormat("mm:ss");
        a1 = new Athlet("Иван Иванов", Gender.MALE);
        a1.setMapOfResult(Map.of(Distance.TEN, time("55:10"), Distance.FIVE, time("10:20")));
        a2 = new Athlet("Евгений Иванов", Gender.MALE);
        a2.setMapOfResult(Map.of(Distance.TEN, time("53:20"), Distance.FIVE, time("11:20")));
        a3 = new Athlet("Игорь Иванов", Gender.MALE);
        a3.setMapOfResult(Map.of(Distance.TEN, time("52:20"), Distance.FIVE, time("09:20")));
        a4 = new Athlet("Артем Иванов", Gender.MALE);
        a4.setMapOfResult(Map.of(Distance.TEN, time("55:20"), Distance.FIVE, time("08:20")));
        a5 = new Athlet("Василий Иванов", Gender.MALE);
        a5.setMapOfResult(Map.of(Distance.TEN, time("53:40"), Distance.FIVE, time("10:40")));
        a6 = new Athlet("Анна Иванова", Gender.FEMAIL);
        a6.setMapOfResult(Map.of(Distance.TEN, time("55:20"), Distance.FIVE, time("10:20")));
        a7 = new Athlet("Мария Иванова", Gender.FEMAIL);
        a7.setMapOfResult(Map.of(Distance.TEN, time("55:30"), Distance.FIVE, time("10:30")));
        a8 = new Athlet("Ирина Иванова", Gender.FEMAIL);
        a8.setMapOfResult(Map.of(Distance.TEN, time("51:20"), Distance.FIVE, time("11:20")));
        a9 = new Athlet("Екатерина Иванова", Gender.FEMAIL);
        a9.setMapOfResult(Map.of(Distance.TEN, time("52:20"), Distance.FIVE, time("12:20")));
        a10 = new Athlet("Анастасия Иванова", Gender.FEMAIL);
        a10.setMapOfResult(Map.of(Distance.TEN, time("51:40"), Distance.FIVE, time("11:40")));
    }
    @Test
    public void showAll(){
        List<Athlet> expected = List.of(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10);
        List<Athlet> actual  = resultsProcessor.showAll();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getFast3Male5km(){
        List<Athlet> expected = List.of(a4,a3,a1);
        List<Athlet> actual  = resultsProcessor.getFastests(3,Gender.MALE,Distance.FIVE);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getFast7Female10km() {
        List<Athlet> expected = List.of(a8, a10, a9, a6, a7);
        List<Athlet> actual = resultsProcessor.getFastests(7, Gender.FEMAIL, Distance.TEN);
        Assert.assertEquals(expected, actual);
    }
    private Long time(String time) throws ParseException {
        Date date = dateFormat.parse(time);
        return date.getTime();
    }
}
