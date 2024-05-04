package MyPackage;

import java.util.ArrayList;

public class Fleet {
    private String AircraftType;
    private ArrayList<Aircraft> aircrafts;
    private String Name;
    //private String OwnerAirline ;  
    private Airline airline;

    public Fleet(String AircraftType, String Name, Airline OwnerAirline) {
        this.AircraftType = AircraftType;
        this.Name = Name;
        this.airline = OwnerAirline;
        this.aircrafts = new ArrayList<Aircraft>();
    }
    public Fleet(String AircraftType, ArrayList<Aircraft> aircrafts, String Name, Airline OwnerAirline) {
    	this(AircraftType,Name,OwnerAirline);
    	this.aircrafts = aircrafts;
    }

    public void addAircraft(Aircraft a) {
    	this.aircrafts.add(a);
    }
    public ArrayList<Aircraft> getThisAircraft() {
        return aircrafts;
    }

    public void setAircrafts(ArrayList<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getOwnerAirlineName() {
        return this.airline.getName();
    }

    public void setOwnerAirlineName(String OwnerAirline) {
        this.airline.setName(OwnerAirline);
    }
    
    public boolean isAircraftExist(Aircraft a) {
    	for(Aircraft e: aircrafts) {
    		if(a.getID() == e.getID()) {
    			return true;
    		}
    	}
    	return false;
    }
    
}
