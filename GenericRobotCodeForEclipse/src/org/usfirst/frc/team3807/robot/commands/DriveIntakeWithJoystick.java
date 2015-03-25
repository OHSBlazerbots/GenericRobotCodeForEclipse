package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveIntakeWithJoystick extends CommandBase {

	JoystickButton button;

	public DriveIntakeWithJoystick() {
		// Use requires() here to declare subsystem dependencies
		requires(intake);
		button = new JoystickButton(oi.getCoDriverJoystick2(), 1);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("DIWJ");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("DIWJ - Exe");
		if (!button.get()) {
			intake.setIntake(oi.getCoDriverJoystick2().getY());
		}
		else
		{
			intake.setIntake(0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
