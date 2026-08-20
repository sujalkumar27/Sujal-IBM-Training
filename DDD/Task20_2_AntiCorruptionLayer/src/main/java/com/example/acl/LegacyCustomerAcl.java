package com.example.acl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class LegacyCustomerAcl {

    private final LegacyCustomerXmlClient legacyClient;

    public LegacyCustomerAcl(LegacyCustomerXmlClient legacyClient) {
        this.legacyClient = legacyClient;
    }

    public ModernCustomerDto getCustomer(String legacyId) {
        String xml = legacyClient.fetchCustomerXml(legacyId);
        return translate(xml);
    }

    private ModernCustomerDto translate(String xml) {
        try {
            DocumentBuilder builder =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(
                    new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
            Element root = doc.getDocumentElement();

            String id     = text(root, "CUST_ID");
            String first  = text(root, "CUST_FNAME");
            String last   = text(root, "CUST_LNAME");
            String email  = text(root, "EMAIL_ADDR");
            String status = text(root, "STATUS_CD");

            return new ModernCustomerDto(
                    id,
                    (first + " " + last).trim(),
                    email,
                    "A".equalsIgnoreCase(status)
            );
        } catch (Exception e) {
            throw new RuntimeException("ACL translation failed", e);
        }
    }

    private static String text(Element root, String tag) {
        return root.getElementsByTagName(tag).item(0).getTextContent().trim();
    }
}
