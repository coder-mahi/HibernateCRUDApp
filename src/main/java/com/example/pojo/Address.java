package com.example.pojo;
import jakarta.persistence.Embeddable;

// @Embeddable
public class Address {
    private String city;
    private int pincode;
    public Address() {}

    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", pincode=" + pincode + "]";
    }
}
