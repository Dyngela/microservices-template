package com.diy.repository;

import com.diy.entity.SubscriptionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SubcriptionTypeRepository extends JpaRepository<SubscriptionTypeEntity, Long> {
    List<SubscriptionTypeEntity> findAllByDeletedAt(LocalDateTime date);
}
