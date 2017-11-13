package org.usfirst.frc.team365.util;

import org.usfirst.frc.team365.structural.RobotInputs;
import org.usfirst.frc.team365.structural.RobotModulesList;
import org.usfirst.frc.team365.structural.RobotOutputs;
import org.usfirst.frc.team365.modules.*;
public abstract class RobotMechanism{
	
	protected static RobotInputs  inputs;
	protected static RobotOutputs outputs;
	protected static RobotModulesList modules;
	public RobotMechanism(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules) {
		RobotMechanism.inputs = inputs;
		RobotMechanism.outputs = outputs;
		RobotMechanism.modules = modules;
		// TODO Auto-generated constructor stub
	}



}
