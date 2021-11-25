public interface Suspension {
	int suspensionNumber = 0;
	int buildTime = 0;
	
	default int getBuildTime(){
		return buildTime;
	}
	
	default int getSuspensionNumber(){
		return suspensionNumber;
	}
}
