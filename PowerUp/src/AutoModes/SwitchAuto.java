package AutoModes;

public class SwitchAuto extends AutoMode {

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		armGoUp(.001, true);
		driveDistance(8, .9, (72280 -260 * 5), 10);
		//
		//turnToAngle(1, 70, 8, .5);
		elevatotSet(3, 50000);
	}

}
