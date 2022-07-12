package cs85.studentmanagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "manage")
public class StudentViewController {


    private final StudentService studentService;

    @Autowired
    public StudentViewController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student-list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getStudent());
        return "student_list";
    }
}
