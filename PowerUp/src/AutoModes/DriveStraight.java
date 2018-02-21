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
		driveDistance(1.2, -.6, -8960, 10);
		if(gameData.charAt(0) == 'L'){
			turnToAngle(1, -21, .5);
			driveDistance(.7, -.7, (-26260 + 12 * 260), 10);
			dropCube(.5, .7, .7);
		}
		else {
			turnToAngle(1, 38, .5);
			driveDistance(.7, -.7, (-26260 + 10 * 260), 10);
			dropCube(.5, .7, .7);
		}
		
	}
	
	
}

//260 encoderclicks = 1 in


//write down autos and where they go and other stuff
//understand what is happening
//know how I am adjusting to failure and stuff
	//Deal with failure
//alows us with something to start with in the next year


	//drop off at back
	//drop one off at switch, then attempt to pick one up and go to scale
	//most autons should dump cube and then go towards middle of field
