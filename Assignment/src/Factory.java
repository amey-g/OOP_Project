import java.util.*;
import java.util.concurrent.TimeUnit;


public class Factory 
{
	public static String getHumanReadableTime(long nanos) {
		nanos = nanos/1000000;
		String hr = "";
	    String mn = "";
	    long seconds = (int) ((nanos) % 60);
	    long minutes = (int) ((nanos / (60)) % 60);
	    long hours = (int) ((nanos / (60 * 60)) % 24);

	    if (hours < 10) {
	        hr = "0" + hours;
	    }
	    if (minutes < 10) {
	        mn = "0" + minutes;
	    }
	    
	    return hours + ":" + minutes + ":" + seconds;
	}
	
	public static void main(String[] args) 
	{	
		final long startTime = System.nanoTime();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Car Production Factory!");
		System.out.println("Enter the number of Assembly Lines");	
		int numAssembly = sc.nextInt();//number of assembly lines
		
		ArrayList<Car> Cars = new ArrayList<Car>(numAssembly);
		
		//Code For Taking Input of Car Specifications and Assembling on different threads
		// each Assemblies[i] will be implementing runnable and having a separate thread to itself
		
		for(int i = 0; i < numAssembly; i++) 
		{
			System.out.println("Enter Specifications for Car Number " + (i+1) + " :- ");	
			int chassis, engine, tyre, suspension,ac,paint;
			
			//interface objects
			Chassis c=null;
			Engine e=null;
			Tyre t=null;
			Suspension s=null;
			Air_conditioning a=null;
			Paint p=null;
			
			System.out.println("Enter type of Chassis (1-4) : ");
			chassis = sc.nextInt();
			switch(chassis)//for referring to the appropriate classes
			{
			case 1:
				c=new Ladder();
				break;
			case 2:
				c=new Backbone();
				break;
			case 3:
				c=new Spacy();
				break;
			case 4:
				c=new Cadillac();
				break;
			default:
				System.out.println("Wrong chassis number entered.");
			}
			
			System.out.println("Enter type of Engine (1-5) : ");
			engine = sc.nextInt();
			switch(engine)
			{
			case 1:
				e=new V8();
				break;
			case 2:
				e=new V10();
				break;
			case 3:
				e=new Two_Cylinder();
				break;
			case 4:
				e=new Four_Cylinder();
				break;
			case 5:
				e=new Internal_Combustion();
				break;
			default:
				System.out.println("Wrong engine number entered.");
			}
			
			System.out.println("Enter type of Tyre (1-3) : ");
			tyre = sc.nextInt();
			switch(tyre)
			{
			case 1:
				t=new Antiskid();
				break;
			case 2:
				t=new Fast_Brake();
				break;
			case 3:
				t=new Mountain();
				break;
			default:
				System.out.println("Wrong tyre number entered.");
			}
			
			System.out.println("Enter type of Suspension (1-3) : ");
			suspension = sc.nextInt();
			switch(suspension)
			{
			case 1:
				s=new Multilink();
				break;
			case 2:
				s=new RightAxle();
				break;
			case 3:
				s=new Double_Wishbone();
				break;
			default:
				System.out.println("Wrong suspension number entered.");
			}
			
			System.out.println("Enter type of AC (1-3) : ");
			ac = sc.nextInt();
			switch(ac)
			{
			case 1:
				a=new Orifice_tube();
				break;
			case 2:
				a=new P_valve();
				break;
			case 3:
				a=new Dual_heater();
				break;
			default:
				System.out.println("Wrong AC number entered.");
			}
			
			System.out.println("Enter type of Paint (1-4) : ");
			paint = sc.nextInt();
			switch(paint)
			{
			case 1:
				p=new Red();
				break;
			case 2:
				p=new Blue();
				break;
			case 3:
				p=new Black();
				break;
			case 4:
				p=new White();
				break;
			default:
				System.out.println("Wrong paint number entered.");
			}
			
			Car C = new Car(c,e,t,s,a,p);
			Cars.add(C);//adding to the arraylist of cars
		}
		
		class AssemblyLine implements Runnable 
		{
			private int threadNumber;//specifies thread number
			Car C;	
			int timer_s;//to record time in seconds for the program
			int timer_m;//to record time in minutes for the program
			AssemblyLine(Car C,int threadNumber)//constructor
			{
				this.C = C;
				this.threadNumber=threadNumber;
				timer_s=0;
				timer_m=0;
			}
			
			//calling this function would start the procedure on the assembly line
			@Override
			public void run() 
			{
				//extracting the building time that is being taken
				int chas_time = C.getChassis();
				int eng_time = C.getEngine();
				int susp_time = C.getSuspension();
				int tyre_time = C.getTyre();
				int p_time=C.getPaint();
				int ac_time=C.getAirConditioning();
				
				try 
				{
					timer_s+=chas_time;
					if(timer_s>=60)
					{
						timer_s/=60;
						timer_m++;
					}
//					String s;
//					if(timer<10)
//					{
//						s="00:0"+timer;
//					}
//					else if(timer<=59)
//					{
//						s="00:"+timer;
//					}
//					else
//					{
//						
//					}
					final long duration = (System.nanoTime() - startTime);
					String dur = getHumanReadableTime(duration); 
					System.out.println(dur +" Chassis fitted at car on Assembly Line " +threadNumber);
					
					Thread.sleep(chas_time*100);//so as to pause the thread upto that time period
				}
				catch(InterruptedException e) 
				{
					System.out.println("Error in fitting the chassis on Assembly Line");
				}
				
				try 
				{
					timer_s+=eng_time;
					if(timer_s>=60)
					{
						timer_s/=60;
						timer_m++;
					}
					final long duration = (System.nanoTime() - startTime);
					String dur = getHumanReadableTime(duration); 
					System.out.println(dur +" Engine fitted at car on Assembly Line " +threadNumber);
					Thread.sleep(eng_time*100);
				}
				catch(InterruptedException e) 
				{
					System.out.println("Error in fitting the engine on Assembly Line");
				}
				
				try 
				{
					timer_s+=susp_time;
					if(timer_s>=60)
					{
						timer_s/=60;
						timer_m++;
					}
					final long duration = (System.nanoTime() - startTime);
					String dur = getHumanReadableTime(duration); 
					System.out.println(dur +" Suspension fitted at car on Assembly Line " +threadNumber);
					Thread.sleep(susp_time*100);
				}
				catch(InterruptedException e) 
				{
					System.out.println("Error in fitting the suspension on Assembly Line");
				}
				
				try 
				{
					timer_s+=tyre_time;
					if(timer_s>=60)
					{
						timer_s/=60;
						timer_m++;
					}
					final long duration = (System.nanoTime() - startTime);
					String dur = getHumanReadableTime(duration); 
					System.out.println(dur +" Tyres fitted at car on Assembly Line " +threadNumber);
					Thread.sleep(tyre_time*100);
				}
				catch(InterruptedException e) 
				{
					System.out.println("Error in fitting the tyres on Assembly Line");
				}
				
				try 
				{
					timer_s+=ac_time;
					if(timer_s>=60)
					{
						timer_s/=60;
						timer_m++;
					}
					final long duration = (System.nanoTime() - startTime);
					String dur = getHumanReadableTime(duration); 
					System.out.println(dur +" AC fitted at car on Assembly Line " +threadNumber);
					Thread.sleep(ac_time*100);
				}
				catch(InterruptedException e) 
				{
					System.out.println("Error in fitting the tyres on Assembly Line");
				}
				
				try 
				{
					timer_s+=p_time;
					if(timer_s>=60)
					{
						timer_s/=60;
						timer_m++;
					}
					final long duration = (System.nanoTime() - startTime);
					String dur = getHumanReadableTime(duration); 
					System.out.println(dur +" Painting done on Assembly Line " +threadNumber);
					Thread.sleep(p_time*100);
				}
				catch(InterruptedException e) 
				{
					System.out.println("Error in fitting the tyres on Assembly Line");
				}
			}
		}
		
		System.out.println("00:00 Starting Production");
		//running assembly lines
		for(int i=0; i < numAssembly; i++) 
		{
			AssemblyLine A = new AssemblyLine(Cars.get(i),i);
			Thread t = new Thread(A);
			t.start();
		}
	}
}
