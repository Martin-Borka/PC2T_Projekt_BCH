import java.awt.geom.Arc2D.Float;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

import org.w3c.dom.Text;


public class Test {

	
	
	public static void upravafilmu(List<FilmAnim> animovaneFilmy, List<FilmHrany> hraneFilmy) {
		
	        String nazev;
	        String herec;
	        int volba;
	        String kos;
	        Scanner sc= new Scanner(System.in);
	        System.out.println("Zadej název filmu: ");
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
	                for (FilmAnim film : animovaneFilmy) {
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
	                        System.out.println(
	                            "1.. Upravit název \n2.. Upravit režiséra \n3.. Upravit rok vydání \n4.. Upravit seznam herců \n5.. Upravit hodnocení \n6.. Hotovo\n");
	                        
	                        volba=Test.pouzeCelaCisla(sc);
	                        kos=sc.nextLine();
	                        
	                        while(volba!=0&&volba!=9){
	                        FilmHrany vybranyFilm = hraneFilmy.get(i);
	                        switch(volba){
	                        case 1:
	                            System.out.print("    Současný název "+vybranyFilm.getNazev()+"\n    Nový název: ");
	                            nazev=sc.nextLine();
	                            if(ctecka.dotupnyNazev(nazev, hraneFilmy, animovaneFilmy)){
	                                vybranyFilm.setNazev(nazev);
	                            }
	                            else{
	                                System.out.println("    Název je již použit");
	                            }
	                        break;
	                        case 2:
	                            System.out.print("    Současný režisér "+vybranyFilm.getReziserH()+"\n    Nový režisér: ");
	                            vybranyFilm.setReziserH(sc.nextLine());
	                        break;
	                        case 3:
	                            System.out.print("    Současný rok vydání "+vybranyFilm.getRok()+"\n    Nový rok vydání: ");
	                            vybranyFilm.setRok(Test.pouzeCelaCisla(sc));
	                        break;
	                        case 4:
	                            if(vybranyFilm.SeznamHercu!=null);
	                            System.out.println("    Současný seznam herců: "+vybranyFilm.SeznamHercu.get(0));
	                            for(int j =1; j<vybranyFilm.SeznamHercu.size();j++)
	                            {
	                                System.out.println("                           "+vybranyFilm.SeznamHercu.get(j));
	                            }
	                            List<String> novySeznamHercu = new ArrayList<String>();
	                            herec="";
	                            System.out.print("    Zadej jméno herce ");
	                            herec = sc.nextLine();
	                            while(!herec.equals("")){
	                                novySeznamHercu.add(herec);
	                                herec="";
		                            System.out.print("    Zadej jméno herce ");
		                            herec = sc.nextLine();
	                            }
	                            vybranyFilm.setSeznamHercu(novySeznamHercu);
	                        break;
	                        case 5:
	                            System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
	                            vybranyFilm.setHodnoceni(sc);
	                            System.out.print(
	                            "    Chceš zadat slovní hodnocení?\n1   Ano\n2   Ne\n");
	                            
	                            volba=Test.pouzeCelaCisla(sc);
	                            kos=sc.nextLine();
	                            if(volba ==1){
	                                System.out.print("    Zadej slovní hodnocení: ");
	                                vybranyFilm.setSlovHod(sc.nextLine());
	                            }
	                        break;
	                        case 0:
	                            hraneFilmy.set(i, vybranyFilm);
	                        break;
	                        case 9:
	                        break;
	                        }
	                        System.out.println("------------------------------------");
	                        System.out.println("1.. Upravit název\n2.. Upravit režiséra\n3.. Upravit rok vydání\n4.. Upravit seznam herců\n5.. Upravit hodnocení\n0.. Hotovo\n9.. Zrušit změny\n");
	                        
	                        volba=Test.pouzeCelaCisla(sc);
	                        kos=sc.nextLine();
	                    }  
	                break;
	                
	                case 2:
	                    System.out.println("1.. Upravit název\n2.. Upravit režiséra\n3.. Upravit rok vydání\n4.. Upravit seznam herců\n5.. Upravit hodnocení\n6.. Upravit Doporučný věk\n0.. Hotovo\n9.. Zrušit změny\n");
                        
	                    volba=Test.pouzeCelaCisla(sc);
	                    kos=sc.nextLine();
	                        while(volba!=0&&volba!=9){
	                    FilmAnim vybranyFilm = animovaneFilmy.get(i);
	                    switch(volba){
	                    case 1:
	                        System.out.print("    Současný název "+vybranyFilm.getNazev()+"\n    Nový název: ");
	                        vybranyFilm.setNazev(sc.nextLine());
	                    break;
	                    case 2:
	                        System.out.print("    Současný režisér "+vybranyFilm.getReziserA()+"\n    Nový režisér: ");
	                        vybranyFilm.setReziserA(sc.nextLine());
	                    break;
	                    case 3:
	                        System.out.print("    Současný rok vydání "+vybranyFilm.getRok()+"\n    Nový rok vydání: ");
	                        vybranyFilm.setRok(Test.pouzeCelaCisla(sc));
	                        kos=sc.nextLine();
	                    break;
	                    case 4:
	                        if(vybranyFilm.SeznamHercu!=null);
	                        System.out.println("    Současný seznam animátorů: "+vybranyFilm.SeznamHercu.get(0));
	                        for(int j =1; j<vybranyFilm.SeznamHercu.size();j++)
	                        {
	                            System.out.println("                               "+vybranyFilm.SeznamHercu.get(j));
	                        }
	                        List<String> novySeznamHercu = new ArrayList<String>();
	                        System.out.print("    Zadej jméno herce ");
	                        herec="";
                            herec = sc.nextLine();
	                        while(!herec.equals("")){
                                novySeznamHercu.add(herec);
                                herec="";
	                            System.out.print("    Zadej jméno herce ");
	                            herec = sc.nextLine();
                            }
	                        
	                        vybranyFilm.setSeznamHercu(novySeznamHercu);
	                    break;
	                    case 5:
	                        System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
	                        vybranyFilm.setHodnoceni(sc);
	                        System.out.print(
	                        "    Chceš zadat slovní hodnocení?\n1   Ano\n2   Ne\n");
	                        volba=Test.pouzeCelaCisla(sc);
	                        kos=sc.nextLine();
	                        if(volba ==1){
	                            System.out.print("    Zadej slovní hodnocení: ");
	                            vybranyFilm.setSlovHod(sc.nextLine());
	                        }
	                    break;
	                    case 6:
	                        System.out.print("    Současný doporučený věk diváka "+vybranyFilm.getNazev()+"\n    Nový doporučený věk diváka: ");
	                        vybranyFilm.setVek(Test.pouzeCelaCisla(sc));
	                        kos=sc.nextLine();
	                    break;
	                    case 0:
	                        animovaneFilmy.set(i, vybranyFilm);
	                    break;
	                    case 9:
	                    break;
	                    }
	                    System.out.println("------------------------------------");
	                    System.out.println("1.. Upravit název\n2.. Upravit režiséra\n3.. Upravit rok vydání\n4.. Upravit seznam herců\n5.. Upravit hodnocení\n6.. Upravit Doporučný věk\n0.. Hotovo\n9.. Zrušit změny\n");
                        
	                    volba=Test.pouzeCelaCisla(sc);
	                    kos=sc.nextLine();
	                }
	            break;
	            case 0:
	                System.out.println("Film nenalezen");
	            break;
	        }
	    
	}
	
	
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
        List<Herec> herci = new ArrayList<Herec>();
        SQLDatabaze sql = new SQLDatabaze();
        
        SQLDatabaze.nactiData(animovaneFilmy, hraneFilmy, herci);

        
		float hodnoceni;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("Vytejte v male databazi filmu.");
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho filmu");			//
			System.out.println("2 .. upravu jednoho filmu");			//
			System.out.println("3 .. smazani filmu");					//
			System.out.println("4 .. přidani hodnoceni ");				// slovně
			System.out.println("5 .. vypis vsech filmu ");				//
			System.out.println("6 .. vyhledavani podle nazvu");			//
			System.out.println("7 .. vyhledavani podle hercu");			//
			System.out.println("8 .. ulozeni do souboru");				//
			System.out.println("9 .. nacteni ze souboru");				//
			System.out.println("10.. herci kteri hrali ve vice filmech"); //  		
			System.out.println("11.. konec a neulozeni do SQL"); 
			
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
					koš=sc.nextLine(); 
					System.out.println("Zadejte nazev filmu");
					 nazev=sc.nextLine();
					 
					 
					 if(ctecka.dotupnyNazev(nazev, hraneFilmy, animovaneFilmy)) {
					 
					 
					System.out.println("Zadejte rok vydani (cislo)");
					rok=Test.pouzeCelaCisla(sc);
					koš=sc.nextLine(); 
					System.out.println("Zadejte Rezisera");
					reziser=sc.nextLine();
					boolean jeVDatabazi=false;


					if (druh!=1) {
						System.out.println("Zadejte doporuceny vek");
						vek=Test.pouzeCelaCisla(sc);
						koš = sc.nextLine();
					}
					
					
					
					if (jeVDatabazi == false) {
						String herec;
						List<String> seznamhercu=new ArrayList<String>();
						do{
						
							if (druh==1) {
								System.out.println("Zadejte dalšího herce (pokud ne, nic nepiš)");
							}
							else{
								System.out.println("Zadejte dalšího animatora (pokud ne, nic nepiš)");
							}
								
						
							herec= "";
							herec=sc.nextLine();
							System.out.println();
							boolean je=false;
							int id1=0;
							
							
							if (herec!="") {
								seznamhercu.add(herec);
								
								
								for (Herec herecD : herci) {
									if(herecD.jeVDatabazi(herec)){
						               je=true;
						                herci.get(id1).pridatFilm();
						                break;
						            }
									id1++;
								}
								if(je==false) {
									herci.add(new Herec(herec,1));
								}
								
								
								
							}
							
						}while(herec!="");
						
						if (druh==1) {
							hraneFilmy.add(new FilmHrany(nazev, rok, reziser, seznamhercu));
						}else {
							animovaneFilmy.add(new FilmAnim(nazev,rok, vek, reziser, seznamhercu));
						}
						
						
						
						//------------------
						
					}
					
					 }else System.out.println("film uz je v databazi");
					
					
					System.out.println("-1-----------------------------------");
					 
					
					break;
//----111111111111111111111111111111111111111111111-----------------------------------------------------------------------------------------
					
				case 2://uprava filmu !!!!!!!!!!!!!!!!!!!!!!!
					
					upravafilmu( animovaneFilmy, hraneFilmy);
					System.out.println("-2-----------------------------------");
					break;
//----22222222222222222222222222222222222222-----------------------------------------------------------------------------------------
					
				case 3://smazani filmu
					
					druh=0; 
					boolean n=false;
					int id = 0;
					druh=0;
					
					System.out.println("Zadejte nazev filmu ktery chcete odebrat");
					
					 nazev=sc.nextLine();
					 
					
					 for (FilmHrany film : hraneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n = true;
				                druh=1;
				                break;
				            }
				            id++;
						}
				            if(n==false){
				            	for (FilmAnim film : animovaneFilmy) {
									if(film.getNazev().equals(nazev)){
						                n = true;
						                druh=2;
						                break;
						            }
						            id++;
								
								}
				                 }
					 
					 
					if (druh==1) {
						
						if (n==false) {
							System.out.println("Film nebyl nalezen");
							break;
						}
						hraneFilmy.remove(id);
						System.out.println("Hrany film byl odebrán");
					}
					else if(druh==2){
						
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
				
				case 4:
					
					int id4=0;
					Boolean n4= false;
					
					druh=0; 
					
					
					System.out.println("Zadejte nazev filmu kteremu chcete přidat hodnoceni");
					
					 nazev=sc.nextLine();
					 
					 
					 for (FilmHrany film : hraneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n4 = true;
				                druh=1;
				                break;
				            }
				            id4++;
						}
				            if(n4==false){
				            	for (FilmAnim film : animovaneFilmy) {
									if(film.getNazev().equals(nazev)){
						                n4 = true;
						                druh=2;
						                break;
						            }
						            id4++;
								
								}
				                 }
					 
					 
					if(druh==1){
						
						if (n4==true) {
							
							hraneFilmy.get(id4).setHodnoceni(sc);
							
				            System.out.print("Chceš zadat slovní hodnocení? \n 1 ANO \n 2 NE");
				            druh = Test.pouzeCelaCisla(sc);
				            koš=sc.nextLine();
				           
				            if(volba ==1){
				                System.out.print("    Zadej slovní hodnocení: ");
				                hraneFilmy.get(id4).setSlovHod(sc.nextLine());
				            }
						}
						else
							System.out.println("nebyl nalezen");	
						}
					
					
					else if(druh==2){
							if (n4==true) {
								
								animovaneFilmy.get(id4).setHodnoceni(sc);
					            System.out.print("Chceš zadat slovní hodnocení? \n 1 ANO \n 2 NE");
					            druh = Test.pouzeCelaCisla(sc);
					            koš=sc.nextLine();
					           
					            if(volba ==1){
					                System.out.print("    Zadej slovní hodnocení: ");
					                animovaneFilmy.get(id4).setSlovHod(sc.nextLine());
					            }
								
							}
							else 
								System.out.println("nebyl nalezen");
						}
					
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
					
					druh=0; 
					System.out.println("Zadejte nazev filmu který chcete najít");
					 nazev=sc.nextLine();
					 
					 
					 
					 for (FilmHrany film : hraneFilmy) {
							if(film.getNazev().equals(nazev)){
				                n6 = true;
				                druh=1;
				                break;
				            }
				            id6++;
						}
				            if(n6==false){
				            	for (FilmAnim film : animovaneFilmy) {
									if(film.getNazev().equals(nazev)){
						                n6 = true;
						                druh=2;
						                break;
						            }
						            id6++;
								
								}
				                 }
					 
					 
					if(druh==1){
						
						if (n6==false) {
							vyhled6 = "nebyl nalezen";
						}
						else 
							vyhled6 = hraneFilmy.get(id6).filmToString();
						System.out.println("Hrany film: "+ vyhled6 );
					}
					
	//-------------------
						else if(druh==2){
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
					System.out.println("Zadejte druh filmu ve kterém chceš hledat:\n 1 pro herce \n 2 pro animatora");
					druh=0; 
					druh=Test.pouzeCelaCisla(sc);
					koš=sc.nextLine(); 
					if (druh== 1)
						System.out.println("Zadejte jmeno herce");
					else
						System.out.println("Zadejte jmeno animatora");
					 String jmeno=sc.nextLine();
					 jmeno=sc.nextLine();
					 if  (druh== 1) {
						 System.out.println("Seznam filmů: ");
						for (FilmHrany film : hraneFilmy) {
								film.filmHerec(jmeno);
					            } 
					 }else if(druh== 2) {
						 System.out.println("Seznam filmů: ");
						for (FilmAnim film : animovaneFilmy) {
							film.filmHerec(jmeno);
					        }  
					 }
					System.out.println("-7-----------------------------------");
//----777777777777777777777777777777777-----------------------------------------------------------------------------------------

					break;
				case 8:
					
					 
						druh=0; 
						boolean n8=false;
						int id8 = 0;
						koš=sc.nextLine();
						System.out.println("Zadejte nazev filmu který chcete uložit");
						 nazev=sc.nextLine();
						 
						 
						 
						 for (FilmHrany film : hraneFilmy) {
								if(film.getNazev().equals(nazev)){
					                n8 = true;
					                druh=1;
					                break;
					            }
					            id8++;
							}
						  if(n8==false){
					            	for (FilmAnim film : animovaneFilmy) {
										if(film.getNazev().equals(nazev)){
							                n8 = true;
							                druh=2;
							                break;
							            }
							            id8++;
									
									}
					                 }
						 
						if (druh==1) {
							
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
						}
						else if(druh==2){
							
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
						}
						else {
							System.out.println("Tato moznost prozatim neni");
							break;
						}	
						System.out.println("-8-----------------------------------");
//----888888888888888888888888888888888-----------------------------------------------------------------------------------------
					break;
				case 9:
					int rok9=0;
					 String reziser9="";
					 double hodnoceni9=0.0;
					 int vek9=0;
					 int druh9=1;
					 Boolean n9=false;
					 List<String> seznamhercu9=new ArrayList<String>();
				
					
					System.out.println("Zadejte nazev filmu");
					 String nazev9=sc.nextLine();
					 nazev9=sc.nextLine();
					 
					 
				    
			        try {
			            FileReader reader = new FileReader(nazev9+".txt");
			            BufferedReader bufferedReader = new BufferedReader(reader);
			            boolean je9=false;
			            int id9=0;

			            String line;
			            while ((line = bufferedReader.readLine()) != null) {
			                String[] data = line.split(":");
			                
			                 druh9 = Integer.valueOf(data[0]);
			                nazev9 = data[1];
			                reziser9 = data[2];
			                rok9 = Integer.valueOf(data[3]);
			               double a = Double.valueOf(data[4]);
			               hodnoceni9 = (float) a;
			               vek9 = Integer.valueOf(data[5]);
			               System.out.println(druh9);
			               System.out.println(nazev9);
			                for(int i=6; i<data.length;i++) {
			                seznamhercu9.add(data[i]);
			                
			                
			                for (Herec herecD : herci) {
								if(herecD.jeVDatabazi(data[i])){
					               je9=true;
					                herci.get(id9).pridatFilm();
					                break;
					            }
								id9++;
							}
							if(je9==false) {
								herci.add(new Herec(data[i],1));
							}

			                }
			                
			            }
			            if (druh9==1) {
				            	for (FilmHrany film : hraneFilmy) {
								if(film.getNazev().equals(nazev9)){
					                n9 = true;
					                break;
					            }
							}
				            	if (n9!=true)
								hraneFilmy.add(new FilmHrany(nazev9, rok9, reziser9, seznamhercu9));
								
							}else {
								for (FilmAnim film : animovaneFilmy) {
									if(film.getNazev().equals(nazev9)){
						                n9 = true;
						                break;
						            }
								}
								if (n9!=true)
								animovaneFilmy.add(new FilmAnim(nazev9,rok9, vek9, reziser9, seznamhercu9));
							}
			            
			            bufferedReader.close();
			            reader.close();
			            System.out.println("Data byla úspěšně načtena ze souboru.");
			        } catch (IOException e) {
			            System.out.println("Nastala chyba při načítání dat ze souboru.");
			            e.printStackTrace();
			        }

			        // zde můžete použít ArrayList s načtenými daty
			    
			        System.out.println("-9-----------------------------------");
//----99999999999999999999999999999999-----------------------------------------------------------------------------------------					
					break;
					
				case 10:
					
					System.out.println("herci kteří hráli ve více filmech: ");
					druh=0; 
					for (Herec herec : herci) {
                        if(herec.getPocetFilmu()>1){
                            Herec.vypsatFilmy(animovaneFilmy, hraneFilmy, herec.getJmeno());
                        }
                    }
					System.out.println("-10-----------------------------------");
					
				break;
				default:
					
					SQLDatabaze.ulozData(animovaneFilmy, hraneFilmy);
					

					run=false;
					break;
			}
			
		}
	}

}
