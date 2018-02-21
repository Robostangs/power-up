package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnToAngle extends AutoCommandBase {
	
	private double angle = 0;
	private double power;
	
	
	public TurnToAngle(double timeOut, double angle, double power) {
		super(timeOut);
		// TODO Auto-generated constructor stub
		this.angle = angle;
		this.power = power;
	}

	
	public void init() {
		DriveTrain.resetGyro();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		//DriveTrain.turnToAngle(angle);
	//90 = 17
		if(DriveTrain.getAngle() > 0){
			if(DriveTrain.getAngle() < (angle -9))
				DriveTrain.arcadeDrive(0, power);
			else if(DriveTrain.getAngle() < angle && DriveTrain.getAngle() > angle - 9)
				DriveTrain.arcadeDrive(0, .15);
		}
		else{
			if(DriveTrain.getAngle() > (angle +9))
				DriveTrain.arcadeDrive(0, -power);
			else if(DriveTrain.getAngle() > angle && DriveTrain.getAngle() < angle + 9)
				DriveTrain.arcadeDrive(0, -.15);
		}
		
		
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.disablePID();
		System.out.println(DriveTrain.getAngle());
		DriveTrain.resetGyro();
		
		//DriveTrain.resetEncoder();
		//SmartDashboard.putNumber("AUTO GYROOO", DriveTrain.getAngle());
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "turn to angle";
	}

}