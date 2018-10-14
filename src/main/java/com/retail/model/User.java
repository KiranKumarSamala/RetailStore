package com.retail.model;

import java.util.Date;

public class User {
    
    private int userid;
    private String name;
    private String userType;
    private Date registeredDate;
    private String contactNo;
    private String memberId;
        
    
    public User(int userid, String name, String userType, Date registeredDate, String contactNo, String memberId) {
        super();
        this.userid = userid;
        this.name = name;
        this.userType = userType;
        this.registeredDate = registeredDate;
        this.contactNo = contactNo;
        this.memberId = memberId;
    }
        
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public Date getRegisteredDate() {
        return registeredDate;
    }
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    @Override
    public String toString() {
        return "User [userid=" + userid + ", name=" + name + ", userTypeRef=" + userType + ", registeredDate="
                + registeredDate + ", contactNo=" + contactNo + ", memberId=" + memberId + "]";
    }
    
    

}
