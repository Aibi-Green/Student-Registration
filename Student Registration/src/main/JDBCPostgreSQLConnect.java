package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			System.out.println("Successfully connected to PostgreSQL server!");
			
		} catch (SQLException e) {
			System.out.println("Failed connected to PostgreSQL server!");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public ArrayList<Students> getStudentRecords() {
		System.out.println("Getting Student Records ...");
		Connection connection = connect();
		ArrayList<Students> studentList = new ArrayList<Students>();
		Statement statement;
		ResultSet resultSet;
		Students students;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * FROM student_record;"
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
			System.out.println("Search Successful!");
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
							+ "\'"+ email +"\', \'"+ contact +"\');;"
					);
			
			System.out.println("Added Student Successful!");
		} catch (SQLException e) {
			System.out.println("Failed to add student record ... ");
			e.printStackTrace();
		}
	}
	
	public void editStudentRecord () {
		
	}
	
	public void deleteStudentRecord () {
		
	}
	
//	public static void main(String[] args) {
//		JDBCPostgreSQLConnect sqlConnect = new JDBCPostgreSQLConnect();
//		sqlConnect.addStudentRecord("2020-08760-MN-0", "Anne", "M.", "Explorer", "2021-05-11",
//				"female", "anne.explorer@gmail.com", "9063150963");
//	}

}
