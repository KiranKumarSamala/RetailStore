package com.retail.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bill {
    
    private Map<Integer,BillItem> billItemMap;
    private User user;
    private Date billDate;
    private double billAmount;
    
    public Map<Integer, BillItem> getBillItemMap() {
        if(null==billItemMap) {
            billItemMap  = new HashMap<>();
        }
        return billItemMap;
    }
    public void setBillItemMap(Map<Integer, BillItem> billItemMap) {
        this.billItemMap = billItemMap;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Date getBillDate() {
        return billDate;
    }
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
    
    public double getBillAmount() {
        return billAmount;
    }
    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
    
    @Override
    public String toString() {
        StringBuilder billString = new StringBuilder();
        billItemMap.forEach((k,v) -> 
        {
            billString.append(v+"\n ");
        });
        return " Bill \n " + billString.toString() + " User= " + user + "\n billDate=" + billDate + "\n billAmount=" + billAmount
                + "]";
    }
}
