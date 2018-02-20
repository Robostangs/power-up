package AutoCommands;

import org.usfirst.frc.team548.robot.Ingestor;

public class DropCube extends AutoCommandBase {
	private double powerLeft, powerRight;
	
	public DropCube(double timeOut, double powerLeft,double powerRight) {
		super(timeOut);
		// TODO Auto-generated constructor stub
		this.powerLeft = powerLeft;
		this.powerRight = powerRight;
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
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		Ingestor.stop();
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return "Drop Cube";
	}

}
