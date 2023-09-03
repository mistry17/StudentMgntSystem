package com.example.SpringBootForm.controller;

import com.example.SpringBootForm.entity.Student;
import com.example.SpringBootForm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


//    @GetMapping("students")
//        public List<Student>getstudents(){
//        return studentService.getStudents();
//}

    @GetMapping("students")
    public String listOfStudents(Model model){
        model.addAttribute("students",studentService.getStudents());
        return "students";
    }

//    @PostMapping("add-student")
//        public String addEmployee(@RequestBody Student student){
//         studentService.addEmployee(student);
//        return "Student added successfully";
//}

    @GetMapping("students/new")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "register-form";
    }

//    @GetMapping("index")
//    public String opernIndex(){
//        return "index";
//    }
//
//    @GetMapping("register")
//    public String openForm(Model model){
//        Student student = new Student();
//        model.addAttribute("student",student);
//        return "register";
   //     }

    @PostMapping("students")
        public String saveStudent(@ModelAttribute("student")Student student){
            studentService.saveStudent(student);
            return "redirect:/students";
    }

    @GetMapping("students/edit/{studentId}")
    public String editStudentForm(@PathVariable int studentId, Model model){
        model.addAttribute("student",studentService.getStudentById(studentId));
        return "edit";
    }

   @PostMapping("students/{studentId}")
     public String updateStudent(@PathVariable int studentId,
                                 @ModelAttribute("student")
                                 Student student,Model model){
        Student existingStudent = studentService.getStudentById(studentId);
        existingStudent.setStudentId(studentId);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setCountry(student.getCountry());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setMobileNumber(student.getMobileNumber());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setGender(student.getGender());
        studentService.updateStudent(existingStudent);
      //return "Student edited successfully";
       return "redirect:/students";
   }

   @GetMapping("students/{studentId}")
   public String deleteStudent(@PathVariable int studentId){
         studentService.deleteStudent(studentId);
         return "redirect:/students";
      // return "Student deleted";
   }
}
