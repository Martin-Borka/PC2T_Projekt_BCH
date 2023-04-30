
public abstract class ImgFilm {
	 String nazev;
	 int rok;
	 int vek;
	 String reziser;
	
	    
	 public String filmToString()
	    {
	        return(
	        "    Nazev: "+this.nazev+
	        "\n    Reziser: "+this.reziser+
	        "\n    Rok vydani: "+ this.rok
	        );
	    }
	 
	public String getNazev()
	{
		return nazev;
	}
	
	public int getRok()
	{
		return rok;
	}
	
	public String getReziser()
	{
		return reziser;
	}
	
	public int getVek()
	{
		return vek;
	}

	
	
	public String filmToSave()
    {
        return(
        this.nazev+
        ":"+this.reziser+
        ":"+ this.rok
        );
    }
	
	
	
}