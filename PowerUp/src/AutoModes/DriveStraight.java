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
		
		String gameData = "";
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		if(gameData==null) {
			for(int i = 0; i < 20; i++) {
				gameData = DriverStation.getInstance().getGameSpecificMessage();
				if(gameData!=null) break;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		driveDistance(1.2, -.6, (-8960 + (2.5*260)), 10, 0, 0);
		if(gameData != null && gameData.charAt(0) == 'L'){
			turnToAngle(1, -30, 5, .5, 0);
			driveDistance(2, -.7, (-19500 + (260 * 5)), 10, 0, 0);
			turnToAngle(1, 60, 8, .5, 0);
			driveDistance(1, -.5, (260 * 20), 10, 0, 0);
			dropCube(.5, .7, .7, 0);
			//armGoUp(1, true);
			//elevatotSet(2, -45500);
		}
		else {
			turnToAngle(1, 40, 7, .5, 0);
			//was 10 *
			driveDistance(2, -.7, (-19500 + (260 * 5)), 10, 0, 0);
			turnToAngle(1, -25, 7, .5, 0);
			driveDistance(1, -.5, (260 * 6), 10, 0, 0);
			dropCube(.5, .6, .6, 0);
			//armGoUp(2, true);
			
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