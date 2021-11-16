package org.company.order.domain;

import lombok.Getter;

@Getter
public class ContactInfo {
    private String name;
    private String phone;

    public ContactInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
