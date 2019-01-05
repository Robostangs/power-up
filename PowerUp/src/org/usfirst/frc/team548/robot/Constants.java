package org.usfirst.frc.team548.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Constants {
	//Drive Train
	public static final int DT_TALON_RIGHTFRONT = 3; // has encoder
	public static final int DT_TALON_RIGHTBACK = 2;
	public static final int DT_TALON_LEFTFRONT = 13;
	public static final int DT_TALON_LEFTBACK = 14; // has encoder
	
	public static final int DT_SOLENOID_SHIFTER = 1;
	public static final boolean DT_SOLENOID_BOOLEAN = true;
	public static final double DT_PID_P = 0.025d;
	public static final double DT_PID_I = 0;
	public static final double DT_PID_D = 0.06d;
	public static final double DT_DRIVE_STRAIGHT = 1;
	
	//Elevator
	public static final int ELEVATOR_TOP_LIMITSWITCH = 1;
	public static final int ELEVATOR_BOTTOM_LIMITSWITCH = 2;
	public static final int ELEVATOR_TALON_RGIHT = 12; // has encoder
	public static final int ELEVATOR_TALON_LEFT = 8;
	public static final double ELEVATOR_DOWNPOWER = -.1;
	public static final double ELEVATOR_DOWN = 0;
	public static final double ELEVATOR_SWITCH  = 0 + 0;
	public static final double ELEVATOR_SCALE_DOWN = 0 + 0;
	public static final double ELEVATOR_SCALE_EVEN = 0 + 0;
	public static final double ELEVATOR_SCALE_UP= 0 + 0;
	public static final double ELEAVTOR_PID_P = 1;
	public static final double ELEAVTOR_PID_I = 0;
	public static final double ELEAVTOR_PID_D = 0;
	public static final double ELEAVTOR_PID_F = 0;
	public static final int ELEVATOR_SOLENOID1 = 3;  //going up
	public static final int ELEVATOR_SOLENOID2 = 2;		//going down
	public static final int ELEVATOR_SOLENOID3 = 7;
	
	//Ingestor
	public static final int INGESTOR_TALON_RIGHT = 6;
	public static final int INGESTOR_TALONG_LEFT = 7;
	public static final int INGESTOR_CURRENT_CONSTANT = 4;
	public static final int INGESTOR_CURRENT_TIMER = 15;
	public static final int INGESTOR_SOLENOID_CLOSE_HEAVY = 0;
	public static final int INGESTOR_SOLENOID_CLOSE_LIGHT = 5;
	
	//Climber
	;public static final int CLIMBER_TALON_UN = 5;
	public static final int CLIMBER_TALON_DEUX = 4;
	public static final int CLIMBER_TALON_TROIS = 11;
	
	//TeleOp
	public static final int XB_POS_DRIVER = 0;
	public static final int XB_POS_MANIP = 1;
}

