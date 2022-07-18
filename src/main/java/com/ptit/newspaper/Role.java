package com.ptit.newspaper;

public enum Role {
    ADMIN(0, "Admin"), USER(1, "User");
    private Integer type;
    private String typeString;
    Role(Integer type, String typeString){
        this.type = type;
        this.typeString = typeString;
    }
    public Integer getValue() {
        return this.type;
    }

    public String getTypeString() {
        return this.typeString;
    }

}
