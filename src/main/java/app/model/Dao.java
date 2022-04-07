package app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
	private Connection conn;
	public Dao() { // DAO = DATA ACCESS OBJECT
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "appuser@localhost", "kukkuluuruu");
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Esimerkki kanta yhteystä ja kuinka tietoa sieltä luetaan
	 */
	public void getEhdokkaat() {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");  
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "appuser@localhost", "kukkuluuruu");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM EHDOKKAAT");
			
			while ( rs.next( ) ) {
				System.out.println(rs.getString("ETUNIMI"));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	public void saveCandidates(candidates) {
	
		String sql="insert into ehdokkaat(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.getString(1,  sukunimi);
			pstmt.getString(2, etunimi);
			pstmt.getString(3, puolue);
			pstmt.getString(4, kotipaikkakunta);
			pstmt.getInt(5, ika);
			pstmt.getString(6, miksi_eduskuntaan);
			pstmt.getString(7, mita_asioita_haluat_edistaa);
			pstmt.getString(8, ammatti);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Candidates> readAllCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		conn.close();
	}

	public Candidates getCandidatesInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

		
	

}
