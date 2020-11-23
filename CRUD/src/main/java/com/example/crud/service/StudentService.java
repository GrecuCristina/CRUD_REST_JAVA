package com.example.crud.service;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public Student getStudent(int id) {

        Optional <Student> student = studentRepository.getStudent(id);
        if(student.isPresent()){
            return student.get();
        }
        else{
            throw new RuntimeException("Student not found");
        }
    }

    public Student updateStudent(Student student, int id) {
//        Optional<Student>updatedStudent = studentRepository.updateStudent(student, id);
//
//        if(updatedStudent.isPresent()){
//            return updatedStudent.get();
//        }
//        else{
//            throw new RuntimeException("Cannot update Student");
//        }
        return studentRepository.updateStudent(student, id);
    }

    public boolean removeStudent(int id) {
        Student student = studentRepository.getOneStudent(id);

        return studentRepository.removeStudent(student);

    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
