package cs85.studentmanagement.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    //Find Student By Id
    @GetMapping(path = "{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Optional<Student> result = studentService.getStudent(id);

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result.get());
    }

    //Find Student By Name
    @GetMapping(params = "name")
    public List<Student> getStudent(@RequestParam(required = true) String name){
        return studentService.getStudent(name);
    }

    //Find Student By Name
    @GetMapping(params = "student_number")
    public ResponseEntity<Student> findStudentByStudentNumber(@RequestParam(required = true) String student_number){
        Optional<Student> result = studentService.findStudentByStudentNumber(student_number);

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result.get());
    }

    //Add New Student
    @PostMapping
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //Update a Students Email
    @PutMapping(path = "{id}",params = "email") //#TODO : Not Working Check!
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id,@RequestParam(name = "email",required = true) String email){
        Boolean res = studentService.updateStudentEmail(id, email);
        if(!res){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Updated Email");
    }

    //Delete an Existing Student
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id ) {
        studentService.deleteStudent(id);
    }



}
