package rp.assignments.individual.ex1;
import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class SquareMotionController implements StoppableRunnable{
	
	private DifferentialDriveRobot robot; 
	private float sideLength;
	private boolean allowedToRun = true;

	public SquareMotionController(DifferentialDriveRobot robot, float sideLength) {
		this.robot = robot;
		this.sideLength = sideLength;
	}

	@Override
	public void run() {
		while(allowedToRun)
		{
			int sidesComplete = 0;
			while(sidesComplete < 4){
				robot.getDifferentialPilot().travel(sideLength);
				robot.getDifferentialPilot().rotate(90);
				sidesComplete++;
			}
		}
	}

	@Override
	public void stop() {
		allowedToRun = false;
	}

}
