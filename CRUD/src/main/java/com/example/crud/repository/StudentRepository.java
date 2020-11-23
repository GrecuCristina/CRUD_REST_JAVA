package com.example.crud.repository;

import com.example.crud.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    List<Student>studentList = new ArrayList<>();

    public Student createStudent(Student student) {
        student.setId(studentList.size()+1);
        studentList.add(student);
        return student;
    }

    public Optional<Student> getStudent(int id) {
        return studentList.stream().filter(student -> student.getId() == id).findFirst();
    }

    public Student getOneStudent(int id){
        return studentList.get(id);
    }
    public Student updateStudent(Student student, int id) {
        System.out.println("id ul este = "+id + student.getFaculty()+ student.getFirstName());
        int counter = 0;
        for( Student student1 : studentList){
            if(student1.equals(student)){
                studentList.set(counter, student);
               // student1 = student;
                System.out.println("vechiul student are facultatea = "+ student1.getFaculty());
                return student;
            }
            counter ++;
            //System.out.println("id ul este = "+id);
        }
        return student;
    }



    public boolean removeStudent(Student student) {
        System.out.println("remove student in repository " + student);
        Optional<Student> studentToRemove = studentList.stream().filter(student1 -> student1.equals(student)).findFirst();
        if(studentToRemove.isPresent()){
            studentList.remove(studentToRemove);
            return true;

        }
        return false;

    }

    public List<Student> getAllStudents() {
        System.out.println(studentList);
        List<Student> students = new ArrayList<>();
        students = studentList.stream().collect(Collectors.toList());
        return students;
    }
}
