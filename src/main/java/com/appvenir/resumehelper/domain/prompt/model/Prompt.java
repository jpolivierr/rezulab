package com.appvenir.resumehelper.domain.prompt.model;


import com.appvenir.resumehelper.domain.common.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "prompt")
public class Prompt extends Auditable{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "context", nullable = false)
    private String context;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "constraints")
    private String constraints;

    @Column(name = "scope")
    private String scope;

    @Column(name = "audience")
    private String audience;

    @Column(name = "examples")
    private String examples;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
