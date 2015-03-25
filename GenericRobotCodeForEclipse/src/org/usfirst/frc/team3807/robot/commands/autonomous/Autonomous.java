package org.usfirst.frc.team3807.robot.commands.autonomous;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.DriveRobot;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.HaltRobot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * This is the autonomous command.
 * Drive forward and shoot.
 * @author jmuller4
 */
public class Autonomous extends CommandGroup {

	protected static final int TOTE_LEVEL = 1;
	protected static final int BOTTOM = 3;
	
	
	 public Autonomous(){
		 
//		 //addParallel(new GoToPosition(TOTE_LEVEL));
//		 //addSequential(new WaitCommand(2.5));
//		 
//		 //addSequential(new DriveRobot(0, -1));
//		 //addSequential(new WaitCommand(.5));
//		 addSequential(new DriveRobot(1, 0));
//		 addSequential(new WaitCommand(1.5));
//		 addSequential(new HaltRobot());
//		 //addSequential(new DriveRobot(0, 1));
//		 //addSequential(new WaitCommand(.5));
//		 //addParallel(new GoToPosition(BOTTOM));
//		 //addSequential(new DriveRobot(-1, 0));
//		 //addSequential(new WaitCommand(1.5));
//		 
////		 addParallel(new GoToPosition(TOTE_LEVEL));
////		 addSequential(new WaitCommand(2.5));
////		 
////		 //Shake		 
////		 addParallel(new DriveRobot(0, -1));
////		 addSequential(new WaitCommand(.25));
////		 
////		 
////		 addParallel(new DriveRobot(.9, 0));
////		 addSequential(new WaitCommand(.25));
////		 
////		 
////    	 addParallel(new DriveRobot(0, 1));
////		 addSequential(new WaitCommand(.5));
////	  
////		 
////		 addParallel(new DriveRobot(.9, 0));
////		 addSequential(new WaitCommand(.25));
////		 
////		 
////		 addParallel(new DriveRobot(0, -1));
////		 addSequential(new WaitCommand(.25));
////		 
//////Forward		 
////		 addParallel(new DriveUntilTote());
////		 addSequential(new WaitCommand(2));
////		 addSequential(new AutoSafeGuard());
////		 
////		 addSequential(new GoToPosition(BOTTOM));
////		 
////		 
////		 addParallel(new GoToPosition(TOTE_LEVEL));
////		 addSequential(new WaitCommand(2.5));
////		 addSequential(new PrintCommand("Turning"));
////		 
//////Shake		 
////		 addParallel(new DriveRobot(0, -1));
////		 addSequential(new WaitCommand(.125));
////		 
////		 
////		 addParallel(new DriveRobot(.9, 0));
////		 addSequential(new WaitCommand(.25));
////		 
////		 
////		 addParallel(new DriveRobot(0, 1));
////		 addSequential(new WaitCommand(.25));
////	
////		 
////		 addParallel(new DriveRobot(.9, 0));
////		 addSequential(new WaitCommand(.25));
////		 
////		 
////		 addParallel(new DriveRobot(0, -1));
////		 addSequential(new WaitCommand(.125));
////		 
//////Forward		 
////		 addSequential(new PrintCommand("Driving"));
////		 addParallel(new DriveUntilTote());
////		 addSequential(new WaitCommand(2));
////		 addSequential(new AutoSafeGuard());
////		 
////		 addSequential(new GoToPosition(BOTTOM));
////		 
////		 addParallel(new DriveRobot(0, 1));
////		 addSequential(new WaitCommand(.5));
////		 addParallel(new DriveRobot(1, 0));
////		 addSequential(new WaitCommand(1.5));
////		 addParallel(new DriveRobot(0, 1));
////		 addSequential(new WaitCommand(.5));
////		 addParallel(new DriveRobot(-1, 0));
////		 addSequential(new WaitCommand(1.5));
	 }

}