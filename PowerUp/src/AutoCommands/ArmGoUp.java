package AutoCommands;

import org.usfirst.frc.team548.robot.Elevator;

public class ArmGoUp extends AutoCommandBase {
	public static boolean position;
	
	public ArmGoUp(double timeOut, boolean pos) {
		super(timeOut);
		this.position = pos;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		Elevator.resetEncoder();

	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		Elevator.setElevatorOut();
		Elevator.setPosition(0);
	}
	

	@Override
	public void end() {
		// TODO Auto-generated method stub
		Elevator.setElevatorOut();
		Elevator.setPosition(0);
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}

}
