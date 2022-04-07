package app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
	private Connection conn;
	public Dao() { // DAO = DATA ACCESS OBJECT
	
	}
	
	/**
	 * Esimerkki kanta yhteystä ja kuinka tietoa sieltä luetaan
	 */
	public void getEhdokkaat() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "appuser@localhost", "kukkuluuruu");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM EHDOKKAAT");
			
			while ( rs.next( ) ) {
				System.out.println(rs.getString("ETUNIMI"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveCandidates(Candidates candidates) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Candidates> readAllCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public Candidates getCandidatesInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
