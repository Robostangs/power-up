package org.usfirst.frc.team548.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleOp {
	private static XBoxController driver, manip;
	
	public TeleOp(){
		driver = new XBoxController(Constants.XB_POS_DRIVER);
		manip = new XBoxController(Constants.XB_POS_MANIP);
	}
	
	public static void init(){
		DriveTrain.resetEncoder();
		Elevator.setElevatorOut();
	}
	
	public static void run(){
		
		//Driver
		DriveTrain.arcadeDrive(driver.getRightStickYAxis(), Utils.negPowTwo(driver.getLeftStickXAxis()));
		
		if(driver.getRightBumper()){
			DriveTrain.setHighGear(true);
		}
		else
			DriveTrain.setHighGear(false);
		
		
		//Manip
		Elevator.setPosition(manip.getRightStickYAxis());
		
		if(manip.getAButton())
			Elevator.calibrateEncoder();
		
		//SmartDashboard
		SmartDashboard.putNumber("Elevator pos", Elevator.getPosition());
		SmartDashboard.putNumber("DT Encoder", DriveTrain.getEncoderAverage());
		SmartDashboard.putBoolean("Top Switch", Elevator.getTopLimitSwitch());
		SmartDashboard.putBoolean("Bottom Switch", Elevator.getBottomLimitSwitch());
	}
	
}
