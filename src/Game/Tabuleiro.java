package Game;

import java.util.ArrayList;
import java.util.Arrays;

import Combat.Tropa;
import Land.MarAzulClaro;
import Land.MarAzulEscuro;
import Land.Territorio;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Tabuleiro {
    private boolean jogoEmProgresso = false;
    private int numRodadas = 0;
    private int maxRodadas;
    private ArrayList<Territorio> territorios = new ArrayList<>();
    private ArrayList<Territorio> pathCache = new ArrayList<>();
    private PApplet p;
    PImage mapa;
    public Tabuleiro(PApplet p){
    	this.p = p;
    }

    // identical use to setup in Processing IDE except for size()
    public void start(){
    	this.mapa = this.p.loadImage("supremacymap.png");
        p.image(this.mapa, 0, 0);
        // South America
        setupSouthAmerica();
        // Central America
        setupCentralAmerica();
        // North America
        setupNorthAmerica();
        // Mar azul
        setupMarAzulClaro();
        //Mar escuro
        setupMarAzulEscuro();
        //Europa
        setupEurope();
        //Africa
        setupAfrica();
        //Russia
        setupRussia();
        //Oceania
        setupOceania();
        // Middle East
        setupMiddleEast();
        
    }
    

    // identical use to draw in Prcessing IDE
    public void show(){
        for (int i = 0; i < territorios.size(); i++) {
            territorios.get(i).show();
        }
    }
    public Territorio getTerritorio(String nome) {
		for (Territorio territorio : territorios) {
			if (nome.equals(territorio.getName())){
				return territorio;
			}
		}
		return null;
	}
    public void setBordersHighlight(Territorio t, boolean state, String color) {
    	for (String front: t.getFronteiras()) {
			Territorio territorio = this.getTerritorio(front);
			if (territorio != null) {
				territorio.setColor(color);
			}
			
		}
    	if (state) {	
    		this.pathCache.add(t);
    	}
    }
    public void confirm() {
    	System.out.println("ENTER");
    	if (this.pathCache.size() > 1) {
    		ArrayList<Tropa> moved = this.getTerritorio(this.pathCache.get(0).getName()).getOcupantes();
    		System.out.println(moved);
    		this.getTerritorio(this.pathCache.get(this.pathCache.size()-1).getName()).addOcupantes(moved);
    		moved.clear();
    		this.getTerritorio(this.pathCache.get(0).getName()).removeOcupantes(99);
    		System.out.println(this.pathCache);
    		System.out.println(this.getTerritorio(this.pathCache.get(this.pathCache.size()-1).getName()).getOcupantes());
    		System.out.println(this.getTerritorio(this.pathCache.get(this.pathCache.size()-1).getName()).getName());
    		for (Territorio t: this.pathCache) {
    			System.out.println(t.getName());
    			this.setBordersHighlight(t, false, "cinza");
    		}
    		this.pathCache.clear();
    	}
    }
    public void click(int x,int  y, Jogador currentPlayer) {
        
        //search for clicked terrain
        for (Territorio territorio: this.territorios) {
            if(territorio.isPointInside(x, y)) {
            	if (this.pathCache.isEmpty()) {
            		//no path yet
            		if (!territorio.getOcupantes().isEmpty()) {
            			// selected terrain is populated
            			if (true){//territorio.getOcupantes().get(0).getOwner() == currentPlayer) {
            				this.setBordersHighlight(territorio, true, "branco");
            			}
            		}
            	} else {
            		if (this.pathCache.contains(territorio)) {
            			int until = this.pathCache.indexOf(territorio);
            			for (int i = this.pathCache.size()-1 ; i > until; i--) {
            				this.pathCache.get(i).setColor("cinza");
            				this.pathCache.remove(i);
            			}
            		} else {
            			if (this.pathCache.get(this.pathCache.size()-1).getFronteiras().contains(territorio.getName())) {
            				//if last of path has clicked terrain as fronteira
            				this.setBordersHighlight(this.pathCache.get(this.pathCache.size()-1), false, "cinza");
            				this.setBordersHighlight(territorio, true, "branco");
            				territorio.setColor("verde");
            			}
            			
            		}

            	}
            }
        }
        System.out.println(this.pathCache);
    }
    


    public boolean isJogoEmProgresso() {
        return jogoEmProgresso;
    }

    public void setJogoEmProgresso(boolean jogoEmProgresso) {
        this.jogoEmProgresso = jogoEmProgresso;
    }
    public int getNumRodadas() {
        return numRodadas;
    }

    public void setNumRodadas(int numRodadas) {
        this.numRodadas = numRodadas;
    }

    public int getMaxRodadas() {
        return maxRodadas;
    }

    public void setMaxRodadas(int maxRodadas) {
        this.maxRodadas = maxRodadas;
    }
    
    
    
    
    

    public void setupSouthAmerica(){
        ArrayList<String> frontBrazil = new ArrayList<>(Arrays.asList("Venezuela",
                "Peru", "Argentina", "Carribean Sea", "Mid Atlantic", "Baia Santos"));
        Territorio brazil = new Territorio(this.p, "Brazil", frontBrazil,
                new PVector(460, 620), 60, 30,null);
        territorios.add(brazil);

        ArrayList<String> frontArg = new ArrayList<>(Arrays.asList("Brazil", "Peru",
                "Baia Santos", "Rio de la Plata", "South Pacific", "Lima Bay"));
        Territorio argentina = new Territorio(this.p, "Argentina", frontArg,
                new PVector(440,740), 60, 30,null);
        territorios.add(argentina);

        ArrayList<String> frontVene = new ArrayList<>(Arrays.asList("Brazil", "Peru",
                "Carribean Sea","Central America", "Gulf of Panama","Lima Bay"));
        Territorio venezuela = new Territorio(this.p, "Venezuela", frontVene,
                new PVector(330, 580), 60, 30,null);
        territorios.add(venezuela);

        ArrayList<String> frontPeru = new ArrayList<>(Arrays.asList("Venezuela", "Brazil",
                "Argentina","Lima Bay"));
        Territorio peru = new Territorio(this.p, "Peru", frontPeru,
                new PVector(380, 670), 60, 30,null);
        territorios.add(peru);

    }
    public void setupCentralAmerica(){
        ArrayList<String> frontCentralAmerica = new ArrayList<>(Arrays.asList("Carribean Sea",
                "Venezuela","Gulf of Panama", "Santa Barbara Passage","Western USA","Mid-West USA"));
        Territorio centralAmerica = new Territorio(this.p, "Central America", frontCentralAmerica,
                new PVector(260, 490), 100, 30,null);
        territorios.add(centralAmerica);
    }
    public void setupNorthAmerica(){
        ArrayList<String> frontAlaska = new ArrayList<>(Arrays.asList("Nothern Canada",
                "Western Canada","North Pacific", "Barkley Sound"));
        Territorio alaska = new Territorio(this.p, "Alaska", frontAlaska,
                new PVector(180, 180), 60, 30,null);
        territorios.add(alaska);

        ArrayList<String> frontWesternUSA = new ArrayList<>(Arrays.asList("Mid-West USA",
                "Western Canada","Santa Barbara Passage", "Barkley Sound","Central America"));
        Territorio westernUSA = new Territorio(this.p, "Western USA", frontWesternUSA,
                new PVector(217, 333), 80, 30,null);
        territorios.add(westernUSA);

        ArrayList<String> frontMidWestUSA = new ArrayList<>(Arrays.asList("Western USA",
                "Western Canada","Eastern Canada", "Eastern USA","Central America"));
        Territorio midWestUSA = new Territorio(this.p, "Mid-West USA", frontMidWestUSA,
                new PVector(333, 297), 90, 30,null);
        territorios.add(midWestUSA);

        ArrayList<String> frontEasternUSA = new ArrayList<>(Arrays.asList("Mid-West USA",
                "Gulf of St. Lawrence","Eastern Canada", "Long Island Sound","Carribean Sea"));
        Territorio easternUSA = new Territorio(this.p, "Eastern USA", frontEasternUSA,
                new PVector(367, 337), 90, 30,null);
        territorios.add(easternUSA);

        ArrayList<String> frontNorthernCanada = new ArrayList<>(Arrays.asList("Alaska",
                "Western Canada", "Greenland", "Hudson Strait"));
        Territorio northernCanada = new Territorio(this.p, "Northern Canada", frontNorthernCanada,
                new PVector(305, 191), 100, 30,null);
        territorios.add(northernCanada);

        ArrayList<String> frontWesternCanada = new ArrayList<>(Arrays.asList("Alaska",
                "Northern Canada", "Barkley Sound", "Hudson Strait","Eastern Canada","Western USA"));
        Territorio westernCanada = new Territorio(this.p, "Western Canada", frontWesternCanada,
                new PVector(280, 252), 100, 30,null);
        territorios.add(westernCanada);

        ArrayList<String> frontEasternCanada = new ArrayList<>(Arrays.asList("Mid-West USA",
                "Eastern USA", "Barkley Sound", "Hudson Strait","Western Canada"));
        Territorio easternCanada = new Territorio(this.p, "Eastern Canada", frontEasternCanada,
                new PVector(423, 260), 100, 30,null);
        territorios.add(easternCanada);

        ArrayList<String> frontGreenland = new ArrayList<>(Arrays.asList("North Atlantic",
                "Northern Canada","Hudson Strait"));
        Territorio greenland = new Territorio(this.p, "Greenland", frontGreenland,
                new PVector(500, 140), 100, 30,null);
        territorios.add(greenland);
    }
    public void setupAfrica(){
        ArrayList<String> frontSahara = new ArrayList<>(Arrays.asList("Mid Atlantic",
                "Mediterranean Sea","Egypt", "Nigeria"));
        Territorio sahara = new Territorio(this.p, "Sahara", frontSahara,
                new PVector(711, 507), 60, 30,null);
        territorios.add(sahara);

        ArrayList<String> frontEgypt = new ArrayList<>(Arrays.asList("Sahara",
                "Mediterranean Sea","Red Sea", "Nigeria","Mozambique"));
        Territorio egypt = new Territorio(this.p, "Egypt", frontEgypt,
                new PVector(844, 527), 60, 30,null);
        territorios.add(egypt);

        ArrayList<String> frontNigeria = new ArrayList<>(Arrays.asList("Sahara",
                "Egypt","Gulf of Guinea", "Zaire","Mozambique","Mid Atlantic"));
        Territorio nigeria = new Territorio(this.p, "Nigeria", frontNigeria,
                new PVector(756, 578), 60, 30,null);
        territorios.add(nigeria);

        ArrayList<String> frontZaire = new ArrayList<>(Arrays.asList("South Africa",
                "Gulf of Guinea", "Nigeria","Mozambique","Cape of Good Hope"));
        Territorio zaire = new Territorio(this.p, "Zaire", frontZaire,
                new PVector(832, 693), 60, 30,null);
        territorios.add(zaire);

        ArrayList<String> frontMozambique = new ArrayList<>(Arrays.asList("South Africa",
                "Straits of Malacca", "Nigeria","Zaire","Red Sea","Egypt"));
        Territorio mozambique = new Territorio(this.p, "Mozambique", frontMozambique,
                new PVector(931, 654), 80, 30,null);
        territorios.add(mozambique);

        ArrayList<String> frontSouthAfrica = new ArrayList<>(Arrays.asList("Mozambique",
                "Straits of Malacca", "Cape of Good Hope","Zaire"));
        Territorio southAfrica = new Territorio(this.p, "South Africa", frontSouthAfrica,
                new PVector(866, 772), 80, 30,null);
        territorios.add(southAfrica);

    }
    public void setupRussia(){
        ArrayList<String> frontKola = new ArrayList<>(Arrays.asList("Barents Sea",
                "Scandinavia","Rusia", "Siberia"));
        Territorio kola = new Territorio(this.p, "Kola", frontKola,
                new PVector(1004, 180), 40, 30,null);
        territorios.add(kola);

        ArrayList<String> frontRussia = new ArrayList<>(Arrays.asList("Baltic Sea",
                "Scandinavia","Baltic Sea", "Siberia","Poland","Romania","Kazakh","Buryatsk","Kola"));
        Territorio russia = new Territorio(this.p, "Russia", frontRussia,
                new PVector(989, 247), 60, 30,null);
        territorios.add(russia);

        ArrayList<String> frontKazakh = new ArrayList<>(Arrays.asList("Black Sea",
                "Manchuria","Mongolia", "Tibet","Pakistan","Romania","Russia","Buryatsk",
                "Black Sea"));
        Territorio kazakh = new Territorio(this.p, "Kazakh", frontKazakh,
                new PVector(1074, 316), 60, 30,null);
        territorios.add(kazakh);

        ArrayList<String> frontSiberia = new ArrayList<>(Arrays.asList("Barents Sea",
                "Yakutsk","Kola","Russia","Buryatsk"));
        Territorio siberia = new Territorio(this.p, "Siberia", frontSiberia,
                new PVector(1152, 200), 60, 30,null);
        territorios.add(siberia);

        ArrayList<String> frontBuryatsk = new ArrayList<>(Arrays.asList("Sea of Okhotsk",
                "Yakutsk","Sea of Japan","Russia","Siberia","Manchuria","Mongolia","Kazakh"));
        Territorio buryatsk = new Territorio(this.p, "Buryatsk", frontBuryatsk,
                new PVector(1224, 281), 60, 30,null);
        territorios.add(buryatsk);

        ArrayList<String> frontYakutsk = new ArrayList<>(Arrays.asList("Sea of Okhotsk",
                "Buryatsk","North Pacific","Siberia"));
        Territorio yakutsk = new Territorio(this.p, "Yakutsk", frontYakutsk,
                new PVector(1314, 171), 60, 30,null);
        territorios.add(yakutsk);

    }
    public void setupEurope(){
        ArrayList<String> frontBritishIsles = new ArrayList<>(Arrays.asList("North Sea"));
        Territorio britishIsles = new Territorio(this.p, "British Isles", frontBritishIsles,
                new PVector(705, 246), 70, 25,null);
        territorios.add(britishIsles);

        ArrayList<String> frontScandinavia = new ArrayList<>(Arrays.asList("North Sea",
                "Barents Sea","Baltic Sea", "Kola","Russia"));
        Territorio scandinavia = new Territorio(this.p, "Scandinavia", frontScandinavia,
                new PVector(785, 190), 90, 25,null);
        territorios.add(scandinavia);

        ArrayList<String> frontPoland = new ArrayList<>(Arrays.asList("Eastern Europe",
                "Greece","Romania", "Kola","Russia","Baltic Sea"));
        Territorio poland = new Territorio(this.p, "Poland", frontPoland,
                new PVector(859, 262), 60, 25,null);
        territorios.add(poland);

        ArrayList<String> frontIberia = new ArrayList<>(Arrays.asList("Western Europe",
                "Bay of Biscay","Mediterranean Sea"));
        Territorio iberia = new Territorio(this.p, "Iberia", frontIberia,
                new PVector(683, 374), 60, 25,null);
        territorios.add(iberia);

        ArrayList<String> frontWesternEurope = new ArrayList<>(Arrays.asList("Iberia",
                "Bay of Biscay","Mediterranean Sea","North Sea","Eastern Europe","Baltic Sea"));
        Territorio westernEurope = new Territorio(this.p, "Western Europe", frontWesternEurope,
                new PVector(740, 323), 90, 25,null);
        territorios.add(westernEurope);

        ArrayList<String> frontEasternEurope = new ArrayList<>(Arrays.asList("Poland",
                "Greece","Mediterranean Sea","Western Europe","Baltic Sea"));
        Territorio easternEurope = new Territorio(this.p, "Eastern Europe", frontEasternEurope,
                new PVector(809, 290), 90, 25,null);
        territorios.add(easternEurope);

        ArrayList<String> frontGreece = new ArrayList<>(Arrays.asList("Poland",
                "Romania","Sea of Crete","Black Sea","Eastern Europe"));
        Territorio greece = new Territorio(this.p, "Greece", frontGreece,
                new PVector(851, 343), 60, 25,null);
        territorios.add(greece);

        ArrayList<String> frontRomania = new ArrayList<>(Arrays.asList("Poland",
                "Greece","Russia","Black Sea","Kazakh"));
        Territorio romania = new Territorio(this.p, "Romania", frontRomania,
                new PVector(900, 305), 60, 25,null);
        territorios.add(romania);

    }
    public void setupOceania(){
    	ArrayList<Tropa> army = new ArrayList<Tropa>();
		Tropa a = new Tropa();
		army.add(a);
		
        ArrayList<String> frontNewZealand = new ArrayList<>(Arrays.asList("Tasman Sea"));
        Territorio newZealand = new Territorio(this.p, "New Zealand", frontNewZealand,
                new PVector(1390, 853), 70, 25,army);
        territorios.add(newZealand);

        ArrayList<String> frontEasternAustralia = new ArrayList<>(Arrays.asList("Tasman Sea",
                "Great Australian Blight","Western Australia","Timor Sea"));
        Territorio easternAustralia = new Territorio(this.p, "Eastern Australia", frontEasternAustralia,
                new PVector(1280, 839), 100, 30,null);
        territorios.add(easternAustralia);

        ArrayList<String> frontWesternAustralia = new ArrayList<>(Arrays.asList("Tasman Sea",
                "Great Australian Blight","Eastern Australia","Shark Bay","Timor Sea"));
        Territorio westernAustralia = new Territorio(this.p, "Western Australia", frontWesternAustralia,
                new PVector(1180, 810), 100, 30,null);
        territorios.add(westernAustralia);

        ArrayList<String> frontIndonesia = new ArrayList<>(Arrays.asList("Java Sea",
                "Mid Pacific","Bay of Bengal","Timor Sea"));
        Territorio indonesia = new Territorio(this.p, "Indonesia", frontIndonesia,
                new PVector(1310, 670), 100, 25,null);
        territorios.add(indonesia);
    }
    public void setupMiddleEast(){
        ArrayList<String> frontMiddleEast = new ArrayList<>(Arrays.asList("Sea of Crete",
                "Red Sea","Arabia","Iraq","Turkey"));
        Territorio middleEast = new Territorio(this.p, "Middle East", frontMiddleEast,
                new PVector(919, 465), 70, 25,null);
        territorios.add(middleEast);

        ArrayList<String> frontArabia = new ArrayList<>(Arrays.asList("Middle East",
                "Red Sea","Arabian Sea","Iraq"));
        Territorio arabia = new Territorio(this.p, "Arabia", frontArabia,
                new PVector(996, 545), 50, 25,null);
        territorios.add(arabia);

        ArrayList<String> frontIraq = new ArrayList<>(Arrays.asList("Middle East",
                "Arabia","Arabian Sea","Turkey","Iran"));
        Territorio iraq = new Territorio(this.p, "Iraq", frontIraq,
                new PVector(1004, 454), 40, 25,null);
        territorios.add(iraq);

        ArrayList<String> frontIran = new ArrayList<>(Arrays.asList("Pakistan",
                "Arabian Sea","Turkey","Iraq"));
        Territorio iran = new Territorio(this.p, "Iran", frontIran,
                new PVector(1056, 444), 40, 25,null);
        territorios.add(iran);

        ArrayList<String> frontTurkey = new ArrayList<>(Arrays.asList("Pakistan",
                "Black Sea","Iran","Iraq","Pakistan","Kazakh"));
        Territorio turkey = new Territorio(this.p, "Turkey", frontTurkey,
                new PVector(1056, 444), 40, 25,null);
        territorios.add(turkey);

    }
    public void setupMarAzulClaro(){
        // South America
        ArrayList<String> frontBarkleySound = new ArrayList<>(Arrays.asList("Alaska",
                "Western Canada","North Pacific", "Western USA","Santa Barbara Passage"));
        MarAzulClaro barkleySound = new MarAzulClaro(this.p, "Barkley Sound", frontBarkleySound,
                new PVector(158, 245), 100, 30,null);
        territorios.add(barkleySound);

        ArrayList<String> frontSantaBarbara = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Gulf of Panama","North Pacific", "Western USA","Central America", "Barkley Sound"));
        MarAzulClaro santaBarbara = new MarAzulClaro(this.p, "Santa Barbara Passage", frontSantaBarbara,
                new PVector(100, 351), 130, 30,null);
        territorios.add(santaBarbara);

        ArrayList<String> frontGulfOfPanama = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Santa Barbara Passage","Venezuela", "Lima Bay","Central America"));
        MarAzulClaro gulfOfPanama = new MarAzulClaro(this.p, "Gulf of Panama", frontGulfOfPanama,
                new PVector(190, 524), 100, 30,null);
        territorios.add(gulfOfPanama);

        ArrayList<String> frontLimaBay = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Argentina","Venezuela", "Peru","Gulf of Panama"));
        MarAzulClaro limaBay = new MarAzulClaro(this.p, "Lima Bay", frontLimaBay,
                new PVector(290, 717), 100, 30,null);
        territorios.add(limaBay);

        ArrayList<String> frontRioDeLaPlata = new ArrayList<>(Arrays.asList("South Atlantic",
                "Argentina","Baia Santos"));
        MarAzulClaro RioDeLaPlata = new MarAzulClaro(this.p, "Rio de la Plata", frontRioDeLaPlata,
                new PVector(490, 832), 100, 30,null);
        territorios.add(RioDeLaPlata);

        ArrayList<String> frontBaiaSantos = new ArrayList<>(Arrays.asList("South Atlantic",
                "Argentina","Rio de la Plata", "Brazil", "Mid Atlantic"));
        MarAzulClaro baiaSantos = new MarAzulClaro(this.p, "Baia Santos", frontBaiaSantos,
                new PVector(537, 697), 70, 30,null);
        territorios.add(baiaSantos);

        ArrayList<String> frontCarribeanSea = new ArrayList<>(Arrays.asList("Central America",
                "Venezuela","Mid-West USA", "Brazil", "Mid Atlantic","Eastern USA","Long Island Sound"));
        MarAzulClaro carribeanSea = new MarAzulClaro(this.p, "Carribean Sea", frontCarribeanSea,
                new PVector(380, 492), 100, 30,null);
        territorios.add(carribeanSea);

        ArrayList<String> frontLongIslandSound = new ArrayList<>(Arrays.asList("Carribean Sea",
                "Gulf of St. Lawrence", "Mid Atlantic","Eastern USA","North Atlantic"));
        MarAzulClaro longIslandSound = new MarAzulClaro(this.p, "Long Island Sound", frontLongIslandSound,
                new PVector(400, 390), 100, 30,null);
        territorios.add(longIslandSound);

        ArrayList<String> frontGulfOfStLawrence = new ArrayList<>(Arrays.asList("Eastern Canada",
                "Long Island Sound", "Hudson Strait","Eastern USA","North Atlantic"));
        MarAzulClaro gulfOfStLawrence = new MarAzulClaro(this.p, "Gulf of St. Lawrence", frontGulfOfStLawrence,
                new PVector(488, 311), 110, 30,null);
        territorios.add(gulfOfStLawrence);

        ArrayList<String> frontHudsonStrait = new ArrayList<>(Arrays.asList("Eastern Canada",
                "Gulf of St. Lawrence", "Greenland","Western Canada","North Atlantic","Northern Canada"));
        MarAzulClaro hudsonStrait = new MarAzulClaro(this.p, "Hudson Strait", frontHudsonStrait,
                new PVector(454, 188), 90, 30,null);
        territorios.add(hudsonStrait);
        // Europe
        ArrayList<String> frontNorthSea = new ArrayList<>(Arrays.asList("Scandinavia",
                "British Isles", "Baltic Sea","Barents Sea","North Atlantic","Bay of Biscay",
                "Western Europe"));
        MarAzulClaro northSea = new MarAzulClaro(this.p, "North Sea", frontNorthSea,
                new PVector(701, 149), 70, 30,null);
        territorios.add(northSea);

        ArrayList<String> frontBarentsSea = new ArrayList<>(Arrays.asList("Scandinavia",
                "Kola", "Siberia","North Sea"));
        MarAzulClaro barentsSea = new MarAzulClaro(this.p, "Barents Sea", frontBarentsSea,
                new PVector(1011, 107), 90, 30,null);
        territorios.add(barentsSea);

        ArrayList<String> frontBalticSea = new ArrayList<>(Arrays.asList("Scandinavia",
                "Russia", "Poland","North Sea","Eastern Europe","Western Europe"));
        MarAzulClaro balticSea = new MarAzulClaro(this.p, "Baltic Sea", frontBalticSea,
                new PVector(861, 200), 60, 25,null);
        territorios.add(balticSea);

        ArrayList<String> frontBayOfBiscay = new ArrayList<>(Arrays.asList("North Sea",
                "Mediterranean Sea","North Atlantic","Iberia","Western Europe"));
        MarAzulClaro bayOfBiscay = new MarAzulClaro(this.p, "Bay of Biscay", frontBayOfBiscay,
                new PVector(641, 319), 90, 30,null);
        territorios.add(bayOfBiscay);

        // Oriente Medio
        ArrayList<String> frontMediterraneanSea = new ArrayList<>(Arrays.asList("Iberia",
                "Sea of Crete","North Atlantic","Red Sea","Western Europe","Mid Atlantic",
                "Eastern Europe","Sahara","Egypt"));
        MarAzulClaro mediterraneanSea = new MarAzulClaro(this.p, "Mediterranean Sea", frontMediterraneanSea,
                new PVector(702, 426), 130, 30,null);
        territorios.add(mediterraneanSea);

        ArrayList<String> frontSeaOfCrete = new ArrayList<>(Arrays.asList("Black Sea",
                "Mediterranean Sea","Red Sea","Eastern Europe","Greece","Middle East","Turkey"));
        MarAzulClaro seaOfCrete = new MarAzulClaro(this.p, "Sea of Crete", frontSeaOfCrete,
                new PVector(862, 418), 90, 30,null);
        territorios.add(seaOfCrete);

        ArrayList<String> frontBlackSea = new ArrayList<>(Arrays.asList("Sea of Crete",
                "Romania","Kazakh","Greece","Turkey"));
        MarAzulClaro blackSea = new MarAzulClaro(this.p, "Black Sea", frontBlackSea,
                new PVector(966, 338), 70, 30,null);
        territorios.add(blackSea);
        // Africa
        ArrayList<String> frontGulfOfGuinea = new ArrayList<>(Arrays.asList("Mid Atlantic",
                "South Atlantic","Nigeria","Zaire","Cape of Good Hope"));
        MarAzulClaro golfOfGuinea = new MarAzulClaro(this.p, "Gulf of Guinea", frontGulfOfGuinea,
                new PVector(713, 637), 90, 30,null);
        territorios.add(golfOfGuinea);

        ArrayList<String> frontCapeOfGoodHope = new ArrayList<>(Arrays.asList("Straits of Malacca",
                "South Atlantic","Indian Ocean","Zaire","Gulf of Guinea","South Africa", "Mozambique"));
        MarAzulClaro capeOfGoodHope = new MarAzulClaro(this.p, "Cape of Good Hope", frontCapeOfGoodHope,
                new PVector(846, 834), 110, 30,null);
        territorios.add(capeOfGoodHope);

        ArrayList<String> frontStraitsOfMalacca = new ArrayList<>(Arrays.asList("Cape of Good Hope",
                "Mozambique","Indian Ocean","Red Sea","South Africa"));
        MarAzulClaro straitsOfMalacca = new MarAzulClaro(this.p, "Straits of Malacca", frontStraitsOfMalacca,
                new PVector(973, 713), 110, 30,null);
        territorios.add(straitsOfMalacca);

        ArrayList<String> frontRedSea = new ArrayList<>(Arrays.asList("Straits of Malacca",
                "Mozambique","Egypt","Arabia","Arabian Sea","Middle East","Sea of Crete","Mediterranean Sea"));
        MarAzulClaro redSea = new MarAzulClaro(this.p, "Red Sea", frontRedSea,
                new PVector(920, 540), 60, 25,null);
        territorios.add(redSea);

        //Russia & China
        ArrayList<String> frontSeaOfOkhotsk = new ArrayList<>(Arrays.asList("North Pacific",
                "Yakutsk","Buryatsk","Japan","Sea of Japan","Tokyo Bay"));
        MarAzulClaro seaOfOkhotsk = new MarAzulClaro(this.p, "Sea of Okhotsk", frontSeaOfOkhotsk,
                new PVector(1350, 251), 110, 25,null);
        territorios.add(seaOfOkhotsk);

        ArrayList<String> frontTokyoBay = new ArrayList<>(Arrays.asList("North Pacific",
                "Sea of Okhotsk","Japan","Sea of Japan"));
        MarAzulClaro tokyoBay = new MarAzulClaro(this.p, "Tokyo Bay", frontTokyoBay,
                new PVector(1416, 330), 60, 30,null);
        territorios.add(tokyoBay);

        ArrayList<String> frontSeaOfJapan = new ArrayList<>(Arrays.asList("North Pacific",
                "Sea of Okhotsk","Japan","Tokyo Bay","Manchuria","Mongolia","Shantung",
                "Nanling","South China Sea","Mid Pacific"));
        MarAzulClaro seaOfJapan = new MarAzulClaro(this.p, "Sea of Japan", frontSeaOfJapan,
                new PVector(1370, 415), 80, 25,null);
        territorios.add(seaOfJapan);

        ArrayList<String> frontSouthChinaSea = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Sea of Japan","Indo-China","Java Sea","Nanling"));
        MarAzulClaro southChinaSea = new MarAzulClaro(this.p, "South China Sea", frontSouthChinaSea,
                new PVector(1379, 476), 100, 25,null);
        territorios.add(southChinaSea);

        // Oceania
        ArrayList<String> frontTasmanSea = new ArrayList<>(Arrays.asList("South Pacific",
                "Timor Sea","New Zealand","Eastern Australia","Great Australian Blight"));
        MarAzulClaro tasmanSea = new MarAzulClaro(this.p, "Tasman Sea", frontTasmanSea,
                new PVector(1338, 941), 70, 25,null);
        territorios.add(tasmanSea);

        ArrayList<String> frontTimorSea = new ArrayList<>(Arrays.asList("South Pacific",
                "Tasman Sea","Western Australia","Eastern Australia","Mid Pacific",
                "Shark Bay","Bay of Bengal","Indonesia"));
        MarAzulClaro timorSea = new MarAzulClaro(this.p, "Timor Sea", frontTimorSea,
                new PVector(1262, 705), 70, 25,null);
        territorios.add(timorSea);

        ArrayList<String> frontTSharkBay = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Timor Sea","Western Australia","Great Australian Blight"));
        MarAzulClaro sharkBay = new MarAzulClaro(this.p, "Shark Bay", frontTSharkBay,
                new PVector(1123, 780), 70, 25,null);
        territorios.add(sharkBay);

        //India - Oriente
        ArrayList<String> frontArabianSea = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Red Sea","Arabia","Iraq","Iran","Pakistan","India","Bay of Bengal"));
        MarAzulClaro arabianSea = new MarAzulClaro(this.p, "Arabian Sea", frontArabianSea,
                new PVector(1097, 572), 70, 25,null);
        territorios.add(arabianSea);

        ArrayList<String> frontBayOfBengal = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Arabian Sea","Burma","India","Java Sea","Timor Sea","Indonesia"));
        MarAzulClaro bayOfBengal = new MarAzulClaro(this.p, "Bay of Bengal", frontBayOfBengal,
                new PVector(1142, 627), 90, 25,null);
        territorios.add(bayOfBengal);

        ArrayList<String> frontJavaSea = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Indo-China","Burma","South China Sea","Bay of Bengal","Indonesia"));
        MarAzulClaro javaSea = new MarAzulClaro(this.p, "Java Sea", frontJavaSea,
                new PVector(1328, 616), 60, 25,null);
        territorios.add(javaSea);

    }
    public void setupMarAzulEscuro(){
        ArrayList<String> frontNorthPacific = new ArrayList<>(Arrays.asList("Alaska",
                "Barkley Sound","", "Mid Pacific","Santa Barbara Passage","Yakutsk",
                "Sea of Okhotsk","Tokyo Bay","Sea of Japan"));
        MarAzulEscuro northPacific = new MarAzulEscuro(this.p, "North Pacific", frontNorthPacific,
                new PVector(63, 191),new PVector(1436,208), 70, 30,null);
        territorios.add(northPacific);

        ArrayList<String> frontMidPacific = new ArrayList<>(Arrays.asList("Gulf of Panama",
                "Lima Bay", "North Pacific","Santa Barbara Passage","South Pacific",
                "Sea of Japan","South China Sea","Java Sea", "Indonesia","Timor Sea"));
        MarAzulEscuro midPacific = new MarAzulEscuro(this.p, "Mid Pacific", frontMidPacific,
                new PVector(58, 561),new PVector(1423,522), 70, 40,null);
        territorios.add(midPacific);

        ArrayList<String> frontSouthPacific = new ArrayList<>(Arrays.asList("Argentina",
                "Lima Bay", "Mid Pacific","South Atlantic","Tasman Sea",
                "Great Australian Blight"));
        MarAzulEscuro southPacific = new MarAzulEscuro(this.p, "South Pacific", frontSouthPacific,
                new PVector(73, 751),new PVector(1429,760), 70, 40,null);
        territorios.add(southPacific);

        ArrayList<String> frontSouthAtlantic = new ArrayList<>(Arrays.asList("Rio de la Plata",
                "Baia Santos", "Mid Atlantic","South Pacific","Gulf of Guinea",
                "Cape of Good Hope","Indian Ocean"));
        MarAzulEscuro southAtlantic = new MarAzulEscuro(this.p, "South Atlantic", frontSouthAtlantic,
                new PVector(630, 824),null, 80, 40,null);
        territorios.add(southAtlantic);

        ArrayList<String> frontMidAtlantic = new ArrayList<>(Arrays.asList("Brazil",
                "Baia Santos", "North Atlantic","Sahara","Gulf of Guinea",
                "Carribean Sea","Long Island Sound","Mediterranean Sea","South Atlantic"));
        MarAzulEscuro midAtlantic = new MarAzulEscuro(this.p, "Mid Atlantic", frontMidAtlantic,
                new PVector(543, 543),null, 80, 40,null);
        territorios.add(midAtlantic);

        ArrayList<String> frontNorthAtlantic = new ArrayList<>(Arrays.asList("Gulf of St. Lawrence",
                "Mid Atlantic", "Hudson Strait","North Sea","Bay of Biscay",
                "Long Island Sound","Mediterranean Sea"));
        MarAzulEscuro northAtlantic = new MarAzulEscuro(this.p, "North Atlantic", frontNorthAtlantic,
                new PVector(533, 370),null, 90, 40,null);
        territorios.add(northAtlantic);

        ArrayList<String> frontIndianOcean = new ArrayList<>(Arrays.asList("Cape of Good Hope",
                "South Atlantic", "Straits of Malacca","Red Sea","Arabian Sea","Bay of Bengal",
                "Timor Sea","Shark Bay", "Great Australian Blight"));
        MarAzulEscuro indianOcean = new MarAzulEscuro(this.p, "Indian Ocean", frontIndianOcean,
                new PVector(960, 878),null, 90, 40,null);
        territorios.add(indianOcean);

        ArrayList<String> frontGreatAusBlight = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Western Australia","Shark Bay", "Eastern Australia","Tasman Sea","South Pacific"));
        MarAzulEscuro greatAusBlight = new MarAzulEscuro(this.p, "Great Australian Blight", frontGreatAusBlight,
                new PVector(1195, 956),null, 140, 40,null);
        territorios.add(greatAusBlight);

    }
}
