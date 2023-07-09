package com.nikitha.jpa.dao;
import java.util.List;

import com.nikitha.jpa.model.Address;
import com.nikitha.jpa.model.Student;


public interface StudentDaoInterface 
{
   String addStudent(Student student);
   String updateStudent(Student student);
   String deleteStudent(Integer studentId);
   Student findByStudentId(Integer studentId);
   Address findByAddressId(Integer addressId);
   List<Student> findByStudentName(String firstName);
   List<Address> findByCity(String city);
   List<Address> findByState(String state);
   List<Student> findAllStudent();
   List<Address> findAllAddress();
}
