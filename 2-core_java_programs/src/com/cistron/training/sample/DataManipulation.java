package com.cistron.training.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataManipulation {

	public DataManipulation() {
		
	}

	String hostname = "localhost";
	int port = 3306;
	String databaseName = "student_management";
	String dbUsername = "root";
	String dbPassword = "rootpassword";
	
	public void readDataFromDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);

			//String query = "SELECT * FROM students";
			String query = "SELECT students.id, students.name, students.address, students.phone_number, students.email, genders.name AS 'gender' FROM student_management.students, student_management.genders WHERE students.gender_id = genders.id";			
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			int totalRecords = 0;
			while(resultSet.next()) {
				System.out.println("Id: " + resultSet.getInt("id"));
				System.out.println("Name: " + resultSet.getString("name"));
				System.out.println("Address: " + resultSet.getString("address"));
				System.out.println("Phone Number: " + resultSet.getString("phone_number"));
				System.out.println("Email Address: " + resultSet.getString("email"));
				System.out.println("Gender: " + resultSet.getString("gender"));
				totalRecords++;
			}
			
			if(totalRecords>0) {
				System.out.println("Total Records: "+ totalRecords);
			} else {
				System.out.println("No Records found");
			}
			
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;					
				} catch (final Exception res) {
					res.printStackTrace();
				}
			}
			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;					
				} catch (final Exception res) {
					res.printStackTrace();
					resultSet = null;
				}
			}			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;					
				} catch (final Exception res) {
					res.printStackTrace();
					resultSet = null;
				}
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}

	public void insertDataIntoDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);
			
			//String query = "SELECT * FROM students";
			String query = "INSERT INTO `students`(`name`,`address`,`phone_number`,`email`,`gender_id`) VALUES ('Example Name', 'Example Address', 'Example Phone', 'Example Email', 3)";			
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();		
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}	

	public void updateDataToDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);
			
			//String query = "UPDATE `students` SET `gender_id` = 2 WHERE id = 1";
			String query = "UPDATE `students` SET `gender_id` = 4";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();		
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}	

	public void deleteDataFromDatabase() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			String datasourceURL = "jdbc:mysql://"+hostname+":"+port+"/"+databaseName+"?useSSL=false&allowPublicKeyRetrieval=True";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(datasourceURL, dbUsername, dbPassword);
			
			//String query = "SELECT * FROM students";
			String query = "DELETE FROM students";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception e) {
					connection = null;
				}
			}
			
		} catch (final Exception e) {
			e.printStackTrace();		
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			if (connection != null) {
				try {
					connection.close();
					connection = null;				
				} catch (Exception cone) {
					cone.printStackTrace();
					connection = null;
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;					
				} catch (final Exception stmte) {
					stmte.printStackTrace();
					preparedStatement = null;
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (Exception e) {
					e.printStackTrace();
					connection = null;
				}
			}

		}

	}
	
}
