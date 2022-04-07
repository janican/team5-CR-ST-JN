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
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private ResultSet saveCandidates(Connection conn, String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksi_eduskuntaan, String mita_asioita_haluat_edistaa, String ammatti) {
	
		String sql="insert into ehdokkaat(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  sukunimi);
			pstmt.setString(2, etunimi);
			pstmt.setString(3, puolue);
			pstmt.setString(4, kotipaikkakunta);
			pstmt.setInt(5, ika);
			pstmt.setString(6, miksi_eduskuntaan);
			pstmt.setString(7, mita_asioita_haluat_edistaa);
			pstmt.setString(8, ammatti);
			pstmt.executeUpdate();
			
			ResultSet RS=pstmt.executeQuery("select * from ehdokkaat");
			return RS;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
