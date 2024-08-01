package com.appvenir.resumehelper.domain.common;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
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

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;


    @Column(name = "last_updated_by", nullable = false)
    private String lastUpdatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdBy = getCurrentUser();
        this.lastUpdatedBy = getCurrentUser();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdatedBy = getCurrentUser();
    }

    private String getCurrentUser() {
        return "defaultUser"; 
    }

    
}
