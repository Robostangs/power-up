package AutoModes;

public class LeftGoAround extends AutoMode {

	public LeftGoAround(){
		super();
	}
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		driveDistance(13, -.6, (52780 + 260 + 260 + 260), 10);
		
		turnToAngle(5, 80, .5);
		
		
		
		//waitTime(5);
		
		driveDistance(10, -.5, (41860 -3120), 10);
		//
		turnToAngle(5, 90, .5);
		
		driveDistance(5, -.6, (8 * 260), 10);
		dropCube(1, .9, .9);
	}

}
