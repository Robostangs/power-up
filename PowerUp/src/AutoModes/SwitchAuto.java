package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;

import edu.wpi.first.wpilibj.DriverStation;

public class SwitchAuto extends AutoMode {

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
		
		
		
		if(gameData != null && gameData.charAt(1) == 'L'){
			
			armGoUp(.001, true);
			driveDistance(1, .3, (260 * 8), 10, 61000, .3);
			driveDistance(6, .7, (72280 - (15 * 260)), 10, 61000, .3);
			turnToAngle(1.2, 30, 15, .5, 61000);
			driveDistance(.5, .4, 8 * 260, 10, 61000, .3);
			dropCube(.5, 1, 1, 61000);
			driveDistance(2, -.5, 2080 + (12 * 260), 20, 61000, 0);
			//OLD driveDistance(1, -.5, 2080 + 9 * 260, 20, 10000, 0);
			//turnToAngle(1, 110, 25, .5, 0);
			//driveDistance(1, .5, 2080 + 20 * 260, 20, 0, 0);
			
			
			}
			
		
		else if(gameData != null && gameData.charAt(0) == 'L'){
			driveDistance(.7, .3, (260 * 8), 10, 0, 0);
			driveDistance(4, .6, (260*144), 10, 0, 0);
			turnToAngle(2, -90, 45, .5, 0);
			driveDistance(1, -.6, (260 * 30), 10, 0, 0);
			dropCube(1, .9, .9, 0);
			driveDistance(1, .6, (260 * 25), 10, 0, 0);
			armGoUp(.1, true);
		}
		else{
			driveDistance(1, .3, (260 * 8), 10, 0, .3);
			driveDistance(8, .7, (72280 - (260 * 80)), 10, 0, .3);
			turnToAngle(2, 45, 8, .5, 0);
			armGoUp(1, true);
		}
		
		
		
	}

}