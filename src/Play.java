
import java.util.Scanner;

public class Play {

    private static ZugKarten StapelVoll;
    private static String SpielerName;

    public static void main(String[] args) {
       
        System.out.println("Hallo, willkommen zum Stadler-Quartett! Um mit einem Gegenspieler zu spielen, gib bitte deinen Namen ein.");
        Scanner scanner = new Scanner(System.in);
        SpielerName = scanner.nextLine();
        System.out.println("Hallo " + SpielerName +"! Drücke bitte die Eingabetaste, um das Spiel zu beginnen. Du kannst das Spiel jederzeit mit 'q' abbrechen.");
        scanner.nextLine();
        System.out.println();      
        StapelVoll = fuelleStapel();

        boolean Ende = false;
        while (!Ende) {
            naechsteSpielrunde();
            System.out.println("Möchtest du nochmals spielen? Bitte antworte mit 'Ja' oder 'Nein'.");
            Scanner scanner2 = new Scanner(System.in);
            String antwort = scanner2.nextLine();
            if (antwort.equalsIgnoreCase("Nein")){
                System.out.println("Das Spiel ist zu Ende. Vielen Dank und bis zum nächsten Mal!");
                Ende = true;
            }
            
                    
        }

   }

    private static void naechsteSpielrunde() {
         boolean Stapel1 = true;
        // StapelVoll.printAll();
        java.util.Collections.shuffle(StapelVoll.Karten);

        System.out.println("Das Kartenset wurde gemischt:");
        StapelVoll.printAll();

        ZugKarten Spieler1 = new ZugKarten();
        ZugKarten Spieler2 = new ZugKarten();
        ZugKarten StapelTemp = new ZugKarten();
        System.out.println();

        for (Karte karte : StapelVoll.Karten) {
            if (Stapel1) {
                Spieler1.addKarte(karte);
            } else {
                Spieler2.addKarte(karte);
            }

            Stapel1 = !Stapel1;

        }

        System.out.println();
        System.out.println("Karten für: "+SpielerName);
        Spieler1.printAll();
        //int anzahlK = StapelVoll.getSize();

        /*System.out.println();
        System.out.println("Karten für Spieler2:");
        Spieler2.printAll();*/

        boolean Spielende = false;
        while (!Spielende) {

            System.out.println();
            System.out.println("Du hälst die Karte " + Spieler1.getKarte(0));// 0 steht für Index (1.Karte)
            //System.out.println("Spieler 2 hält die Karte " + Spieler2.getKarte(0));
            Scanner scanner = new Scanner(System.in);
            //System.out.println("Bitte Vergleichskriterium eingeben. Geschwindigkeit = v, Beschleunigung = a, Verkaufte Produkte = n");

            String krit;
            boolean eingabe = false;
            do {
                System.out.println("Bitte Vergleichskriterium eingeben, für Geschwindigkeit = v, Beschleunigung = a, Verkaufte Produkte = n");
                krit = scanner.nextLine();
                eingabe = krit.equals("v") || krit.equals("a") || krit.equals("n") || krit.equals("q");
                if (!eingabe) {
                    System.out.println("Falsche Eingabe. ");
                }
            } while (!eingabe);
            if (krit.equals("q")) {
                System.out.println("Das Spiel wurde abgebrochen.");
                break;
            }
            int ergebnis = Vergleichen(krit, Spieler1.getKarte(0), Spieler2.getKarte(0));

            if (ergebnis < 0) {
                Spieler2.addKarte(Spieler1.removeKarte(0));
                Spieler2.addKarten(StapelTemp.getAll());
                Karte k = Spieler2.removeKarte(0);
                Spieler2.addKarte(k);
                StapelTemp.remove();
                System.out.println("Spieler 2 hat die Karte mit dem besseren Wert und bekommt deine Karte sowie (falls vorhanden) die Karten vom temporären Stapel.");
            } else if (ergebnis > 0) {
                Spieler1.addKarte(Spieler2.removeKarte(0));
                Spieler1.addKarten(StapelTemp.getAll());
                Karte k = Spieler1.removeKarte(0);
                Spieler1.addKarte(k);
                StapelTemp.remove();
                System.out.println(SpielerName+", du hast die Karte mit dem besseren Wert und bekommst die Karte von deinem Gegenspieler sowie (falls vorhanden) die Karten vom temporären Stapel.");

            } else { // ergebnis = 0
                StapelTemp.addKarte(Spieler1.removeKarte(0));
                StapelTemp.addKarte(Spieler2.removeKarte(0));
                System.out.println("Beide Werte sind gleich. Beide Karten werden zur Seite gelegt.");
            }
            System.out.println("Du hast " + Spieler1.getSize() + " Karten und Spieler 2 hat " + Spieler2.getSize() + " Karten.");
            Spielende = Spieler1.getSize() == 0 || Spieler2.getSize() == 0;
        }

        if (Spieler1.getSize() == Spieler2.getSize()) {
            System.out.println("Beide Spieler haben gleich viele Karten, somit besteht Gleichstand.");
        } else {

            String gewinner = "Spieler ";
            //Gewinner += Spieler1.getSize() == 0 ? "2" : "1";

            if (Spieler1.getSize() < Spieler2.getSize()) {
                gewinner = gewinner + "2";
            } else {
                gewinner = SpielerName;
            }
            System.out.println("SPIELENDE! Der/die Gewinner/in ist " + gewinner + ". Glückwunsch!");
        }
 
    }

    private static int Vergleichen(String krit, Karte karte1, Karte karte2) {

        if (krit.equals("v")) {
            System.out.println("Die Höchstgeschwindigkeit von " + karte1.name + " und " + karte2.name + " wird verglichen.");
            return Integer.compare(karte1.topSpeed, karte2.topSpeed);
        } else if (krit.equals("a")) {
            System.out.println("Die Beschleunigung von " + karte1.name + " und " + karte2.name + " wird verglichen.");
            return Double.compare(karte1.timeTo100, karte2.timeTo100);
        } else if (krit.equals("n")) {
            System.out.println("Die Anzahl verkaufter Produkte von " + karte1.name + " und " + karte2.name + " wird verglichen.");
            return Integer.compare(karte1.verkauft, karte2.verkauft);
        } else {
            System.out.println("Vergleich nicht möglich!");
            return 0;
        }
        //Schleife, um Methode zu wiederholen, bis gültige Eingabe.
    }

    private static ZugKarten fuelleStapel() {
        ZugKarten Karten = new ZugKarten();
        Karten.addKarte(new Karte("SMILE", 250, 18, 29));//Hochgeschwindigkeitszug
        Karten.addKarte(new Karte("FLIRT160", 160, 22, 580));//Regionalzug
        Karten.addKarte(new Karte("FLIRT200", 200, 21, 620));
        Karten.addKarte(new Karte("WINK", 140, 23, 550));//Niederflur-Triebzug    
        Karten.addKarte(new Karte("KISS160", 160, 22, 129));//Doppelstockzug
        Karten.addKarte(new Karte("KISS200", 200, 21, 171));
        Karten.addKarte(new Karte("GTW", 140, 23, 610));//Gelenktriebwagen
        Karten.addKarte(new Karte("RS1", 120, 23, 497));
        Karten.addKarte(new Karte("Lokomotive EURO3000", 200, 23, 420));
        Karten.addKarte(new Karte("Lokomotive EURO4000", 120, 25, 460));
        Karten.addKarte(new Karte("Lokomotive Eurolight", 160, 24, 500));
        Karten.addKarte(new Karte("Lokomotive Eurodual", 160, 24, 380));
        Karten.addKarte(new Karte("Rangierlokomotive", 60, 25, 390));
        Karten.addKarte(new Karte("Triebzug", 120, 23, 720));
        Karten.addKarte(new Karte("Zahnradbahn", 33, 50));
        Karten.addKarte(new Karte("Wagen", 100, 64));
        Karten.addKarte(new Karte("METRO", 58, 24, 400));
        Karten.addKarte(new Karte("Citylink", 100, 25, 100)); //Hybrid-Strassenbahn
        Karten.addKarte(new Karte("Metelitsa", 75, 28, 23)); //Breitspur-Strassenbahn
        Karten.addKarte(new Karte("Variobahn", 70, 210));//Niederflur-Strassenbahn
        Karten.addKarte(new Karte("Tramlink", 75, 55));//mehrfachgelenkige Niederflur-Strassebahn
        Karten.addKarte(new Karte("Tango", 85, 130));//Stadtbahn(Hochflurfahrzeug)
        return Karten;
    }

}
