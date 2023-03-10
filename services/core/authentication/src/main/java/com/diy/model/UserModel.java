package com.diy.model;

import com.diy.enums.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    Long userId;
    String email;
    String password;
    String firstName;
    String lastName;
    String phoneNumber;
    String ethAddress;
    Long storeId;
    Roles role;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime deletedAt;

    // Attribute only for owner
    String siret;
    String storeName;
    String sector;

}
