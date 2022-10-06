package com.diy.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id", unique = true, nullable = false)
    Long storeId;
    @Column(name = "siret", unique = true, nullable = false)
    String siret;
    @Column(name = "sector", nullable = false)
    String sector;
    @Column(name = "firstname", nullable = false)
    String firstname;
    @Column(name = "lastname", nullable = false)
    String lastname;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    LocalDateTime deletedAt;

    @Column(name = "subscription_id")
    Long subscriptionId;

    @OneToMany(mappedBy = "store")
    List<AddressEntity> addresses;
}
