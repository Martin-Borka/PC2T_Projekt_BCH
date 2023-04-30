import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaze {

	SQLDatabaze(){
	}
	
	private Connection conn;
	public boolean connect() {
		conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:databazeProjekt.db");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	
	
	
	public void disconnect() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	
	
	public boolean dropTable(String nazev){
		if(conn==null)
			return false;
		String sql = "DROP TABLE IF EXISTS "+nazev+";";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			return true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	//--------------------------------------------------------------------------------
	
	public boolean createTable() {
		if(conn==null)
			return false;
		String sql  = "CREATE TABLE IF NOT EXISTS animovane("+" id INTEGER,"+"nazev TEXT,"+"typ TEXT,"+"reziser TEXT,"+"rokVydani real,"+"doporucenyVek real,"+"PRIMARY KEY (id)"+");";
		String sql2 = "CREATE TABLE IF NOT EXISTS hrane("+" id INTEGER,"+"nazev TEXT,"+"typ TEXT,"+"reziser TEXT,"+"rokVydani real,"+"PRIMARY KEY (id)"+");";
		String sql3 = "CREATE TABLE IF NOT EXISTS hodnoceni("+" id INTEGER,"+"film TEXT,"+"typ TEXT,"+"slovniHodnoceni TEXT,"+"bodoveHodnoceni real,"+"PRIMARY KEY (id)"+");";
		String sql4 = "CREATE TABLE IF NOT EXISTS herciH("+" id INTEGER,"+"film TEXT,"+"jmeno TEXT,"+"PRIMARY KEY (id)"+");";
		String sql5 = "CREATE TABLE IF NOT EXISTS herciA("+" id INTEGER,"+"film TEXT,"+"jmeno TEXT,"+"PRIMARY KEY (id)"+");";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.execute(sql2);
			stmt.execute(sql3);
			stmt.execute(sql4);
			return true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void vlozeniAnimovany(String nazev, String typ, String reziser, int rokVydani, int doporucenyVek) {
		String sql = "INSERT INTO animovane(nazev, typ, reziser, rokVydani, doporucenyVek) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nazev);
			pstmt.setString(2, typ);
			pstmt.setString(3, reziser);
			pstmt.setFloat(4, rokVydani);
			pstmt.setFloat(5, doporucenyVek);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void vlozeniHrany(String nazev, String typ, String reziser, int rokVydani) {
		String sql = "INSERT INTO hrane(nazev, typ, reziser, rokVydani) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nazev);
			pstmt.setString(2, typ);
			pstmt.setString(3, reziser);
			pstmt.setFloat(4, rokVydani);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void vlozeniHodnoceni(String film, String typ, String slovniHodnoceni, int bodoveHodnoceni) {
		String sql = "INSERT INTO hodnoceni(film, typ, slovniHodnoceni, bodoveHodnoceni) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, film);
			pstmt.setString(2, typ);
			pstmt.setString(3, slovniHodnoceni);
			pstmt.setFloat(4, bodoveHodnoceni);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void vlozeniHerce(String film, String jmeno) {
		String sql = "INSERT INTO herci(film, jmeno) VALUES(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, film);
			pstmt.setString(2, jmeno);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void vybratVsechno(){
        String sql = "SELECT nazev, typ, reziser, rokVydani, doporucenyVek FROM animovane";
        try {
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             while (rs.next()) {
                		System.out.println(rs.getString("nazev") +  "\t" +  
                		rs.getString("typ") + "\t" + 
                		rs.getString("reziser") + "\t" + 
                		rs.getFloat("rokVydani") + "\t" +
                		rs.getFloat("doporucenyVek"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	//----------------------------------------------------------------------------------------------
	public void nacteniAnimovane(FilmAnim seznamAnimovanych) {
		String nazev;
		String reziser;
		int rokVydani;
		int doporucenyVek;
		String sql = "SELECT nazev, typ, reziser, rokVydani, doporucenyVek FROM animovane";
		try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
               		nazev = rs.getString("nazev");
               		reziser = rs.getString("reziser");
               		rokVydani = rs.getInt("rokVydani"); 
               		doporucenyVek = rs.getInt("doporucenyVek");
               		seznamAnimovanych.add(new FilmHrany(nazev, doporucenyVek, rokVydani, reziser));
            }
            System.out.println("Animovane filmy nacteny.");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
	}
	
	public void nacteniHrane(FilmHrany seznamHranych) {
		String nazev;
		String reziser;
		int rokVydani;
		String sql = "SELECT nazev, typ, reziser, rokVydani FROM hrane";
		try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
               		nazev = rs.getString("nazev");
               		reziser = rs.getString("reziser");
               		rokVydani = rs.getInt("rokVydani"); 
               		seznamHranych.setHrany(nazev, rokVydani, reziser);
            }
            System.out.println("Hrane filmy nacteny.");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
	}
	
	
	public void nacteniHercuH(FilmHrany seznamHercuH) {
		String film;
		String jmeno;
		String sql = "SELECT film, jmeno FROM herci";
		try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
               		film = rs.getString("film");
               		jmeno = rs.getString("jmeno");
               		seznamHercu.addHerce(film, jmeno);
            }
            System.out.println("Herci nacteni.");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
	}
	
	public void nacteniHercuA(FilmAnim seznamHercuA) {
		String film;
		String jmeno;
		String sql = "SELECT film, jmeno FROM herci";
		try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
               		film = rs.getString("film");
               		jmeno = rs.getString("jmeno");
               		seznamHercu.addHerce(film, jmeno);
            }
            System.out.println("Herci nacteni.");
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
	}
	
	
}
