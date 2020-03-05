

public class Karte extends Object {
    public String name;
    public int topSpeed; //in km/h
    public double timeTo100; //in s
    public int verkauft; //Anzahl verkaufte Produkte

    public String toString() {
        return name + " mit den Eigenschaften Höchstgeschwindigkeit: " + topSpeed + ", Beschleunigung: "+timeTo100 + " und Anzahl verkaufter Produkte: "+verkauft;
    }
    
    public Karte(String name, int topspeed, double beschleunigung, int verkauft) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.topSpeed = topspeed;
        this.timeTo100 = beschleunigung;
        this.verkauft = verkauft;
    }
    
    public Karte(String name, int topspeed, int verkauft) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.topSpeed = topspeed;
        this.verkauft = verkauft;
    }
    
    public void printKarte(){
        
    	System.out.println(this.name);
    }
    
}
