package com.diy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTypeModel {
    Long subscriptionTypeId;
    String name;
    Double turnover;
    String support;
    Float price;
    List<SubscriptionModel> subscriptions;
}

