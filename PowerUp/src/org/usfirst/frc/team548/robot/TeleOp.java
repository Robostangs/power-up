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
			DriveTrain.setHighGear(true);
		}
		else
			DriveTrain.setHighGear(false);	
		
		//Manip
		Elevator.setPower(manip.getRightStickYAxis());
		
		if(manip.getRightBumper()){
			Climber.climb(manip.getRightStickYAxis());
		}
		
		if(manip.getAButton())
			Elevator.resetEncoder();
		if(manip.getBButton())
			Elevator.calibrateEncoder();
		if(manip.getXButton())
			Elevator.setPosition(30000);
		if(manip.getBackButton())
			Elevator.setElevatorIn();
		
		
		Ingestor.ingestCurentLimiting();
		Ingestor.leftControl(manip.getLeftTriggerAxis());
		Ingestor.rightControl(manip.getRightTriggerAxis());
		if(Ingestor.isGearInIngestor()){
			manip.setLeftRumble(1);
			driver.setLeftRumble(1);
		}
		
		Ingestor.bothControl(manip.getLeftStickYAxis());
			
		
		
		//SmartDashboard
		SmartDashboard.putNumber("DT Encoder", DriveTrain.getEncoderAverage());
		//SmartDashboard.putNumber("Pitch", DriveTrain.getRoll());
		SmartDashboard.putNumber("eleavtor encoder", Elevator.getPosition());
		//SmartDashboard.putNumber("Angle", DriveTrain.getAngle());
		//SmartDashboard.putBoolean("Limit Switch Error", Elevator.checkLimitSwitches(Elevator.getBottomLimitSwitch()));
		SmartDashboard.putBoolean("Switch", Elevator.getBottomLimitSwitch());
		//SmartDashboard.putNumber("xbox", manip.getRightStickYAxis());
		SmartDashboard.putNumber("Elevator power", Elevator.getAmountPower());		
	}
	
}
