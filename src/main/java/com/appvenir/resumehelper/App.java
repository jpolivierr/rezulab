package com.appvenir.resumehelper;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.appvenir.resumehelper.domain.prompt.Prompt;
import com.appvenir.resumehelper.domain.resumeBuilder.Experience;
import com.appvenir.resumehelper.domain.resumeBuilder.ResumeBuilder;
import com.appvenir.resumehelper.domain.resumeBuilder.ResumeBuilderService;
import com.appvenir.resumehelper.domain.user.UserService;
import com.appvenir.resumehelper.domain.user.dto.UserDto;
import com.appvenir.resumehelper.domain.user.dto.UserRegistrationDto;

@SpringBootApplication
public class App{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(UserService userService, ResumeBuilderService resumeBuilderService) {
        return args -> {

			var experience = new Experience();
			experience.setCompany("ReminderMedia");
			experience.setJobTitle("Software Engineer");
			experience.setJobDescription("Build software");
			experience.setStartDate(LocalDate.of(2021, 3, 26));
			experience.setEndDate(LocalDate.of(2024, 7, 22));

			var resumeBuilder = new ResumeBuilder();
	        resumeBuilder.setJobDescription("this job is for software engineers that works hard");
			// resumeBuilder.removeExperience(experience);

			//  var savedResumeBuilder = resumeBuilderService.saveResumeBuilder(resumeBuilder);
			// System.out.println(savedResumeBuilder);
            // var user = new UserRegistrationDto();
			// user.setName("Frederic Olivier");
			// user.setEmail("jp@gmail.com");
			// user.setPassword("somepassword");

			// var prompt = new Prompt();
			// prompt.setContext("Generate a summary for the following article.");
			// prompt.setInstructions("Write a summary in 3-4 sentences highlighting the main points.");
			// prompt.setExamples("For instance, 'The article discusses the impact of climate change on polar bears, noting significant habitat loss and changes in migration patterns.");
			// prompt.setConstraints("The summary should be no longer than 100 words and should use formal language.");
			// prompt.setScope("Concentrate on the economic implications of the new policy rather than its political background.");
			// prompt.setAudience("Explain the concept in simple terms suitable for a high school student.");

			// System.out.println(prompt.build());

			// UserDto userDto = userService.saveUser(user);
        };
    }

}
