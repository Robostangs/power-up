package AutoModes;

public class DriveStraight extends AutoMode {
	
	public DriveStraight(){
		super();
	}
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		driveDistance(5, .5, 3, 3);
	}
	
	
}
