package org.usfirst.frc.team365.robot;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team365.modules.*;
import org.usfirst.frc.team365.structural.*;

public final class RobotModulesList {
	
	
	public Azimuth azimuth;
	public Climber climber;
	public Collector collector;
	public Drivetrain drivetrain;
	public Feeder feeder;
	public Indexer indexer;
	public Shooter shooter;
	public BallFlap ballflap;
	public GearThing gearthing;
	public List<RobotModule>allModules;

	
	public RobotModulesList(RobotInputs inputs, RobotOutputs outputs) {
		azimuth = new Azimuth(inputs, outputs);
		collector = new Collector(inputs, outputs);
		drivetrain = new Drivetrain(inputs, outputs);
		feeder = new Feeder(inputs, outputs);
		indexer = new Indexer(inputs, outputs);
		climber = new Climber(inputs, outputs);
		shooter = new Shooter(inputs, outputs);
		ballflap = new BallFlap(inputs, outputs);
		gearthing = new GearThing(inputs, outputs);
		
		allModules =new ArrayList<>();
		allModules.add(azimuth);
		allModules.add(collector);
		allModules.add(drivetrain);
		allModules.add(feeder);
		allModules.add(indexer);
		allModules.add(climber);
		allModules.add(shooter);
		allModules.add(ballflap);
		allModules.add(gearthing);
		
	}

	
	
}
