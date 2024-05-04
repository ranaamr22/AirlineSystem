package MyPackage;

import java.util.ArrayList;


public class Aircraft {
    private String Type;
    //private ArrayList<LandingArrangement> Arrangements;
    private int ID;

//    public Aircraft(String Type, ArrayList<LandingArrangement> Arrangements, int ID) {
//        this.Type = Type;
//        this.Arrangements = Arrangements;
//        this.ID = ID;
//    }
    public Aircraft(String Type, int ID) {
        this.Type = Type;
        //this.Arrangements = Arrangements;
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

//    public ArrayList<LandingArrangement> getLandingArrangements() {
//        return Arrangements;
//    }
//
//    public void setArrangements(ArrayList<LandingArrangement> Arrangements) {
//        this.Arrangements = Arrangements;
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
}
