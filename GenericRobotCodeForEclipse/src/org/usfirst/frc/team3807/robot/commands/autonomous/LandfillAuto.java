package org.usfirst.frc.team3807.robot.commands.autonomous;

import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.DriveRobot;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.HaltRobot;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class LandfillAuto extends Autonomous {

	public LandfillAuto()
	{
		//drives forward for .5 seconds
		addParallel(new DriveRobot(.7,0));
		addSequential(new WaitCommand(.25));
		
		//turns right
		addParallel(new DriveRobot(0, -2));
		addSequential(new WaitCommand(.5));
		
		/*//reset
		addParallel(new DriveRobot(-.5, -1));
		addSequential(new WaitCommand(.5));*/
		
		addSequential(new HaltRobot());
		
		
		
	}
}
