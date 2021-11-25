
public class Car {
	
	private int chassis;
	private int suspension;
	private int engine;
//	private int airConditioning;
//	private int paint;
	private int tyre;
	
	Car(int chassis, int suspension, int engine, int tyre){
		this.chassis = chassis;
		this.suspension = suspension;
		this.engine = engine;
//		this.airConditioning = airConditioning;
//		this.paint = paint;
		this.tyre = tyre;
	}
	
	int getChassis(){
		return this.chassis;
	}
	
	int getSuspension(){
		return this.suspension;
	}
	
//	int getAirConditioning(){
//		return this.airConditioning;
//	}
	
	int getEngine(){
		return this.engine;
	}
	
//	int getPaint(){
//		return this.paint;
//	}
//	
	int getTyre(){
		return this.tyre;
	}
		
}
