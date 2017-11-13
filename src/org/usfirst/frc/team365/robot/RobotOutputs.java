package org.usfirst.frc.team365.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;

public final class RobotOutputs {
	public CANTalon driveL1;
	public CANTalon driveL2;
	public CANTalon driveL3;
	public CANTalon driveR1;
	public CANTalon driveR2;
	public CANTalon driveR3;
	public CANTalon collector;
	public CANTalon shooterA;
	public CANTalon shooterB;
	public CANTalon indexer;
	public CANTalon feeder;
	public CANTalon azimuth;
	public CANTalon climberA;
	public CANTalon climberB;

	public DoubleSolenoid gearShift;
	public DoubleSolenoid releaseGear;
	public Solenoid ballFlap;
	public Solenoid signalLight;

	public RobotOutputs() {
		driveL1 = new CANTalon(IOPort.DRIVE_L1);
		driveL2 = new CANTalon(IOPort.DRIVE_L2);
		driveL3 = new CANTalon(IOPort.DRIVE_L3);
		driveR1 = new CANTalon(IOPort.DRIVE_R1);
		driveR2 = new CANTalon(IOPort.DRIVE_R2);
		driveR3 = new CANTalon(IOPort.DRIVE_R3);
		collector = new CANTalon(IOPort.COLLECTOR);
		shooterA = new CANTalon(IOPort.SHOOT_SPIN_A);
		shooterB = new CANTalon(IOPort.SHOOT_SPIN_B);
		indexer = new CANTalon(IOPort.INDEXER);
		feeder = new CANTalon(IOPort.FEEDER);
		azimuth = new CANTalon(IOPort.AZIMUTH);
		climberA = new CANTalon(IOPort.CLIMBER_A);
		climberB = new CANTalon(IOPort.CLIMBER_B);

		gearShift = new DoubleSolenoid(IOPort.SHIFT_FWD, IOPort.SHIFT_BAK);
		releaseGear = new DoubleSolenoid(IOPort.GEAR_RELEASE_BAK, IOPort.GEAR_RELEASE_FWD);
		ballFlap = new Solenoid(IOPort.BALL_FLAP);
		signalLight = new Solenoid(3);

		motorInit();
	}

	public void motorInit() {
		driveL1.setInverted(true);
		driveL2.setInverted(true);
		driveL3.setInverted(true);
		indexer.setInverted(true);
		feeder.setInverted(true);

		driveL1.enableBrakeMode(true);
		driveL2.enableBrakeMode(true);
		driveL3.enableBrakeMode(true);
		driveR1.enableBrakeMode(true);
		driveR2.enableBrakeMode(true);
		driveR3.enableBrakeMode(true);
		climberA.enableBrakeMode(true);
		climberB.enableBrakeMode(true);
		azimuth.enableBrakeMode(true);

		shooterA.setPIDSourceType(PIDSourceType.kRate);

	}
}
