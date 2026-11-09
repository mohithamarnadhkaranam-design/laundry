package com.laundry.laundry;

import jakarta.persistence.*;

@Entity
public class LaundryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String phone;
    private String laundryType;
    private int clothesCount;
    private String serviceType;
    private double price;
    private String status = "Received";

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getLaundryType() { return laundryType; }
    public void setLaundryType(String laundryType) { this.laundryType = laundryType; }
    public int getClothesCount() { return clothesCount; }
    public void setClothesCount(int clothesCount) { this.clothesCount = clothesCount; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}