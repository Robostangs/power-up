/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team548.robot;

import com.kauailabs.navx.frc.AHRS;

import AutoModes.AutoLine;
import AutoModes.AutoMode;
import AutoModes.DriveStraight;
import AutoModes.RightSwitchRightScale;
import AutoModes.SwitchAuto;
import AutoModes.SwitchAuto2;
import AutoModes.SwitchPriorityLeft;
import AutoModes.SwitchPriorityRight;
import AutoModes.LeftScaleSwitchOutside;
import AutoModes.RightScaleSwitchOutside;
import AutoModes.RightCross;           
import AutoModes.LeftCross;
//import AutoModes.Beesswervecode;
//import AutoModes.BeesPID;
//import AutoModes.5cubeauto;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public Robot(){
		
		AHRS ahrs = new AHRS(SerialPort.Port.kUSB); 
		/* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */
		
	}
	
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
		//USBLED.getInstance();
		//CameraServer.getInstance().startAutomaticCapture();
		PDP = new PowerDistributionPanel();
		
		autoChooser = new SendableChooser<AutoMode>();
		autoChooser.addDefault("Center Switch", new DriveStraight());
		autoChooser.addDefault("Cross Baseline", new AutoLine());
		//autoChooser.addDefault("Scale/Switch Left", new SwitchAuto1());
		autoChooser.addDefault("Scale/Switch Left", new SwitchAuto());
		autoChooser.addDefault("Scale/Switch Right", new RightSwitchRightScale());
		autoChooser.addDefault("Switch/Scale Left", new SwitchPriorityLeft());
		autoChooser.addDefault("Switch/Scale Right", new SwitchPriorityRight());
		autoChooser.addDefault("Left Scale for alliance two cube/switch", new LeftScaleSwitchOutside());
		autoChooser.addDefault("Right Scale for alliance two cube/switch", new RightScaleSwitchOutside());
		autoChooser.addDefault("Cross Scale Right", new RightCross());
		autoChooser.addDefault("Cross Scale Left", new LeftCross());
		autoChooser.addDefault("Pick your auto",  new SwitchAuto2());
		SmartDashboard.putData("Auto mode", autoChooser);
		//SmartDashboard.putData("Is Gyro Connected?", DriveTrain.isConnected());
		SmartDashboard.putBoolean("Gyro Connection", DriveTrain.isConnected());
		//SmarasdftDashboard.putNumber("Match Time:", DriverStation.getInstance().getMatchTime());
		DriveTrain.resetGyro();
		DriveTrain.resetEncoder();
	}
	
	@Override
	public void autonomousInit() {
		DriveTrain.resetGyro();
		autoChooser.getSelected().start();
		Ingestor.openIngest();
	}

	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Drive Train", DriveTrain.getEncoderAverage());
		SmartDashboard.putNumber("AUTO GYRO", DriveTrain.getAngle());
		System.out.println("Gyro: " + DriveTrain.isConnected());
		System.out.println(DriveTrain.isConnected());
		//SmartDashboard.putBoolean("Is Gyro Connected", DriveTrain.isConnected());
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
