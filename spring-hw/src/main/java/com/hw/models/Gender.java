package com.hw.models;

import java.util.Objects;
import java.util.stream.Stream;

public enum Gender {
    MALE("М"),FEMAIL("Ж");

    private String code;
    Gender(String code) {
        this.code=code;
    }
    public static Gender of(String code) {
        return Stream.of(values()).filter(g-> Objects.equals(g.code,code)).
                findFirst().orElseThrow(()->new IllegalArgumentException("Unknown gender: "+code));
    }
}
