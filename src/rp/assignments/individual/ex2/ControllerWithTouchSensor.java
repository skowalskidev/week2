package rp.assignments.individual.ex2;

import lejos.util.Delay;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;
import rp.systems.StoppableRunnable;

	public class ControllerWithTouchSensor implements StoppableRunnable, TouchSensorListener{
		
	private DifferentialDriveRobot robot;
	
	private boolean allowedToRun = true;
	private boolean pressed = false;

	public ControllerWithTouchSensor(DifferentialDriveRobot robot) {
		this.robot = robot;
	}

	@Override
	public void run() {
		while(allowedToRun){
			if(pressed){
				pressed = false;
				robot.getDifferentialPilot().stop();
				robot.getDifferentialPilot().travel(-robot.getRobotLength() * 0.3);
				robot.getDifferentialPilot().rotate(180);
			}
			robot.getDifferentialPilot().forward();
			Delay.msDelay(100);
		}
	}
	
	@Override
	public void stop() {
		allowedToRun = false;
	}

	@Override
	public void sensorPressed(TouchSensorEvent _e) {
		pressed = true;
	}

	@Override
	public void sensorReleased(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sensorBumped(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		
	}
}
