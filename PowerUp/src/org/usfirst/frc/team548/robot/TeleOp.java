package org.usfirst.frc.team548.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp {
	private static XBoxController driver, manip;
	private static TeleOp instance;
	
	public static TeleOp getInstance() {
		if (instance == null)
			instance = new TeleOp();
		return instance;
	}
	
	private TeleOp(){
		driver = new XBoxController(Constants.XB_POS_DRIVER);
		manip = new XBoxController(Constants.XB_POS_MANIP);
	}
	
	public static void init(){
		//DriveTrain.resetEncoder();
		Elevator.setElevatorOut();
		//Elevator.resetEncoder();
	}
	
	public static void run(){
		//DriveTrain.preventTip();

		//Driver
		DriveTrain.arcadeDrive(driver.getRightStickYAxis(), Utils.negPowTwo(driver.getLeftStickXAxis()));
		
		if(driver.getRightBumper()){
			DriveTrain.setHighGear(false);
		}
		else
			DriveTrain.setHighGear(true);	
		
		//Manip
		
		
		
		
		if(manip.getRightBumper())
			Climber.climb(manip.getRightStickYAxis());
		else{ 
			Elevator.setPower(manip.getRightStickYAxis());
			Climber.climb(0);
		}
		
		/*
		if(manip.getLeftStickYAxis() > .5){
			Ingestor.ingestCurentLimiting();
				if (Ingestor.isCubeInIngestor()) {
					manip.setLeftRumble(1);
					driver.setLeftRumble(1);

				} else {
					manip.setLeftRumble(0);
					driver.setLeftRumble(0);
				}
		}
		*/
		if(driver.getAButton())
			DriveTrain.resetEncoder();
		if(driver.getBButton())
			DriveTrain.resetGyro();
		if(driver.getXButton())
			Elevator.resetEncoder();;
		if(manip.getYButton())
			Elevator.setElevatorIn();
		else
				Elevator.setElevatorOut();
		
		if(manip.getLeftBumper())
			Ingestor.closeIngestor();
		else
			Ingestor.openIngest();
		
		//else //Jason uncommented lines 56 and 57 on 3/10/18 after kurt left because elevator wasn't unfolding.
		//	Elevator.setElevatorOut();
		//else
		//	Elevator.setElevatorOut();
		//Ingestor.ingestCurentLimiting();
		
		
		
		if(manip.getBackButton()){
			Ingestor.leftControl(.5);
			Ingestor.rightControl(-.5);
		}
		else if(manip.getStartButton()){
			Ingestor.leftControl(-.5);
			Ingestor.rightControl(.5);
		}
		else if(manip.getLeftJoystickButton()){
			Ingestor.leftControl(-.3);
			Ingestor.rightControl(-.3);
		}
		else 
			Ingestor.bothControl(-manip.getLeftStickYAxis());
			
		
		//Ingestor.ingestCurentLimiting();
		if(Ingestor.isCubeInIngestor()){
			manip.setLeftRumble(1);
			driver.setLeftRumble(1);
		}
		else{
			manip.setLeftRumble(0);
			driver.setLeftRumble(0);
		}
		//asdfj}
		
		if(driver.getBButton()){
			Elevator.resetEncoder();
		}
		
		if(driver.getAButton()){
			
			Elevator.setPosition(55000);
		}
		
		
		//Ingestor.rightControl(manip.getRightTriggerAxis());
		//Ingestor.leftControl(manip.getLeftTriggerAxis());
		
		//SmartDashboard
		SmartDashboard.putNumber("DT Encoder", DriveTrain.getEncoderAverage());
		//SmartDashboard.putNumber("Pitch", DriveTrain.getRoll());
		SmartDashboard.putNumber("eleavtor encoder", Elevator.getPosition());
		SmartDashboard.putNumber("Angle", DriveTrain.getAngle());
		//SmartDashboard.putBoolean("Limit Switch Error", Elevator.checkLimitSwitches(Elevator.getBottomLimitSwitch()));
		SmartDashboard.putBoolean("Switch", Elevator.getBottomLimitSwitch());
		SmartDashboard.putNumber("xbox", manip.getLeftStickYAxis());
		SmartDashboard.putNumber("Elevator power", Elevator.getAmountPower());	
		SmartDashboard.putBoolean("Gyro", DriveTrain.isConnected());
	}
	
}
