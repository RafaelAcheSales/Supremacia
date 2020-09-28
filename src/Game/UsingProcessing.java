package Game;
import processing.core.*;

import javax.swing.*;
import java.util.*;

public class UsingProcessing extends PApplet {
    private ArrayList<Territorio> territorios = new ArrayList<>();
    private ArrayList<Botao> botoes = new ArrayList<>();
	PImage mapa;
    // The argument passed to main must match the class name
    public static void main(String[] args) {
//        PApplet.main("Game.UsingProcessing");
        JFrame frame = new SupremaciaGUI("Supremacia");
        frame.setVisible(true);
    }

    // method used only for setting the size of the window
    public void settings(){
    	size(displayWidth, displayHeight);
    }

    public void setupSouthAmerica(){
        ArrayList<String> frontBrazil = new ArrayList<>(Arrays.asList("Venezuela",
                "Peru", "Argentina", "Carribean Sea", "Mid Atlantic", "Baia Santos"));
        Territorio brazil = new Territorio(this, "Brazil", frontBrazil,
                new PVector(460, 620), 60, 30,null);
        territorios.add(brazil);

        ArrayList<String> frontArg = new ArrayList<>(Arrays.asList("Brazil", "Peru",
                "Baia Santos", "Rio de la Plata", "South Pacific", "Lima Bay"));
        Territorio argentina = new Territorio(this, "Argentina", frontArg,
                new PVector(440,740), 60, 30,null);
        territorios.add(argentina);

        ArrayList<String> frontVene = new ArrayList<>(Arrays.asList("Brazil", "Peru",
                "Carribean Sea","Central America", "Gulf of Panama","Lima Bay"));
        Territorio venezuela = new Territorio(this, "Venezuela", frontVene,
                new PVector(330, 580), 60, 30,null);
        territorios.add(venezuela);

        ArrayList<String> frontPeru = new ArrayList<>(Arrays.asList("Venezuela", "Brazil",
                "Argentina","Lima Bay"));
        Territorio peru = new Territorio(this, "Peru", frontPeru,
                new PVector(380, 670), 60, 30,null);
        territorios.add(peru);

    }
    public void setupCentralAmerica(){
        ArrayList<String> frontCentralAmerica = new ArrayList<>(Arrays.asList("Carribean Sea",
                "Venezuela","Gulf of Panama", "Santa Barbara Passage","Western USA","Mid-West USA"));
        Territorio centralAmerica = new Territorio(this, "Central America", frontCentralAmerica,
                new PVector(260, 490), 100, 30,null);
        territorios.add(centralAmerica);
    }
    public void setupNorthAmerica(){
        ArrayList<String> frontAlaska = new ArrayList<>(Arrays.asList("Nothern Canada",
                "Western Canada","North Pacific", "Barkley Sound"));
        Territorio alaska = new Territorio(this, "Alaska", frontAlaska,
                new PVector(180, 180), 60, 30,null);
        territorios.add(alaska);

        ArrayList<String> frontWesternUSA = new ArrayList<>(Arrays.asList("Mid-West USA",
                "Western Canada","Santa Barbara Passage", "Barkley Sound","Central America"));
        Territorio westernUSA = new Territorio(this, "Western USA", frontWesternUSA,
                new PVector(217, 333), 80, 30,null);
        territorios.add(westernUSA);

        ArrayList<String> frontMidWestUSA = new ArrayList<>(Arrays.asList("Western USA",
                "Western Canada","Eastern Canada", "Eastern USA","Central America"));
        Territorio midWestUSA = new Territorio(this, "Mid-West USA", frontMidWestUSA,
                new PVector(333, 297), 90, 30,null);
        territorios.add(midWestUSA);

        ArrayList<String> frontEasternUSA = new ArrayList<>(Arrays.asList("Mid-West USA",
                "Gulf of St. Lawrence","Eastern Canada", "Long Island Sound","Carribean Sea"));
        Territorio easternUSA = new Territorio(this, "Eastern USA", frontEasternUSA,
                new PVector(367, 337), 90, 30,null);
        territorios.add(easternUSA);

        ArrayList<String> frontNorthernCanada = new ArrayList<>(Arrays.asList("Alaska",
                "Western Canada", "Greenland", "Hudson Strait"));
        Territorio northernCanada = new Territorio(this, "Northern Canada", frontNorthernCanada,
                new PVector(305, 191), 100, 30,null);
        territorios.add(northernCanada);

        ArrayList<String> frontWesternCanada = new ArrayList<>(Arrays.asList("Alaska",
                "Northern Canada", "Barkley Sound", "Hudson Strait","Eastern Canada","Western USA"));
        Territorio westernCanada = new Territorio(this, "Western Canada", frontWesternCanada,
                new PVector(280, 252), 100, 30,null);
        territorios.add(westernCanada);

        ArrayList<String> frontEasternCanada = new ArrayList<>(Arrays.asList("Mid-West USA",
                "Eastern USA", "Barkley Sound", "Hudson Strait","Western Canada"));
        Territorio easternCanada = new Territorio(this, "Eastern Canada", frontEasternCanada,
                new PVector(423, 260), 100, 30,null);
        territorios.add(easternCanada);

        ArrayList<String> frontGreenland = new ArrayList<>(Arrays.asList("North Atlantic",
                "Northern Canada","Hudson Strait"));
        Territorio greenland = new Territorio(this, "Greenland", frontGreenland,
                new PVector(500, 140), 100, 30,null);
        territorios.add(greenland);
    }
    public void setupAfrica(){
        ArrayList<String> frontSahara = new ArrayList<>(Arrays.asList("Mid Atlantic",
                "Mediterranean Sea","Egypt", "Nigeria"));
        Territorio sahara = new Territorio(this, "Sahara", frontSahara,
                new PVector(711, 507), 60, 30,null);
        territorios.add(sahara);

        ArrayList<String> frontEgypt = new ArrayList<>(Arrays.asList("Sahara",
                "Mediterranean Sea","Red Sea", "Nigeria","Mozambique"));
        Territorio egypt = new Territorio(this, "Egypt", frontEgypt,
                new PVector(844, 527), 60, 30,null);
        territorios.add(egypt);

        ArrayList<String> frontNigeria = new ArrayList<>(Arrays.asList("Sahara",
                "Egypt","Gulf of Guinea", "Zaire","Mozambique","Mid Atlantic"));
        Territorio nigeria = new Territorio(this, "Nigeria", frontNigeria,
                new PVector(756, 578), 60, 30,null);
        territorios.add(nigeria);

        ArrayList<String> frontZaire = new ArrayList<>(Arrays.asList("South Africa",
                "Gulf of Guinea", "Nigeria","Mozambique","Cape of Good Hope"));
        Territorio zaire = new Territorio(this, "Zaire", frontZaire,
                new PVector(832, 693), 60, 30,null);
        territorios.add(zaire);

        ArrayList<String> frontMozambique = new ArrayList<>(Arrays.asList("South Africa",
                "Straits of Malacca", "Nigeria","Zaire","Red Sea","Egypt"));
        Territorio mozambique = new Territorio(this, "Mozambique", frontMozambique,
                new PVector(931, 654), 80, 30,null);
        territorios.add(mozambique);

        ArrayList<String> frontSouthAfrica = new ArrayList<>(Arrays.asList("Mozambique",
                "Straits of Malacca", "Cape of Good Hope","Zaire"));
        Territorio southAfrica = new Territorio(this, "Mozambique", frontSouthAfrica,
                new PVector(866, 772), 80, 30,null);
        territorios.add(southAfrica);

    }
    public void setupRussia(){
        ArrayList<String> frontKola = new ArrayList<>(Arrays.asList("Barents Sea",
                "Scandinavia","Rusia", "Siberia"));
        Territorio kola = new Territorio(this, "Kola", frontKola,
                new PVector(1004, 180), 40, 30,null);
        territorios.add(kola);

        ArrayList<String> frontRussia = new ArrayList<>(Arrays.asList("Baltic Sea",
                "Scandinavia","Baltic Sea", "Siberia","Poland","Romania","Kazakh","Buryatsk","Kola"));
        Territorio russia = new Territorio(this, "Russia", frontRussia,
                new PVector(989, 247), 60, 30,null);
        territorios.add(russia);

        ArrayList<String> frontKazakh = new ArrayList<>(Arrays.asList("Black Sea",
                "Manchuria","Mongolia", "Tibet","Pakistan","Romania","Russia","Buryatsk",
                "Black Sea"));
        Territorio kazakh = new Territorio(this, "Kazakh", frontKazakh,
                new PVector(1074, 316), 60, 30,null);
        territorios.add(kazakh);

        ArrayList<String> frontSiberia = new ArrayList<>(Arrays.asList("Barents Sea",
                "Yakutsk","Kola","Russia","Buryatsk"));
        Territorio siberia = new Territorio(this, "Siberia", frontSiberia,
                new PVector(1152, 200), 60, 30,null);
        territorios.add(siberia);

        ArrayList<String> frontBuryatsk = new ArrayList<>(Arrays.asList("Sea of Okhotsk",
                "Yakutsk","Sea of Japan","Russia","Siberia","Manchuria","Mongolia","Kazakh"));
        Territorio buryatsk = new Territorio(this, "Buryatsk", frontBuryatsk,
                new PVector(1224, 281), 60, 30,null);
        territorios.add(buryatsk);

        ArrayList<String> frontYakutsk = new ArrayList<>(Arrays.asList("Sea of Okhotsk",
                "Buryatsk","North Pacific","Siberia"));
        Territorio yakutsk = new Territorio(this, "Yakutsk", frontYakutsk,
                new PVector(1314, 171), 60, 30,null);
        territorios.add(yakutsk);

    }
    public void setupEurope(){
        ArrayList<String> frontBritishIsles = new ArrayList<>(Arrays.asList("North Sea"));
        Territorio britishIsles = new Territorio(this, "British Isles", frontBritishIsles,
                new PVector(705, 246), 70, 25,null);
        territorios.add(britishIsles);

        ArrayList<String> frontScandinavia = new ArrayList<>(Arrays.asList("North Sea",
                "Barents Sea","Baltic Sea", "Kola","Russia"));
        Territorio scandinavia = new Territorio(this, "Scandinavia", frontScandinavia,
                new PVector(785, 190), 90, 25,null);
        territorios.add(scandinavia);

        ArrayList<String> frontPoland = new ArrayList<>(Arrays.asList("Eastern Europe",
                "Greece","Romania", "Kola","Russia","Baltic Sea"));
        Territorio poland = new Territorio(this, "Poland", frontPoland,
                new PVector(859, 262), 60, 25,null);
        territorios.add(poland);

        ArrayList<String> frontIberia = new ArrayList<>(Arrays.asList("Western Europe",
                "Bay of Biscay","Mediterranean Sea"));
        Territorio iberia = new Territorio(this, "Iberia", frontIberia,
                new PVector(683, 374), 60, 25,null);
        territorios.add(iberia);

        ArrayList<String> frontWesternEurope = new ArrayList<>(Arrays.asList("Iberia",
                "Bay of Biscay","Mediterranean Sea","North Sea","Eastern Europe","Baltic Sea"));
        Territorio westernEurope = new Territorio(this, "Western Europe", frontWesternEurope,
                new PVector(740, 323), 90, 25,null);
        territorios.add(westernEurope);

        ArrayList<String> frontEasternEurope = new ArrayList<>(Arrays.asList("Poland",
                "Greece","Mediterranean Sea","Western Europe","Baltic Sea"));
        Territorio easternEurope = new Territorio(this, "Eastern Europe", frontEasternEurope,
                new PVector(809, 290), 90, 25,null);
        territorios.add(easternEurope);

        ArrayList<String> frontGreece = new ArrayList<>(Arrays.asList("Poland",
                "Romania","Sea of Crete","Black Sea","Eastern Europe"));
        Territorio greece = new Territorio(this, "Greece", frontGreece,
                new PVector(851, 343), 60, 25,null);
        territorios.add(greece);

        ArrayList<String> frontRomania = new ArrayList<>(Arrays.asList("Poland",
                "Greece","Russia","Black Sea","Kazakh"));
        Territorio romania = new Territorio(this, "Romania", frontRomania,
                new PVector(900, 305), 60, 25,null);
        territorios.add(romania);

    }
    public void setupOceania(){
        ArrayList<String> frontNewZealand = new ArrayList<>(Arrays.asList("Tasman Sea"));
        Territorio newZealand = new Territorio(this, "New Zealand", frontNewZealand,
                new PVector(1390, 853), 70, 25,null);
        territorios.add(newZealand);

        ArrayList<String> frontEasternAustralia = new ArrayList<>(Arrays.asList("Tasman Sea",
                "Great Australian Blight","Western Australia","Timor Sea"));
        Territorio easternAustralia = new Territorio(this, "Eastern Australia", frontEasternAustralia,
                new PVector(1280, 839), 100, 30,null);
        territorios.add(easternAustralia);

        ArrayList<String> frontWesternAustralia = new ArrayList<>(Arrays.asList("Tasman Sea",
                "Great Australian Blight","Eastern Australia","Shark Bay","Timor Sea"));
        Territorio westernAustralia = new Territorio(this, "Western Australia", frontWesternAustralia,
                new PVector(1180, 810), 100, 30,null);
        territorios.add(westernAustralia);

        ArrayList<String> frontIndonesia = new ArrayList<>(Arrays.asList("Java Sea",
                "Mid Pacific","Bay of Bengal","Timor Sea"));
        Territorio indonesia = new Territorio(this, "Indonesia", frontIndonesia,
                new PVector(1310, 670), 70, 25,null);
        territorios.add(indonesia);
    }
    public void setupMiddleEast(){
        ArrayList<String> frontMiddleEast = new ArrayList<>(Arrays.asList("Sea of Crete",
                "Red Sea","Arabia","Iraq","Turkey"));
        Territorio middleEast = new Territorio(this, "Middle East", frontMiddleEast,
                new PVector(919, 465), 70, 25,null);
        territorios.add(middleEast);

        ArrayList<String> frontArabia = new ArrayList<>(Arrays.asList("Middle East",
                "Red Sea","Arabian Sea","Iraq"));
        Territorio arabia = new Territorio(this, "Arabia", frontArabia,
                new PVector(996, 545), 50, 25,null);
        territorios.add(arabia);

        ArrayList<String> frontIraq = new ArrayList<>(Arrays.asList("Middle East",
                "Arabia","Arabian Sea","Turkey","Iran"));
        Territorio iraq = new Territorio(this, "Iraq", frontIraq,
                new PVector(1004, 454), 40, 25,null);
        territorios.add(iraq);

        ArrayList<String> frontIran = new ArrayList<>(Arrays.asList("Pakistan",
                "Arabian Sea","Turkey","Iraq"));
        Territorio iran = new Territorio(this, "Iran", frontIran,
                new PVector(1056, 444), 35, 25,null);
        territorios.add(iran);

        ArrayList<String> frontTurkey = new ArrayList<>(Arrays.asList("Pakistan",
                "Black Sea","Iran","Iraq","Pakistan","Kazakh","Sea of Crete","Middle East"));
        Territorio turkey = new Territorio(this, "Turkey", frontTurkey,
                new PVector(991, 384), 40, 25,null);
        territorios.add(turkey);

        ArrayList<String> frontPakistan = new ArrayList<>(Arrays.asList("Turkey",
                "Iran","Tibet","India","Kazakh","Arabian Sea"));
        Territorio pakistan = new Territorio(this, "Pakistan", frontPakistan,
                new PVector(1107, 433), 50, 25,null);
        territorios.add(pakistan);

    }
    public void setupChina(){
        ArrayList<String> frontManchuria = new ArrayList<>(Arrays.asList("Buryatsk",
                "Mongolia","Sea of Japan"));
        Territorio manchuria = new Territorio(this, "Manchuria", frontManchuria,
                new PVector(1256, 341), 60, 25,null);
        territorios.add(manchuria);

        ArrayList<String> frontMongolia = new ArrayList<>(Arrays.asList("Buryatsk",
                "Manchuria","Sea of Japan","Shantung","Tibet","Kazakh"));
        Territorio mongolia = new Territorio(this, "Mongolia", frontMongolia,
                new PVector(1226,378 ), 60, 25,null);
        territorios.add(mongolia);

        ArrayList<String> frontTibet = new ArrayList<>(Arrays.asList("Mongolia",
                "Nanling","Shantung","Kazakh","Pakistan","India"));
        Territorio tibet = new Territorio(this, "Tibet", frontTibet,
                new PVector(1171,423 ), 40, 25,null);
        territorios.add(tibet);

        ArrayList<String> frontShantung = new ArrayList<>(Arrays.asList("Mongolia",
                "Nanling","Tibet","Sea of Japan"));
        Territorio shantung = new Territorio(this, "Shantung", frontShantung,
                new PVector(1270,412 ), 60, 25,null);
        territorios.add(shantung);

        ArrayList<String> frontNanling = new ArrayList<>(Arrays.asList("India",
                "Shantung","Tibet","Sea of Japan","South China Sea","Burma","Indo-China"));
        Territorio nanling = new Territorio(this, "Nanling", frontNanling,
                new PVector(1263,444 ), 60, 25,null);
        territorios.add(nanling);

        ArrayList<String> frontJapan = new ArrayList<>(Arrays.asList("Sea of Japan",
                "Tokyo Bay","Sea of Okhotsk"));
        Territorio japan = new Territorio(this, "Japan", frontJapan,
                new PVector(1380,378 ), 40, 25,null);
        territorios.add(japan);

        ArrayList<String> frontIndia = new ArrayList<>(Arrays.asList("Tibet",
                "Arabian Sea","Bay of Bengal","Burma","Nanling","Pakistan"));
        Territorio india = new Territorio(this, "India", frontIndia,
                new PVector(1175, 509), 50, 25,null);
        territorios.add(india);

        ArrayList<String> frontBurma = new ArrayList<>(Arrays.asList("Indo-China",
                "Java Sea","Bay of Bengal","India","Nanling"));
        Territorio burma = new Territorio(this, "Burma", frontBurma,
                new PVector(1248, 505), 45, 25,null);
        territorios.add(burma);

        ArrayList<String> frontIndoChina = new ArrayList<>(Arrays.asList("Burma",
                "Java Sea","South China Sea","Nanling"));
        Territorio indoChina = new Territorio(this, "Indo-China", frontIndoChina,
                new PVector(1309, 505), 60, 25,null);
        territorios.add(indoChina);
    }
    public void setupMarAzulClaro(){
        // South America
        ArrayList<String> frontBarkleySound = new ArrayList<>(Arrays.asList("Alaska",
                "Western Canada","North Pacific", "Western USA","Santa Barbara Passage"));
        MarAzulClaro barkleySound = new MarAzulClaro(this, "Barkley Sound", frontBarkleySound,
                new PVector(158, 245), 100, 30,null);
        territorios.add(barkleySound);

        ArrayList<String> frontSantaBarbara = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Gulf of Panama","North Pacific", "Western USA","Central America", "Barkley Sound"));
        MarAzulClaro santaBarbara = new MarAzulClaro(this, "Santa Barbara Passage", frontSantaBarbara,
                new PVector(100, 351), 130, 30,null);
        territorios.add(santaBarbara);

        ArrayList<String> frontGulfOfPanama = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Santa Barbara Passage","Venezuela", "Lima Bay","Central America"));
        MarAzulClaro gulfOfPanama = new MarAzulClaro(this, "Gulf of Panama", frontGulfOfPanama,
                new PVector(190, 524), 100, 30,null);
        territorios.add(gulfOfPanama);

        ArrayList<String> frontLimaBay = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Argentina","Venezuela", "Peru","Gulf of Panama"));
        MarAzulClaro limaBay = new MarAzulClaro(this, "Lima Bay", frontLimaBay,
                new PVector(290, 717), 100, 30,null);
        territorios.add(limaBay);

        ArrayList<String> frontRioDeLaPlata = new ArrayList<>(Arrays.asList("South Atlantic",
                "Argentina","Baia Santos"));
        MarAzulClaro RioDeLaPlata = new MarAzulClaro(this, "Rio de la Plata", frontRioDeLaPlata,
                new PVector(490, 832), 100, 30,null);
        territorios.add(RioDeLaPlata);

        ArrayList<String> frontBaiaSantos = new ArrayList<>(Arrays.asList("South Atlantic",
                "Argentina","Rio de la Plata", "Brazil", "Mid Atlantic"));
        MarAzulClaro baiaSantos = new MarAzulClaro(this, "Baia Santos", frontBaiaSantos,
                new PVector(537, 697), 70, 30,null);
        territorios.add(baiaSantos);

        ArrayList<String> frontCarribeanSea = new ArrayList<>(Arrays.asList("Central America",
                "Venezuela","Mid-West USA", "Brazil", "Mid Atlantic","Eastern USA","Long Island Sound"));
        MarAzulClaro carribeanSea = new MarAzulClaro(this, "Carribean Sea", frontCarribeanSea,
                new PVector(380, 492), 100, 30,null);
        territorios.add(carribeanSea);

        ArrayList<String> frontLongIslandSound = new ArrayList<>(Arrays.asList("Carribean Sea",
                "Gulf of St. Lawrence", "Mid Atlantic","Eastern USA","North Atlantic"));
        MarAzulClaro longIslandSound = new MarAzulClaro(this, "Long Island Sound", frontLongIslandSound,
                new PVector(400, 390), 100, 30,null);
        territorios.add(longIslandSound);

        ArrayList<String> frontGulfOfStLawrence = new ArrayList<>(Arrays.asList("Eastern Canada",
                "Long Island Sound", "Hudson Strait","Eastern USA","North Atlantic"));
        MarAzulClaro gulfOfStLawrence = new MarAzulClaro(this, "Gulf of St. Lawrence", frontGulfOfStLawrence,
                new PVector(488, 311), 110, 30,null);
        territorios.add(gulfOfStLawrence);

        ArrayList<String> frontHudsonStrait = new ArrayList<>(Arrays.asList("Eastern Canada",
                "Gulf of St. Lawrence", "Greenland","Western Canada","North Atlantic","Northern Canada"));
        MarAzulClaro hudsonStrait = new MarAzulClaro(this, "Hudson Strait", frontHudsonStrait,
                new PVector(454, 188), 90, 30,null);
        territorios.add(hudsonStrait);
        // Europe
        ArrayList<String> frontNorthSea = new ArrayList<>(Arrays.asList("Scandinavia",
                "British Isles", "Baltic Sea","Barents Sea","North Atlantic","Bay of Biscay",
                "Western Europe"));
        MarAzulClaro northSea = new MarAzulClaro(this, "North Sea", frontNorthSea,
                new PVector(701, 149), 70, 30,null);
        territorios.add(northSea);

        ArrayList<String> frontBarentsSea = new ArrayList<>(Arrays.asList("Scandinavia",
                "Kola", "Siberia","North Sea"));
        MarAzulClaro barentsSea = new MarAzulClaro(this, "Barents Sea", frontBarentsSea,
                new PVector(1011, 107), 90, 30,null);
        territorios.add(barentsSea);

        ArrayList<String> frontBalticSea = new ArrayList<>(Arrays.asList("Scandinavia",
                "Russia", "Poland","North Sea","Eastern Europe","Western Europe"));
        MarAzulClaro balticSea = new MarAzulClaro(this, "Baltic Sea", frontBalticSea,
                new PVector(861, 200), 60, 25,null);
        territorios.add(balticSea);

        ArrayList<String> frontBayOfBiscay = new ArrayList<>(Arrays.asList("North Sea",
                "Mediterranean Sea","North Atlantic","Iberia","Western Europe"));
        MarAzulClaro bayOfBiscay = new MarAzulClaro(this, "Bay of Biscay", frontBayOfBiscay,
                new PVector(641, 319), 90, 30,null);
        territorios.add(bayOfBiscay);

        // Oriente Medio
        ArrayList<String> frontMediterraneanSea = new ArrayList<>(Arrays.asList("Iberia",
                "Sea of Crete","North Atlantic","Red Sea","Western Europe","Mid Atlantic",
                "Eastern Europe","Sahara","Egypt"));
        MarAzulClaro mediterraneanSea = new MarAzulClaro(this, "Mediterranean Sea", frontMediterraneanSea,
                new PVector(702, 426), 130, 30,null);
        territorios.add(mediterraneanSea);

        ArrayList<String> frontSeaOfCrete = new ArrayList<>(Arrays.asList("Black Sea",
                "Mediterranean Sea","Red Sea","Eastern Europe","Greece","Middle East","Turkey"));
        MarAzulClaro seaOfCrete = new MarAzulClaro(this, "Sea of Crete", frontSeaOfCrete,
                new PVector(862, 418), 90, 30,null);
        territorios.add(seaOfCrete);

        ArrayList<String> frontBlackSea = new ArrayList<>(Arrays.asList("Sea of Crete",
                "Romania","Kazakh","Greece","Turkey"));
        MarAzulClaro blackSea = new MarAzulClaro(this, "Black Sea", frontBlackSea,
                new PVector(966, 338), 70, 30,null);
        territorios.add(blackSea);
        // Africa
        ArrayList<String> frontGulfOfGuinea = new ArrayList<>(Arrays.asList("Mid Atlantic",
                "South Atlantic","Nigeria","Zaire","Cape of Good Hope"));
        MarAzulClaro golfOfGuinea = new MarAzulClaro(this, "Gulf of Guinea", frontGulfOfGuinea,
                new PVector(713, 637), 90, 30,null);
        territorios.add(golfOfGuinea);

        ArrayList<String> frontCapeOfGoodHope = new ArrayList<>(Arrays.asList("Straits of Malacca",
                "South Atlantic","Indian Ocean","Zaire","Gulf of Guinea","South Africa"));
        MarAzulClaro capeOfGoodHope = new MarAzulClaro(this, "Cape of Good Hope", frontCapeOfGoodHope,
                new PVector(846, 834), 110, 30,null);
        territorios.add(capeOfGoodHope);

        ArrayList<String> frontStraitsOfMalacca = new ArrayList<>(Arrays.asList("Cape of Good Hope",
                "Mozambique","Indian Ocean","Red Sea","South Africa"));
        MarAzulClaro straitsOfMalacca = new MarAzulClaro(this, "Straits of Malacca", frontStraitsOfMalacca,
                new PVector(973, 713), 110, 30,null);
        territorios.add(straitsOfMalacca);

        ArrayList<String> frontRedSea = new ArrayList<>(Arrays.asList("Straits of Malacca",
                "Mozambique","Egypt","Arabia","Arabian Sea","Middle East","Sea of Crete","Mediterranean Sea"));
        MarAzulClaro redSea = new MarAzulClaro(this, "Red Sea", frontRedSea,
                new PVector(920, 540), 60, 25,null);
        territorios.add(redSea);

        //Russia & China
        ArrayList<String> frontSeaOfOkhotsk = new ArrayList<>(Arrays.asList("North Pacific",
                "Yakutsk","Buryatsk","Japan","Sea of Japan","Tokyo Bay"));
        MarAzulClaro seaOfOkhotsk = new MarAzulClaro(this, "Sea of Okhotsk", frontSeaOfOkhotsk,
                new PVector(1350, 251), 110, 25,null);
        territorios.add(seaOfOkhotsk);

        ArrayList<String> frontTokyoBay = new ArrayList<>(Arrays.asList("North Pacific",
                "Sea of Okhotsk","Japan","Sea of Japan"));
        MarAzulClaro tokyoBay = new MarAzulClaro(this, "Tokyo Bay", frontTokyoBay,
                new PVector(1416, 330), 60, 30,null);
        territorios.add(tokyoBay);

        ArrayList<String> frontSeaOfJapan = new ArrayList<>(Arrays.asList("North Pacific",
                "Sea of Okhotsk","Japan","Tokyo Bay","Manchuria","Mongolia","Shantung",
                "Nanling","South China Sea","Mid Pacific"));
        MarAzulClaro seaOfJapan = new MarAzulClaro(this, "Sea of Japan", frontSeaOfJapan,
                new PVector(1370, 415), 80, 25,null);
        territorios.add(seaOfJapan);

        ArrayList<String> frontSouthChinaSea = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Sea of Japan","Indo-China","Java Sea","Nanling"));
        MarAzulClaro southChinaSea = new MarAzulClaro(this, "South China Sea", frontSouthChinaSea,
                new PVector(1379, 476), 100, 25,null);
        territorios.add(southChinaSea);

        // Oceania
        ArrayList<String> frontTasmanSea = new ArrayList<>(Arrays.asList("South Pacific",
                "Timor Sea","New Zealand","Eastern Australia","Great Australian Blight"));
        MarAzulClaro tasmanSea = new MarAzulClaro(this, "Tasman Sea", frontTasmanSea,
                new PVector(1338, 941), 70, 25,null);
        territorios.add(tasmanSea);

        ArrayList<String> frontTimorSea = new ArrayList<>(Arrays.asList("South Pacific",
                "Tasman Sea","Western Australia","Eastern Australia","Mid Pacific",
                "Shark Bay","Bay of Bengal","Indonesia"));
        MarAzulClaro timorSea = new MarAzulClaro(this, "Timor Sea", frontTimorSea,
                new PVector(1262, 705), 70, 25,null);
        territorios.add(timorSea);

        ArrayList<String> frontTSharkBay = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Timor Sea","Western Australia","Great Australian Blight"));
        MarAzulClaro sharkBay = new MarAzulClaro(this, "Shark Bay", frontTSharkBay,
                new PVector(1123, 780), 70, 25,null);
        territorios.add(sharkBay);

        //India - Oriente
        ArrayList<String> frontArabianSea = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Red Sea","Arabia","Iraq","Iran","Pakistan","India","Bay of Bengal"));
        MarAzulClaro arabianSea = new MarAzulClaro(this, "Arabian Sea", frontArabianSea,
                new PVector(1097, 572), 70, 25,null);
        territorios.add(arabianSea);

        ArrayList<String> frontBayOfBengal = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Arabian Sea","Burma","India","Java Sea","Timor Sea","Indonesia"));
        MarAzulClaro bayOfBengal = new MarAzulClaro(this, "Bay of Bengal", frontBayOfBengal,
                new PVector(1142, 627), 90, 25,null);
        territorios.add(bayOfBengal);

        ArrayList<String> frontJavaSea = new ArrayList<>(Arrays.asList("Mid Pacific",
                "Indo-China","Burma","South China Sea","Bay of Bengal","Indonesia"));
        MarAzulClaro javaSea = new MarAzulClaro(this, "Java Sea", frontJavaSea,
                new PVector(1328, 616), 60, 25,null);
        territorios.add(javaSea);

    }
    public void setupMarAzulEscuro(){
        ArrayList<String> frontNorthPacific = new ArrayList<>(Arrays.asList("Alaska",
                "Barkley Sound","", "Mid Pacific","Santa Barbara Passage","Yakutsk",
                "Sea of Okhotsk","Tokyo Bay","Sea of Japan"));
        MarAzulEscuro northPacific = new MarAzulEscuro(this, "North Pacific", frontNorthPacific,
                new PVector(63, 191),new PVector(1436,208), 70, 30,null);
        territorios.add(northPacific);

        ArrayList<String> frontMidPacific = new ArrayList<>(Arrays.asList("Gulf of Panama",
                "Lima Bay", "North Pacific","Santa Barbara Passage","South Pacific",
                "Sea of Japan","South China Sea","Java Sea", "Indonesia","Timor Sea"));
        MarAzulEscuro midPacific = new MarAzulEscuro(this, "Mid Pacific", frontMidPacific,
                new PVector(58, 561),new PVector(1423,522), 70, 40,null);
        territorios.add(midPacific);

        ArrayList<String> frontSouthPacific = new ArrayList<>(Arrays.asList("Argentina",
                "Lima Bay", "Mid Pacific","South Atlantic","Tasman Sea",
                "Great Australian Blight"));
        MarAzulEscuro southPacific = new MarAzulEscuro(this, "South Pacific", frontSouthPacific,
                new PVector(73, 751),new PVector(1429,760), 70, 40,null);
        territorios.add(southPacific);

        ArrayList<String> frontSouthAtlantic = new ArrayList<>(Arrays.asList("Rio de la Plata",
                "Baia Santos", "Mid Atlantic","South Pacific","Gulf of Guinea",
                "Cape of Good Hope","Indian Ocean"));
        MarAzulEscuro southAtlantic = new MarAzulEscuro(this, "South Atlantic", frontSouthAtlantic,
                new PVector(630, 824),null, 80, 40,null);
        territorios.add(southAtlantic);

        ArrayList<String> frontMidAtlantic = new ArrayList<>(Arrays.asList("Brazil",
                "Baia Santos", "North Atlantic","Sahara","Gulf of Guinea",
                "Carribean Sea","Long Island Sound","Mediterranean Sea","South Atlantic"));
        MarAzulEscuro midAtlantic = new MarAzulEscuro(this, "Mid Atlantic", frontMidAtlantic,
                new PVector(543, 543),null, 80, 40,null);
        territorios.add(midAtlantic);

        ArrayList<String> frontNorthAtlantic = new ArrayList<>(Arrays.asList("Gulf of St. Lawrence",
                "Mid Atlantic", "Hudson Strait","North Sea","Bay of Biscay",
                "Long Island Sound","Mediterranean Sea"));
        MarAzulEscuro northAtlantic = new MarAzulEscuro(this, "North Atlantic", frontNorthAtlantic,
                new PVector(533, 370),null, 90, 40,null);
        territorios.add(northAtlantic);

        ArrayList<String> frontIndianOcean = new ArrayList<>(Arrays.asList("Cape of Good Hope",
                "South Atlantic", "Straits of Malacca","Red Sea","Arabian Sea","Bay of Bengal",
                "Timor Sea","Shark Bay", "Great Australian Blight"));
        MarAzulEscuro indianOcean = new MarAzulEscuro(this, "Indian Ocean", frontIndianOcean,
                new PVector(960, 878),null, 90, 40,null);
        territorios.add(indianOcean);

        ArrayList<String> frontGreatAusBlight = new ArrayList<>(Arrays.asList("Indian Ocean",
                "Western Australia","Shark Bay", "Eastern Australia","Tasman Sea","South Pacific"));
        MarAzulEscuro greatAusBlight = new MarAzulEscuro(this, "Great Australian Blight", frontGreatAusBlight,
                new PVector(1195, 956),null, 140, 40,null);
        territorios.add(greatAusBlight);

    }
    public void setupMapa(){
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
        //China & India
        setupChina();
    }

    public void setupBotoesEstagio(){
        // Pagar Salarios
        int botoesX=1707,salarioY=109;
        int width=120, height=30;
        Botao botaoSalario = new Botao(this,"Pagar Salarios",new PVector(botoesX,salarioY),width,height);
        botoes.add(botaoSalario);

        // Vender Suprimentos
        int venderY=159;
        Botao botaoSuprimentos = new Botao(this,"Vender Suprimentos",new PVector(botoesX,venderY),width,height);
        botoes.add(botaoSuprimentos);

        // Atacar
        int atacarY=209;
        Botao botaoAtacar = new Botao(this,"Atacar",new PVector(botoesX,atacarY),width,height);
        botoes.add(botaoAtacar);

        // Movimentar tropas
        int movimentarY=259;
        Botao botaoMovimentar = new Botao(this,"Movimentar Tropas",new PVector(botoesX,movimentarY),width,height);
        botoes.add(botaoMovimentar);

        // Construir
        int contruirY=309;
        Botao botaoConstruir = new Botao(this,"Construir",new PVector(botoesX,contruirY),width,height);
        botoes.add(botaoConstruir);

        // Comprar
        int comprarY=359;
        Botao botaoComprar = new Botao(this,"Comprar Suprimentos",new PVector(botoesX,comprarY),width,height);
        botoes.add(botaoComprar);
    }
    // identical use to setup in Processing IDE except for size()
    public void setup(){
    	this.mapa = loadImage("supremacymap.png");
        image(this.mapa, 0, 0);

        setupMapa();
        setupBotoesEstagio();
    }

    // identical use to draw in Prcessing IDE
    public void draw(){
        for (int i = 0; i < territorios.size(); i++) {
            territorios.get(i).show();
        }
        for (int i = 0; i < botoes.size(); i++) {
            botoes.get(i).show();
        }
    }

    public void mouseClicked() {
    	int x = mouseX;
    	int y = mouseY;
        System.out.println(x+"|"+y);
        for (int i = 0; i < territorios.size(); i++) {
            Territorio territorio = territorios.get(i);
            //Função pro territorio
            if(territorio.isPointInside(x, y)) {
                ArrayList<String> fronteiras = territorio.getFronteiras();
                for (int j = 0; j < fronteiras.size(); j++) {
//                  Itera sobre as fronteiras e retorna o seu Territorio pelo nome
                    Territorio fronteira = Territorio.getTerritorio(territorios, fronteiras.get(j));
                    if(fronteira != null) {
                        Territorio.highlight(fronteira);
                    }
                }
            }
        }

        for (int i = 0; i < botoes.size(); i++) {
            Botao botao = botoes.get(i);
            if (botao.isPointInside(x,y)){
                switch (botao.getName()){
                    case "Pagar Salarios":
                        JOptionPane.showMessageDialog(null,"Selecione as tropas e companhias");
                        break;
                    case "Vender Suprimentos":
                        JOptionPane.showMessageDialog(null,"Selecione o suprimento para vender");
                        break;
                    case "Atacar":
                        JOptionPane.showMessageDialog(null,"Selecione a tropa e o territorio para atacar");
                        break;
                    case "Movimentar Tropas":
                        JOptionPane.showMessageDialog(null,"Selecione a tropa e o caminho para o territorio desejado");
                        break;
                    case "Construir":
                        JOptionPane.showMessageDialog(null,"Selecione o que deseje construir");
                        break;
                    case "Comprar Suprimentos":
                        JOptionPane.showMessageDialog(null,"Selecione o suprimento desejado");
                        break;
                }
            }
        }
    }
}
