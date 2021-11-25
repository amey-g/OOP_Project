import java.util.*;

public class Factory {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Car Production Factory!");
		System.out.println("Enter the number of Assembly Lines");	
		int numberOfAssemblyLines = sc.nextInt();
		
		System.out.println("Enter the number of Cars to be produced");
		int numberOfCars = sc.nextInt();
		
		//ArrayList<Assembly> Assemblies = new ArrayList<Assembly>(numberOfAssemblyLines);
		ArrayList<Car> Cars = new ArrayList<Car>(numberOfCars);
		
		//Code For Taking Input of Car Specifications and Assembling on different threads
		// each Assemblies[i] will be implementing runnable and having a separate thread to itself
		
		for(int i = 0; i < numberOfCars; i++) {
			System.out.println("Enter Specifications for Car Number " + (i+1) + " :- ");
			
			int chassis, engine, tyre, suspension;
			
			System.out.println("Enter Chassis (1-5) : ");
			chassis = sc.nextInt();
			
			System.out.println("Enter Engine (1-3) : ");
			engine = sc.nextInt();
			
			System.out.println("Enter Tyre (1-6) : ");
			tyre = sc.nextInt();
			
			System.out.println("Enter Suspension (1-4) : ");
			suspension = sc.nextInt();
		
			Car C = new Car(chassis, engine, tyre, suspension);
			Cars.add(C);
			
		}
		
		class AssemblyLine implements Assembly, Runnable{
			
			Car C;
			
			AssemblyLine(Car C){
				this.C = C;
			}
			
			 //calling this function would start the procedure on the assembly line
			public void run() {
				
				
				
				int chassis = C.getChassis();
				int engine = C.getEngine();
				int suspension = C.getSuspension();
				int tyre = C.getTyre();
				
				try {
					System.out.println("Fitting Chassis on Assembly Line");
					Thread.sleep(chassis);
				}
				catch(InterruptedException e) {
					System.out.println("Error in fitting the chassis on Assembly Line");
				}
				
				try {
					System.out.println("Fitting Engine on Assembly Line");
					Thread.sleep(engine);
				}
				catch(InterruptedException e) {
					System.out.println("Error in fitting the engine on Assembly Line");
				}
				
				try {
					System.out.println("Fitting Suspension on Assembly Line");
					Thread.sleep(suspension);
				}
				catch(InterruptedException e) {
					System.out.println("Error in fitting the suspension on Assembly Line");
				}
				
				try {
					System.out.println("Fitting Tyres on Assembly Line");
					Thread.sleep(tyre);
				}
				catch(InterruptedException e) {
					System.out.println("Error in fitting the tyres on Assembly Line");
				}
				
				
			}
		}
		
		//ArrayList<AssemblyLine> Assemblies
		//ArrayList<AssemblyLine> Assemblies = new ArrayList<AssemblyLine>(numberOfAssemblyLines);
		
		for(int i=0; i < numberOfAssemblyLines; i++) {
			AssemblyLine A = new AssemblyLine(Cars.get(i));
			Thread t = new Thread(A);
			t.start();
		}	
		
	}
	
}
