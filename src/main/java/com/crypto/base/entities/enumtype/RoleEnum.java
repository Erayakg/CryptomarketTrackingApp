package com.crypto.base.entities.enumtype;

public enum RoleEnum {

    ADMIN("ADMIN", 1),
    USER("USER", 2),
    TRADER("TRADER",3);
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
