package cs85.studentmanagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Gets a List of All students
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    //Add new student
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    //Get list of student with the given name
    public List<Student> getStudent(String name) {
        return studentRepository.findByNameContains(name);
    }

    public Optional<Student> findStudentByStudentNumber(String student_number) {
       return studentRepository.findOneByStudentNumber(student_number);
    }
}
