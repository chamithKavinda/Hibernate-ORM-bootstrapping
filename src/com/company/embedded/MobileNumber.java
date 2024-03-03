package com.company.embedded;

import javax.lang.model.element.Name;
import javax.persistence.Column;
import javax.persistence.Embeddable;

public class MobileNumber {

    @Column(name = "mobile_no_type")
    private  String type;

    @Column(name = "mobile_no")
    private  String mobileNo;

    public MobileNumber(String type, String mobileNo) {
        this.type = type;
        this.mobileNo = mobileNo;
    }

    public MobileNumber() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

}
