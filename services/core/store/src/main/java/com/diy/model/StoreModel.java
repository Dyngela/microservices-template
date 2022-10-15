package com.diy.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreModel {
    Long storeId;
    String siret;
    String sector;
    String storeName;
    String firstname;
    String lastname;
    String email;
    String phoneNumber;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime deletedAt;
    Long subscriptionId;
    List<AddressModel> addresses;
}
