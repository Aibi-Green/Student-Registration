package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * take off white spaces at each end of strings and capitalize names
 * fix search results when searching for key words
 */

public class JDBCPostgreSQLConnect {
	// url, name, password
	
	private final String url = "jdbc:postgresql://localhost/postgres";
	private final String user = "postgres";
	private final String password = "893248";
	
	public Connection connect() {
		System.out.println("Trying to make a Connection ...");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Successfully connected to PostgreSQL server!\n");
			
		} catch (SQLException e) {
			System.out.println("Failed connected to PostgreSQL server!\n");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public boolean checkStudentIdExists(String id) {
		System.out.println("Checking if student ID:"+id+" exists in database");
		
		Connection connection = connect();
		Statement statement;
		ResultSet resultSet;
		boolean idExists = false;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT COUNT(*) FROM student_record WHERE student_id = \'"+id+"\';"
					);
			resultSet.next();
			if(resultSet.getInt(1) > 0) {
				System.out.println("ID exists!\n");
				idExists = true;
			} else {
				System.out.println("ID does not exist!\n");
			}
			
			resultSet.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idExists;
	}
	
	public ArrayList<Students> getStudentRecords() {
		System.out.println("Getting Student Records ...");
		
		Connection connection = connect();
		ArrayList<Students> studentList = new ArrayList<Students>();
		Statement statement;
		ResultSet resultSet;
		Students students;
		
		try {
			System.out.println("Collecting data from database ... ");
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * FROM student_record GROUP BY student_id ORDER BY student_id ASC;"
					);
			
			while(resultSet.next()) {
				students = new Students(
					resultSet.getString("student_id"),
					resultSet.getString("first_name"),
					resultSet.getString("middle_name"),
					resultSet.getString("last_name"),
					resultSet.getString("date_of_birth"),
					resultSet.getString("gender"),
					resultSet.getString("email"),
					resultSet.getString("contact_number")
				);
				
				studentList.add(students);
			}
			System.out.println("Successfully migrated data in ArrayList!\n");		
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Failed to migrate data in ArrayList ... \n");
			e.printStackTrace();
		}
		
		return studentList;		
	}
	
	public ArrayList<Students> searchStudentRecord (String id) {
		System.out.println("Searching for student with id: " + id);
		
		Connection connection = connect();
		ArrayList<Students> studentList = new ArrayList<Students>();
		Statement statement;
		ResultSet resultSet;
		Students students;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * FROM student_record WHERE student_id = \'"+id+"\';"
					);
			System.out.println(id);
			
			while(resultSet.next()) {
				students = new Students(
					resultSet.getString("student_id"),
					resultSet.getString("first_name"),
					resultSet.getString("middle_name"),
					resultSet.getString("last_name"),
					resultSet.getString("date_of_birth"),
					resultSet.getString("gender"),
					resultSet.getString("email"),
					resultSet.getString("contact_number")
				);
				
				studentList.add(students);
			}
			System.out.println("Search Successful!\n");
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Failed to search data with an id of " + id+ " ... \n");
			e.printStackTrace();
		}
		
		return studentList;
	}
	
	public void addStudentRecord (
			String id, String first, String middle, String last, String birth,
			String gender, String email, String contact
			) {
		Connection connection = connect();
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO student_record ("
					+ "student_id, first_name, middle_name, last_name, date_of_birth,"
					+ "gender, email, contact_number)"
					+ "VALUES (\'"+ id +"\', \'"+ first +"\', \'"+ middle +"\',"
							+ "\'"+ last +"\', DATE \'"+ birth +"\', \'"+ gender +"\',"
							+ "\'"+ email +"\', \'"+ contact +"\');"
				);
			
			System.out.println("Added Student Successful!\n");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Failed to add student record ... \n");
			e.printStackTrace();
		}
	}
	
	public void editStudentRecord (
			String id, String first, String middle, String last, String birth,
			String gender, String email, String contact
			) {
		Connection connection = connect();
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE student_record SET "
					+ "first_name = \'"+first+"\', "
					+ "middle_name = \'"+middle+"\', "
					+ "last_name = \'"+last+"\', "
					+ "date_of_birth = DATE \'"+birth+"\', "
					+ "gender = \'"+gender+"\', "
					+ "email = \'"+email+"\', "
					+ "contact_number = \'"+contact+"\' "
					+ "WHERE student_id = \'"+id+"\';"
				);
			
			System.out.println("Updated student record Successfully!\n");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Failed to update student record ... \n");
			e.printStackTrace();
		}
	}
	
	public void deleteStudentRecord (String id) {
		Connection connection = connect();
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(
					"DELETE FROM student_record WHERE student_id = \'"+id+"\';"
				);
			
			System.out.println("Delete student with a student ID of"
					+ "\n"+id+"\nSuccessfully!\n");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Failed to delete student id record ... \n");
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		JDBCPostgreSQLConnect sqlConnect = new JDBCPostgreSQLConnect();
////		sqlConnect.editStudentRecord("2020-08760-MN-0", "Anne", "M.", "Explorer", "2021-06-11",
////				"female", "anne.lariosa@gmail.com", "9063150963");
//		sqlConnect.checkStudentIdExists("2020-07760-MN-0");
//	}

}
