package com.example.collegedemo.domain;


import javax.persistence.*;

@Entity
@Table
public class Address {
    @Id
    private int addressid;
    @Column
    private String addressline1;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String pincode;

    @OneToOne(mappedBy = "address")
    private Student student;

    public Address() {
    }

    public Address(int addressid, String addressline1, String city, String state, String pincode) {
        this.addressid = addressid;
        this.addressline1 = addressline1;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressid=" + addressid +
                ", addressLine1='" + addressline1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
