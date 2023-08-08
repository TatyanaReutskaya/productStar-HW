package com.hw.dao;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ResultParser {
    private String pathKey;
    private String pathAnswer;

    public ResultParser(@Value("${path.key}") String pathKey, @Value("${path.answer}") String pathAnswer) {
        this.pathKey = pathKey;
        this.pathAnswer = pathAnswer;
    }

    @SneakyThrows
    public Map<Integer, String> getKey() {
        return Files.lines(Paths.get(pathKey)).map(line->line.split("-")).
                collect(Collectors.toMap(arr->Integer.valueOf(arr[0]),arr->arr[1]));
    }
    @SneakyThrows
    public Map<Integer, String> getAnswer() {
        return Files.lines(Paths.get(pathAnswer)).map(line->line.split("-")).
                collect(Collectors.toMap(arr->Integer.valueOf(arr[0]),arr->arr[1]));
    }
}
