package com.appvenir.rezulab.domain.common;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@Data
public abstract class Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    
}
