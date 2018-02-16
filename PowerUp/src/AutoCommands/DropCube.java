package AutoCommands;

import org.usfirst.frc.team548.robot.Ingestor;

public class DropCube extends AutoCommandBase {
	private double power;
	
	public DropCube(double timeOut, double power) {
		super(timeOut);
		// TODO Auto-generated constructor stub
		this.power = power;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		Ingestor.bothControl(-power);
		
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
