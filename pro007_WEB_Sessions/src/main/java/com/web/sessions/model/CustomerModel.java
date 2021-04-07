package com.web.sessions.model;

public class CustomerModel {

    private String name;
    private String surname;
    private Integer age;
    private String login;
    private String password;
    private Long creditCard;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(Long creditCard) {
        this.creditCard = creditCard;
    }
}
