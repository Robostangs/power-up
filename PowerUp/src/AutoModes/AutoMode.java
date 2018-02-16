package AutoModes;

import AutoCommands.AutoCommandBase;
import AutoCommands.DriveDistance;
import AutoCommands.DropCube;
import AutoCommands.TurnToAngle;


public abstract class AutoMode {
	private String autoName;
	
	public  void start(){
		run();
	}
	
    protected abstract void run();

    protected  void driveDistance(double seconds, double power, double distance, double threshold){
		runCommand(new DriveDistance(seconds, power, distance));
	}
	
    protected void dropCube(double seconds, double power){
    	runCommand(new DropCube(seconds, power));
    }
    
    protected void turnToAngle(double seconds, double angle, boolean reset){
    	runCommand(new TurnToAngle(seconds, angle, reset));
    }
	private  void runCommand(AutoCommandBase command) {
		// TODO Auto-generated method stub
		command.execute();
	}
	
	
}

