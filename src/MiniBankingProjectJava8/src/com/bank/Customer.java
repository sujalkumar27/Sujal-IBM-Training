package com.bank;

import java.util.Optional;

public class Customer {
    private String name;
    private Optional<String> pancard;

    Customer(String name , String pancard){
        this.name = name;
        this.pancard= Optional.ofNullable(pancard);

    }
    public String getName(){
        return this.name;
    }

    public Optional<String> getPancard(){
        return this.pancard;
    }

    @Override
    public String toString(){
        return "Customer { name = "+name+" }";
    }
}
