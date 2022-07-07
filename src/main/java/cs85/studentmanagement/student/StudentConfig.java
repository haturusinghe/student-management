package cs85.studentmanagement.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//CS/2018/015, Jon, Doe, jon@mail.com, LocalDate dob
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            repository.saveAll(List.of(new Student("CS/2018/015", "Jon", "Doe", "jon@mail.com", LocalDate.of(2000, Month.APRIL,11))));
        };
    }
}
