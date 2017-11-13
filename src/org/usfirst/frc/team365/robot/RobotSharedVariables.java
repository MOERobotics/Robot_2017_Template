package org.usfirst.frc.team365.robot;

public final class RobotSharedVariables {

	public int autoRoutine;
	public int autoStep;
	public int robotLoopCounter;
	public int localLoopCounter;
	public boolean redSide;
	
	public double setYaw;

	public RobotSharedVariables() {
		autoStep=0;
		autoRoutine=0;
		robotLoopCounter=0;
		localLoopCounter=0;
		redSide = false;
		
		setYaw = 0;
	}

}
