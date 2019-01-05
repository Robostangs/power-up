package AutoCommands;

import org.usfirst.frc.team548.robot.Elevator;

public class armGoDown extends AutoCommandBase {
	public static boolean position;
	
	public armGoDown(double timeOut, boolean pos) {
		super(timeOut);
		this.position = pos;
		// TODO Auto-genearmGoDownrated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		Elevator.resetEncoder();

	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		Elevator.setElevatorIn();
		////Elevator.setPosition(0);
	}
	

	@Override
	public void end() {
		// TODO Auto-generated method stub
		Elevator.setElevatorIn();
		Elevator.setPosition(0);
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}

}