package org.usfirst.frc.team3807.robot.commands.autonomous;

import org.usfirst.frc.team3807.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveUntilTote extends CommandBase {

    public DriveUntilTote() {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassis.drive(.9, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//accounting for the robot's inability to drive straight!!! Change value on smart dashboard
    		chassis.drive(.75, SmartDashboard.getDouble("AutoTurn"));
    }
    
    // Make this return true when this Command no longer needs to run execute()
    //if the limit switch is pressed, then the command is finished
    //sensor normally returns true
    protected boolean isFinished() {
        return (!CommandBase.sensorBase.getLimitTote());
    }

    protected void end() {
    	// once isFinished() is called, then the robot stops
    	chassis.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	chassis.drive(0, 0);
    }
}
