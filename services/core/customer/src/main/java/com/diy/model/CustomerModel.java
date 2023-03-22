package com.diy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {

    Long customerId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    Long storeId;
    String ethAddress;
    LocalDateTime createdAt;

}
