package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Elevator;
import org.usfirst.frc.team548.robot.Ingestor;

public class DriveDistance extends AutoCommandBase{
	private double power, distance, threshold, elevatorSetPoint, ingestorPower;
	
	public DriveDistance(double timeOut, double power, double distance, double elevatorSetPoint, double ingestorPower){
		super(timeOut);
		this.power = power;
		this.distance = distance;
		this.elevatorSetPoint = elevatorSetPoint;
		this.ingestorPower = ingestorPower;
	}
	
	public void init(){
		DriveTrain.resetEncoder();
		DriveTrain.resetGyro();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		if(Math.abs(DriveTrain.getEncoderAverage()) < Math.abs(distance)){
			DriveTrain.driveStraight(power);
			Elevator.setPosition(elevatorSetPoint);
			Ingestor.bothControl(ingestorPower);
		}
		else
			DriveTrain.stop();
			Elevator.setPosition(elevatorSetPoint);
			Ingestor.bothControl(ingestorPower);
		//DriveTrain.resetGyro();
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.stop();
		//DriveTrain.resetGyro();
		DriveTrain.resetEncoder();
		Elevator.setPosition(elevatorSetPoint);
		Ingestor.bothControl(ingestorPower);
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Drive Distance";
	}
	
}