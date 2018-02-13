package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;

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
		while(DriveTrain.getEncoderAverage() < distance){
			DriveTrain.driveStraight(power);
		}
		DriveTrain.stop();
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.stop();
		
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Drive Distance";
	}
	
}
