package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

public class Collector extends RobotModule{

	public Collector(RobotInputs inputs, RobotOutputs outputs) {
		super(inputs, outputs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HALT() {
		setSpeed(0);
		
	}

	@Override
	public void off() {
		setSpeed(0);
		
	}

	@Override
	public void setSpeed(double speed) {
		outputs.collector.set(speed);
	}
	
	public void in() {
		setSpeed(1);
	}
	public void out() {
		setSpeed(-1);
	}
	

}
