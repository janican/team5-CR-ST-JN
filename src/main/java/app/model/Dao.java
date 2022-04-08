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

	public void saveCandidates(Candidates candidates) {
	
		String sql="insert into ehdokkaat(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  candidates.getSukunimi());
			pstmt.setString(2, candidates.getEtunimi());
			pstmt.setString(3, candidates.getPuolue());
			pstmt.setString(4, candidates.getKotipaikkakunta());
			pstmt.setInt(5, candidates.getIka());
			pstmt.setString(6, candidates.getMiksi_eduskuntaan());
			pstmt.setString(7, candidates.getMita_asioita_haluat_edistaa());
			pstmt.setString(8, candidates.getAmmatti());
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Candidates candidates= new Candidates();
				candidates.setEhdokas_id(rs.getInt("ehdokas_id"));
				candidates.setSukunimi(rs.getString("sukunimi"));
				candidates.setEtunimi(rs.getString("etunimi"));
				candidates.setPuolue(rs.getString("puolue"));
				candidates.setKotipaikkakunta(rs.getString("kotipaikkakunta"));
				candidates.setIka(rs.getInt("Ika"));
				candidates.setMiksi_eduskuntaan(rs.getString("miksi_eduskuntaan"));
				candidates.setMita_asioita_haluat_edistaa(rs.getString("mita_asioita-haluat_edistää"));
				candidates.setAmmatti(rs.getString("ammatti"));
				list.add(candidates);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		conn.close();
	}

	public Candidates getCandidatesInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	//public void close() {
	//	try { 
	//		conn.close();
	//	} catch (SQLException e) {
	//		e.printStackTrace();;
	//	}
	// }
	public void addUser(String tunnus, String hashsalasana, String salt) {
		// TODO Auto-generated method stub
		String sql = "insert into kayttaja (tunnus, hashsalasana, salt) values (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, tunnus);
			stmt.setString(2, hashsalasana);
			stmt.setString(3, salt);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getTunnusSalt(String tunnus) {
		String result = "";
		String sql = "select salt from kayttaja where tunnus = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, tunnus);
			
			ResultSet rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				result = rs.getString("salt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;	
	}
	
	public String getTunnusHashSalasana(String kayttaja) {
		String result = "";
		String sql = "select hashsalasana from kayttaja where tunnus = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, kayttaja);
			
			ResultSet rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				result = rs.getString("hashsalasana");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
