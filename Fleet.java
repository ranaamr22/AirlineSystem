import java.util.ArrayList;

public class Fleet {
    private String AircraftType;
    private ArrayList<Aircraft> aircrafts;
    private String Name;
    private String OwnerAirline ;  

    public Fleet(String AircraftType, ArrayList<Aircraft> aircrafts, String Name, String OwnerAirline) {
        this.AircraftType = AircraftType;
        this.aircrafts = aircrafts;
        this.Name = Name;
        this.OwnerAirline = OwnerAirline;
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

    public String getOwnerAirline() {
        return OwnerAirline;
    }

    public void setOwnerAirline(String OwnerAirline) {
        this.OwnerAirline = OwnerAirline;
    }
    
}
