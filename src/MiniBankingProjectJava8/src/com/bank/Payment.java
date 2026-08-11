package com.bank;

public interface Payment {
    default  void validate(){
        System.out.println("Basic Validation Done.");
    }
    static void log(String msg){
        System.out.println("Log:"+msg);
    }

}
