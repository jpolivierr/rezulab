package com.appvenir.resumehelper.domain.prompt.model;

import com.appvenir.resumehelper.domain.common.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
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

    public String use (String component){
        return component.equals("") || component == null ? "" : component + "\n";
    }

    public String build(){
        String result = use(context) +
                        use(instructions) + 
                        use(constraints) +
                        use(scope) + 
                        use(audience) +
                        use(examples) ; 
        return result.trim().replaceAll("\n$", "");
    }

    
}
