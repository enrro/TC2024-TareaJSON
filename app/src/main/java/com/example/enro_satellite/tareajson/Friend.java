package com.example.enro_satellite.tareajson;

/**
 * Created by enro-satellite on 17/03/17.
 */

public final class Friend {

    private final String name, hobby, address;
    private final int age, phone;

    public Friend(String name, String hobby, String address, int age, int phone) {
        this.name = name;
        this.hobby = hobby;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }
}