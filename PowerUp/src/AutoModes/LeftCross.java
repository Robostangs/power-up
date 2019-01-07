package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Ingestor;

import edu.wpi.first.wpilibj.DriverStation;

public class LeftCross extends AutoMode {

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
			
			//driveDistance(.5, -.5, (260 * 8), 10, 0, .3);
			Ingestor.closeIngestor();
			armGoUp(.001, true);
			driveDistance(4.25, -.9, 72080, 10, 0, .3);
			//turnToAngle(1.2, -120, 15, .5, 18750);
			dtTurnToAngle(1.25, -115, .7, 22000, .3);
			driveDistance(1.25, .85, 10000, 10, 22000, .3);
			dropCube(.3, .7, .7, 22000);
			//driveDistance(.6, -.85, (-2500), 20, -50000, 0);
			dtTurnToAngle(1.25, 95, 0.6, -55000, 0);
			Ingestor.openIngest();
			driveDistance(1.5, .9, (22500), 20, -50000, 1);
			driveDistance(0.75, 0, 0, 0, -50000, 1);
			Ingestor.closeIngestor();
			driveDistance(0.3, 0, 0, 0, -50000, 1);
			driveDistance(1.5, -.9, 22000, 20, 0, 0);
			dtTurnToAngle(1.1, -70, 0.9, 22000, 1);
			driveDistance(1.5, .85, (5000), 20, 22000, 0);
			dropCube(.5, 1, 1, 22000);
			//OLD driveDistance(1, -.5, 2080 + 9 * 260, 20, 10000, 0);
			//turnToAngle(1, 110, 25, .5, 0);
			//driveDistance(1, .5, 2080 + 20 * 260, 20, 0, 0);
			
			
			}
			
		
		else if(gameData != null && gameData.charAt(1) == 'R'){
			Ingestor.closeIngestor();
			armGoUp(.001, true);
			driveDistance(3.8, -.9, 65000, 10, 0, .3);
			dtTurnToAngle(1.5, 95, .35, 0, .3);
			driveDistance(4.25, -.9, 51000, 10, -30000, .3);
			dtTurnToAngle(1.5, 87, .35, 22000, .3);
			driveDistance(1.5, .7, 15000, 10, 22000, .3);
			dropCube(.5, 1, 1, 22000);
			driveDistance(1.5, -.7, 10000, 10, 22000, .3);
			dtTurnToAngle(1.5, 180, .35, -50000, .3);
			//dtTurnToAngle(2,-52.5,50,.5);
			//driveDistance(1, -.6, (260 * 25), 10, 0, 0);
			//driveDistance(2, 0, 0, -50000, 0, 0);
					
		}
		else{
			driveDistance(1, -.3, (260 * 8), 10, 0, .3);
			driveDistance(8, -.7, (72280 - (260 * 80)), 10, 0, .3);
			turnToAngle(2, 45, 8, .5, 0);
			Ingestor.closeIngestor();
			armGoUp(1, true);
		}
		
		
		
	}

}