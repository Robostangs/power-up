package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Elevator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnToAngle extends AutoCommandBase {
	
	private double angle = 0;
	private double power;
	private double angleOffSet;
	private double elevatorSetPoint;
	
	
	public TurnToAngle(double timeOut, double angle, double angleOffSet, double power, double elevatorSetPoint) {
		super(timeOut);
		// TODO Auto-generated constructor stub
		this.angle = angle;
		this.power = power;
		this.angleOffSet = angleOffSet;
		this.elevatorSetPoint = elevatorSetPoint;
	}

	
	public void init() {
		DriveTrain.resetGyro();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		//DriveTrain.turnToAngle(angle);
	//90 = 17
		//30 ==7
		if(DriveTrain.getAngle() > 0){
			if(DriveTrain.getAngle() < (angle - angleOffSet))
				DriveTrain.arcadeDrive(0, power);
			else if(DriveTrain.getAngle() < angle && DriveTrain.getAngle() > angle - angleOffSet)
				DriveTrain.arcadeDrive(0, .15);
			Elevator.setPosition(elevatorSetPoint);
		}
		else{
			if(DriveTrain.getAngle() > (angle + angleOffSet))
				DriveTrain.arcadeDrive(0, -power);
			else if(DriveTrain.getAngle() > angle && DriveTrain.getAngle() < angle + angleOffSet)
				DriveTrain.arcadeDrive(0, -.15);
			Elevator.setPosition(elevatorSetPoint);
		}
		
		
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.disablePID();
		System.out.println(DriveTrain.getAngle());
		DriveTrain.resetGyro();
		Elevator.setPosition(elevatorSetPoint);
		
		//DriveTrain.resetEncoder();
		//SmartDashboard.putNumber("AUTO GYROOO", DriveTrain.getAngle());
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "turn to angle";
	}

}