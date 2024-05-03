package MyPackage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Airport {
	private String name;
	private String locationCity ;
	private ArrayList<LandingArrangement> landingArrangements;

	public Airport() {

	}
	public Airport(String name, String locationCity) {
		this.name = name;
		this.locationCity = locationCity;
	}
	public Airport(String name, String locationCity,ArrayList<LandingArrangement> landingArrangements ) {
		this(name, locationCity);
		this.landingArrangements = landingArrangements;

	}

	public String getName() {
		return this.name;
	}

	public ArrayList<LandingArrangement> getLandingArrangements(){
		return this.landingArrangements;
	}

	public void addLandingArrangements(LandingArrangement landingArrangement) {
		this.landingArrangements.add(landingArrangement);

	}
	public void removeLandingArrangement(LandingArrangement landingArrangement) {
		this.landingArrangements.remove(landingArrangement);
	}

	public void printLandingArrangements() {
		for(LandingArrangement L : this.landingArrangements) {
			System.out.println(landingArrangements.toString());
		}
	}

	public void printAircraftTypes() {
		for(LandingArrangement L : landingArrangements) {
			System.out.println( 
					this.name + ": " +
							"Aircraft Type:" + L.getAircarftType());
		}
	}

		public ArrayList<String> getAircraftTypes() {
			ArrayList<String> aircraftTypes = new ArrayList<String>();
			for(LandingArrangement L : landingArrangements) {
				aircraftTypes.add(L.getAircarftType());
			}
			return aircraftTypes;

		}
		

	}
