package com.perfectbuildm.perfectbuildm.model;

public class ContactFormBindingModel {

    private String name;

    private String email;

    private String phone;

    private String message;

    public String getName() {
        return name;
    }

    public ContactFormBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactFormBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ContactFormBindingModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ContactFormBindingModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
