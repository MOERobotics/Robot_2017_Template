package org.usfirst.frc.team365.routines;

import org.usfirst.frc.team365.autoRoutines.CenterGear;
import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotModulesList;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.robot.RobotSharedVariables;
import org.usfirst.frc.team365.structural.RobotRoutine;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends RobotRoutine{

	public Autonomous(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules, RobotSharedVariables variables) {
		super(inputs, outputs, modules, variables);
		// TODO Auto-generated constructor stub
	}
	int autoLoop=0;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		variables.localLoopCounter=0;
		modules.allModules.forEach((x)->x.HALT());
		modules.drivetrain.setGearLow();
	}

	@Override
	public void periodic() {
		// TODO Auto-generated method stub
		variables.localLoopCounter++;
		
		switch (variables.autoRoutine){
		case 1:
			CenterGear.loop(inputs, outputs, modules, variables);
			break;
		case 2:
			if (variables.redSide) {
				//autoHopperShootRed();
			}
			else //autoHopperShootBlue();

			break;
		case 3:
			if (variables.redSide) {
				//autoShootFirstRed();
			}
			else //autoShootFirstBlue();
			break;
		case 4:
			//autoOuterGear();
			break;
		case 5:
			if (variables.redSide) {
				//autoBoilerGearRed();
			}
			else //autoBoilerGearBlue();
			break;
		}
		
	}
}

