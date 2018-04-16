package AutoModes;

import edu.wpi.first.wpilibj.DriverStation;

public class SwitchPriorityLeft extends AutoMode {

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
		//
		if(gameData != null && gameData.charAt(0) == 'L'){
			driveDistance(.7, .3, (260 * 8), 10, 0, 0);
			driveDistance(4, .6, (260*144), 10, 0, 0);
			turnToAngle(2, -90, 45, .5, 0);
			driveDistance(1, -.6, (260 * 30), 10, 0, 0);
			dropCube(1, .9, .9, 0);
			driveDistance(1, .6, (260 * 15), 10, 0, 0);
			turnToAngle(2, 90, 45, .5, 0);
			armGoUp(.1, true);
		
		}
		/*
		else if(gameData != null && gameData.charAt(1) == 'L'){
			armGoUp(.001, true);
			driveDistance(1, .3, (260 * 8), 10, 0, .3);
			driveDistance(7, .7, (72280 - (29 * 260)), 10, 0, .3);
			
			turnToAngle(1, 30, 25, .5, 10000);
			driveDistance(2, .4, 15 * 260, 10, 10000, .3);
			dropCube(.5, .9, .9, 10000);
			driveDistance(1, -.5, 2080 + 12 * 260, 20, 0, 0);
			//OLD driveDistance(1, -.5, 2080 + 9 * 260, 20, 10000, 0);
			turnToAngle(1, 110, 25, .5, 0);
			driveDistance(1, .5, 2080 + 20 * 260, 20, 0, 0);
		}
		*/
		else{
			driveDistance(1, .3, (260 * 8), 10, 0, .3);
			driveDistance(8, .7, (72280 - (260 * 80)), 10, 0, .3);
			turnToAngle(2, 45, 8, .5, 0);
			armGoUp(1, true);
		}
		
		
		
	}

}