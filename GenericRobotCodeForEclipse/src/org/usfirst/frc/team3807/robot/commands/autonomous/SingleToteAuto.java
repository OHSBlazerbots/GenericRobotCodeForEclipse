package org.usfirst.frc.team3807.robot.commands.autonomous;

import org.usfirst.frc.team3807.robot.commands.GoToPosition;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.DriveRobot;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.HaltRobot;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class SingleToteAuto extends Autonomous {
	//picks up one tote and goes to auto zone
	public SingleToteAuto(){
		//lift arms
		 addParallel(new GoToPosition(TOTE_LEVEL));
		 addSequential(new WaitCommand(2.5));
		 
		 //turn
		 addSequential(new DriveRobot(0, 1));
		 addSequential(new WaitCommand(.5));
		 
		 //drive to auto zone
		 addSequential(new DriveRobot(1, 0));
		 addSequential(new WaitCommand(2.5));
		 addSequential(new HaltRobot());
	}
}
