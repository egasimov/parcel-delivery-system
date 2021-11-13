package org.company.user.domain;

import java.util.Arrays;
import java.util.Optional;

public enum CustomerLevel {

    GOLD("GOLD", 1, 500),
    PLATINUM("PLATINUM", 2, 350),
    SILVER("SILVER", 3, 250),
    BRONZE("BRONZE", 4, 100),
    SIMPLE("SIMPLE", 5, 0);

    private String name;
    private int order;
    private int neededDeliveryCount;

    CustomerLevel(String name, int order, int neededDeliveryCount) {
        this.name = name;
        this.order = order;
        this.neededDeliveryCount = neededDeliveryCount;
    }

    public static Optional<CustomerLevel> of(String name) {
        return Arrays.stream(CustomerLevel.values())
                .filter(item -> item.name.equalsIgnoreCase(name))
                .findFirst();
    }

    public static Optional<CustomerLevel> of(int order) {
        return Arrays.stream(CustomerLevel.values())
                .filter(item -> item.order == order)
                .findFirst();
    }

    public int getOrder() {
        return this.order;
    }

    public String getName() {
        return this.name;
    }

    public int getNeededDeliveryCount() {
        return this.neededDeliveryCount;
    }
}