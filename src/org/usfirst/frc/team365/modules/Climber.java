package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

public class Climber extends RobotModule
{
	
	
	public Climber(RobotInputs inputs, RobotOutputs outputs){
		super(inputs, outputs);
	}
	
	
	public void on(boolean state) {
		outputs.climberA.set(state?1:0);
		outputs.climberB.set(state?1:0);
	}
	
	public void on() {
		outputs.climberA.set(1);
		outputs.climberB.set(1);
	}
	
	public void off() {
		outputs.climberA.set(1);
		outputs.climberB.set(1);
	}
	
	
	public void HALT() {
		outputs.climberA.set(0);
		outputs.climberB.set(0);
	}


	@Override
	public void setSpeed(double speed) {
		outputs.climberA.set(speed);
	}
	
	
}