package AutoCommands;

import org.usfirst.frc.team548.robot.Elevator;

public class ElevatorSetPoint extends AutoCommandBase {

	private static double setPoint;
	
	public ElevatorSetPoint(double timeOut, double setPoint) {
		super(timeOut);
		this.setPoint = setPoint;
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
		Elevator.setPosition(setPoint);
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		Elevator.stop();
		
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}

}