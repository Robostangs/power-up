package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Elevator;
import org.usfirst.frc.team548.robot.Ingestor;

public class DT_DriveDistance extends AutoCommandBase{
	private double power;
	private double elevatorSetPoint;
	private double ingestorPower;
	private double distance;
	private final double kP = 0.03;
	
	public DT_DriveDistance(double timeOut, double power, double distance, double elevatorSetPoint, double ingestorPower) {
		super(timeOut);
		
		this.power = power;
		this.elevatorSetPoint = elevatorSetPoint;
		this.ingestorPower = ingestorPower;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		DriveTrain.resetEncoder();
		DriveTrain.resetGyro();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		if(Math.abs(Math.abs(DriveTrain.getEncoderAverage())) < Math.abs(distance)){
			double angle = DriveTrain.getAngle();
			DriveTrain.pidDriveStraight(0.5);
		}else{
			DriveTrain.stop();
			Elevator.setPosition(elevatorSetPoint);
			Ingestor.bothControl(ingestorPower);
		}

	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.stop();
		DriveTrain.resetGyro();
		DriveTrain.resetEncoder();
		DriveTrain.disablePID();
		
		Elevator.setPosition(elevatorSetPoint);
		Ingestor.bothControl(ingestorPower);

	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Better Drive Distance";
	}
	
	
}
