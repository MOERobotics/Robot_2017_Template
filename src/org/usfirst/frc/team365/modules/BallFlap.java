package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

public class BallFlap extends RobotModule{

	
	
	public BallFlap(RobotInputs inputs, RobotOutputs outputs) {
		super(inputs, outputs);
		// TODO Auto-generated constructor stub
	}

	public void up() {
		outputs.ballFlap.set(true);
	}
	public void down() {
		outputs.ballFlap.set(false);
	}
	
	
	@Override
	public void HALT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		
	}

}
