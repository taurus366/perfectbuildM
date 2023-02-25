package com.perfectbuildm.perfectbuildm.event;

public class ContactSuccessfullEventImpl {

    private final String email;

    private final String name;
    private final String customerEmail;
    private final String phone;
    private final String message;

    public ContactSuccessfullEventImpl(String email, String name, String customerEmail, String phone, String message) {
        this.email = email;
        this.name = name;
        this.customerEmail = customerEmail;
        this.phone = phone;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }
}
