package rp.assignments.individual.ex3;

import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.Pose;
import rp.config.RangeFinderDescription;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;

public class TestVirtualBumper {
	
	private VirtualBumper vBumper;
	
	public static void main(String[] args) {
		TestVirtualBumper testVirtualBumper = new TestVirtualBumper();
		testVirtualBumper.Init();
	}
	
	public void Init(){
		RangeFinderDescription desc = new RangeFinderDescription(new Pose(7, 3, 0), 1, 0, 0.03f, 100);
		RangeFinder ranger = new RangeFinder() {
			
			@Override
			public float[] getRanges() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public float getRange() {
				// TODO Auto-generated method stub
				return 1;
			}
		};
		float touchRange = 0.5f;
		vBumper = new VirtualBumper(desc, ranger, touchRange);
		vBumper.addTouchSensorListener(new TouchSensorListener() {
			
			@Override
			public void sensorReleased(TouchSensorEvent _e) {
				System.out.println("sensorReleased");
				
			}
			
			@Override
			public void sensorPressed(TouchSensorEvent _e) {
				System.out.println("sensorPressed");
				
			}
			
			@Override
			public void sensorBumped(TouchSensorEvent _e) {
				System.out.println("sensorBumped");
				
			}
		});
	}
}
