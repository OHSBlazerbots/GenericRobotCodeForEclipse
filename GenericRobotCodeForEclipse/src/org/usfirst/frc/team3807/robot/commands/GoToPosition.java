package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToPosition extends CommandBase {

	private int position;
	private double speed;
	
    public GoToPosition(int pos) {
        // Use requires() here to declare subsystem dependencies
        requires(elevator);
        this.position = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(elevator.getCurrentPosition() == position){
    		speed = 0;
    	}
    	else if(elevator.getCurrentPosition() > position){
    		speed = -1;
    	} else{
    		speed = 1;
    	}
    	elevator.setElevatorSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.getCurrentPosition() == position;
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
