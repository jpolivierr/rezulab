package com.appvenir.resumehelper;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.appvenir.resumehelper.domain.experience.Experience;
import com.appvenir.resumehelper.domain.experience.ExperienceMapper;
import com.appvenir.resumehelper.domain.experience.ExperienceService;
import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.prompt.Prompt;
import com.appvenir.resumehelper.domain.resumeBuilder.ResumeBuilder;
import com.appvenir.resumehelper.domain.resumeBuilder.ResumeBuilderService;
import com.appvenir.resumehelper.domain.resumeBuilder.dto.ResumeBuilderDto;
import com.appvenir.resumehelper.domain.user.UserService;
import com.appvenir.resumehelper.domain.user.dto.UserDto;
import com.appvenir.resumehelper.domain.user.dto.UserRegistrationDto;

@SpringBootApplication
public class App{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(
		UserService userService, 
		ResumeBuilderService resumeBuilderService,
		ExperienceService experienceService,
		ExperienceMapper experienceMapper
		) {
        return args -> {

			// var newUser = new UserRegistrationDto();
			// newUser.setName("Frederic Olivier");
			// newUser.setEmail("jp@gmail.com");
			// newUser.setPassword("Somepassword");

			var user = new UserDto();
			user.setName("Frederic Olivier");
			user.setEmail("jp@gmail.com");

			// userService.saveUser(newUser);

			var exp1 = new ExperienceDto();
			exp1.setCompany("Vultr");
			exp1.setJobTitle("Web Designer");
			exp1.setJobDescription("Design application for the web");
			exp1.setStartDate(LocalDate.of(2021, 3, 26));
			exp1.setEndDate(LocalDate.of(2024, 7, 22));

			var exp2 = new ExperienceDto();
			exp2.setCompany("Zara");
			exp2.setJobTitle("Cashier");
			exp2.setJobDescription("Worked with registered");
			exp2.setStartDate(LocalDate.of(2021, 3, 26));
			exp2.setEndDate(LocalDate.of(2024, 7, 22));

			List<ExperienceDto> experiences = List.of(exp1, exp2);
			// experienceService.addExperiences(user.getEmail(), experiences);
;            // experienceService.addExperience(user.getEmail(), exp2);
			// userService.addExperience(user, experience);
			// userService.removeExperiencese(user, Long.valueOf(1));
			// userService.updateExperience(user, Long.valueOf(2), experience);

			List<Long> experienceIds = List.of(Long.valueOf(2));

			var resumeBuilderDto = new ResumeBuilderDto();
	        resumeBuilderDto.setJobDescription("this job is for software engineers that works hard");
			// resumeBuilderService.addExperiences(user.getEmail(), Long.valueOf(1), experienceIds);
			// resumeBuilder.addExperiences(List.of(experienceMapper.toEntity(experience)));
			// resumeBuilder.removeExperience(experience);
			// resumeBuilderService.saveResumeBuilder(user, resumeBuilderDto);

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
