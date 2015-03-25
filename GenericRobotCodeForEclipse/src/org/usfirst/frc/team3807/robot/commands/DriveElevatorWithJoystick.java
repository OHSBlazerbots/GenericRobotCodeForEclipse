package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveElevatorWithJoystick extends CommandBase {

	JoystickButton button;

	public DriveElevatorWithJoystick() {
		// Use requires() here to declare subsystem dependencies
		requires(elevator);
		button = new JoystickButton(oi.getCoDriverJoystick(), 1);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!button.get()) {
			elevator.driveWithJoystick(oi.getCoDriverJoystick());
		} else {
			elevator.setElevatorSpeed(0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		elevator.setElevatorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		elevator.setElevatorSpeed(0);
	}
}
