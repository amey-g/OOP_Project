public interface Engine {
	int engineNumber = 0;
	int buildTime = 0;
	
	default int getBuildTime(){
		return buildTime;
	}
	
	default int getEngineNumber(){
		return engineNumber;
	}
}
