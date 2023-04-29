
public abstract class ImgFilm {
	 String nazev;
	 int rok;
	 int vek;
	 String reziser;
	
	    

	
/*	public ImgFilm(String nazev, int rok, String reziser)
	{
		this.nazev=nazev;
		this.rok=rok;
		this.reziser=reziser;
	}*/
	
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
	
	public String getVek()
	{
		return reziser;
	}

	
	
	public String filmToSave()
    {
        return(
        this.nazev+
        "\n"+this.reziser+
        "\n"+ this.rok
        );
    }
	
	
	
	
	/*
	public float getStudijniPrumer() {
		return studijniPrumer;
	}

	public boolean setStudijniPrumer(float studijniPrumer) {
		if (studijniPrumer<1||studijniPrumer>5)
		{
			System.out.println("Chybny prumer");
			return false;
		}
		this.studijniPrumer = studijniPrumer;
		return true;
	}
	private float studijniPrumer;
*/
	
	
}