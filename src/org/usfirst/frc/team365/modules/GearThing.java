package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class GearThing extends RobotModule{

	final Value GEAR_DN = Value.kReverse;
	final Value GEAR_UP = Value.kForward;
	
	public GearThing(RobotInputs inputs, RobotOutputs outputs) {
		super(inputs, outputs);
		// TODO Auto-generated constructor stub
	}

	
	public void up() {
		outputs.gearShift.set(GEAR_UP);
	}
	
	public void down() {
		outputs.gearShift.set(GEAR_DN);
	}
	
	@Override
	public void HALT() {
		
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
