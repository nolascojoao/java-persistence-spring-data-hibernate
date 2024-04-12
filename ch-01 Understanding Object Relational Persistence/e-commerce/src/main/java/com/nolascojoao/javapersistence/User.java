package com.nolascojoao.javapersistence;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String username;
    private String addressStreet;
    private String addressZipCode;
    private String addressCity;
    private Set<BillingDetails> billingDetails = new HashSet<>();

    public User() {

    }

    public User(String username, String addressStreet, String addressZipCode, String addressCity) {
        this.username = username;
        this.addressStreet = addressStreet;
        this.addressZipCode = addressZipCode;
        this.addressCity = addressCity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressZipcode() {
        return addressZipCode;
    }

    public void setAddressZipcode(String addressZipcode) {
        this.addressZipCode = addressZipcode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public Set<BillingDetails> getBillingDetails() {
        return billingDetails;
    }

    public void addBillingDetails(BillingDetails billingDetail) {
        billingDetails.add(billingDetail);
    }

}
