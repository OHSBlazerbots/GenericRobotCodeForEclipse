package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToAnalogPoint extends CommandBase {

	double point;
	
    public GoToAnalogPoint() {
        // Use requires() here to declare subsystem dependencies
        requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	point = (((oi.getCoDriverJoystick().getZ() *-1) + 1) *10)+1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Point: " + point + " LED: " + sensorBase.getLinearEncoderDistance());
    	elevator.setElevatorSpeed((point > sensorBase.getLinearEncoderDistance()) ? -.75 : .75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(point - sensorBase.getLinearEncoderDistance()) <= .1;
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
