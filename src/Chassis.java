
public interface Chassis {
	int chassisNumber = 0;
	int buildTime = 0;
	
	default int getBuildTime(){
		return buildTime;
	}
	
	default int getChassisNumber(){
		return chassisNumber;
	}
}
