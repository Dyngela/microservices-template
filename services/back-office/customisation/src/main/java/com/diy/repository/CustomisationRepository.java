package com.diy.repository;

import com.diy.entity.CustomisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomisationRepository extends JpaRepository<CustomisationEntity, Long> {
    List<CustomisationEntity> findAllByStoreIdAndDeletedAt(Long id, LocalDateTime date);
}
