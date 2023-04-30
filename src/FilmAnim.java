import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FilmAnim extends ImgFilm{
	List<String>SeznamHercu;
	private float Hodnoceni;
    private String SlovHod;
	
	FilmAnim(){
		}

	FilmAnim(String nazev, int rok, int vek, String reziser){
		this.nazev=nazev;
		this.rok=rok;
		this.vek=vek;
		this.reziser=reziser;
	}
	
	public FilmAnim(String nazev, int rok, int vek, String reziser, List<String>seznamHercu){
		this.nazev=nazev;
		this.rok=rok;
		this.reziser=reziser;
		this.SeznamHercu= seznamHercu;
		this.vek=vek;
		
	}
	
	public FilmAnim(String nazev, int rok, int vek, String reziser, List<String>seznamHercu,float hodnoceni){
		this.nazev=nazev;
		this.rok=rok;
		this.vek=vek;
		this.reziser=reziser;
		this.SeznamHercu= seznamHercu;
		this.Hodnoceni= hodnoceni;
		
	}
	
	

	
	
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
        return(super.filmToString()+"Doporuceny vek: "+vek+herci);
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

    public void setVek(int vek) {
    	this.vek=vek;
    }
    
    public int getVek() {
    	return vek;
    }
    
    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getReziserA() {
        return reziser;
    }

    public void setReziserA(String reziser) {
        this.reziser = reziser;
    }

    public void setHodnoceni(Scanner sc) {
        System.out.print("Zadej hodnoceni (0-10): ");
        float hodnoceni = Test.pouzeCisla(sc);
        if(hodnoceni <11 && hodnoceni >-1)
        this.Hodnoceni = hodnoceni;
        else
        setHodnoceni(sc);
    }
    
    public float getHodnoceni() {
        return Hodnoceni;
    }
    
    public void setSlovHod(String slovHod)
    {
        this.SlovHod = slovHod;
    }
    
    
    public String filmToSave()
    {
        String herci = ":";
        if(SeznamHercu!=null){
            for (String jmeno : this.SeznamHercu) {
                herci+=jmeno+":";
            }
        }
        
        return("2:"+super.filmToSave()+":"+Float.toString(Hodnoceni)+":"+Integer.toString(vek)+herci);
    }
    
    public List<String> getSeznamHercu() {
        return SeznamHercu;
    }

    public void setSeznamHercu(List<String> seznamHercu) {
        this.SeznamHercu = seznamHercu;
    }
}
