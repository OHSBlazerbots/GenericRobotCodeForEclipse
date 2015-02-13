package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.DriveRobot;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.HaltRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * This is the autonomous command.
 * Drive forward and shoot.
 * @author jmuller4
 */
public class Autonomous extends CommandGroup {

	private static final int TOTE_LEVEL = 1;
	private static final int BOTTOM = 3;
	
	
	 public Autonomous(){
		 
		 addParallel(new GoToPosition(TOTE_LEVEL));
		 addSequential(new WaitCommand(2.5));
		 addSequential(new PrintCommand("Turning"));
		 
		 
		 addParallel(new DriveRobot(0, -1));
		 addSequential(new WaitCommand(.25));
		 
		 
		 addParallel(new DriveRobot(.9, 0));
		 addSequential(new WaitCommand(.25));
		 
		 
		 addParallel(new DriveRobot(0, 1));
		 addSequential(new WaitCommand(.5));
	
		 
		 addParallel(new DriveRobot(.9, 0));
		 addSequential(new WaitCommand(.25));
		 
		 
		 addParallel(new DriveRobot(0, -1));
		 addSequential(new WaitCommand(.25));
		 
		 
		 addSequential(new PrintCommand("Driving"));
		 addSequential(new DriveUntilTote());
		 
		 
		 addSequential(new GoToPosition(BOTTOM));
		 
		 
		 addParallel(new GoToPosition(TOTE_LEVEL));
		 addSequential(new WaitCommand(2.5));
		 addSequential(new PrintCommand("Turning"));
		 
		 
		 addParallel(new DriveRobot(0, -1));
		 addSequential(new WaitCommand(.125));
		 
		 
		 addParallel(new DriveRobot(.9, 0));
		 addSequential(new WaitCommand(.25));
		 
		 
		 addParallel(new DriveRobot(0, 1));
		 addSequential(new WaitCommand(.25));
	
		 
		 addParallel(new DriveRobot(.9, 0));
		 addSequential(new WaitCommand(.25));
		 
		 
		 addParallel(new DriveRobot(0, -1));
		 addSequential(new WaitCommand(.125));
		 
		 
		 addSequential(new PrintCommand("Driving"));
		 addSequential(new DriveUntilTote());
	 }

}