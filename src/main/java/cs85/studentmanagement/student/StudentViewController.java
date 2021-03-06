package cs85.studentmanagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student";

    }

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addNewStudent(student);
        return "redirect:/manage/student-list";
    }

    @GetMapping("/student/{id}")
    public String editStudent(@PathVariable Long id,Model model) {
        model.addAttribute("student", studentService.getStudent(id).get());
        return "edit_student";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student ,Model model) {
        studentService.addNewStudent(student);
        return "redirect:/manage/student-list";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/manage/student-list";
    }
}
