package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

public class Shooter extends RobotModule{

	public Shooter(RobotInputs inputs, RobotOutputs outputs) {
		super(inputs, outputs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HALT() {
		// TODO Auto-generated method stub
		setSpeed(0);
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		setSpeed(0);
	}

	@Override
	public void setSpeed(double speed) {
		// TODO Auto-generated method stub
		outputs.shooterA.set(speed);
		outputs.shooterB.set(speed);
		
	}

}
