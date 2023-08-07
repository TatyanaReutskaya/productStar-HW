package com.hw.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

public class Athlet{
    @Getter
    private String name;
    @Getter
    private Gender gender;
    @Getter
    @Setter
    private Map<Distance,Long> mapOfResult;

    public Athlet(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
    @Override
    public boolean equals(Object athlet) {
        if (this == athlet) {
            return true;
        }
        if ((athlet==null)||this.getClass()!=athlet.getClass()) {
            return false;
        }
        Athlet test=(Athlet) athlet;
        return (this.name.equals(test.getName()))&&(gender==test.getGender());
    }
    @Override
    public int hashCode() {
        int code = 11;
        return code*Objects.hash(name,gender);
    }
    @Override
    public String toString(){
        return name + " "+gender+" "+mapOfResult;
    }

}
