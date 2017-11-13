package org.usfirst.frc.team365.routines;

import org.usfirst.frc.team365.robot.*;
import org.usfirst.frc.team365.structural.*;

public class AllTheTime extends RobotRoutine{

	public AllTheTime(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules, RobotSharedVariables variables) {
		super(inputs, outputs, modules, variables);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init() {
		// TODO Auto-generated method stub
		modules.allModules.forEach((x)->x.HALT());
		variables.robotLoopCounter=0;
	}

	@Override
	public void periodic() {
		// TODO Auto-generated method stub
		variables.robotLoopCounter++;
	}

}
