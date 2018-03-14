package AutoModes;

public class LeftGoAround extends AutoMode {

	public LeftGoAround(){
		super();
	}
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		turnToAngle(5, -40, 7, .6, 0);
		
	}

}
