
import java.util.ArrayList;
import java.util.List;

public class ZugKarten {

    public List<Karte> Karten = new ArrayList<Karte>(); // hier vom typ der Karten-Klasse

    public ZugKarten() { //leerer Stapel
/*
        Karten.add(new Karten("SMILE", 250, 18, 29));//Hochgeschwindigkeitszug
        Karten.add(new Karten("FLIRT160", 160, 22, 580));//Regionalzug
        Karten.add(new Karten("FLIRT200", 200, 21, 620));
        Karten.add(new Karten("WINK", 140, 23, 550));//Niederflur-Triebzug
        Karten.add(new Karten("KISS160", 160, 22, 129));//Doppelstockzug
        Karten.add(new Karten("KISS200", 200, 21, 171));
        Karten.add(new Karten("GTW", 140, 23, 610));//Gelenktriebwagen
        Karten.add(new Karten("RS1", 120, 23, 497));
        Karten.add(new Karten("Lokomotive ERUO3000", 200, 23, 420));
        Karten.add(new Karten("Lokomotive EURO4000", 120, 25, 460));
        Karten.add(new Karten("Lokomotive Eurolight", 160, 24, 500));
        Karten.add(new Karten("Lokomotive Eurodual", 160, 24, 380));
        Karten.add(new Karten("Rangierlokomotive", 60, 25, 390));
        Karten.add(new Karten("Triebzug", 120, 23, 720));
        Karten.add(new Karten("Zahnradbahn", 33, 50));
        Karten.add(new Karten("Wagen", 100, 64));
        Karten.add(new Karten("METRO", 58, 24, 400));
        Karten.add(new Karten("Citylink", 100, 25, 100)); //Hybrid-Strassenbahn
        Karten.add(new Karten("Metelitsa", 75, 28, 23)); //Breitspur-Strassenbahn
        Karten.add(new Karten("Variobahn", 70, 210));//Niederflur-Strassenbahn
        Karten.add(new Karten("Tramlink", 75, 55));//mehrfachgelenkige Niederflur-Strassebahn
        Karten.add(new Karten("Tango", 85, 130));//Stadtbahn(Hochflurfahrzeug)
*/
    }

    public Karte getKarte(int id) {
        return Karten.get(id);
    }
    
    public List<Karte> getAll() {
        return Karten;
    }
    
    public void remove(){
        Karten.clear();
}
    
    public Karte removeKarte(int index) {
        return Karten.remove(index);
    }
    public void addKarte(Karte a) {
        Karten.add(a);
    }

    public void addKarten(List<Karte> a) {
        Karten.addAll(a);
    }
    
    public void printAll() {
        for (Karte a : Karten) {
            a.printKarte();
        }
    }

    public int getSize (){
        return Karten.size();
    }
    
    
    
    /*void printAll(String set_nicht_gemischt) {
        for (int i = 0; i < getSize(); i++){
            System.out.println(getKarte(i).name);
        }
    }*/
}
