package AutoCommands;

import org.usfirst.frc.team548.robot.Elevator;
import org.usfirst.frc.team548.robot.Ingestor;

public class DropCube extends AutoCommandBase {
	private double powerLeft, powerRight, elevatorSetPoint;
	
	public DropCube(double timeOut, double powerLeft,double powerRight, double elevatorSetPoint) {
		super(timeOut);
		// TODO Auto-generated constructor stub
		this.powerLeft = powerLeft;
		this.powerRight = powerRight;
		this.elevatorSetPoint = elevatorSetPoint;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		Ingestor.leftControl(-powerRight);
		Ingestor.rightControl(-powerLeft);
		Elevator.setPosition(elevatorSetPoint);
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		Ingestor.stop();
		//Elevator.setElevatorOut();
		
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Drop Cube";
	}

}
