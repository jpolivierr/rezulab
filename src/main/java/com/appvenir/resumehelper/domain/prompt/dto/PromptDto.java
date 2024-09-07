package com.appvenir.resumehelper.domain.prompt.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class PromptDto {

    private Long id;
    private String name;
    private String context;
    private List<String> instructions;
    private List<String> constraints;
    private String scope;
    private String audience;
    private String examples;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

    public void setInstructions(List<String> instructions)
    {
        this.instructions = instructions;
    }

    public void setConstraints(List<String> constraints)
    {
        this.constraints = constraints;
    }

    public void setStringInstructions(String instructions)
    {
        if (instructions == null || instructions.isEmpty()) {
            this.instructions = new ArrayList<>();
        }
        this.instructions = Arrays.stream(instructions.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    public void setStringConstraints(String constraints)
    {
        if (constraints == null || constraints.isEmpty()) {
            this.constraints = new ArrayList<>();
        }
        this.constraints = Arrays.stream(constraints.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    public String getInstructionsAsStrings() {
        if (instructions == null || instructions.isEmpty()) {
            return "";
        }
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < instructions.size(); i++) {
            content.append(instructions.get(i));
            
            if (i < instructions.size() - 1) {
                content.append("\n");
            }
        }
        return content.toString();
    }

    public String getConstraintsAsStrings() {
        if (constraints == null || constraints.isEmpty()) {
            return "";
        }
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < constraints.size(); i++) {
            content.append(constraints.get(i));
            if (i < constraints.size() - 1) {
                content.append("\n");
            }
        }
        return content.toString();
    }

    public String use (String component){
        if(component == null) return "";
        return component.equals("") || component == null ? "" : component + "\n\n";
    }

    public String build(){
        String result = use(context) +
                        use(getInstructionsAsStrings()) + 
                        use(getConstraintsAsStrings()) +
                        use(scope) + 
                        use(audience) +
                        use(examples) ; 
        return result.trim().replaceAll("\n$", "");
    }
    
}
