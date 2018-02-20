package AutoCommands;

import org.usfirst.frc.team548.robot.DriveTrain;

public class OneSideTurn extends AutoCommandBase {
	private static double right, left;
	
	public OneSideTurn(double timeOut, double left, double right) {
		super(timeOut);
		// TODO Auto-generated constructor stub
		this.right = right;
		this.left = left;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		DriveTrain.arcadeDrive(left, right);
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		DriveTrain.stop();
	}

	@Override
	protected String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}

}
