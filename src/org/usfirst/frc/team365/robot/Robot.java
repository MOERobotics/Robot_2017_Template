// Louminator and Kevin weren't here.
package org.usfirst.frc.team365.robot;

import org.usfirst.frc.team365.routines.*;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	public static RobotInputs inputs;
	public static RobotOutputs outputs;
	public static RobotModulesList modules;
	public static RobotSharedVariables variables;

	Teleop teleop;
	Disabled disabled;
	Autonomous auto;
	AllTheTime allTheTime;

	public Robot() {
		inputs = new RobotInputs();
		outputs = new RobotOutputs();
		modules = new RobotModulesList(inputs, outputs);
		variables = new RobotSharedVariables();

		teleop = new Teleop(inputs, outputs, modules, variables);
		disabled = new Disabled(inputs, outputs, modules, variables);
		auto = new Autonomous(inputs, outputs, modules, variables);
		allTheTime = new AllTheTime(inputs, outputs, modules, variables);

	}

	@Override
	public void robotInit() {
		allTheTime.init();
	}

	@Override
	public void robotPeriodic() {
		allTheTime.periodic();
	}

	@Override
	public void disabledInit() {
		disabled.init();
	}

	@Override
	public void disabledPeriodic() {
		disabled.periodic();
	}

	@Override
	public void autonomousInit() {
		auto.init();
	}

	@Override
	public void autonomousPeriodic() {
		auto.periodic();
	}

	@Override
	public void teleopInit() {
		teleop.init();
	}

	@Override
	public void teleopPeriodic() {
		teleop.periodic();
	}

}
