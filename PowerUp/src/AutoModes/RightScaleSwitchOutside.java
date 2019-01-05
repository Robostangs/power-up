package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Ingestor;

import edu.wpi.first.wpilibj.DriverStation;

public class RightScaleSwitchOutside extends AutoMode {

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
		
		
		
		if(gameData != null && gameData.charAt(1) == 'R'){
			
			//driveDistance(.5, -.5, (260 * 8), 10, 0, .3);
			Ingestor.closeIngestor();
			armGoUp(.001, true);
			driveDistance(4.25, -.9, 72080, 10, 0, .3);
			//turnToAngle(1.2, -120, 15, .5, 18750);
			dtTurnToAngle(1.25, 115, .7, 22000, .3);
			driveDistance(1.25, .85, 10000, 10, 22000, .3);
			dropCube(.7, .7, .7, 22000);
			driveDistance(3, -.6, (-20000), 20, -50000, 0);
			
			
			}
			
		
		else if(gameData != null && gameData.charAt(0) == 'R'){
			Ingestor.closeIngestor();
			armGoDown(.1, true);
			driveDistance(.7, -.3, (260 * 8), 10, 0, 0);
			driveDistance(4, -.6, (40000), 10, 0, 0);
			dtTurnToAngle(2, -80, 5, 0, 0);
			driveDistance(1, -.6, (1500 * 50), 10, 0, 0);
			dropCube(1, .9, .9, 0);
			driveDistance(1, .6, 3000, 10, 0, 0);
			//dtTurnToAngle(2,-52.5,50,.5);
			//driveDistance(1, -.6, (260 * 25), 10, 0, 0);
			armGoUp(3, true);
			driveDistance(2, 0, 0, -50000, 0, 0);
					
		}
		else{
			driveDistance(1, -.3, (260 * 8), 10, 0, .3);
			driveDistance(8, -.7, (72280 - (260 * 80)), 10, 0, .3);
			turnToAngle(2, -45, 8, .5, 0);
			Ingestor.closeIngestor();
			armGoUp(1, true);
		}
		
		
		
	}

}