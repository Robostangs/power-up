package org.usfirst.frc.team548.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class DriveTrain {
public static DriveTrain instance;
	
	public static DriveTrain getInstance(){
		if(instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	private static TalonSRX rightFront, leftFront, rightBack, leftBack;
	
	private static Solenoid sol;
	
	private DriveTrain(){
		rightFront = new TalonSRX(Constants.DT_TALON_RIGHTFRONT);
		rightBack = new TalonSRX(Constants.DT_TALON_RIGHTBACK);
		leftFront = new TalonSRX(Constants.DT_TALON_LEFTFRONT);
		leftBack = new TalonSRX(Constants.DT_TALON_LEFTBACK);
		sol = new Solenoid(Constants.DT_SOLENOID_SHIFTER);
	}
	
	public static void drive(double leftPower, double rightPower){
		rightFront.set(ControlMode.PercentOutput, -rightPower);
		rightBack.set(ControlMode.PercentOutput, -rightPower);
		leftBack.set(ControlMode.PercentOutput, leftPower);
		leftFront.set(ControlMode.PercentOutput, leftPower);
	}
	
	public static void arcadeDrive(double fwd, double tur) {
		if (Math.abs(tur) < .01)
			tur = 0;
		if (Math.abs(fwd) < .2)
			fwd = 0;
		drive(Utils.ensureRange(fwd + tur, -1d, 1d), Utils.ensureRange(fwd - tur, -1d, 1d));
	}
	
	public static void blaze(boolean b){
		sol.set(b);
	}
	
	////
}
