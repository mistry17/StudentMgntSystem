package com.example.SpringBootForm;

import com.example.SpringBootForm.entity.Student;
import com.example.SpringBootForm.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringBootFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFormApplication.class, args);
	}

	@Autowired
	private StudentRepo studentRepo;

//	@Override
//	public void run(String... args) throws Exception {
//
//
//		Student student1 = new Student(1,"Dharmik","Mistry","Mumbai",8521479l,"dharmik@gmial.com","India","Male","BE");
//		studentRepo.save(student1);
//	}


}
