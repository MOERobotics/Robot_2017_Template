package org.usfirst.frc.team365.Routines;

import org.usfirst.frc.team365.robot.*;
import org.usfirst.frc.team365.structural.*;

public class Disabled extends RobotRoutine{

	public Disabled(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules) {
		super(inputs, outputs, modules);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		modules.allModules.forEach((x)->x.HALT());
		
	}

	@Override
	public void periodic(int loopCounter) {
		// TODO Auto-generated method stub
		
	}




}
