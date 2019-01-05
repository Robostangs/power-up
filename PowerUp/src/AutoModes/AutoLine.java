package AutoModes;

import org.usfirst.frc.team548.robot.Ingestor;

public class AutoLine extends AutoMode {

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		driveDistance(1, -.3, (260 * 8), 10, 0, .3);
		driveDistance(8, -.7, (32500), 10, 0, .3);
		turnToAngle(2, 45, 8, .5, 0);
		Ingestor.closeIngestor();
		armGoUp(1, true);
	}

}
