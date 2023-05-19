package br.com.exemplos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerType {
    DOCUMENT, ID, UNKNOW;

    public static CustomerType getCustomerType(String value) {
        try {
            return CustomerType.valueOf(value);
        } catch (IllegalArgumentException ex) {
            return CustomerType.UNKNOW;
        }
    }
}
