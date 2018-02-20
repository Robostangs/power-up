package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnToAngle extends AutoCommandBase {
	
	double angle = 0;
	boolean reset;
	double power;
	public TurnToAngle(double timeOut, double angle, double power, boolean r) {
		super(timeOut);
		// TODO Auto-generated constructor stub
		this.angle = angle;
		this.reset = r;
		this.power = power;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		//if(reset) {
			DriveTrain.resetGyro();
			//DriveTrain.resetPID();
		//}
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		//DriveTrain.turnToAngle(angle);
		
		SmartDashboard.putNumber("PID error", DriveTrain.getPIDError());
		
		int num = 0;
		
		while(DriveTrain.getAngle() < angle){
			if(DriveTrain.getAngle() < (angle - 5))
				DriveTrain.arcadeDrive(0, power);
			else
				DriveTrain.arcadeDrive(0, .2);
			
		}
		DriveTrain.stop();
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.disablePID();
		DriveTrain.resetEncoder();
		SmartDashboard.putNumber("AUTO GYROOO", DriveTrain.getAngle());
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Turn to angle";
	}

}