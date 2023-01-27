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
@Table(name = "subscription_type")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubscriptionTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscription_type_id", nullable = false, unique = true)
    Long subscriptionTypeId;
    @Column(name = "name")
    String name;
    @Column(name = "turnover")
    Double turnover;
    @Column(name = "support")
    String support;
    @Column(name = "price")
    Float price;
    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    LocalDateTime deletedAt;

    @OneToMany(mappedBy = "subscriptionType")
    List<SubscriptionEntity> subscriptions;

}
