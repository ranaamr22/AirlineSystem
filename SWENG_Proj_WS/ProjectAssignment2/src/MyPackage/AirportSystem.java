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
		ArrayList<LandingArrangement> LA_Airport1 = new ArrayList<LandingArrangement>();
		LA_Airport1.add(LA1);
		LA_Airport1.add(LA3);
		Airport airport1 = new Airport("Lyon Airport" , "Lyon" , LA_Airport1);

		ArrayList<LandingArrangement> LA_Airport2 = new ArrayList<LandingArrangement>();
		LA_Airport2.add(LA4);
		LA_Airport2.add(LA6);
		Airport airport2 = new Airport("Charles de Gaulle Airport" , "Paris",LA_Airport2);

		ArrayList<LandingArrangement> LA_Airport3 = new ArrayList<LandingArrangement>();
		LA_Airport3.add(LA5);
		LA_Airport3.add(LA2);
		Airport airport3 = new Airport("Cairo International Airport" , "Cairo", LA_Airport3);


		//now we can put all airports in the system in a List 
		ArrayList<Airport> systemAirports = new ArrayList<Airport>();
		systemAirports.add(airport1);
		systemAirports.add(airport2);
		systemAirports.add(airport3);

		// Creating Countries and adding airports in them  
		Country country1 = new Country("France");
		country1.addAirport(airport1);
		country1.addAirport(airport2);

		Country country2 = new Country("Egypt");
		country2.addAirport(airport3);

		// a list of all countries in the system
		ArrayList<Country> systemCountries = new ArrayList<Country>();
		systemCountries.add(country1);
		systemCountries.add(country2);


		//Question 1 :  List the aircraft types which may land at a particular airport.
		Scanner scanner = new Scanner(System.in);
		int flag =0;
		do {
			System.out.println(" ---- Please Choose an Airport ----");
			System.out.println("# Exisiting Airports in the system are: ");
			for(Airport e: systemAirports) {
				System.out.println("-"+e.getName());
			}
			String chosenAirport = scanner.nextLine();
			for(Airport a : systemAirports) {
				if(chosenAirport.equals(a.getName())) {
					a.printAircraftTypes();
					flag=1;
				}
			}
			if(flag ==0) {
				System.out.println("--- Chosen Airport doesn't exist please try again! ---");
			}
		}while(flag==0);
		flag=0;

		///////////////////////////////////////////////////////////////////////////////////
		//Question 2: Find all airports at which a Boeing 757 could land
		do{
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("---- Please Choose an Aircraft Type ----");
			System.out.println("# Existing aircraft types in the system are:");

			for(Aircraft a: systemAircrafts) {
				System.out.println("-"+a.getType());
			}
			String chosenAircraft = scanner.nextLine();
			ArrayList<String> Types = new ArrayList<String>();
			for(Airport a : systemAirports) {
				Types = a.getAircraftTypes();
				for(String s : Types) {
					if(chosenAircraft.equals(s)) {
						System.out.println( "--->"+"Airport Name: " + a.getName());
						flag=1;

					}
				}
			}
			if(flag ==0) {
				System.out.println("--- Chosen Aircrtaft doesn't exist please try again! ---");
			}
		}while(flag==0);
		flag=0;
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


