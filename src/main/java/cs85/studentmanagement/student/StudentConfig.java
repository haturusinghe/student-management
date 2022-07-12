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
            repository.saveAll(
                    List.of(
                            new Student("CS/2018/015", "Jon Doe", "jon@mail.com", LocalDate.of(2000, Month.APRIL,11)),
                            new Student("CS/2018/016", "Bon Joe", "bnn@mail.com", LocalDate.of(1999, Month.JUNE,21)),
                            new Student("CS/2018/017", "Xon Was", "asew@mail.com", LocalDate.of(1998, Month.JUNE,1)),
                            new Student("CS/2018/025", "Ann Gaw", "sagasg@mail.com", LocalDate.of(1990, Month.JULY,10)),
                            new Student("CS/2018/028", "Ann Gaw", "sagasg@mail.com", LocalDate.of(1990, Month.JULY,10),"Kandu"),
                            new Student("CS/2018/036", "Wimm Gatt", "attt3123@mail.com", LocalDate.of(1980, Month.JUNE,20))
                    )

            );
        };
    }
}
