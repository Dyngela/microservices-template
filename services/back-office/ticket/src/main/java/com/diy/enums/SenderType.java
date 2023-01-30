package com.diy.enums;

import lombok.Getter;

@Getter
public enum SenderType {
    Store("Store"),
    Customer("Customer");

    private final String label;
    private SenderType(String label) {
        this.label = label;
    }
}
