package org.usfirst.frc.team548.robot;

import java.util.Arrays;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

/*
 * See https://docs.google.com/spreadsheets/d/1tdbu5kxECmHi2MyT0dEW17oEaT4cRJXpTU9CM4r0fAo/edit?usp=sharing for bit reference
 * BIT ZERO IS LEAST SIGNIFICANT BIT, LIKE ARDUINO
 */
public class USBLED {
	private static short elevatorPosition;
	private static short oldPosition;
	private static USBLED instance = null;
	private static SerialPort serial;
	private static byte status;
	private static boolean[] statusBools;
	private static boolean[] oldBools;
	private USBLED() {
		try {
			serial = new SerialPort(115200, SerialPort.Port.kUSB1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		status = 0;
		statusBools = new boolean[8];
		oldBools = new boolean[8];
		elevatorPosition=0;
		oldPosition=0;
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						
						sync();
						//System.out.println("memes");
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public static USBLED getInstance() {
		if (instance == null) {
			instance = new USBLED();
		}
		return instance;
	}

	private static void updateByte() {
		status = (byte) ((statusBools[7] ? 1 << 7 : 0) + (statusBools[6] ? 1 << 6 : 0) + (statusBools[5] ? 1 << 5 : 0)
				+ (statusBools[4] ? 1 << 4 : 0) + (statusBools[3] ? 1 << 3 : 0) + (statusBools[2] ? 1 << 2 : 0)
				+ (statusBools[1] ? 1 << 1 : 0) + (statusBools[0] ? 1 : 0));
	}

	private static void sync() {
		//System.out.println(serial.readString());
		updateDsValues();
		updateByte();
		try {
			for (int i = 0; i < 5; i++){
				serial.write(new byte[] {(byte)0x0f,(byte) 0xf0,  status,(byte)(elevatorPosition&0xff),(byte)((elevatorPosition>>8)&0xff) }, 5);
			}
			//System.out.println(Arrays.toString(statusBools));
		} catch (Exception e) {
			//e.printStackTrace();
			try {
				serial = new SerialPort(9600, SerialPort.Port.kUSB);
			} catch (Exception ex) {
				//ex.printStackTrace();
			}
			//e.printStackTrace();
		}
	}

	private static void updateDsValues() {
		if (DriverStation.getInstance().isBrownedOut()) {
			statusBools[0] = true;
			statusBools[1] = true;
		} else if (!DriverStation.getInstance().isDSAttached()
				|| DriverStation.getInstance().getAlliance() == Alliance.Invalid) {
			statusBools[0] = false;
			statusBools[1] = false;
		} else if (DriverStation.getInstance().getAlliance() == Alliance.Red) {
			statusBools[0] = false;
			statusBools[1] = true;
		} else {
			statusBools[0] = true;
			statusBools[1] = false;
		}
		if (DriverStation.getInstance().isAutonomous()&&DriverStation.getInstance().isEnabled()) {
			statusBools[2] = true;
			statusBools[3] = false;
		} else if (DriverStation.getInstance().isOperatorControl()&&DriverStation.getInstance().isEnabled()) {
			statusBools[2] = true;
			statusBools[3] = true;
		} else if (DriverStation.getInstance().isFMSAttached()) {
			statusBools[2] = false;
			statusBools[3] = true;
		} else {
			statusBools[2] = false;
			statusBools[3] = false;
		}
	}

	public static void isHasCube(boolean hasCube) {
		statusBools[4] = hasCube;
		if(statusBools[4]!=oldBools[4]){
			sync();
			oldBools[4]=statusBools[4];
		}
	}

	public static void isWantCube(boolean wantCube) {
		statusBools[5] = !wantCube;
		if(statusBools[5]!=oldBools[5]){
			sync();
			oldBools[5]=statusBools[5];
		}
	}

	public static void isWombo(boolean wombo) {
		statusBools[6] = wombo;
		if(statusBools[6]!=oldBools[6]){
			sync();
			oldBools[6]=statusBools[6];
		}
	}

	public static void isClimbing(boolean rft) {
		statusBools[7] = rft;
		if(statusBools[7]!=oldBools[7]){
			sync();
			oldBools[7]=statusBools[7];
		}
	}
	public void setElevatorPosition(short elevatorPos) {
		elevatorPosition = elevatorPos;
		if(elevatorPosition!=oldPosition){
			sync();
			oldPosition=elevatorPosition;
		}
	}
}