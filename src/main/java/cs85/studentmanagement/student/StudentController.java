package cs85.studentmanagement.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Get List of All Students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudent(), HttpStatus.OK);

    }

    //Add New Student
    @PostMapping
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addNewStudent(student);
    }

    /*@GetMapping(value = "/{stu_num}")
    public ResponseEntity<Student> findStudentByStudentNumber(@PathVariable("stu_num") String stu_num){
        Student student = studentService.getStudent(stu_num);
    }*/
}
