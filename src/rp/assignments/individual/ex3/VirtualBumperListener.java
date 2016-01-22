package rp.assignments.individual.ex3;

import java.util.ArrayList;

import lejos.robotics.RangeFinder;
import rp.config.RangeFinderDescription;
import rp.robotics.EventBasedTouchSensor;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;

public class VirtualBumperListener implements EventBasedTouchSensor, Runnable{
	private RangeFinder ranger;
	private float touchRange;
	private ArrayList <TouchSensorListener> listeners = new ArrayList<TouchSensorListener>();
	
	private float prevRange;
	private boolean allowedToRun = true;
	private int refreshTime;
	
	private boolean isTouching = false;
	
	public VirtualBumperListener(RangeFinderDescription desc, RangeFinder ranger, Float touchRange){
		this.ranger = ranger;
		this.touchRange = touchRange + desc.getNoise();
		refreshTime = (int) Math.ceil(1000.0 / desc.getRate());
		
		prevRange = touchRange;
	}
	
	@Override
	public void run() {
		while(allowedToRun){
			try{
				float range = ranger.getRange();
				if(range <= touchRange){
					if(!isTouching)
						sensorPressed(range);
				}else{
					if(isTouching)
						sensorReleased(range);
				}
				Thread.sleep(refreshTime);
			}catch(InterruptedException iE){
				System.out.println("VirtualBumperListener Thread Interrupted");
			}
		}
		
	}
	
	public void stop(){
		allowedToRun = false;
	}
	
	private void sensorPressed(float range){
		isTouching = true;
		for (TouchSensorListener l : listeners){
			l.sensorPressed(new TouchSensorEvent(prevRange, range));
		}
		prevRange = range;
	}
	
	private void sensorReleased(float range){
		isTouching = false;
		for (TouchSensorListener l : listeners){
			l.sensorReleased(new TouchSensorEvent(prevRange, range));
			l.sensorBumped(new TouchSensorEvent(prevRange, range));
		}
		prevRange = range;
	}

	@Override
	public boolean isPressed() {
		return isTouching;
	}

	@Override
	public void addTouchSensorListener(TouchSensorListener _listener) {
		listeners.add(_listener);
	}
}
