package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent =  studentService.createStudent(student);
        return  new ResponseEntity<>(createdStudent, null == createdStudent ? HttpStatus.EXPECTATION_FAILED : HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){

        Student student = studentService.getStudent(id);
        return new ResponseEntity<>(student, null == student ? HttpStatus.EXPECTATION_FAILED : HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){

        Student updatedStudent = studentService.updateStudent(student, id);
        return new ResponseEntity<>(updatedStudent, null == student ? HttpStatus.EXPECTATION_FAILED : HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>removeStudent(@PathVariable int id){
        boolean removed = studentService.removeStudent(id);
        return new ResponseEntity<>(removed, HttpStatus.OK);
    }

    @GetMapping()
    public List<Student>getAllStudents(){

        return studentService.getAllStudents();
    }

}
