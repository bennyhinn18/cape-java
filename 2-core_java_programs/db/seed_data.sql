-- Seed data for student_management database
USE student_management;

-- Clear existing data (optional - uncomment if you want to start fresh)
-- DELETE FROM students;
-- DELETE FROM departments;
-- DELETE FROM colleges;
-- DELETE FROM genders;

-- Reset auto increment (optional - uncomment if you cleared data)
-- ALTER TABLE students AUTO_INCREMENT = 1;
-- ALTER TABLE departments AUTO_INCREMENT = 1;
-- ALTER TABLE colleges AUTO_INCREMENT = 1;
-- ALTER TABLE genders AUTO_INCREMENT = 1;

-- Insert Genders
INSERT IGNORE INTO genders (id, name) VALUES 
(1, 'Male'),
(2, 'Female'),
(3, 'Other');

-- Insert Colleges
INSERT IGNORE INTO colleges (id, name, address, email, phone) VALUES 
(1, 'SMCE ', '123, Main Road, Nagercoil', 'admin@smce.edu.in', '42135235256265'),
(2, 'St. Joseph College', '456, Church Street, Trivandrum', 'info@stjoseph.edu', '471234567890'),
(3, 'Government Engineering College', '789, College Road, Kochi', 'contact@gec.ac.in', '484567891234'),
(4, 'Anna University', 'Sardar Patel Road, Guindy, Chennai', 'registrar@annauniv.edu', '044567891234'),
(5, 'VIT University', 'Vellore Institute of Technology, Vellore', 'admissions@vit.ac.in', '416234567890');

-- Insert Departments
INSERT IGNORE INTO departments (id, name, hod_name, college_id) VALUES 
(1, 'Computer Science', 'Dr. John Smith', 1),
(2, 'Electronics and Communication', 'Dr. Mary Johnson', 1),
(3, 'Mechanical Engineering', 'Dr. Robert Brown', 1),
(4, 'Civil Engineering', 'Dr. Sarah Davis', 2),
(5, 'Information Technology', 'Dr. Michael Wilson', 2),
(6, 'Electrical Engineering', 'Dr. Jennifer Garcia', 3),
(7, 'Chemical Engineering', 'Dr. David Martinez', 3),
(8, 'Biotechnology', 'Dr. Lisa Anderson', 4),
(9, 'Aerospace Engineering', 'Dr. James Taylor', 4),
(10, 'Computer Applications', 'Dr. Patricia Thomas', 5);

-- Insert Students
INSERT IGNORE INTO students (id, name, address, phone_number, email, gender_id, department_id) VALUES 
-- Computer Science Students
(1, 'Babu Raj', '12, Barathi Nagar, Nagercoil', '9876543210', 'babu@newmail.com', 1, 1),
(2, 'Priya Sharma', '45, Gandhi Street, Chennai', '9876543211', 'priya.sharma@email.com', 2, 1),
(3, 'Arjun Kumar', '78, MG Road, Bangalore', '9876543212', 'arjun.kumar@email.com', 1, 1),
(4, 'Sneha Reddy', '23, Park Avenue, Hyderabad', '9876543213', 'sneha.reddy@email.com', 2, 1),
(5, 'Vikram Singh', '56, Mall Road, Delhi', '9876543214', 'vikram.singh@email.com', 1, 1),

-- Electronics Students
(6, 'Kavya Nair', '34, Beach Road, Kochi', '9876543215', 'kavya.nair@email.com', 2, 2),
(7, 'Rajesh Gupta', '67, Station Road, Mumbai', '9876543216', 'rajesh.gupta@email.com', 1, 2),
(8, 'Anita Patel', '89, Ring Road, Ahmedabad', '9876543217', 'anita.patel@email.com', 2, 2),

-- Mechanical Engineering Students
(9, 'Suresh Babu', '12, Industrial Area, Coimbatore', '9876543218', 'suresh.babu@email.com', 1, 3),
(10, 'Deepika Iyer', '45, Tech Park, Pune', '9876543219', 'deepika.iyer@email.com', 2, 3),

-- Civil Engineering Students
(11, 'Karthik Menon', '78, Construction Lane, Kottayam', '9876543220', 'karthik.menon@email.com', 1, 4),
(12, 'Ritu Verma', '23, Builder Street, Jaipur', '9876543221', 'ritu.verma@email.com', 2, 4),

-- IT Students
(13, 'Anil Krishna', '56, Software City, Trivandrum', '9876543222', 'anil.krishna@email.com', 1, 5),
(14, 'Meera Pillai', '34, IT Park, Thiruvananthapuram', '9876543223', 'meera.pillai@email.com', 2, 5),

-- Electrical Engineering Students
(15, 'Ramesh Kumar', '67, Power Grid Road, Kochi', '9876543224', 'ramesh.kumar@email.com', 1, 6),
(16, 'Lakshmi Devi', '89, Electrical Avenue, Kollam', '9876543225', 'lakshmi.devi@email.com', 2, 6),

-- Chemical Engineering Students
(17, 'Gopal Krishnan', '12, Chemical Complex, Kochi', '9876543226', 'gopal.krishnan@email.com', 1, 7),
(18, 'Sunitha Raj', '45, Refinery Road, Chennai', '9876543227', 'sunitha.raj@email.com', 2, 7),

-- Biotechnology Students
(19, 'Mahesh Sharma', '78, Bio Park, Chennai', '9876543228', 'mahesh.sharma@email.com', 1, 8),
(20, 'Divya Nair', '23, Research Center, Chennai', '9876543229', 'divya.nair@email.com', 2, 8),

-- Aerospace Engineering Students
(21, 'Vinod Kumar', '56, Aerospace City, Chennai', '9876543230', 'vinod.kumar@email.com', 1, 9),
(22, 'Shalini Reddy', '34, Aviation Road, Chennai', '9876543231', 'shalini.reddy@email.com', 2, 9),

-- Computer Applications Students
(23, 'Praveen Raj', '67, App Development Center, Vellore', '9876543232', 'praveen.raj@email.com', 1, 10),
(24, 'Nisha Patel', '89, Software Solutions, Vellore', '9876543233', 'nisha.patel@email.com', 2, 10),
(25, 'Manoj Kumar', '12, Digital Hub, Vellore', '9876543234', 'manoj.kumar@email.com', 1, 10);

-- Display inserted data summary
SELECT 'Data Seeding Complete!' as Message;
SELECT COUNT(*) as 'Total Colleges' FROM colleges;
SELECT COUNT(*) as 'Total Departments' FROM departments;
SELECT COUNT(*) as 'Total Genders' FROM genders;
SELECT COUNT(*) as 'Total Students' FROM students;
