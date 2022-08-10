package com.ptit.newspaper.constant;


import java.util.HashMap;
import java.util.Map;

public enum Roles {
    ADMIN(0), AUTHOR(1), STUDENT(2);
    private Integer value;

    Roles(int value) {
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }

    private static final Map<Integer, Roles> BY_TYPE = new HashMap<>();

    static {
        for (Roles e : values()) {
            BY_TYPE.put(e.value, e);
        }
    }

    public String getName(){
        return this.toString();
    }

    public static Roles valueOfType(Integer type) {
        return BY_TYPE.get(type);
    }
}
