package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import connect.DBConnUtil;
import connect.DBPropertyUtil;

public class StudentService {
	
	
	public void addStudent(Student student) {
        try (Connection conn = DBConnUtil.getConnection(DBPropertyUtil.getConnectionFromProperties("db.properties"))) {
            String query = "INSERT INTO Student (Roll, Name, Fee) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, student.getRollNo());
            stmt.setString(2, student.getName());
            stmt.setDouble(3, student.getFee());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void removeStudent(int rollno) {
		try (Connection conn = DBConnUtil.getConnection(DBPropertyUtil.getConnectionFromProperties("db.properties"))){
			String query = "DELETE FROM Student where Roll=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, rollno);
			stmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void removeByFee(double fee) {
		try (Connection conn = DBConnUtil.getConnection(DBPropertyUtil.getConnectionFromProperties("db.properties"))){
			String query = "DELETE FROM Student where Fee<?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setDouble(1, fee);
			stmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Student> showAllStudents() {
		List<Student> student = new ArrayList();
		try(Connection conn = DBConnUtil.getConnection(DBPropertyUtil.getConnectionFromProperties("db.properties"))){
			String query = "Select * From Student";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Student st = new Student(rs.getInt("Roll"), rs.getString("Name"), rs.getDouble("Fee"));
				student.add(st);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public void updateFee(int RollNo,double updatedFee)
	{
		try(Connection conn=DBConnUtil.getConnection(DBPropertyUtil.getConnectionFromProperties("db.properties"))){
			String query = "Update Student Set fee=? Where Roll=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setDouble(1, updatedFee);
			stmt.setInt(2, RollNo);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void increaseFee(int RollNo,double value)
	{
		try(Connection conn=DBConnUtil.getConnection(DBPropertyUtil.getConnectionFromProperties("db.properties"))){
			String query = "Update Student Set fee=fee+? Where Roll=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setDouble(1, value);
			stmt.setInt(2, RollNo);
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Student searchStudent(int RollNo) {
		Student st=null;
		try(Connection conn=DBConnUtil.getConnection(DBPropertyUtil.getConnectionFromProperties("db.properties"))){
			String query = "Select * From Student where Roll=?";
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, RollNo);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
			st = new Student(rs.getInt("Roll"),rs.getString("Name"),rs.getDouble("Fee"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return st;
		
	}
}
