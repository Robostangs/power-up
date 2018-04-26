package org.usfirst.frc.team548.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;

//import edu.wpi.first.wpilibj.Encoder;

public class Elevator {
	private static TalonSRX left, right;
	private static Elevator instance;
	private static DigitalInput bottomLimitSwitch, topLimitSwitch;
	private static PIDController pid;
	private static DoubleSolenoid whip1;
	
	
	
	//public static final DoubleSolenoid.Value kOff;
	
	public static Elevator getInstance(){
		if (instance == null){
			instance = new Elevator();
		}
		return instance;
	}
	
	private Elevator(){
		left = new TalonSRX(Constants.ELEVATOR_TALON_LEFT); // master
		right = new TalonSRX(Constants.ELEVATOR_TALON_RGIHT); // slave
		bottomLimitSwitch = new DigitalInput(Constants.ELEVATOR_BOTTOM_LIMITSWITCH);
		topLimitSwitch = new DigitalInput(Constants.ELEVATOR_TOP_LIMITSWITCH);
		right.set(ControlMode.Follower, left.getDeviceID());
		left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		whip1 = new DoubleSolenoid(2, 3);
		left.config_kP(0, Constants.ELEAVTOR_PID_P, 0);
		left.config_kI(0, Constants.ELEAVTOR_PID_I, 0);
		left.config_kD(0, Constants.ELEAVTOR_PID_D, 0);
		left.config_kF(0, Constants.ELEAVTOR_PID_F, 0);
		left.configPeakOutputForward(.5, 10);
		left.configPeakOutputReverse(-.5, 10);
		
		
		//left.setInverted(false);
		//right.setInverted(true);
		left.setSensorPhase(true);
		
	}
	
	public static void setPower(double power){
		if(Math.abs(power) < .1)
			Elevator.stop();
		else
			left.set(ControlMode.PercentOutput, power);
	}
	
	/*
	public static void setAlwaysPower(){
		if(getPosition() > 400 && Math.abs(getAmountPower()) <.1 )
			left.set(ControlMode.PercentOutput, .14);
	}
	*/
	
	public static double getPosition(){
		return left.getSelectedSensorPosition(0);
	}
	
	public static void setPosition(double position){
		left.set(ControlMode.Position, position);
	}
	
	public static boolean getBottomLimitSwitch(){
		return bottomLimitSwitch.get();
	}
	
	public static boolean getTopLimitSwitch(){
		return topLimitSwitch.get();
	}
	
	public static void stop(){
		left.set(ControlMode.PercentOutput, 0);
	}
	
	public static void resetEncoder(){
		left.setSelectedSensorPosition(0, 0, 10);
		
	}
	
	public static void calibrateEncoder(){
		if(getBottomLimitSwitch()){
			setPower(Constants.ELEVATOR_DOWNPOWER);
		}
		else{
			Elevator.stop();
			Elevator.resetEncoder();
		}
	}
	
	public static void setElevatorIngest(){
		Elevator.setPosition(0);
	}
	
	public static void setSwitchPosition(){
		Elevator.setPosition(Constants.ELEVATOR_SWITCH);
	}
	
	public static void setScaleUpPosition(){
		Elevator.setPosition(Constants.ELEVATOR_SCALE_UP);
	}
	
	public static void setScalePositionEven(){
		Elevator.setPosition(Constants.ELEVATOR_SCALE_EVEN);
	}
	
	public static void setScalePositionDown(){
		Elevator.setPosition(Constants.ELEVATOR_SCALE_DOWN);
	}
	
	public static void setElevatorOut(){
		whip1.set(DoubleSolenoid.Value.kForward);
		//whip2.set(true);
	}
	
	public static void setElevatorIn(){
		whip1.set(DoubleSolenoid.Value.kReverse);
	}
	
	public static boolean checkLimitSwitches(boolean limitSwitch){
		if(limitSwitch && !limitSwitch){
			//This means that there is something that has gone wrong
			return false;
		}
		else
			//this means that it is working
			return true;
	}
	
	public static void powerBottom(){
		if(Elevator.getPosition() < 10000 && left.getMotorOutputPercent() < -.11)
			Elevator.setPower(-.1);
	}
	
	public static void stopTop(double power){
		if(getTopLimitSwitch())
			stop();
		else
			setPosition(power);
	}
	
	public static double getAmountPower(){
		return left.getMotorOutputPercent();
	}
	
}
