package org.company.order.adapter.in.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ContactDetailsModel {
    @NotNull
    private String name;
    @NotNull
    private String phone;
}
