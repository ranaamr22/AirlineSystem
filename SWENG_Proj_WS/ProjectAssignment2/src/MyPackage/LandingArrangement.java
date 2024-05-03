package MyPackage;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LandingArrangement {
	private LocalDate date;
    private LocalTime time;
	private Aircraft aircraft;
	//private ArrayList<Airport> airports;
	
	public LandingArrangement() {
		
	}
//	public LandingArrangement(LocalDate date, LocalTime time,Aircraft aircraft, ArrayList<Airport> airports) {
//		this.aircraft = aircraft;
//		this.date = date;
//		this.time = time;
//		this.airports = airports;
//	}
	public LandingArrangement(LocalDate date, LocalTime time,Aircraft aircraft) {
		this.aircraft = aircraft;
		this.date = date;
		this.time = time;
		//this.airports = airports;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public void setDate(LocalDate date) {
		this.date=date;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	public LocalTime getTime() {
		return this.time;
	}
//	public ArrayList<Airport> getAirports(){
//		return airports;
//	}
	public Aircraft getAircraft() {
		return this.aircraft;
	}
//	public void addAirport(Airport airport) {
//		this.airports.add(airport);
//	}
//	public void removeAirport(Airport airport) {
//		this.airports.remove(airport);
//	}
	
    public void printInfo() {
        System.out.println("Landing Arrangement Information:\n" +
                "Date: " + date + "\n" +
                "Time: " + time + "\n" +
                "Aircraft: " + aircraft.getType() + "\n"); 
    }
    
    public String getAircarftType() {
    	return this.aircraft.getType();
    	}
    
    public int getAircarftID() {
    	return this.aircraft.getID();
    	}
    
 // Method to check if a date is within the last week
    public boolean isWithinLastWeek() {
        LocalDate oneWeekAgo = LocalDate.now().minus(1, ChronoUnit.WEEKS);
        return !date.isBefore(oneWeekAgo);
    }
	
    

}
