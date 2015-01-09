/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3807.robot.commands.GenericChassisControls;

import org.usfirst.frc.team3807.robot.commands.CommandBase;

/**
 *
 * @author sgoldman
 */
public class DriveRobot extends CommandBase {
    
    private double speed,turn;
    
    
    
    public DriveRobot(double speed, double turn) {
       requires(chassis);
       this.speed = speed;
       this.turn = turn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.drive(speed, turn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}