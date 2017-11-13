package org.usfirst.frc.team365.Routines;

import org.usfirst.frc.team365.robot.*;
import org.usfirst.frc.team365.structural.*;

public class Roboot extends RobotRoutine{

	public Roboot(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules) {
		super(inputs, outputs, modules);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init() {
		// TODO Auto-generated method stub
		modules.allModules.forEach((x)->x.HALT());
		
	}

	@Override
	public void periodic(int robotLoopCounter) {
		// TODO Auto-generated method stub
		
	}

}
