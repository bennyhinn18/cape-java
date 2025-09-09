-- Create missing tables for Department and College
USE student_management;

-- Create colleges table
CREATE TABLE `colleges` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Create departments table
CREATE TABLE `departments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `hod_name` varchar(64) DEFAULT NULL,
  `college_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `departments_colleges_FK_idx` (`college_id`),
  CONSTRAINT `departments_colleges_FK` FOREIGN KEY (`college_id`) REFERENCES `colleges` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Add department_id column to students table if it doesn't exist
ALTER TABLE `students` ADD COLUMN `department_id` int DEFAULT NULL;

-- Add foreign key constraint for department in students table
ALTER TABLE `students` ADD KEY `students_departments_FK_idx` (`department_id`);
ALTER TABLE `students` ADD CONSTRAINT `students_departments_FK` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`);

-- Insert some sample data
INSERT INTO `colleges` (`name`, `address`, `email`, `phone`) VALUES 
("Stella Mary's", '123, Main Road, Nagercoil', 'admin@smce.edu.in', '42135235256265');

INSERT INTO `departments` (`name`, `hod_name`, `college_id`) VALUES 
('Computer Science', 'John', 1);

-- Update the genders table with sample data if not already present
INSERT IGNORE INTO `genders` (`name`) VALUES ('Male'), ('Female');
