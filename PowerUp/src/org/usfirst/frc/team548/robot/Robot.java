/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team548.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	
	XBoxController driver;
	XBoxController manip;
	
	@Override
	public void robotInit() {
		DriveTrain.getInstance();
		Elevator.getInstance();
		driver = new XBoxController(0);
		manip = new XBoxController(1);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
	
	}

	/**
	 * This function is called periodically during operator control.
	 */
	public void teleopInit(){
		//TeleOp.init();
		
		//if(driver.getAButton())
			//Elevator.setElevatorOut();
	}
	
	@Override
	public void teleopPeriodic() {
		//DriveTrain.preventTip();
		
		//TeleOp.run();
		
		
		//if(driver.getAButton()){
			Elevator.setElevatorOut();
		//}
		//else
		//	Elevator.setElevatorIn();
		
		DriveTrain.arcadeDrive(driver.getRightStickYAxis(), Utils.negPowTwo(driver.getLeftStickXAxis()));
		
		if(driver.getRightBumper()){
			DriveTrain.setHighGear(true);
		}
		else
			DriveTrain.setHighGear(false);	
		
		
		Elevator.setPower(manip.getRightStickYAxis());
		
		SmartDashboard.putNumber("Pitch", DriveTrain.getRoll());
		SmartDashboard.putNumber("eleavtor encoder", Elevator.getPosition());
		SmartDashboard.putNumber("Angle", DriveTrain.getAngle());
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
