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
		Elevator.setElevatorIn();
		//Elevator.resetEncoder();
	}
	
	public static void run(){
		//DriveTrain.preventTip();

		//Driver
		DriveTrain.arcadeDrive(driver.getRightStickYAxis(), Utils.negPowTwo(driver.getLeftStickXAxis()));
		
		if(driver.getRightBumper()){
			DriveTrain.setHighGear(true);
		}
		else
			DriveTrain.setHighGear(false);	
		
		//Manip
		
		
		
		if(manip.getRightBumper())
			Climber.climb(manip.getRightStickYAxis());
		else{ 
			Elevator.setPower(manip.getRightStickYAxis());
			Climber.climb(0);
		}
		
		/*
		if(manip.getLeftBumper())
			Ingestor.openIngest();
		else{ 
			Ingestor.closeIngestor();
		}
		*/
		if(manip.getAButton())
			USBLED.isWombo(true);
		else
			USBLED.isWombo(false);
		
		//asf
		
		
		
		//if(driver.getXButton())
		//	DriveTrain.turnToAngle(-30);
		
		if(manip.getXButton())
			DriveTrain.tipOut();
		else
			DriveTrain.tipIn();
		
		/*
		if(manip.getYButton())
			DriveTrain.rampOut();
		elsekjg
			DriveTrain.rampIn();
		*/
		if(manip.getYButton())
			Elevator.setElevatorIn();
		//else
		//	Elevator.setElevatorOut();
		//else
		//	Elevator.setElevatorOut();
		//Ingestor.ingestCurentLimiting();
		
		
		if(manip.getLeftBumper())
			Elevator.setBarsOut();
		else
			Elevator.setBarsIn();
		if(manip.getRightTriggerAxis() > 90){
			Ingestor.leftControl(.5);
			Ingestor.rightControl(-.5);
		}
		else if(manip.getLeftTriggerAxis() > 90){
			Ingestor.leftControl(-.5);
			Ingestor.rightControl(.5);
		}
		else 
			Ingestor.bothControl(-manip.getLeftStickYAxis());
			//asdf;lkasf
		
		
		//if(Ingestor.isGearInIngestor()){
		//	manip.setLeftRumble(1);
		//	driver.setLeftRumble(1);
		//}
		
		
			
		
		
		//SmartDashboard
		SmartDashboard.putNumber("DT Gryo", DriveTrain.getAngle());
		SmartDashboard.putNumber("DT Encoder", DriveTrain.getEncoderAverage());
		//SmartDashboard.putNumber("Pitch", DriveTrain.getRoll());
		SmartDashboard.putNumber("eleavtor encoder", Elevator.getPosition());
		SmartDashboard.putNumber("Angle", DriveTrain.getAngle());
		//SmartDashboard.putBoolean("Limit Switch Error", Elevator.checkLimitSwitches(Elevator.getBottomLimitSwitch()));
		SmartDashboard.putBoolean("Switch", Elevator.getBottomLimitSwitch());
		SmartDashboard.putNumber("xbox", manip.getLeftStickYAxis());
		SmartDashboard.putNumber("Elevator power", Elevator.getAmountPower());
		SmartDashboard.putBoolean("GYRO", DriveTrain.isConnected());
	}
	
}
