package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent (Student student){
        return studentRepository.addStudent(student);
    }

    public String addTeacher (Teacher teacher){
        return studentRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair (String Sname , String Tname){
        return studentRepository.addStudentTeacherPair(Sname , Tname);
    }

   //4
    public Student StudentByStudentName (String name){
        return studentRepository.StudentByStudentName(name);
    }

    //5
     public Teacher TeacherByTeacherName (String name){
        return studentRepository.TeacherByTeacherName(name);
     }
     //6
    public List<String> getStudentByTeacherName(String teacher){
        return studentRepository.getStudentByTeacherName(teacher);
    }
    //7
    public List<String> FindAllStudent(){
        return studentRepository.FindAllStudent();

    }
    //8

    public String deleteteacherByName (String Tname){
        return studentRepository.deleteteacherByName(Tname);
    }
    public String deleteAllTeacher(){
        return studentRepository.deleteAllTeacher();

    }
}
