package AutoModes;

import org.usfirst.frc.team548.robot.DriveTrain;
import org.usfirst.frc.team548.robot.Ingestor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight extends AutoMode {
	
	public DriveStraight(){
		super();
	}
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
		String gameData = "";
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		//
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
		
		SmartDashboard.putNumber("Auto Enc", DriveTrain.getEncoderAverage());
		//driveDistance(.5, -.2, (800), 10, 0, 0);
		driveDistance(.5, -.2, (800), 10, 0, 0);
		
		if(gameData != null && gameData.charAt(0) == 'L'){
			if(DriveTrain.isConnected()){
				//double timeOut, double angle, double power, double elevatorSetPoint
				Ingestor.closeIngestor();
				driveDistance(1.2, -.6, (7510), 10, 0, 0);
				Ingestor.closeIngestor();
				dtTurnToAngle(1, -45, .5, 0, 0);
				// 6-18-2018 
				driveDistance(2, -.7, (20000), 10, 0, 0);
				//turnToAngle(2, -35, 25, .5, 0);
				dtTurnToAngle(2, 50, .5, 0, 0);
				driveDistance(1, -.5, (260 * 28), 10, 0, 0);
				dropCube(.5, .7, .6, 0);
				driveDistance(2, .5, (260 * 12), 10, 0, 0);
				//turnToAngle(1, -90, 13, .5, 0);
				dtTurnToAngle(1, 90, .5, 0, 0);
				armGoUp(1, true);
				
				
				
				
				////driveDistance(1.2, -.6, (7510), 10, 0, 0);
				//driveDistance(1, -.6, (7510), 10, 0, 0);
				////turnToAngle(2, -45, 30, .5, 0);
				//dtTurnToAngle(2, -45, .5, 0);
				
				////driveDistance(2, -.7, (20057 - 2928), 10, 0, 0);
				//driveDistance(2, -.7, (20057 - 2928), 10, 0, 0);
				////turnToAngle(2, 45, 20, .5, 0);
				//dtTurnToAngle(2, 50, .5, 0);
				//System.out.println("3");
				////driveDistance(1, -.5, (260 * 28), 10, 0, 0);
				//driveDistance(1, -.5, (260*28), 10, 0, 0);
				//System.out.println("4");
				
				////power goes from 0-1
				//dropCube(1, 0.875, 0.875, 0);
				//System.out.println("5");
				//armGoUp(.1, true);
				////driveDistance(2, .5, (260 * 8), 10, 0, 0);
				//driveDistance(2, .5, (260*8), 10, 0, 0);
				//System.out.println("6");
				
				////armGoUp(1, true);
				////turnToAngle(1, -90, 13, .5, 0);
				//dtTurnToAngle(2, -90, .5, 0);
				//System.out.println("7");
				
				////armGoUp(1, true);
				System.out.println("8");
			}
			else{
				System.out.println("NO GYRO");
				//turnToAngle(.4, -90, 13, .5, 0);
				dtTurnToAngle(.4, -90, .5, 0, 0);
				//driveDistance(1, -.5, (260 * 20), 10, 0, 0);
				driveDistance(1, 0.5, (260 * 20), 10, 0, 0);
				armGoUp(1, true);

			}
			
			//uirkj
		}
		else {
			if(DriveTrain.isConnected() && gameData.charAt(0) == 'R' && gameData != null){
				//double timeOut, double angle, double power, double elevatorSetPoint
				Ingestor.closeIngestor();
				driveDistance(1.2, -.6, (9000), 10, 0, 0);
				Ingestor.closeIngestor();
				dtTurnToAngle(1.5, 45, .5, 0, 0);
				// 6-18-2018 
				driveDistance(2, -.7, (10000), 10, 0, 0);
				//turnToAngle(2, -35, 25, .5, 0);
				dtTurnToAngle(2, -35, .5, 0, 0);
				driveDistance(1, -.5, (260 * 28), 10, 0, 0);
				dropCube(.5, .7, .6, 0);
				driveDistance(2, .5, (260 * 12), 10, 0, 0);
				//turnToAngle(1, -90, 13, .5, 0);
				dtTurnToAngle(1, 90, .5, 0, 0);
				armGoUp(1, true);
			}
			else{
				System.out.println("NO GYRO");
				//turnToAngle(.4, -90, 13, .5, 0);
				dtTurnToAngle(.4, -90, .5, 0, 0);
				driveDistance(1, -.5, (260 * 20), 10, 0, 0);
				armGoUp(1, true);

			}	
			
		}
		
	}
	
	
}