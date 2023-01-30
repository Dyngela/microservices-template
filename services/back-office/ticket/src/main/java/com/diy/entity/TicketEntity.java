package com.diy.entity;

import com.diy.enums.ProblemType;
import com.diy.enums.SenderType;
import com.diy.enums.State;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id", unique = true, nullable = false)
    Long ticketId;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "problem_type", nullable = false)
    @Enumerated(EnumType.STRING)
    ProblemType problemType;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "sender_type", nullable = false)
    @Enumerated(EnumType.STRING)
    SenderType senderType;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    State state;

    @Column(name = "store_id")
    Long storeId;

    @Column(name = "customer_id")
    Long customerId;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    LocalDateTime deletedAt;
}
