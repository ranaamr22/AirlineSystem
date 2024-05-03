package MyPackage;

import java.util.ArrayList;

public class Country {
	private String name; 
	private ArrayList<Airport> airports;
	
	public Country(){
		
	}
	public Country(String name ) {
		this.name = name;
		airports = new ArrayList<Airport>();
	}
	public Country(String name , ArrayList<Airport> airports) {
		this.name = name;
		this.airports = airports;
	}
	
	public void addAirport(Airport a) {
		this.airports.add(a);
	}
	
	public ArrayList<Airport> getAirports() {
		return airports;
		
	}
	public String getName() {
		return this.name;
	}
	
	public void printAirports() {
		for(Airport a : airports) {
			System.out.println(
					"Airport: " + 
			a.getName());
		}
	}

}
