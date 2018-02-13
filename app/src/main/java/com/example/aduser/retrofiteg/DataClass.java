package com.example.aduser.retrofiteg;

/**
 * Created by aduser on 2/12/2018.
 */

public class DataClass {
    private String name;
    private String phone;

    public DataClass(){

    }

    public DataClass(String name,String phone){
        this.name=name;
        this.phone=phone;

    }
    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
