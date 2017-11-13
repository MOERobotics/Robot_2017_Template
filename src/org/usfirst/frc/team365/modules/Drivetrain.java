package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Drivetrain extends RobotModule{

	Value HI_GEAR = Value.kReverse;
	final Value LO_GEAR = Value.kForward;
	
	public Drivetrain(RobotInputs inputs, RobotOutputs outputs) {
		super(inputs, outputs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void HALT() {
		setSpeed(0);
		
	}

	@Override
	public void off() {
		setSpeed(0);
		
	}

	
	public void drive(double leftSpeed, double rightSpeed) {
		setLeftSpeed(leftSpeed);
		setRightSpeed(rightSpeed);
	}
	
	public void driveStraight(double speed) {
		setSpeed(speed);
	}
	@Override
	public void setSpeed(double speed) {
		setLeftSpeed(speed);
		setRightSpeed(speed);
	}
	public void setLeftSpeed(double speed) {
		outputs.driveL1.set(limitMotor(speed));
		outputs.driveL2.set(limitMotor(speed));
		outputs.driveL3.set(limitMotor(speed));
	}
	
	public void setRightSpeed(double speed) {
		outputs.driveR1.set(limitMotor(speed));
		outputs.driveR2.set(limitMotor(speed));
		outputs.driveR3.set(limitMotor(speed));
	}
	
	
	
	public void setGearHigh() {
		if(outputs.gearShift.get()!=HI_GEAR) {
			outputs.gearShift.set(HI_GEAR);
		}
	}
	
	public void setGearLow() {
		if(outputs.gearShift.get()!=LO_GEAR) {
			outputs.gearShift.set(LO_GEAR);
		}
	}
	
	public void zeroYaw() {
		inputs.navx.zeroYaw();
	}
	public void resetEncoders() {
		inputs.leftEncoder.reset();
		inputs.rightEncoder.reset();
	}
	
	public double limitMotor(double power) {
		return power>1?1:power<-1?-1:power;
	}
	
	public double getEncoderDist() {
		return 1.25*(Math.abs(inputs.leftEncoder.getRaw())>Math.abs(inputs.rightEncoder.getRaw())? 
				inputs.leftEncoder.getRaw():inputs.rightEncoder.getRaw());
	}

}
