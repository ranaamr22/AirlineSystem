package MyPackage;

import java.util.ArrayList;

public class Airline {
    private String Name;
    private ArrayList<Fleet> Fleets;
    private String OwningCountry;

    public String getName() {
        return Name;
    }

    public Airline(String Name, String OwningCountry) {
        this.Name = Name;
        //this.Fleets = Fleets;
        this.OwningCountry = OwningCountry;
        this.Fleets = new ArrayList<Fleet>();
        		
    }
    public Airline(String Name, ArrayList<Fleet> Fleets, String OwningCountry) {
        this(Name,OwningCountry);
        this.Fleets= Fleets;
    }
    
    public void addFleet(Fleet f) {
    	this.Fleets.add(f);
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Fleet> getFleets() {
        return Fleets;
    }

    public void setFleets(ArrayList<Fleet> Fleets) {
        this.Fleets = Fleets;
    }

    public String getOwningCountry() {
        return OwningCountry;
    }

    public void setOwningCountry(String OwningCountry) {
        this.OwningCountry = OwningCountry;
    }
    
    
}
