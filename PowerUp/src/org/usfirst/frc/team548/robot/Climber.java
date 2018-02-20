package org.usfirst.frc.team548.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Climber {
	private static Climber instance;
	private static TalonSRX talonUn, talonDeux, talonTrois;
	
	public static Climber getInstance(){
		if(instance == null)
			instance = new Climber();
		return instance;
	}
	
	private Climber(){
		talonUn = new TalonSRX(Constants.CLIMBER_TALON_UN); //Master
		talonDeux = new TalonSRX(Constants.CLIMBER_TALON_DEUX); //Slave
		talonTrois = new TalonSRX(Constants.CLIMBER_TALON_TROIS); //Slave
		
	}
	
	public static void climb(double power){
		talonUn.set(ControlMode.PercentOutput, -power);
		talonDeux.set(ControlMode.PercentOutput, power);
		talonTrois.set(ControlMode.PercentOutput, power);
	}
	
	
}
