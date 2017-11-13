package org.usfirst.frc.team365.structural;

import org.usfirst.frc.team365.robot.*;

public abstract class RobotRoutine {
	protected static RobotInputs  inputs;
	protected static RobotOutputs outputs;
	protected static RobotModulesList modules;
	protected static RobotSharedVariables variables;
	public RobotRoutine(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules, RobotSharedVariables variables){
		RobotRoutine.inputs=inputs;
		RobotRoutine.outputs=outputs;
		RobotRoutine.modules=modules;
		RobotRoutine.variables=variables;
	}
	
	public abstract void init();
	public abstract void periodic();


	
}
