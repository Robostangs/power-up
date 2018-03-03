package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Elevator;

public class DriveDistance extends AutoCommandBase{
	private double power, distance, threshold;
	
	public DriveDistance(double timeOut, double power, double distance){
		super(timeOut);
		this.power = power;
		this.distance = distance;
	}
	
	public void init(){
		DriveTrain.resetEncoder();
		DriveTrain.resetGyro();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		if(Math.abs(DriveTrain.getEncoderAverage()) < Math.abs(distance)){
			DriveTrain.drive(power, power * .95);
			Elevator.setPosition(0);
		}
		else
			DriveTrain.stop();
			Elevator.setPosition(0);
		//DriveTrain.resetGyro();
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.stop();
		//DriveTrain.resetGyro();
		DriveTrain.resetEncoder();
		Elevator.setPosition(0);
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Drive Distance";
	}
	
}
