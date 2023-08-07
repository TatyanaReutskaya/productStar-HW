package com.hw.models;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class AthletsParser {
    @Value("${upload.path}")
    private String path;
    @Value("${upload.dateFormat}")
    private String dateFormatfromFile;
    private DateFormat dateFormat;
    @PostConstruct
    private void setDateFormat() {
        dateFormat = new SimpleDateFormat(dateFormatfromFile);
    }
    private static final int name = 0;
    private static final int gender = 1;
    private static final int distance = 2;
    private static final int time = 3;
    @SneakyThrows
    public List<Athlet> returnSetOfAthlets(){
        List<String[]> list= Files.lines(Paths.get(path)).map(line->line.split(",")).toList();
        ArrayList<Athlet> all = new ArrayList<>();
        for (String[] arr:list) {
            Athlet athlet = new Athlet(arr[name], Gender.of(arr[gender]));
            if (!all.contains(athlet)) {
                changeMapOfResults(athlet,Distance.of(arr[distance]),parseTime(arr[time]));
                all.add(athlet);
            }
            else {
                int i = all.indexOf(athlet);
                all.get(i).getMapOfResult().put(Distance.of(arr[distance]), parseTime(arr[time]));
            }
        }
        return all;
    }
    private void changeMapOfResults(Athlet athlet, Distance distance, Long time){
        Map<Distance,Long> mapOfResult = new HashMap<>();
        mapOfResult.put(distance,time);
        athlet.setMapOfResult(mapOfResult);
    }
    @SneakyThrows
    private Long parseTime(String time) {
        time=time.trim();
        Date date = dateFormat.parse(time);
        return date.getTime();
    }
}
