package cs85.studentmanagement.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    List<Student> findByNameContains(String name);

    Optional<Student> findByEmailContains(String email);

    Optional<Student> findOneByStudentNumber(String stu_no);

//    #TODO: findStudentByStudentNumber(stu_no)
//    #TODO: findStudentByCity(city)

}
