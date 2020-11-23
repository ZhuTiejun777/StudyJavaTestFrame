package com.qa.experiment;

public class User {

    private String name;
    private int age;
    private String sex;
    private String address;

    public User () {
        super();
    }

    public User (String name, int age, String sex, String address) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString () {
        return "sex:" + getSex() + " address:" + getAddress() + " name:" + getName() + " age:" + getAge();
    }
}
