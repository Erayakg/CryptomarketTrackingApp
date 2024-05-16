package com.crypto.base.entities;

public enum RoleEnum {

    ADMIN("admin", 1),
    USER("user", 2);

    Integer typeInt;
    String typeString;

    RoleEnum(String typeString, Integer typeInt) {
        this.typeInt = typeInt;
        this.typeString = typeString;
    }

    @Override
    public String toString() {
        return "RoleEnum{" +
                "typeInt=" + typeInt +
                ", typeString='" + typeString + '\'' +
                '}';
    }

    public Integer getTypeInt() {
        return typeInt;
    }

    public String getTypeString() {
        return typeString;
    }
}
