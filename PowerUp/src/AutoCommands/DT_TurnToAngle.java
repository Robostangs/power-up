package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Elevator;
import org.usfirst.frc.team548.robot.Ingestor;

public class DT_TurnToAngle extends AutoCommandBase{
	
	private double angle = 0;
	private double power;
	private double elevatorSetPoint;
	private double ingestorPower;
	
	public DT_TurnToAngle(double timeOut, double angle, double power, double elevatorSetPoint, double ingestorPower){
		super(timeOut);
		this.angle = angle;
		this.power = power;
		this.elevatorSetPoint = elevatorSetPoint;
		this.ingestorPower = ingestorPower;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		DriveTrain.resetGyro();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		DriveTrain.turnToAngle(angle);
		Ingestor.bothControl(ingestorPower);
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.disablePID();
		System.out.println(DriveTrain.getAngle());
		DriveTrain.resetGyro();
		Elevator.setPosition(elevatorSetPoint);
		Ingestor.bothControl(ingestorPower);
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Accurate Turn To Angle";
	}
}
