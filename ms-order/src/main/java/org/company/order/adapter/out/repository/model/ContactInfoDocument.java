package org.company.order.adapter.out.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.company.order.domain.ContactInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDocument {

    private String name;
    private String phone;

    public static ContactInfo toEntity(ContactInfoDocument document) {
        if (document == null) {
            return null;
        }
        return new ContactInfo(document.name, document.phone);
    }

    public static ContactInfoDocument toDocument(ContactInfo entity) {
        if (entity == null) {
            return null;
        }
        var document = new ContactInfoDocument();
        document.setName(entity.getName());
        document.setPhone(entity.getPhone());

        return document;
    }
}
