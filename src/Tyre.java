public interface Tyre {
	int tyreNumber = 0;
	int buildTime = 0;
	
	default int getBuildTime(){
		return buildTime;
	}
	
	default int getTyreNumber(){
		return tyreNumber;
	}
}
