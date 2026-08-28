package com.example.acl;

public class Main {
    public static void main(String[] args) {
        LegacyCustomerAcl acl = new LegacyCustomerAcl(new LegacyCustomerXmlClient());
        ModernCustomerDto dto = acl.getCustomer("1001");
        System.out.println("Modern JSON DTO -> " + dto);
    }
}
