package rp.assignments.individual.ex1;

import lejos.robotics.RangeFinder;
import rp.assignments.individual.ex2.ControllerWithTouchSensor;
import rp.assignments.individual.ex3.VirtualBumper;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.EventBasedTouchSensor;
import rp.systems.StoppableRunnable;

public class SolutionFactory {

    public static StoppableRunnable createEquilateralTriangleController(DifferentialDriveRobot _robot, Float _sideLength) {
        return new TriangleMotionController(_robot, _sideLength);
    }
    
    public static StoppableRunnable createSquareController( DifferentialDriveRobot _robot, Float _sideLength){
    	return new SquareMotionController(_robot, _sideLength);
    }
    
    public static StoppableRunnable createDecagonController( DifferentialDriveRobot _robot, Float _sideLength){
    	return new DecagonMotionController(_robot, _sideLength);
    }
    
    public static ControllerWithTouchSensor createBumperController(DifferentialDriveRobot _robot) {
        return new ControllerWithTouchSensor(_robot);
    }
	
	public static EventBasedTouchSensor createVirtualBumper(RangeFinderDescription desc, RangeFinder ranger, Float touchRange){
		 return new VirtualBumper(desc, ranger, touchRange);
	}
}