CREATE DATABASE `student_management1`;

CREATE TABLE `genders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `students_genders_FK_idx` (`gender_id`) /*!80000 INVISIBLE */,
  KEY `students_name_search_INDEX` (`name`),
  CONSTRAINT `students_genders_FK` FOREIGN KEY (`gender_id`) REFERENCES `genders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='		\n';

INSERT INTO `student_management`.`genders` (`name`) VALUES ('Male');
INSERT INTO `student_management`.`genders` (`name`) VALUES ('Female');