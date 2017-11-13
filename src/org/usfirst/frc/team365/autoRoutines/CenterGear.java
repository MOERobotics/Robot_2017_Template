package org.usfirst.frc.team365.autoRoutines;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotModulesList;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.robot.RobotSharedVariables;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CenterGear {


	public static void loop(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules, RobotSharedVariables variables) {
		double currentYaw = inputs.navx.getYaw();
		switch(variables.autoStep) {
		case 1:
			variables.setYaw = currentYaw;
			if (modules.drivetrain.getEncoderDist() > 5200) {
				variables.autoStep = 2;
				variables.localLoopCounter = 0;
				}
			else modules.drivetrain.goStraight(0,0.45);
				break;
		case 2:
			if (modules.drivetrain.getEncoderDist() > 7800 || variables.localLoopCounter > 100) { 
				if (/*inputs.sonar.getAverageVoltage() > 0.15 ||*/ variables.localLoopCounter > 100) {
				
					variables.autoStep = 8;
					variables.setYaw = currentYaw;
					SmartDashboard.putNumber("autoDist", modules.drivetrain.getEncoderDist());
//					SmartDashboard.putNumber("autoSonar", inputs.sonar.getAverageVoltage());
					modules.drivetrain.resetEncoders();
				}
				else {
				variables.autoStep = 3;
				modules.drivetrain.drive(0,0);				
				SmartDashboard.putNumber("autoDist", modules.drivetrain.getEncoderDist());
//				SmartDashboard.putNumber("autoSonar", inputs.sonar.getAverageVoltage());
				variables.localLoopCounter = 0;
				}
			}
			else modules.drivetrain.goStraight(0,0.3);
			break;
		case 3:
			modules.drivetrain.drive(0,0);
			modules.gearthing.down();
			if (variables.localLoopCounter > 25) {
				variables.autoStep = 4;
				modules.drivetrain.resetEncoders();
			}
			break;
		case 4:
			if (modules.drivetrain.getEncoderDist() < -2200) {
				variables.autoStep = 5;
				modules.drivetrain.drive(0,0);
			}
			else modules.drivetrain.drive(-0.4,-0.4);
			break;
		case 5:
			if (variables.redSide) {
			if (currentYaw < -63) {
				variables.autoStep = 6;
				modules.drivetrain.resetEncoders();
			}
			else modules.drivetrain.drive(-0.5,0.5);
			}
			else {
				if (currentYaw > 63) {
					variables.autoStep = 6;
					modules.drivetrain.resetEncoders();
				}
				else modules.drivetrain.drive(0.5,-0.5);
			}
			modules.gearthing.up();
			break;
		case 6:
			if (modules.drivetrain.getEncoderDist() < -11200) {
				variables.autoStep = 10;
				variables.setYaw=currentYaw;
				modules.drivetrain.drive(0,0);
			}
			else {
				if (variables.redSide) modules.drivetrain.goStraight(-67,-0.7);
				else modules.drivetrain.goStraight(67,-0.7);
			}
			break;
		case 7: 
			modules.drivetrain.drive(0,0);
			break;
		case 8:
			if (modules.drivetrain.getEncoderDist() < -1100) {
				variables.autoStep = 9;
				modules.drivetrain.drive(0,0);
			}
			else modules.drivetrain.goStraight(variables.setYaw + 3, -0.4);
			break;
		case 9:
			if (modules.drivetrain.getEncoderDist() > 500) {
				variables.autoStep = 3;
				modules.drivetrain.drive(0,0);
			}
			else modules.drivetrain.goStraight(variables.setYaw, 0.3);
			break;
		case 10:
			modules.indexer.setSpeed(1);
			modules.drivetrain.turnToAngle(variables.setYaw);
		}
			
		
	}

}
