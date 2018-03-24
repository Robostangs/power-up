package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestStuff extends AutoMode {

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		turnToAngle(1, -45, 23, .5, 0);
		SmartDashboard.putNumber("Auto Stuff", DriveTrain.getAngle());
	}

}
