package rp.assignments.individual.ex3;

import lejos.robotics.RangeFinder;
import rp.config.RangeFinderDescription;
import rp.robotics.EventBasedTouchSensor;
import rp.robotics.TouchSensorListener;

public class VirtualBumper implements EventBasedTouchSensor{
	
	private VirtualBumperListener virtualBumperListener;
	private Thread virtualBumperListenerThread;
	
	public VirtualBumper(RangeFinderDescription desc, RangeFinder ranger, Float touchRange){
		virtualBumperListener = new VirtualBumperListener(desc, ranger, touchRange);
		virtualBumperListenerThread = new Thread(virtualBumperListener);
		virtualBumperListenerThread.start();
	}
	
	public void stop() {
		virtualBumperListener.stop();
		virtualBumperListenerThread.interrupt();
	}
	
	@Override
	public boolean isPressed() {
		return virtualBumperListener.isPressed();
	}

	@Override
	public void addTouchSensorListener(TouchSensorListener listener) {
		virtualBumperListener.addTouchSensorListener(listener);
	}
}
