package org.usfirst.frc.team365.routines;

import org.usfirst.frc.team365.robot.*;
import org.usfirst.frc.team365.structural.*;

public class Disabled extends RobotRoutine{

	public Disabled(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules, RobotSharedVariables variables) {
		super(inputs, outputs, modules, variables);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		variables.localLoopCounter=0;
		modules.allModules.forEach((x)->x.HALT());
		
	}

	@Override
	public void periodic() {
		// TODO Auto-generated method stub
		variables.localLoopCounter++;
		
		if (inputs.driveStick.getRawButton(2))//  zero yaw
			inputs.navx.zeroYaw();
		if (inputs.driveStick.getRawButton(4))//  reset encoders
			modules.drivetrain.resetEncoders();
		
		if (inputs.driveStick.getRawButton(6)) variables.autoRoutine = 1;
		else if (inputs.driveStick.getRawButton(8)) variables.autoRoutine = 2;
		else if (inputs.driveStick.getRawButton(10)) variables.autoRoutine = 3;
		else if (inputs.driveStick.getRawButton(12)) variables.autoRoutine = 4;
		else if (inputs.driveStick.getRawButton(11)) variables.autoRoutine = 5;
		else if (inputs.driveStick.getRawButton(9)) variables.autoRoutine = 6;
		
		if (inputs.funStick.getRawButton(8)) variables.redSide = true;
		else if (inputs.funStick.getRawButton(9)) variables.redSide = false;
		
		
	}




}
