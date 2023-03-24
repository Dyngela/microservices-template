package com.diy.repository;

import com.diy.entity.TicketEntity;
import com.diy.enums.SenderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findAllByStoreIdAndSenderTypeAndDeletedAt(Long storeId, SenderType sender, LocalDateTime date);
    List<TicketEntity> findAllByCustomerIdAndDeletedAt(Long id, LocalDateTime date);
}
