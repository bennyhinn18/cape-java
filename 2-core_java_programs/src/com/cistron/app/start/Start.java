package com.cistron.app.start;

import com.cistron.app.student.model.Gender;
import com.cistron.app.student.model.Student;
import com.cistron.training.sample.DataManipulation;
import com.cistron.training.sample.FileManipulation;
import com.cistron.training.sample.NetworkUtil;
import com.cistron.training.thread.ThreadRunExample;
import com.cistron.app.department.model.Department;
import com.cistron.app.student.model.College;

public class Start {

	public Start(){
	 //Initialize
	}

	public static void main(String[] args) {		
		System.out.println("This is the Start of the program");
		
		Start start = new Start();
		
//		Student student = new Student();
//		student.setId(22);
//		student.setAddress("wdsfsdfee");
//		
//		
//		Student newlyAddedStudent = start.feedStudentData();
//		
//		start.printStudentData(newlyAddedStudent);
		
		FileManipulation fileManipulation = new FileManipulation();
		fileManipulation.createFile();
		fileManipulation.writeFile();
		fileManipulation.readFile();
		fileManipulation.deleteFile();
		
//		ThreadRunExample threadRunExample = new ThreadRunExample();
//		threadRunExample.threadDemo();
		
//		NetworkUtil networkUtil = new NetworkUtil(); 		
//		networkUtil.downloadWebPage("http://www.google.com", "webpage.html");
//		networkUtil.advancedDownload("http://www.google.com", "webpageAdv.html");
		
		
		
//		DataManipulation dataManipulation = new DataManipulation();
//		
//		dataManipulation.readDataFromDatabase();
//		dataManipulation.insertDataIntoDatabase();
//		dataManipulation.readDataFromDatabase();
//		dataManipulation.updateDataToDatabase();
//		dataManipulation.readDataFromDatabase();
//		dataManipulation.deleteDataFromDatabase();
//		dataManipulation.readDataFromDatabase();
				
	}

	private Student feedStudentData() {
		
		Student student = new Student();
		Department department = new Department();
		College college = new College();
		Gender gender = new Gender();
		
		college.setId(1);
		college.setName("SSSSS College");
		college.setAddress("123,  Main Road, Nagercoil");
		college.setEmail("admin@suncollege.com");
		college.setPhone("42135235256265");
		
		department.setId(1);
		department.setHODName("John");
		department.setName("Computer Science");
		department.setCollege(college);
		
		gender.setId(1);
		gender.setName("Male");
		
		student.setId(1);
		student.setName("Babu");
		student.setAddress("12, Barathi Nagar, Nagercoil");
		student.setEmail("babu@newmail.com");
		student.setPhone("4235436346436");
		student.setDepartment(department);
		student.setGender(gender);
		
		return student;
	}
		
	private void printStudentData(Student student) {
	
		System.out.println("Student Id: "+student.getId());
		System.out.println("Student Name: "+student.getName());
		System.out.println("Student Address: "+student.getAddress());
		System.out.println("Student Phone Number: "+student.getPhone());
		System.out.println("Student Email: "+student.getEmail());
		System.out.println("Student Genger: "+student.getGender().getName());
		System.out.println("Department Name: "+student.getDepartment().getName());
		System.out.println("HOD Name: "+student.getDepartment().gethodName());
		System.out.println("College Name: "+student.getDepartment().getCollege().getName());
		System.out.println("College Address: "+student.getDepartment().getCollege().getAddress());
		System.out.println("College Email: "+student.getDepartment().getCollege().getEmail());
		System.out.println("College Phone Number: "+student.getDepartment().getCollege().getPhone());
	}
	
	
}

