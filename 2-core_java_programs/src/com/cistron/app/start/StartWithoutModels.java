package com.cistron.app.start;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class StartWithoutModels {

    public static void main(String[] args) {
        // Without models - everything is raw SQL and HashMap/ResultSet manipulation
        
        // Instead of: Student student = feedStudentData();
        Map<String, Object> studentData = feedStudentDataWithoutModels();
        
        // Instead of: printStudentData(student);
        printStudentDataWithoutModels(studentData);
    }

    private static Map<String, Object> feedStudentDataWithoutModels() {
        // Messy data structure - no type safety
        Map<String, Object> student = new HashMap<>();
        Map<String, Object> department = new HashMap<>();
        Map<String, Object> college = new HashMap<>();
        Map<String, Object> gender = new HashMap<>();
        
        // No IDE autocompletion, no compile-time checking
        college.put("id", 1);
        college.put("name", "Stella Mary's");
        college.put("address", "123, Main Road, Nagercoil");
        college.put("email", "admin@suncollege.com");
        college.put("phone", "42135235256265");
        
        department.put("id", 1);
        department.put("hodName", "John"); // What if you mistype "hodname"?
        department.put("name", "Computer Science");
        department.put("college", college);
        
        gender.put("id", 1);
        gender.put("name", "Male");
        
        student.put("id", 1);
        student.put("name", "Babu");
        student.put("address", "12, Barathi Nagar, Nagercoil");
        student.put("email", "babu@newmail.com");
        student.put("phone", "4235436346436");
        student.put("department", department);
        student.put("gender", gender);
        
        return student;
    }
    
    private static void printStudentDataWithoutModels(Map<String, Object> student) {
        // Ugly, error-prone casting everywhere
        System.out.println("Student Id: " + student.get("id"));
        System.out.println("Student Name: " + student.get("name"));
        System.out.println("Student Address: " + student.get("address"));
        System.out.println("Student Phone Number: " + student.get("phone"));
        System.out.println("Student Email: " + student.get("email"));
        
        // Nested casting - very error prone!
        Map<String, Object> gender = (Map<String, Object>) student.get("gender");
        System.out.println("Student Gender: " + gender.get("name"));
        
        Map<String, Object> department = (Map<String, Object>) student.get("department");
        System.out.println("Department Name: " + department.get("name"));
        System.out.println("HOD Name: " + department.get("hodName"));
        
        Map<String, Object> college = (Map<String, Object>) department.get("college");
        System.out.println("College Name: " + college.get("name"));
        System.out.println("College Address: " + college.get("address"));
        System.out.println("College Email: " + college.get("email"));
        System.out.println("College Phone Number: " + college.get("phone"));
    }
}
