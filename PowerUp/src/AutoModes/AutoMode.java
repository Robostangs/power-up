package AutoModes;

import AutoCommands.ArmGoUp;
import AutoCommands.AutoCommandBase;
import AutoCommands.DriveDistance;
import AutoCommands.DropCube;
import AutoCommands.ElevatorSetPoint;
import AutoCommands.OneSideTurn;
import AutoCommands.TurnToAngle;
import AutoCommands.Wait;


public abstract class AutoMode {
	private String autoName;
	
	public  void start(){
		run();
	}
	
    protected abstract void run();

    protected  void driveDistance(double seconds, double power, double distance, double threshold){
		runCommand(new DriveDistance(seconds, power, distance));
	}
	
    protected void dropCube(double seconds, double powerLeft, double powerRight){
    	runCommand(new DropCube(seconds, powerLeft, powerRight));
    }
    
    protected void turnToAngle(double seconds, double angle, double offset, double power){
    	runCommand(new TurnToAngle(seconds, angle, offset, power));
    }
    
    protected void doubleSidePower(double seconds, double leftPower, double rightPower){
    	runCommand(new OneSideTurn(seconds, leftPower, rightPower));
    }
    
    protected void  waitTime(double seconds){
    	runCommand(new Wait(seconds));
    }
    
    protected void armGoUp(double seconds, boolean pos){
    	runCommand(new ArmGoUp(seconds, pos));
    }
    
    protected void elevatotSet(double seconds, double angle){
    	runCommand(new ElevatorSetPoint(seconds, angle));
    }
    
	private  void runCommand(AutoCommandBase command) {
		// TODO Auto-generated method stub
		command.execute();
	}
	
	
}

