import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;



public class FilmHrany extends ImgFilm{
	List<String>SeznamHercu;
	private float Hodnoceni;
    private String SlovHod;


	public FilmHrany(){
	}
	
	public FilmHrany(String nazev, int rok, String reziser){
		this.nazev=nazev;
		this.rok=rok;
		this.reziser=reziser;
		
	}
	
	public FilmHrany(String nazev, int rok, String reziser, List<String>seznamHercu){
		this.nazev=nazev;
		this.rok=rok;
		this.reziser=reziser;
		this.SeznamHercu= seznamHercu;
	}
	
	public FilmHrany(String nazev, int rok, String reziser, List<String>seznamHercu,float hodnoceni){
		this.nazev=nazev;
		this.rok=rok;
		this.reziser=reziser;
		this.SeznamHercu= seznamHercu;
		this.Hodnoceni= hodnoceni;
		//this.SeznamHodnoceni;
	}
	
	@Override
	public String getNazev() {
		return nazev;
	}

	@Override
    public String filmToString()
    {
        String herci = "\n--Seznam herců: \n";
        if(SeznamHercu!=null){
            for (String jmeno : this.SeznamHercu) {
                herci+=jmeno+"\n";
            }
        }
        return(super.filmToString()+herci);
    }
	
	
	
    public String filmHerec(String herec)
    {
        String filmy = "";
        if(SeznamHercu!=null){
            for (String jmeno : this.SeznamHercu) {
            	if (herec.equals(jmeno)) {
            		filmy= getNazev();
            		System.out.println(filmy);
            	}
            }
        }
		return filmy;
       
    }
	
	
	@Override
    public int hashCode() {
        return nazev.hashCode();
    }


    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getReziserH() {
        return reziser;
    }

    public void setReziserH(String reziser) {
        this.reziser = reziser;
    }
    
    public void setHodnoceni(Scanner sc) {
        System.out.print("Zadej hodnoceni (0-5): ");
        float hodnoceni = Test.pouzeCisla(sc);
        if(hodnoceni <6 && hodnoceni >-1)
        this.Hodnoceni = hodnoceni;
        else
        setHodnoceni(sc);
    }
	
    public float getHodnoceni() {
        return Hodnoceni;
    }
    
    public String getSlovHod() {
		return SlovHod;
	}
    
    public void setSlovHod(String slovHod)
    {
        this.SlovHod = slovHod;
    }
    
    
    public List<String> getSeznamHercu() {
        return SeznamHercu;
    }

    public void setSeznamHercu(List<String> seznamHercu) {
        this.SeznamHercu = seznamHercu;
    }
    
    public String filmToSave()
    {
        String herci = ":";
        if(SeznamHercu!=null){
            for (String jmeno : this.SeznamHercu) {
                herci+=jmeno+":";
            }
        }
        
        return("1:"+super.filmToSave()+":"+Float.toString(Hodnoceni)+":0"+herci);
    }
    
    
    
    
    
    
    
    
    
    
}
