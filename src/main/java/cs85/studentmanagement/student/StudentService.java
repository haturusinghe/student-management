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
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    //Get list of student with the given name
    public List<Student> getStudent(String name) {
        return studentRepository.findByNameContains(name);
    }

    //Get list of student with the given id
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    //Get One student details for given Student Number
    public Optional<Student> findStudentByStudentNumber(String student_number) {
       return studentRepository.findOneByStudentNumber(student_number);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Boolean updateStudentEmail(Long id, String email) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            return false;
        }
        Student student = studentRepository.findById(id).get();
        student.setEmail(email);
        studentRepository.save(student);
        return true;
    }


}
