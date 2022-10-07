package com.diy.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customisation")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomisationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customisation_id", nullable = false, unique = true)
    Long customisationId;
}
