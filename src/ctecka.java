
import java.util.Scanner;
import java.util.List;

public class ctecka {
    
    
    public static boolean dotupnyNazev(String nazev, List<FilmHrany> hraneFilmy, List<FilmAnim> animovaneFilmy){
        for (FilmAnim film : animovaneFilmy) {
            if(film.getNazev().equals(nazev)){
                return false;
            }
        }
        for (FilmHrany film : hraneFilmy) {
            if(film.getNazev().equals(nazev)){
                return false;
            }
        }
        return true;
    }

}
