package rp.assignments.individual.ex1;

import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class TriangleMotionController implements StoppableRunnable{
	private DifferentialDriveRobot robot; 
	private float sideLength;
	private boolean allowedToRun = true;

	public TriangleMotionController(DifferentialDriveRobot robot, Float sideLength) {
		this.robot = robot;
		this.sideLength = sideLength;
	}
	
	@Override
	public void run() {
		while(allowedToRun)
		{
			int sidesComplete = 0;
			while(sidesComplete < 3){
				robot.getDifferentialPilot().travel(sideLength);
				robot.getDifferentialPilot().rotate(120);
				sidesComplete++;
			}
		}
	}

	@Override
	public void stop() {
		allowedToRun = false;
	}
}
