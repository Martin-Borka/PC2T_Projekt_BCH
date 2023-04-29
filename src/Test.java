import java.awt.geom.Arc2D.Float;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Text;


public class Test {

	
	/*
	public static void upravafilmu() {
		
		//public static void upravFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy)
	        String nazev;
	        String herec;
	        int volba;
	        Scanner sc= new Scanner(System.in);
	        System.out.print("    Zadej název filmu: ");
	        nazev=sc.nextLine();
	        int i = 0;
	        int nalezeno = 0;
	                    
	        for (FilmHrany film : hraneFilmy) {
	            if(film.getNazev().equals(nazev)){
	            	nalezeno = 1;
	                break;
	            }
	            i++;
	            }
	            if(nalezeno==0){
	            	i = 0;
	                for (FilmAnimovany film : animovaneFilmy) {
	                     if(film.getNazev().equals(nazev)){
	                      nalezeno = 2;
	                        break;
	                }   
	                i++;
	                 }
	                 }
	        switch(nalezeno)
	             {
	                    case 1:
	                        System.out.print(
	                            "[1]   Upravit název\n"+
	                            "[2]   Upravit režiséra\n"+
	                            "[3]   Upravit rok vydání\n"+
	                            "[4]   Upravit seznam herců\n"+
	                            "[5]   Upravit hodnocení\n"+
	                            "[0]   Hotovo\n"+
	                            "    Vyber akci: ");
	                        volba=InputChecker.getInt(sc);
	                        while(volba!=0&&volba!=9){
	                        FilmHrany vybranyFilm = hraneFilmy.get(i);
	                        switch(volba){
	                        case 1:
	                            System.out.print("    Současný název "+vybranyFilm.getNazev()+"\n    Nový název: ");
	                            nazev=sc.nextLine();
	                            if(InputChecker.dotupnyNazev(nazev, hraneFilmy, animovaneFilmy)){
	                                vybranyFilm.setNazev(nazev);
	                            }
	                            else{
	                                System.out.println("    Název je již použit");
	                            }
	                        break;
	                        case 2:
	                            System.out.print("    Současný režisér "+vybranyFilm.getNazev()+"\n    Nový režisér: ");
	                            vybranyFilm.setReziser(sc.nextLine());
	                        break;
	                        case 3:
	                            System.out.print("    Současný rok vydání "+vybranyFilm.getNazev()+"\n    Nový rok vydání: ");
	                            vybranyFilm.setRokVydani(InputChecker.getInt(sc));
	                        break;
	                        case 4:
	                            if(vybranyFilm.SeznamHercu!=null);
	                            System.out.println("    Současný seznam herců: "+vybranyFilm.SeznamHercu.get(0));
	                            for(int j =1; j<vybranyFilm.SeznamHercu.size();j++)
	                            {
	                                System.out.println("                           "+vybranyFilm.SeznamHercu.get(j));
	                            }
	                            List<String> novySeznamHercu = new ArrayList<String>();
	                            System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
	                            herec = InputChecker.upravJmeno(sc.nextLine());
	                            while(!herec.equals("0")){
	                                novySeznamHercu.add(herec);
	                                System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
	                                herec = InputChecker.upravJmeno(sc.nextLine());
	                            }
	                            vybranyFilm.setSeznamHercu(novySeznamHercu);
	                        break;
	                        case 5:
	                            System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
	                            vybranyFilm.setHodnoceni(sc);
	                            System.out.print(
	                            "    Chceš zadat slovní hodnocení?\n"+
	                            "[1]   Ano\n"+
	                            "[2]   Ne\n"+
	                            "    Vyber akci: ");
	                            volba=InputChecker.getInt(sc);
	                            if(volba ==1){
	                                System.out.print("    Zadej slovní hodnocení: ");
	                                vybranyFilm.setSlovniHodnoceni(sc.nextLine());
	                            }
	                        break;
	                        case 0:
	                            hraneFilmy.set(i, vybranyFilm);
	                        break;
	                        case 9:
	                        break;
	                        }
	                        System.out.print(
	                            "[1]   Upravit název\n"+
	                            "[2]   Upravit režiséra\n"+
	                            "[3]   Upravit rok vydání\n"+
	                            "[4]   Upravit seznam herců\n"+
	                            "[5]   Upravit hodnocení\n"+
	                            "[0]   Hotovo\n"+
	                            "[9]   Zrušit změny\n"+
	                            "    Vyber akci: ");
	                        volba=InputChecker.getInt(sc);
	                    }
	                break;
	                case 2:
	                    System.out.print(
	                            "[1]   Upravit název\n"+
	                            "[2]   Upravit režiséra\n"+
	                            "[3]   Upravit rok vydání\n"+
	                            "[4]   Upravit seznam herců\n"+
	                            "[5]   Upravit hodnocení\n"+
	                            "[6]   Upravit Doporučný věk\n"+
	                            "[0]   Hotovo\n"+
	                            "    Vyber akci: ");
	                    volba=InputChecker.getInt(sc);
	                        while(volba!=0&&volba!=9){
	                    FilmAnimovany vybranyFilm = animovaneFilmy.get(i);
	                    switch(volba){
	                    case 1:
	                        System.out.print("    Současný název "+vybranyFilm.getNazev()+"\n    Nový název: ");
	                        vybranyFilm.setNazev(sc.nextLine());
	                    break;
	                    case 2:
	                        System.out.print("    Současný režisér "+vybranyFilm.getNazev()+"\n    Nový režisér: ");
	                        vybranyFilm.setReziser(sc.nextLine());
	                    break;
	                    case 3:
	                        System.out.print("    Současný rok vydání "+vybranyFilm.getNazev()+"\n    Nový rok vydání: ");
	                        vybranyFilm.setRokVydani(InputChecker.getInt(sc));
	                    break;
	                    case 4:
	                        if(vybranyFilm.SeznamHercu!=null);
	                        System.out.println("    Současný seznam animátorů: "+vybranyFilm.SeznamHercu.get(0));
	                        for(int j =1; j<vybranyFilm.SeznamHercu.size();j++)
	                        {
	                            System.out.println("                               "+vybranyFilm.SeznamHercu.get(j));
	                        }
	                        List<String> novySeznamHercu = new ArrayList<String>();
	                        System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
	                        herec = InputChecker.upravJmeno(sc.nextLine());
	                        while(!herec.equals("0")){
	                            novySeznamHercu.add(herec);
	                            System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
	                            herec = InputChecker.upravJmeno(sc.nextLine());
	                        }
	                        vybranyFilm.setSeznamHercu(novySeznamHercu);
	                    break;
	                    case 5:
	                        System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
	                        vybranyFilm.setHodnoceni(sc);
	                        System.out.print(
	                        "    Chceš zadat slovní hodnocení?\n"+
	                        "[1]   Ano\n"+
	                        "[2]   Ne\n"+
	                        "    Vyber akci: ");
	                        volba=InputChecker.getInt(sc);
	                        if(volba ==1){
	                            System.out.print("    Zadej slovní hodnocení: ");
	                            vybranyFilm.setSlovniHodnoceni(sc.nextLine());
	                        }
	                    break;
	                    case 6:
	                        System.out.print("    Současný doporučený věk diváka "+vybranyFilm.getNazev()+"\n    Nový doporučený věk diváka: ");
	                        vybranyFilm.setDoporucenyVek(InputChecker.getInt(sc));
	                    break;
	                    case 0:
	                        animovaneFilmy.set(i, vybranyFilm);
	                    break;
	                    case 9:
	                    break;
	                    }
	                    System.out.print(
	                        "[1]   Upravit název\n"+
	                        "[2]   Upravit režiséra\n"+
	                        "[3]   Upravit rok vydání\n"+
	                        "[4]   Upravit seznam herců\n"+
	                        "[5]   Upravit hodnocení\n"+
	                        "[6]   Upravit Doporučný věk\n"+
	                        "[0]   Hotovo\n"+
	                        "[9]   Zrušit změny\n"+
	                        "    Vyber akci: ");
	                    volba=InputChecker.getInt(sc);
	                }
	            break;
	            case 0:
	                System.out.println("    Film nenalezen");
	            break;
	        }
	    
	}
	
	*/
	
//---------------------------------------------------	
	//čtení
	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	
	
	
	//možná odstraníme
	public static float pouzeCisla(Scanner sc) 
	{
		float cislo = 0;
		try
		{
			cislo = sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}

	
//----------------------------------------------------------------------------------	
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
		List<FilmAnim> animovaneFilmy = new ArrayList<FilmAnim>();
        List<FilmHrany> hraneFilmy = new ArrayList<FilmHrany>();
        List<Herci> herci = new ArrayList<Herci>();
		
		//System.out.println(mojeDatabazeH.getNazev());
		
		//String nazev;
		//int rok;
		//String reziser;
		float hodnoceni;
		
		int volba;
		boolean run=true;

		while(run)
		{
			System.out.println("Vytejte v male databazi filmu.");
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho filmu");			//
			System.out.println("2 .. upravu jednoho filmu");			
			System.out.println("3 .. smazani filmu");					//
			System.out.println("4 .. přidani hodnoceni ");				// slovně
			System.out.println("5 .. vypis vsech filmu ");				//
			System.out.println("6 .. vyhledavani podle nazvu");			//
			System.out.println("7 .. vyhledavani podle hercu");			
			System.out.println("8 .. ulozeni do souboru");				
			System.out.println("9 .. nacteni ze souboru");				
			System.out.println("10.. konec a ulozeni do SQL");   		
			
			volba=pouzeCelaCisla(sc);
			
			int rok;
			String nazev = null;
			String reziser = null;
			int vek = 0;
			String koš;
			
			switch(volba)
			{
				case 1:
				
					//  pridaniFilm(sc);
					System.out.printf("Zadejte kategorii filmu: \n 1 pro hrane \n 2 pro animovane %n ");
					int druh=Test.pouzeCelaCisla(sc);
					 
					System.out.println("Zadejte nazev filmu");
					 nazev=sc.nextLine();
					 nazev=sc.nextLine();
					System.out.println("Zadejte rok vydani (cislo)");
					rok=Test.pouzeCelaCisla(sc);
					System.out.println("Zadejte Rezisera");
					reziser=sc.nextLine();
					reziser=sc.nextLine();
					boolean jeVDatabazi=false;


					if (druh==1) {
						
					}
					else{
						
						System.out.println("Zadejte doporuceny vek");
						vek=Test.pouzeCelaCisla(sc);
						koš = sc.nextLine();
						
					}
					
					
					if (jeVDatabazi == false) {
						String herec;
						List<String> seznamhercu=new ArrayList<String>();
						do{
						
							
								System.out.println("Zadejte dalšího herce (pokud ne, nic nepiš)");
						
							herec= "";
							herec=sc.nextLine();
							System.out.println();
							
							if (herec!="") {
								seznamhercu.add(herec);
							}
							
						}while(herec!="");
						
						if (druh==1) {
							hraneFilmy.add(new FilmHrany(nazev, rok, reziser, seznamhercu));
						}else {
							animovaneFilmy.add(new FilmAnim(nazev,rok, vek, reziser, seznamhercu));
						}
						
						
						
						//------------------
						
					}
					
					
					
					
					System.out.println("-1-----------------------------------");
					 
					
					break;
//----111111111111111111111111111111111111111111111-----------------------------------------------------------------------------------------
					
				case 2://uprava filmu !!!!!!!!!!!!!!!!!!!!!!!
					System.out.printf("Zadejte kategorii pro upravu filmu: \n 1 pro hrane \n 2 pro animovane \n ");
					druh=Test.pouzeCelaCisla(sc);
					
					
					

					break;
//----22222222222222222222222222222222222222-----------------------------------------------------------------------------------------
					
				case 3://smazani filmu
					System.out.println("Zadejte druh filmu který chcete odebrat:\n 1 pro hrane \n 2 pro animovane");
					druh=0; 
					boolean n=false;
					int id = 0;
					
					druh=Test.pouzeCelaCisla(sc);
					
					System.out.println("Zadejte nazev filmu");
					 nazev=sc.nextLine();
					 nazev=sc.nextLine();
					 
					
					if (druh==1) {
						for (FilmHrany film : hraneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n = true;
				                break;
				            }
				            id++;
						}
						if (n==false) {
							System.out.println("Film nebyl nalezen");
							break;
						}
						hraneFilmy.remove(id);
						System.out.println("Hrany film byl odebrán");
					}
					else if(druh==2){
						for (FilmAnim film : animovaneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n = true;
				                break;
				            }
				            id++;
						
						}
						if (n==false) {
							System.out.println("Film nebyl nalezen");
							break;
						}
						animovaneFilmy.remove(id);
						System.out.println("Anime film byl odebrán");
					}
					else {
						System.out.println("Tato moznost prozatim neni");
						break;
					}
					
					System.out.println("-3-----------------------------------");
					break;
					
//----333333333333333333333333333333333333-----------------------------------------------------------------------------------------
				
				case 4://přidání hodnocení
					
					int id4=0;
					Boolean n4= false;
					System.out.println("Zadejte druh filmu kteremu chcete přidat hodnoceni:\n 1 pro hrane \n 2 pro animovane");
					druh=0; 
					druh = Test.pouzeCelaCisla(sc);
					
					System.out.println("Zadejte nazev filmu");
					 nazev=sc.nextLine();
					 nazev=sc.nextLine();
					 
					if(druh==1){
						for (FilmHrany film : hraneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n4 = true;
				                break;
				            }
				            id4++;
						}
						if (n4==true) {
							
							hraneFilmy.get(id4).setHodnoceni(sc);
				            System.out.print("Chceš zadat slovní hodnocení? \n 1 ANO \n 2 NE");
				            druh = Test.pouzeCelaCisla(sc);
				           
				            if(volba ==1){
				                System.out.print("    Zadej slovní hodnocení: ");
				                hraneFilmy.get(id4).setSlovHod(sc.nextLine());
				            }
						}
						else
							System.out.println("nebyl nalezen");	
						}
					
					
					else if(druh==2){
							
						for (FilmAnim film : animovaneFilmy) {
								if(film.getNazev().equals(nazev)){
					                n4 = true;
					                break;
					            }
					            id4++;
							}
							if (n4==true) {
								
								animovaneFilmy.get(id4).setHodnoceni(sc);
					            System.out.print("Chceš zadat slovní hodnocení? \n 1 ANO \n 2 NE");
					            druh = Test.pouzeCelaCisla(sc);
					           
					            if(volba ==1){
					                System.out.print("    Zadej slovní hodnocení: ");
					                animovaneFilmy.get(id4).setSlovHod(sc.nextLine());
					            }
								
							}
							else 
								System.out.println("nebyl nalezen");
						}
						
							
					
					//DatabazeHodoceni.setHodnoceni()
					
					
					 
			            
			            

						System.out.println("-4-----------------------------------");
					break;
//----444444444444444444444444444444444-----------------------------------------------------------------------------------------

				case 5:
					System.out.println("--Seznam hranych filmu--");
					for (FilmHrany film : hraneFilmy) {
			            System.out.println(film.filmToString());
			        }
					System.out.println("--Seznam animovanych filmu--");
					for (FilmAnim film : animovaneFilmy) {
						System.out.println(film.filmToString());
					}
					System.out.println("-5-----------------------------------");
					break;
//----5555555555555555555555555555555555-----------------------------------------------------------------------------------------

				case 6:
					int id6=0;
					Boolean n6= false;
					String vyhled6 = "";
					System.out.println("Zadejte druh filmu který chcete vyhledat: \n 1 pro hrane \n 2 pro animovane");
					druh=0; 
					druh = Test.pouzeCelaCisla(sc);
					
					System.out.println("Zadejte nazev filmu");
					 nazev=sc.nextLine();
					 nazev=sc.nextLine();
					 
					if(druh==1){
						for (FilmHrany film : hraneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n6 = true;
				                break;
				            }
				            id6++;
						}
						if (n6==false) {
							vyhled6 = "nebyl nalezen";
						}
						else 
							vyhled6 = hraneFilmy.get(id6).filmToString();
						System.out.println("Hrany film: "+ vyhled6 );
					}
					
	//-------------------
						else if(druh==2){
						
						for (FilmAnim film : animovaneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n6 = true;
				                break;
				            }
				            id6++;
						}
						if (n6==false) {
							vyhled6 = " nebyl nalezen";
						}
						else 
							vyhled6 = animovaneFilmy.get(id6).filmToString();
						System.out.println("Animovany film: "+ vyhled6 );
					}
					System.out.println("-6-----------------------------------");
					break;
//----6666666666666666666666666666666-----------------------------------------------------------------------------------------
				case 7:
					
					
					System.out.println("-7-----------------------------------");
//----777777777777777777777777777777777-----------------------------------------------------------------------------------------

					break;
				case 8:
					
					 System.out.println("Zadejte druh filmu který chcete ulozit:\n 1 pro hrane \n 2 pro animovane");
						druh=0; 
						boolean n8=false;
						int id8 = 0;
						
						druh=Test.pouzeCelaCisla(sc);
						
						System.out.println("Zadejte nazev filmu");
						 nazev=sc.nextLine();
						 nazev=sc.nextLine();
						
						if (druh==1) {
							for (FilmHrany film : hraneFilmy) {
								if(film.getNazev().equals(nazev)){
					                n8 = true;
					                break;
					            }
					            id8++;
							}
							if (n8==false) {
								System.out.println("Film nebyl nalezen");
								break;
							}
							 try {
								 String textakNazev = nazev+".txt";
						            FileWriter writer = new FileWriter(textakNazev);
						            String text = hraneFilmy.get(id8).filmToSave();
						            writer.write(text);
						            writer.close();
						            System.out.println("Prvek byl úspěšně uložen do souboru.");
						        } catch (IOException e) {
						            System.out.println("Nastala chyba při ukládání prvku do souboru.");
						            e.printStackTrace();
						        }
							//-----------------------
							
						}
						else if(druh==2){
							for (FilmAnim film : animovaneFilmy) {
								if(film.getNazev().equals(nazev)){
					                n8 = true;
					                break;
					            }
					            id8++;
							
							}
							if (n8==false) {
								System.out.println("Film nebyl nalezen");
								break;
							}
							 try {
								 String textakNazev = nazev+".txt";
						            FileWriter writer = new FileWriter(textakNazev);
						            String text = animovaneFilmy.get(id8).filmToSave();
						            writer.write(text);
						            writer.close();
						            System.out.println("Prvek byl úspěšně uložen do souboru.");
						        } catch (IOException e) {
						            System.out.println("Nastala chyba při ukládání prvku do souboru.");
						            e.printStackTrace();
						        }
							//-------------------
						}
						else {
							System.out.println("Tato moznost prozatim neni");
							break;
						}
						

						        
						       
						    
						

						
							/*
								
								try {
								
								fw = new FileWriter(vystupniSoubor);
								out = new BufferedWriter(fw);
								out.write(new String(prvkyDatabaze.get(film).getTyp()+"\n"));
								out.write(new String(prvkyDatabaze.get(film).getNazev()+"\n"));
								out.write(new String(prvkyDatabaze.get(film).getRok()+"\n"));
								out.write(new String(prvkyDatabaze.get(film).getReziser()+"\n"));
								out.write(new String(String.valueOf(pocetHodnoceni)+"\n"));
								if(pocetHodnoceni > 0) {
									out.write(new String(seznamHodnoceni.getHodnoceniFilmu(film)));
									 }
								out.write(new String(String.valueOf(pocetHercu)+"\n"));
								if(pocetHercu > 0) {
									out.write(new String(seznamHercu.getHercikFilmu(film)));
								}
								out.close();
								fw.close();
								
								}
								*/
							
						
						System.out.println("-8-----------------------------------");
					break;
				case 9:
					break;
				default:
					run=false;
					break;
			}
			
		}
	}

}
