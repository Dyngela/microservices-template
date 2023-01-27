package com.diy.model;

import com.diy.entity.SubscriptionTypeEntity;
import com.diy.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionModel {
    Long subscriptionId;
    LocalDateTime dateStart;
    LocalDateTime dateEnd;
    PaymentType paymentType;
    Long storeId;
    SubscriptionTypeEntity subscriptionType;
}
