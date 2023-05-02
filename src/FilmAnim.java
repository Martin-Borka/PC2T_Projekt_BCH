import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FilmAnim extends ImgFilm{
	List<String>SeznamHercu;

	List<Integer>SeznamHodnocei;
	List<String>SeznamSlovniHodnoceni;
	//private float Hodnoceni;
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
	
	public FilmAnim(String nazev, int rok, int vek, String reziser, List<String>seznamHercu,List<Integer>SeznamHodnocei){
		this.nazev=nazev;
		this.rok=rok;
		this.vek=vek;
		this.reziser=reziser;
		this.SeznamHercu= seznamHercu;
		this.SeznamHodnocei= SeznamHodnocei;
		
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
        
        String hodnoceni = "\\n--Seznam hodnoceni: \\n";
        if(SeznamHercu!=null){
            for (Integer hodno : this.SeznamHodnocei) {
                hodnoceni+= Float.toString(hodno)+"\\n";
            }
        }
        
        return(super.filmToString()+"Doporuceny vek: "+vek+herci+ hodnoceni);
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
        int hodnoceni = Test.pouzeCelaCisla(sc);
        if(hodnoceni <11 && hodnoceni >-1)
        this.SeznamHodnocei.add(hodnoceni) ;
        else
        setHodnoceni(sc);
    }
    
    public void setSeznamHodnoceni(List<Integer> SeznamHodnocei) {
        this.SeznamHodnocei = SeznamHodnocei;
    }
    
    public List<Integer> getHodnoceni() {
        return SeznamHodnocei;
    }
    
    public String ulozHodnoceni() {
        String hodnoceni = ";";
        if(SeznamHercu!=null){
            for (Integer hodno : this.SeznamHodnocei) {
                hodnoceni+= Float.toString(hodno)+";";
            }
        }
        
        return(hodnoceni);
        	
        }
    
    public String getSlovHod() {
    	String hodnoceni = "\n--Slovni hodnoceni: \n";
        if(SeznamHercu!=null){
            for (String hodno : this.SeznamSlovniHodnoceni) {
                hodnoceni+= hodno+"\n";
            }
        }
		return hodnoceni;
	}
    
    public void addSlovHod(String hodnota) {
    	this.SeznamSlovniHodnoceni.add(hodnota);
    }
    
    
    public void setSlovHod(List<String> slovHod)
    {
        this.SeznamSlovniHodnoceni = slovHod;
    }
    
    
    public String filmToSave()
    {
        String herci = ":";
        if(SeznamHercu!=null){
            for (String jmeno : this.SeznamHercu) {
                herci+=jmeno+":";
            }
        }
        String hodnoceni = ";";
        if(SeznamHercu!=null){
            for (Integer hodno : this.SeznamHodnocei) {
                hodnoceni+= Float.toString(hodno)+";";
            }
        }

    
        return("2:"+super.filmToSave()+":"+hodnoceni+":"+Integer.toString(vek)+herci);
    }
    
    public List<String> getSeznamHercu() {
        return SeznamHercu;
    }

    public void setSeznamHercu(List<String> seznamHercu) {
        this.SeznamHercu = seznamHercu;
    }
}
