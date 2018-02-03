package org.usfirst.frc.team548.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;

//import edu.wpi.first.wpilibj.Encoder;

public class Elevator {
	private static TalonSRX left, right;
	private static Elevator instance;
	private static DigitalInput bottomLimitSwitch, topLimitSwitch;
	private static PIDController pid;
	private static Solenoid whip;
	
	public static Elevator getInstance(){
		if (instance == null){
			instance = new Elevator();
		}
		return instance;
	}
	
	private Elevator(){
		left = new TalonSRX(Constants.ELEVATOR_TALON_LEFT); // slave
		right = new TalonSRX(Constants.ELEVATOR_TALON_RGIHT); // master
		bottomLimitSwitch = new DigitalInput(Constants.ELEVATOR_BOTTOM_LIMITSWITCH);
		topLimitSwitch = new DigitalInput(Constants.ELEVATOR_TOP_LIMITSWITCH);
		left.set(ControlMode.Follower, right.getDeviceID());
		right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		whip = new Solenoid(Constants.ELEVATOR_SOLENOID);
		left.config_kP(0, Constants.ELEAVTOR_PID_P, 10);
		left.config_kI(0, Constants.ELEAVTOR_PID_I, 10);
		left.config_kD(0, Constants.ELEAVTOR_PID_D, 10);
		left.config_kF(0, Constants.ELEAVTOR_PID_F, 10);
		
	}
	
	public static void setPower(double power){
		left.set(ControlMode.PercentOutput, power);
		
	}
	
	public static int getPosition(){
		return right.getSensorCollection().getPulseWidthPosition();
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
		left.getSensorCollection().setPulseWidthPosition(0, 10);
	}
	
	public static void calibrateEncoder(){
		if(!getBottomLimitSwitch()){
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
		whip.set(true);
	}
	
	public static void setElevatorIn(){
		whip.set(false);
	}
	
	public static void stopTop(double power){
		if(getTopLimitSwitch())
			stop();
		else
			setPosition(power);
	}
	
}
