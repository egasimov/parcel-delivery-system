package org.company.order.adapter.in.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MakeOrderResponse {
    private String orderUUID;
    private String trackingRefNo;
    private String status;
    private String systemNote;
}
