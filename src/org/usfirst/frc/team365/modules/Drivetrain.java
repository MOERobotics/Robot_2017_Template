package org.usfirst.frc.team365.modules;

import org.usfirst.frc.team365.robot.RobotInputs;
import org.usfirst.frc.team365.robot.RobotOutputs;
import org.usfirst.frc.team365.structural.RobotModule;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Drivetrain extends RobotModule{

	Value HI_GEAR = Value.kReverse;
	final Value LO_GEAR = Value.kForward;
	double straightSum;
	double turnSum;
	double lastOffYaw;
	
	public Drivetrain(RobotInputs inputs, RobotOutputs outputs) {
		super(inputs, outputs);
		// TODO Auto-generated constructor stub
		straightSum = 0;
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
	
	public void goStraight (double setBearing, double speed) {
		double currentYaw = inputs.navx.getYaw();
		double offYaw = setBearing - currentYaw;
		
		if (offYaw > 0.7 || offYaw < -0.7) {
			if (offYaw > 0 && offYaw < 6) straightSum = straightSum + 0.0005;
			else if (offYaw < 0 && offYaw > -6) straightSum = straightSum - 0.0005;
		}
		else offYaw = 0;
		
		double newPower = .05 * offYaw + straightSum;
		double leftSide = speed + newPower;
		double rightSide = speed - newPower;
		drive(leftSide, rightSide);
	}
	public void resetStraightSum() {
		straightSum=0;
	}
	public void turnToAngle(double setBearing) {
		double currentYaw = inputs.navx.getYaw();
		double offYaw = setBearing - currentYaw;

		if (offYaw * lastOffYaw <= 0) {
			turnSum = 0;
		}
		if (offYaw > 0.6 || offYaw < -0.6) {
			if (offYaw < 20 && offYaw > -20) {
				if (offYaw > 0) turnSum = turnSum + 0.01;
				else turnSum = turnSum - 0.01;
			}
			double newPower = .03 * offYaw + turnSum + .05 * (offYaw - lastOffYaw) ;
			if (newPower > 0.7) newPower = 0.7;
			else if (newPower < -0.7) newPower = -0.7;

			drive(newPower, - newPower);
			lastOffYaw = offYaw;
		}

		else {
			drive(0,0);
			lastOffYaw = offYaw;
		}
	
	}

}
