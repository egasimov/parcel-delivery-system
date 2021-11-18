package org.company.order.application.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.company.order.domain.ContactInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailsView {
    private String name;
    private String phone;

    public static ContactDetailsView construct(ContactInfo contactInfo) {
        var view = new ContactDetailsView();
        view.setName(contactInfo.getName());
        view.setPhone(contactInfo.getPhone());

        return view;
    }
}
