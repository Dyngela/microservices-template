package com.diy.model;

import com.diy.enums.ProblemType;
import com.diy.enums.SenderType;
import com.diy.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketModel {
    Long ticketId;
    String title;
    ProblemType problemType;
    String description;
    SenderType senderType;
    State state;
    Long storeId;
    Long customerId;
}
