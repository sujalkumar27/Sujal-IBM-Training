package com.example.acl;

public class LegacyCustomerXmlClient {

    public String fetchCustomerXml(String legacyId) {
        return """
               <CUST_REC>
                   <CUST_ID>%s</CUST_ID>
                   <CUST_FNAME>Sujal</CUST_FNAME>
                   <CUST_LNAME>Kumar</CUST_LNAME>
                   <EMAIL_ADDR>sujal@example.com</EMAIL_ADDR>
                   <STATUS_CD>A</STATUS_CD>
               </CUST_REC>
               """.formatted(legacyId);
    }
}
