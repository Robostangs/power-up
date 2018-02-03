package org.usfirst.frc.team548.robot;

public class Constants {
	//Drive Train
	public static final int DT_TALON_RIGHTFRONT = 1; // has encoder
	public static final int DT_TALON_RIGHTBACK = 2;
	public static final int DT_TALON_LEFTFRONT = 13;
	public static final int DT_TALON_LEFTBACK = 14; // has encoder
	public static final int DT_SOLENOID_SHIFTER = 4;
	public static final boolean DT_SOLENOID_BOOLEAN = true;
	public static final double DT_PID_P = 0;
	public static final double DT_PID_I = 0;
	public static final double DT_PID_D = 0;
	public static final double DT_DRIVE_STRAIGHT = 1.20;
	
	//Elevator
	public static final int ELEVATOR_TOP_LIMITSWITCH = 1;
	public static final int ELEVATOR_BOTTOM_LIMITSWITCH = 2;
	public static final int ELEVATOR_TALON_RGIHT = 0;
	public static final int ELEVATOR_TALON_LEFT = 0;
	public static final double ELEVATOR_DOWNPOWER = -.20;
	public static final double ELEVATOR_DOWN = 0;
	public static final double ELEVATOR_SWITCH  = 0 + 0;
	public static final double ELEVATOR_SCALE_DOWN = 0 + 0;
	public static final double ELEVATOR_SCALE_EVEN = 0 + 0;
	public static final double ELEVATOR_SCALE_UP= 0 + 0;
	public static final double ELEAVTOR_PID_P = 0;
	public static final double ELEAVTOR_PID_I = 0;
	public static final double ELEAVTOR_PID_D = 0;
	public static final double ELEAVTOR_PID_F = 0;
	public static final int ELEVATOR_SOLENOID = 0;
	
	//TeleOp
	public static final int XB_POS_DRIVER = 0;
	public static final int XB_POS_MANIP = 0;
}
