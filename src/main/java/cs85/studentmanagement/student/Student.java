package cs85.studentmanagement.student;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "^[A-Z]{2}\\/2[0-9]{3}\\/[0-9]{3}$",
            message = "Student Number must be in correct format")
    private String studentNumber;

    @NotBlank
    @Pattern(regexp="^[A-Z a-z]*$",message = "Must only contain Characters")
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String city;

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(String studentNumber, String name, String email, LocalDate dob) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String studentNumber, String name, String email, LocalDate dob, String city) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.city = city;
    }

    //Customer Getter for Age
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
