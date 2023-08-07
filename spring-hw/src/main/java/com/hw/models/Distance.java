package com.hw.models;

import java.util.Objects;
import java.util.stream.Stream;

public enum Distance {
    FIVE("5 км"), TEN("10 км");
    private String code;
    Distance(String code) {
        this.code=code;
    }
    public static Distance of(String code) {
        return Stream.of(values()).filter(g-> Objects.equals(g.code,code)).
                findFirst().orElseThrow(()->new IllegalArgumentException("Unknown distance: "+code));
    }
}
