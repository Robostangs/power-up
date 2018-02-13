package AutoModes;

import AutoCommands.AutoCommandBase;
import AutoCommands.DriveDistance;


public abstract class AutoMode {
	private String autoName;
	
	public  void start(){
		run();
	}
	
    protected abstract void run();

    protected  void driveDistance(double seconds, double power, double distance, double threshold){
		runCommand(new DriveDistance(seconds, power, distance));
	}
	
	private  void runCommand(AutoCommandBase command) {
		// TODO Auto-generated method stub
		command.execute();
	}
	
	
}

