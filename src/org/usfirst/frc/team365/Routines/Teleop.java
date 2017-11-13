package org.usfirst.frc.team365.Routines;

import org.usfirst.frc.team365.robot.*;
import org.usfirst.frc.team365.structural.*;

public class Teleop extends RobotRoutine{

	boolean runShooter;
	boolean runFeeder;
	boolean lastButtonD3;
	boolean lastButtonD10;
	double xJoy=0;
	double yJoy=0;
	
	
	public Teleop(RobotInputs inputs, RobotOutputs outputs, RobotModulesList modules) {
		super(inputs, outputs, modules);
	}
	
	public void init() {
		modules.allModules.forEach((x)->x.HALT());
		runShooter = false;
		runFeeder = false;
		lastButtonD3 = false;
		lastButtonD10 = false;
	}
	
	public void periodic(int loopCounter) {
		if(Robot.inputs.funStick.getY()>.5) {
			modules.climber.on();
		} else {
			modules.climber.off();
		}
		
		if(inputs.funStick.getRawButton(4)) {
			runShooter=true;
		}
		if(inputs.funStick.getRawButton(5)) {
			runShooter=false;
		}
		if(inputs.funStick.getRawButton(8)) {
			runFeeder=true;
		}
		if(inputs.funStick.getRawButton(9)) {
			runFeeder=false;
		}
		modules.indexer.setSpeed(inputs.funStick.getRawButton(1)?1:0);
		if(runShooter) {
			modules.shooter.setSpeed((inputs.driveStick.getRawAxis(2)+1.0)/2.0);
			modules.collector.in();
			if(runFeeder) {
				modules.feeder.setSpeed(.75);
			} else {
				modules.feeder.HALT();
			}
		} else {
			modules.shooter.HALT();
			modules.feeder.HALT();
			if(inputs.funStick.getRawButton(5)) {
				modules.collector.in();
			} else if (inputs.funStick.getRawButton(6)) {
				modules.collector.out();
			}
		}
		if (inputs.funStick.getRawButton(2)) {
			modules.azimuth.up();
		} else if (inputs.funStick.getRawButton(3)){
			modules.azimuth.down();
		}
		xJoy = inputs.driveStick.getX();
		yJoy = inputs.driveStick.getY();
		xJoy = Math.abs(xJoy)>0.1?xJoy:0;
		yJoy = Math.abs(yJoy)>0.1?yJoy:0;
		
		if(inputs.driveStick.getRawButton(8)) {
			modules.drivetrain.setGearHigh();
		} else {
			modules.drivetrain.setGearLow();
		}
		if(inputs.driveStick.getTrigger()) {
			modules.drivetrain.driveStraight(yJoy);
		} 
		
		else if(inputs.driveStick.getRawButton(2)){
			if (inputs.lightRight.get()) {
				modules.drivetrain.HALT();
			}
			else {
			modules.drivetrain.drive(-0.35,0.35);
			}	
		}
		
		else if(inputs.driveStick.getRawButton(2)){
			if (inputs.lightRight.get()) {
				modules.drivetrain.HALT();
			}
			else {
			modules.drivetrain.drive(-0.35,0.35);
			}
		}
		else if(inputs.driveStick.getRawButton(3)) {
			if (!lastButtonD3) {
				modules.drivetrain.resetEncoders();
			}
			lastButtonD3 = true;
			if (modules.drivetrain.getEncoderDist()>2400) {
				modules.drivetrain.HALT();
			}
			else modules.drivetrain.drive(0.35,0.35);
		}
		else {
			modules.drivetrain.drive(yJoy+xJoy, yJoy-xJoy);
			lastButtonD3 = false;
		}
		
		if (inputs.funStick.getY()<-0.5) {
			modules.ballflap.up();
		} else {
			modules.ballflap.down();
		}
		
		if (inputs.funStick.getRawButton(6)) {
			modules.gearthing.up();
		} else if (inputs.funStick.getRawButton(7)) {
			modules.gearthing.down();
		}
	
	}
	
	

}
