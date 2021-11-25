
public class Car 
{	
	//interface objects
	Chassis c;
	Engine e;
	Tyre t;
	Suspension s;
	Air_conditioning a;
	Paint p;
	
	Car(Chassis c,Engine e,Tyre t,Suspension s,Air_conditioning a,Paint p){
		this.c=c;
		this.e=e;
		this.t=t;
		this.s=s;
		this.a=a;
		this.p=p;
	}
	
	//methods to return the time stamps
	int getChassis()
	{
		return this.c.getBuildTime();
	}
	int getSuspension()
	{
		return this.s.getBuildTime();
	}
	int getAirConditioning()
	{
		return this.a.getBuildTime();
	}
	int getEngine()
	{
		return this.e.getBuildTime();
	}
	int getPaint()
	{
		return this.p.getBuildTime();
	}
	int getTyre()
	{
		return this.t.getBuildTime();
	}	
}
