import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Herci {
	
	int filmy;


        Herci(int filmy)
    	{
    		this.filmy = filmy;
    	}
        
        
        public Herci(){
            this.filmy = 0;
        }

        public void pridatFilm(){
            this.filmy++;
        }

        public void ubratFilm(){
            this.filmy--;
        }

        public int getPocetFilmu() {
            return this.filmy;
        }

        public void setPocetFilmu(int pocetFilmu) {
            this.filmy = pocetFilmu;
        }
	
}