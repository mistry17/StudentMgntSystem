package com.example.SpringBootForm.service;

import com.example.SpringBootForm.entity.Student;
import com.example.SpringBootForm.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
//    List<Student> students = new ArrayList<>();
    @Autowired
    private StudentRepo studentRepo;
    public  List<Student> getStudents() {
        return studentRepo.findAll();
    }
    public String addEmployee(Student student) {
     studentRepo.save(student);
    return "Student added";
    }
//    public Student updateEmployee( int studentId,String name) {
//        Optional<Student> student = studentRepo.findById(studentId);
//        if(student.isEmpty()){
//        System.out.println("Student by the id " + studentId + " is not found");
//        }else{
//         student.get().setFirstName(name);
//         return studentRepo.save(student.get());
//        // return "Employee updated succesfully";
//            }
//        return student ;
//    }

    public Student updateStudent(Student student){
       return studentRepo.save(student);
    }

    public Student getStudentById(int studentId){
        return studentRepo.findById(studentId).get();
    }
    public void deleteStudent(int id) {
//        Optional<Student> studentOptional = studentRepo.findById(id);
//        if(studentOptional.isEmpty()){
//        return "Student with id " + id + " not found";
//        }else{
//        studentRepo.delete(studentOptional.get());
//        return "Student with id "+ id + " deleted successfully ";
//            }
        studentRepo.deleteById(id);
    }
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
}
