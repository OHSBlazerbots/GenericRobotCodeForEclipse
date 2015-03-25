package org.usfirst.frc.team3807.robot.commands.autonomous;

import org.usfirst.frc.team3807.robot.commands.GoToPosition;
import org.usfirst.frc.team3807.robot.commands.ReverseIntake;
import org.usfirst.frc.team3807.robot.commands.StartIntake;
import org.usfirst.frc.team3807.robot.commands.StopIntake;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.DriveRobot;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class ThreeToteAuto extends Autonomous {
	public ThreeToteAuto() {
		
		
		// Lift tote #1
		addParallel(new GoToPosition(TOTE_LEVEL));
		addSequential(new WaitCommand(2.5));
		
		addParallel(new StartIntake());
		addSequential(new WaitCommand(3));

		// Shake bin #1
//		addParallel(new DriveRobot(0, -1));
//		addSequential(new WaitCommand(.25));
//
//		addParallel(new DriveRobot(.9, 0));
//		addSequential(new WaitCommand(.25));
//
//		addParallel(new DriveRobot(0, 1));
//		addSequential(new WaitCommand(.5));
//
//		addParallel(new DriveRobot(.9, 0));
//		addSequential(new WaitCommand(.25));
//
//		addParallel(new DriveRobot(0, -1));
//		addSequential(new WaitCommand(.35));

		// Forward to tote #2
		addSequential(new DriveUntilTote());
		addSequential(new WaitCommand(3));
		//Acquire tote #2
		addSequential(new GoToPosition(BOTTOM));

		//Lift tote #2
		addParallel(new GoToPosition(TOTE_LEVEL));
		addSequential(new WaitCommand(2.5));

		// Shake bin #2
//		addParallel(new DriveRobot(0, -1));
//		addSequential(new WaitCommand(.25));
//
//		addParallel(new DriveRobot(.9, 0));
//		addSequential(new WaitCommand(.25));
//
//		addParallel(new DriveRobot(0, 1));
//		addSequential(new WaitCommand(.5));
//
//		addParallel(new DriveRobot(.9, 0));
//		addSequential(new WaitCommand(.25));
//
//		addParallel(new DriveRobot(0, -1));
//		addSequential(new WaitCommand(.25));

		// Forward to tote #3
		addSequential(new DriveUntilTote());

		addParallel(new StopIntake());
		addSequential(new WaitCommand(3));
		//Acquire tote #3
		addSequential(new GoToPosition(BOTTOM));

		//Drive to autozone
		  //turn
		addParallel(new DriveRobot(0, 1));
		addSequential(new WaitCommand(.5));
		  //forward
		addParallel(new DriveRobot(1, 0));
		addSequential(new WaitCommand(1.5));
	      //Turn
		addParallel(new DriveRobot(0, -1));
		addSequential(new WaitCommand(.5));
		
		addParallel(new ReverseIntake());
		
		  //leave totes
		addParallel(new DriveRobot(-1, 0));
		addSequential(new WaitCommand(1.5));
		addSequential(new DriveRobot(0, 0));
		
		addParallel(new StopIntake());
	}
}
