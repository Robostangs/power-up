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
		
		if(driver.getAButton())
			DriveTrain.resetEncoder();
		if(driver.getBButton())
			DriveTrain.resetGyro();
		if(driver.getXButton())
			DriveTrain.turnToAngle(-30);
		if(manip.getYButton())
			Elevator.setElevatorIn();
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
		else 
			Ingestor.bothControl(-manip.getLeftStickYAxis());
			
		
		
		//if(Ingestor.isGearInIngestor()){
		//	manip.setLeftRumble(1);
		//	driver.setLeftRumble(1);
		//}
		
		
			
		
		
		//SmartDashboard
		SmartDashboard.putNumber("DT Encoder", DriveTrain.getEncoderAverage());
		//SmartDashboard.putNumber("Pitch", DriveTrain.getRoll());
		SmartDashboard.putNumber("eleavtor encoder", Elevator.getPosition());
		SmartDashboard.putNumber("Angle", DriveTrain.getAngle());
		//SmartDashboard.putBoolean("Limit Switch Error", Elevator.checkLimitSwitches(Elevator.getBottomLimitSwitch()));
		SmartDashboard.putBoolean("Switch", Elevator.getBottomLimitSwitch());
		SmartDashboard.putNumber("xbox", driver.getLeftStickXAxis());
		SmartDashboard.putNumber("Elevator power", Elevator.getAmountPower());
		SmartDashboard.putNumber("right power dt", DriveTrain.getRightPower());
		//SmartDashboard.putNumber("left power dt", DriveTrain.getLeftPower());
	}
	
}
