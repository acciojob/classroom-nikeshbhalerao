package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String , Student> S = new HashMap<>();;
    HashMap<String  , Teacher> T = new HashMap<>();
    HashMap<String  , List<String>> pairST = new HashMap<>();


    public String addStudent(Student student) {
        String name = student.getName();
        if (!S.containsKey(name)) {
            S.put(name, student);
        }
        return "Student added successfully";
    }

    public String addTeacher(Teacher teacher){
        String name = teacher.getName();
        if(!T.containsKey(name)){
            T.put(name , teacher);
        }
        return "Teacher added successfully";
    }

    public String addStudentTeacherPair(String Sname , String Tname){
        if(!S.containsKey(Sname) || !T.containsKey(Tname)){
            if(pairST.containsKey(Tname)){
                pairST.get(Tname).add(Sname);
            }
            else{
                List<String> ans  = new ArrayList<>();

                ans.add(Tname);
                pairST.put(Sname , ans);
            }
        }
        return "Teacher and Student pair added successfully";
    }

    //Get Student by student name; 4
    public Student StudentByStudentName (String name){
        if(!S.containsKey(name)){
            return null;
        }else{
            return S.get(name);
        }
    }

    //Get Teacher by teacher name: 5
    public Teacher TeacherByTeacherName (String name){
        if(!T.containsKey(name)){
            return null;
        }else{
            return T.get(name);
        }
    }

    //Get List of students name for a given teacher name:6
    public List<String> getStudentByTeacherName(String teacher){
        return pairST.get(teacher);
    }

    //Get List of all students added:7

     public List<String> FindAllStudent(){
        List<String> ans = new ArrayList<>();
        for(String Sname : S.keySet() ){
            ans.add(Sname);
        }
        return ans;
     }

  //Delete a teacher and its students from the records:8

    public String deleteteacherByName (String Tname){
        List<String> student  = pairST.get(Tname);
        for(int i =0 ;i<student.size() ; i++){
            if(S.containsKey(student.get(i))){
                S.remove(student.get(i));
            }
        }
        pairST.remove(Tname);
        if(T.containsKey(Tname)){
            T.remove(Tname);
        }
        return "Delete a teacher and its students from the records";
    }

    public String deleteAllTeacher(){
        for (String dir: pairST.keySet()) {
            List<String> lis = pairST.get(dir);
            for (String name: lis) {
                if(S.containsKey(name)){
                    S.remove(name);
                }
            }
            T.remove(dir);
        }
        for (String d: T.keySet()) {
            T.remove(d);
        }

        return "All teacher and all of their student removed successfully";
    }
}
