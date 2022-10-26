package com.diy.entity;

import com.diy.enums.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    Long userId;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "firstname", unique = true, nullable = false)
    String firstName;

    @Column(name = "lastname", unique = true, nullable = false)
    String lastName;

    @Column(name = "phonenumber", unique = true, nullable = false)
    String phoneNumber;

    @Column(name = "store_id", nullable = false)
    Long storeId;

    @Column(name = "role", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    Roles role;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    LocalDateTime deletedAt;


}
