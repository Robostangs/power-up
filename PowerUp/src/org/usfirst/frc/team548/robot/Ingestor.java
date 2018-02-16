package org.usfirst.frc.team548.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Timer;

public class Ingestor {
	
	private static Ingestor instance;
	private static TalonSRX right, left;
	private static boolean currentLimiting = false, startedTimer = false;
	private static Timer currentTimer;
	
	public static Ingestor getInstance(){
		if(instance == null)
			instance = new Ingestor();
		return instance;
	}
	
	private Ingestor(){
		right = new TalonSRX(Constants.INGESTOR_TALON_RIGHT);
		left = new TalonSRX(Constants.INGESTOR_TALONG_LEFT);
		currentTimer = new Timer();
	}
	
	public static void ingestCurentLimiting(){
		if(!currentLimiting){
			if(!startedTimer && Robot.PDP.getCurrent(Constants.INGESTOR_CURRENT_CONSTANT) > Constants.INGESTOR_CURRENT_TIMER){
				startedTimer = true;
					currentTimer.reset();
					currentTimer.start();
			}
			else if(Robot.PDP.getCurrent(Constants.INGESTOR_CURRENT_CONSTANT) < 10 && startedTimer){
				startedTimer = false;
				currentTimer.stop();
			}
			else if(currentTimer.get() < .15 && startedTimer){
				currentLimiting = true;
				startedTimer = false;
			}
			right.set(ControlMode.PercentOutput, .7);
			left.set(ControlMode.PercentOutput, .7);
		}
		else{
			right.set(ControlMode.PercentOutput, .25);
			left.set(ControlMode.PercentOutput, .7);
			if(Robot.PDP.getCurrent(Constants.INGESTOR_CURRENT_CONSTANT) < 1);
				currentLimiting = false;
		}
	}
	
	public static void bothControl(double power){
		if(Math.abs(power) < 0.15){
			stop();
		}
		else{
		right.set(ControlMode.PercentOutput, -power);
		left.set(ControlMode.PercentOutput, power);
		}
	}
	
	public static void stop(){
		right.set(ControlMode.PercentOutput, 0);
		left.set(ControlMode.PercentOutput, 0);
	}
	
	public static void leftControl(double power){
		left.set(ControlMode.PercentOutput, power);
	}
	
	public static void rightControl(double power){
		right.set(ControlMode.PercentOutput, -power);
	}
	
	public static boolean isGearInIngestor() {
		return currentLimiting;
	}
}
