package com.appvenir.resumehelper.domain.prompt.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.prompt.dto.PromptDto;
import com.appvenir.resumehelper.domain.resumeTemplate.dto.ResumeTemplateDto;

@Component
public class PromptFactory {

    private static String experienceTextFormat(ExperienceDto experience)
    {
        String experience1 ="Company: " + experience.getCompany() + "\n" +
                            "About company: " + experience.getJobDescription() + "\n" +
                            "Job Title: " + experience.getJobTitle() + "\n" +
                            "From: " + experience.getStartDate() + " - " + experience.getEndDate() + "\n" ;
        return experience1;
    }

   
    public static PromptDto getResumeTemplatePrompt(PromptDto prompt, List<ExperienceDto> experiences, ResumeTemplateDto resumeTemplate)
    {
        
        StringBuilder content = new StringBuilder();

        String skills = "My Skills are: Programming Languages: Java, Spring Boot, Node.js, TypeScript. "+ 
                "Web Technologies: HTML, CSS, Java script, TypeScript, React.js, RESTful APIs, JSON" +
                "Databases & Cloud: MySQL, PostgreSQL, Vultr" +
                "Tools & Platforms: Git, Docker, RabbitMq, Redis, JIRA, Unix/Linux, CI/CD.";

        content.append(skills).append("\n\n");

        if(experiences.size() > 0)
        {
            content.append("My experience: \n");
            for(ExperienceDto experience : experiences)
            {
              content.append(experienceTextFormat(experience)).append("\n");
            }
        }

        String jobDescription = "Here is the job description: \n\n" + resumeTemplate.getJobDescription();

        prompt.setExamples(content + jobDescription);

        return prompt;
    }
    
}
