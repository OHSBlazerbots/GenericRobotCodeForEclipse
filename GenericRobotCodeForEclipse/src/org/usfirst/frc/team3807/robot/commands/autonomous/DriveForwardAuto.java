package org.usfirst.frc.team3807.robot.commands.autonomous;

import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.DriveRobot;
import org.usfirst.frc.team3807.robot.commands.GenericChassisControls.HaltRobot;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class DriveForwardAuto extends Autonomous {
	//drives to auto zone
	public DriveForwardAuto(){
		//drive forward
		 addSequential(new DriveRobot(1, 0));
		 addSequential(new WaitCommand(1.5));
		 addSequential(new HaltRobot());
	}
}
