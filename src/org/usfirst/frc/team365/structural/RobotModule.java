package org.usfirst.frc.team365.structural;

import org.usfirst.frc.team365.robot.*;

public abstract class RobotModule{
	protected static RobotInputs  inputs;
	protected static RobotOutputs outputs;
	public RobotModule(RobotInputs inputs, RobotOutputs outputs){
		RobotModule.inputs=inputs;
		RobotModule.outputs=outputs;
	}
	
	public double pulsesToInch(double pulses){
		return pulses / 107.0 ;
	}
	
	public abstract void HALT();
	public abstract void off();
	public abstract void setSpeed(double speed);
}