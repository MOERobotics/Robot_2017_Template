package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

public class Azimuth extends RobotModule {

	public Azimuth(RobotInputs inputs, RobotOutputs outputs) {
		super(inputs, outputs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HALT() {
		// TODO Auto-generated method stub
		setSpeed(0);
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		setSpeed(0);
	}

	@Override
	public void setSpeed(double speed) {
		outputs.azimuth.set(speed);
	}
	
	public void up() {
		setSpeed(-.25);
	}
	
	public void down() {
		setSpeed(.25);
	}
	
	public void turntoAngle(double theta) {
		double dTheta = theta - getPosition();
		double turnPower = 0;
		if (Math.abs(dTheta)<2) {
			return;
		}
		turnPower = .25 * Math.tanh(dTheta);
		setSpeed(turnPower);
	}
	
	public double getPosition() {
		return outputs.azimuth.getPulseWidthPosition()%4096;
	}

}
