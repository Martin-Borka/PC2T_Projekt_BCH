import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SQLDatabaze {
    public static void nactiData(List<FilmAnim> animovanefilmy, List<FilmHrany> hranefilmy, List<Herec> herci)
    {   try
        {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:Filmy.db";
            Connection con = DriverManager.getConnection(url);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM filmy";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int druh = rs.getInt(2);
                if(druh == 1)//String nazev, int rok, String reziser, List<String>seznamHercu,float hodnoceni){
                {
                    String nazev = rs.getString(3);
                    int rok = rs.getInt(4);
                    String reziser = rs.getString(5);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(6);
                    if(!herciText.equals("")){
                    	
                        for (String herec : herciText.split(":")){
                            if(herec !=""){
                                seznamHercu.add(herec);
                                int id=0;
                                boolean je=false;
								for (Herec herecD : herci) {
									if(herecD.jeVDatabazi(herec)){
						               je=true;
						                herci.get(id).pridatFilm();
						                break;
						            }
									id++;
								}
								if(je==false) {
									herci.add(new Herec(herec,1));
								}
                            }
                        }
                    }//------------------
                    
                    float hodnoceni = rs.getFloat(6);
                    FilmHrany film =new FilmHrany(nazev, rok, reziser, seznamHercu, hodnoceni);//String nazev, int rok, String reziser, List<String>seznamHercu,float hodnoceni)
                    hranefilmy.add(film);
                }
                else
                {
                    String nazev = rs.getString(3);
                    int rok = rs.getInt(4);
                    String reziser = rs.getString(5);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(6);
                    for (String herec : herciText.split(":")){
                        if(herec !=""){
                            seznamHercu.add(herec);
                            int id=0;
                            boolean je=false;
							for (Herec herecD : herci) {
								if(herecD.jeVDatabazi(herec)){
					               je=true;
					                herci.get(id).pridatFilm();
					                break;
					            }
								id++;
							}
							if(je==false) {
								herci.add(new Herec(herec,1));
							}
                        }
                    }
                    int hodnoceni = rs.getInt(7);
                    int doporucenyVek = rs.getInt(8);
                    FilmAnim film =new FilmAnim(nazev, rok, doporucenyVek,reziser,seznamHercu ,hodnoceni);
                    animovanefilmy.add(film);
                }
            }
            con.close();
        }catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void ulozData(List<FilmAnim> animovanefilmy, List<FilmHrany> hranefilmy){   
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:Filmy.db";
            Connection con = DriverManager.getConnection(url);
            String sql = "DELETE FROM filmy";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            sql = "INSERT INTO filmy (druh, nazev,  rok, reziser,herci, hodnoceni) VALUES (?, ?, ?, ?, ?, ?)";//String nazev, int rok, String reziser, List<String>seznamHercu,float hodnoceni){
            statement = con.prepareStatement(sql); 
            for (FilmHrany film : hranefilmy){
                statement.setInt(1, 1);
                statement.setString(2, film.getNazev());
                statement.setInt(3, film.getRok());
                statement.setString(4, film.getReziser());
                statement.setFloat(6, film.getHodnoceni());
                String herci = "";
                if(!film.getSeznamHercu().isEmpty()){
                    
                        for (String jmeno : film.getSeznamHercu()) {
                            herci+=jmeno+":";
                        }
                      statement.setString(5, herci);
                }
                else{
                    statement.setString(5, "");
                }
                
                statement.executeUpdate();
            }
            sql = "INSERT INTO filmy(druh,nazev,rok,reziser,herci,hodnoceni,vek)VALUES(?,?,?,?,?,?,?)";//String nazev, int rok, int vek, String reziser, List<String>seznamHercu,float hodnoceni)
            statement = con.prepareStatement(sql); 
            for (FilmAnim film : animovanefilmy) {
                statement.setInt(1, 2);
                statement.setString(2, film.getNazev());
                statement.setInt(3, film.getRok());
                statement.setString(4, film.getReziser());
                statement.setFloat(6, film.getHodnoceni());
                statement.setInt(7, film.getVek());
                
                String herci = "";
                if(!film.getSeznamHercu().isEmpty()){
                	for (String jmeno : film.getSeznamHercu()) {
                        herci+=jmeno+":";
                    }
                  statement.setString(5, herci);
                }
                else{
                    statement.setString(5, "");
                }


                statement.executeUpdate();
            }
            statement.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error executing SQL statement.");
            e.printStackTrace();
        }
    }
}


