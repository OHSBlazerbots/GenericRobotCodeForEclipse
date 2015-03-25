package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PrintSensorValue extends CommandBase {

    public PrintSensorValue() {
        // Use requires() here to declare subsystem dependencies
        requires(sensorBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//System.out.println("R1: " + sensorBase.getReed1());
    	//System.out.println("R2: " + sensorBase.getReed2());
    	//System.out.println("R3: " + sensorBase.getReed3());
    	//System.out.println("R4: " + sensorBase.getReed4());
    	//System.out.println("HT: " + sensorBase.getTopHall());
    	
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
