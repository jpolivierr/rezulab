package com.appvenir.resumehelper.domain.prompt;

import lombok.Data;

@Data
public class Prompt {

    private String context = "";
    private String instructions = "";
    private String examples = "";
    private String constraints = "";
    private String scope = "";
    private String audience = "";

    public String use (String component){
        return component.equals("") || component == null ? "" : component + "\n";
    }

    public String build(){
        String result = use(context) +
                        use(instructions) + 
                        use(examples) + 
                        use(constraints) +
                        use(scope) + 
                        use(audience) ; 
        return result.trim().replaceAll("\n$", "");
    }

    
}
