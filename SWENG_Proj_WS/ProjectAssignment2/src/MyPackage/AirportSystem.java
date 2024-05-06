package MyPackage;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class AirportSystem {
	public static void main(String[] args) { 

		/* N.B : the program could be easily modified to prompt user to add an aircraft, airline, airport, landing arrangement 
		 * or a fleet, but we made a ready example to make it easier for the evaluator to just run the program
		 * to test the requirements :) */  

		// Existing Aircrafts
		Aircraft aircraft1 = new Aircraft("Boeing 757", 1);
		Aircraft aircraft2 = new Aircraft("Boeing 757", 2);
		Aircraft aircraft3 = new Aircraft("Warhawk P-40N", 3);
		Aircraft aircraft4 = new Aircraft("Warhawk P-40N", 4);
		Aircraft aircraft5 = new Aircraft("Scorpion F-89J", 5);
		Aircraft aircraft6 = new Aircraft("Scorpion F-89J", 6);

		// Existing Airlines
		Airline airline1 = new Airline("France Air", "France");
		Airline airline2 = new Airline("Egypt Air", "Egypt");


		// Existing Fleets with their owner airlines 
		Fleet fleet1 = new Fleet("Boeing 757","Boeing Fleet",airline1);
		Fleet fleet2 = new Fleet("Warhawk P-40N","Warhawk Fleet",airline1);
		Fleet fleet3 = new Fleet("Scorpion F-89J","Scorpion Fleet",airline2);

		// Adding aircrafts to their corresponding fleets 
		fleet1.addAircraft(aircraft1);
		fleet1.addAircraft(aircraft2);
		fleet2.addAircraft(aircraft3);
		fleet2.addAircraft(aircraft4);
		fleet3.addAircraft(aircraft5);
		fleet3.addAircraft(aircraft6);


		// Assigning fleets to airlines 
		airline1.addFleet(fleet1);
		airline1.addFleet(fleet2);
		airline2.addFleet(fleet3);

		// Creating Landing Arrangements
		LandingArrangement LA1 = new LandingArrangement( LocalDate.now().minusDays(5), LocalTime.of(10,30), aircraft1 );
		LandingArrangement LA2 = new LandingArrangement( LocalDate.now().minusDays(7), LocalTime.of(10,30), aircraft2 );
		LandingArrangement LA3 = new LandingArrangement( LocalDate.now().minusDays(8), LocalTime.of(10,30), aircraft3 );
		LandingArrangement LA4 = new LandingArrangement( LocalDate.now().minusDays(1), LocalTime.of(10,30), aircraft4 );
		LandingArrangement LA5 = new LandingArrangement( LocalDate.now().minusDays(2), LocalTime.of(10,30), aircraft5 );
		LandingArrangement LA6 = new LandingArrangement( LocalDate.now().minusDays(3), LocalTime.of(10,30), aircraft6 );


		// Creating a list of all the fleets in the system 
		ArrayList<Fleet> systemFleets = new ArrayList<Fleet>();
		systemFleets.add(fleet1);
		systemFleets.add(fleet2);
		systemFleets.add(fleet3);

		// Creating a list of all the aircrafts in the system
		ArrayList<Aircraft> systemAircrafts = new ArrayList<Aircraft>();
		systemAircrafts.add(aircraft1);
		systemAircrafts.add(aircraft2);
		systemAircrafts.add(aircraft3);
		systemAircrafts.add(aircraft4);
		systemAircrafts.add(aircraft5);
		systemAircrafts.add(aircraft6);

		// Creating a list of all landing arrangements in the system 
		ArrayList<LandingArrangement> systemLandingArrangements = new ArrayList<LandingArrangement>();
		systemLandingArrangements.add(LA1);
		systemLandingArrangements.add(LA2);
		systemLandingArrangements.add(LA3);
		systemLandingArrangements.add(LA4);
		systemLandingArrangements.add(LA5);
		systemLandingArrangements.add(LA6);

		// Assigning landing arrangements to airports 
	//to be implemented


		//now we can put all airports in the system in a List 
		//to be implemented

		// Creating Countries and adding airports in them  
		//to be implemented

		// a list of all countries in the system
		//to be implemented

		//Question 1 :  List the aircraft types which may land at a particular airport.
		//to be implemmented 

		///////////////////////////////////////////////////////////////////////////////////
		//Question 2: Find all airports at which a Boeing 757 could land
    //to be implemenetd 
	
		////////////////////////////////////////////////////////////////////////////////
		//Question 3 :  List all airports in France.
		do {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("---- Please Choose a Country ----");
			System.out.println("# Existing countries in the system are:");
			for(Country c: systemCountries) {
				System.out.println(""+c.getName());
			}
			String chosenCountry = scanner.nextLine();
			for(Country c: systemCountries) {
				if(chosenCountry.equals(c.getName())) {
					c.printAirports();
					flag=1;
				}
			}
			if(flag ==0) {
				System.out.println("--- Chosen Country doesn't exist please try again! ---");
			}
		}while(flag==0);
		flag=0;
		///////////////////////////////////////////////////////////////////////////////
		//Question 4: Given the unique number of a particular aircraft, track down 
		//which airline owns it, and all flights it has made in the last week
		do {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("---- Please Choose Aircraft ID -----");
			System.out.println("# Existing aircrafts' IDs in the system are:");
			for(Aircraft a: systemAircrafts) {
				System.out.println(""+a.getID());
			}
			int chosenID = scanner.nextInt();
			for(Aircraft a: systemAircrafts) {
				if( chosenID == a.getID()) 
				{
					flag=1;
					for(Fleet f: systemFleets)
					{
						if(f.isAircraftExist(a))
						{
							System.out.println("The Owner Airline is: " + f.getOwnerAirlineName());
							for(LandingArrangement L : systemLandingArrangements) 
							{
								if(a.getID() == L.getAircarftID())
								{
									if (L.isWithinLastWeek()){ L.printInfo(); }
									for(Airport ar: systemAirports) {
										if(ar.doesLAExist(L)) {
											System.out.println("Airport: " + ar.getName());
										}
									}
								}
							}

						}
					}
				}
			}
			if(flag ==0) {
				System.out.println("--- Chosen ID doesn't exist please try again! --- ");
			}
			
		}while(flag==0);
		flag=0;



	}


}


