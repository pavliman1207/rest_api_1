package com.example.api1.Student;

import java.util.List;

public interface StudentService {

  List<Student> findAll() throws InterruptedException;

  void createStudent(Student student) throws InterruptedException;


  Student getStudentById(int id) throws InterruptedException;
 boolean deleteStudentById(int id) throws InterruptedException;


  boolean updateStudentFam(int id, String fam) throws InterruptedException;
}
