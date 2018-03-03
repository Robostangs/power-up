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
		driveDistance(1.2, -.6, (-8960 + (2.5*260)), 10);
		if(gameData.charAt(0) == 'L'){
			turnToAngle(1, -30, 5, .5);
			driveDistance(2, -.7, (-19500 + (260 * 5)), 10);
			turnToAngle(1, 60, 8, .5);
			driveDistance(1, -.5, (260 * 20), 10);
			dropCube(.5, .7, .7);
			armGoUp(1, true);
			elevatotSet(2, -45500);
		}
		else {
			turnToAngle(1, 35, 7, .5);
			//was 10 *
			driveDistance(.7, -.7, (-26260 + 20 * 260), 10);
			turnToAngle(1, -35, 7, .5);
			driveDistance(.7, -.5, (260 * 3), 10);
			dropCube(.5, .6, .6);
			armGoUp(2, true);
			
			//armGoUp(1, true);		
			
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
