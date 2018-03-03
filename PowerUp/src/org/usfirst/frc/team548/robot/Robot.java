/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team548.robot;

import AutoModes.AutoMode;
import AutoModes.DriveStraight;
import AutoModes.LeftGoAround;
import AutoModes.SwitchAuto;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	AutoMode autonCommand;
	SendableChooser<AutoMode> autoChooser;
	
	public static PowerDistributionPanel PDP;
	@Override
	public void robotInit() {
		DriveTrain.getInstance();
		Elevator.getInstance();
		TeleOp.getInstance();
		Elevator.getInstance();
		Ingestor.getInstance();
		Climber.getInstance();
		PDP = new PowerDistributionPanel();
		
		autoChooser = new SendableChooser<AutoMode>();
		autoChooser.addDefault("Test Auto", new DriveStraight());
		autoChooser.addDefault("left goaround",new LeftGoAround());
		autoChooser.addDefault("scale auton test", new SwitchAuto());
		
		SmartDashboard.putData("Auto mode", autoChooser);
		//SmartDashboard.putNumber("Match Time:", DriverStation.getInstance().getMatchTime());
		
		
	}
	
	@Override
	public void autonomousInit() {
		DriveTrain.resetGyro();
		autoChooser.getSelected().start();
		
		
		
	}

	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Drive Train", DriveTrain.getEncoderAverage());
		SmartDashboard.putNumber("AUTO GYRO", DriveTrain.getAngle());
		//SmartDashboard.putNumber("PID Error", DriveTrain.getPIDError());
	}

	@Override
	public void teleopPeriodic() {		
		TeleOp.run();
	}
	
	@Override
	public void teleopInit(){
		TeleOp.init();

	}	
	@Override
	public void testPeriodic() {
	}
}
