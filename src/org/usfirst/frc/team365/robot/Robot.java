
package org.usfirst.frc.team365.robot;

import org.usfirst.frc.team365.Routines.*;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	public static RobotInputs inputs;
	public static RobotOutputs outputs;
	public static RobotModulesList modules;

	int robotLoopCounter;
	int disabledLoopCounter;
	int autoLoopCounter;
	int teleopLoopCounter;

	Teleop teleop;
	Disabled disabled;
	Autonomous auto;
	Roboot roboot;

	public Robot() {
		inputs = new RobotInputs();
		outputs = new RobotOutputs();
		modules = new RobotModulesList(inputs, outputs);

		teleop = new Teleop(inputs, outputs, modules);
		disabled = new Disabled(inputs, outputs, modules);
		auto = new Autonomous(inputs, outputs, modules);
		roboot = new Roboot(inputs, outputs, modules);

	}

	@Override
	public void robotInit() {
		robotLoopCounter = 0;
		roboot.init();
	}

	@Override
	public void robotPeriodic() {
		robotLoopCounter++;
		roboot.periodic(robotLoopCounter);
	}

	@Override
	public void disabledInit() {
		disabledLoopCounter = 0;
		disabled.init();
	}

	@Override
	public void disabledPeriodic() {
		disabledLoopCounter++;
		disabled.periodic(disabledLoopCounter);
	}

	@Override
	public void autonomousInit() {
		autoLoopCounter = 0;
		auto.init();
	}

	@Override
	public void autonomousPeriodic() {
		autoLoopCounter++;
		auto.periodic(autoLoopCounter);
	}

	@Override
	public void teleopInit() {
		teleopLoopCounter = 0;
		teleop.init();
	}

	@Override
	public void teleopPeriodic() {
		teleopLoopCounter++;
		teleop.periodic(teleopLoopCounter);
	}

}