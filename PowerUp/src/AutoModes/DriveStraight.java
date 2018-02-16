package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;

public class DriveStraight extends AutoMode {
	
	public DriveStraight(){
		super();
	}
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		driveDistance(1, -.4, 3500, 10);
	//	if(gameData.charAt(0) == 'L'){
			turnToAngle(2, 30, true);
		//	driveDistance(4, -.6, -25000, 10);
		//	dropCube(5, .7);
	//	}
	//	else
	//		DriveTrain.stop();
			
			///////;LHSF LA SHF
		
	}
	
	
}
//drop off at back
//drop one off at switch, then attempt to pick one up and go to scale
//most autons should dump cube and then go towards middle of field
