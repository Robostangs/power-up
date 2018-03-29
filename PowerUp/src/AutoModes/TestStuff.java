package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestStuff extends AutoMode {

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		//turnToAngle(1, -45, 23, .5, 0);
		turnToAngle(2, -90, 45, .5, 0);
		//driveDistance(2, .5, (260 * 8), 10, 0, 0);
		SmartDashboard.putNumber("Auto Stuff", DriveTrain.getAngle());
	}

}
