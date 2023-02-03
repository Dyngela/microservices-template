package com.diy.entity;

import com.diy.enums.PaymentType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscription")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", nullable = false, unique = true)
    Long subscriptionId;

    @Column(name = "date_start")
    LocalDateTime dateStart;

    @Column(name = "date_end")
    LocalDateTime dateEnd;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;

    @Column(name = "store_id")
    Long storeId;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_type_id")
    SubscriptionTypeEntity subscriptionType;

}
