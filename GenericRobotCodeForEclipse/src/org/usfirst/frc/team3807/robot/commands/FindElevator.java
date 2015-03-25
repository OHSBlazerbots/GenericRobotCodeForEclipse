package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FindElevator extends CommandBase {

    public FindElevator() {
        requires(sensorBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Gyro", sensorBase.getGyroAngle());
    	System.out.println(sensorBase.getLinearEncoderDistance());
    	if(sensorBase.getTopHall() == false){
    		elevator.setCurrentPosition(0);
    	}
    	if(sensorBase.getReed1() == false){
    		elevator.setCurrentPosition(1);
    	}
    	if(sensorBase.getReed2() == false){
    		elevator.setCurrentPosition(2);
    	}
    	if(sensorBase.getBottomHall() == false){
    		elevator.setCurrentPosition(3);
    	}
    	
    	SmartDashboard.putBoolean("Switch", sensorBase.getLimitTote());
    	System.out.println(sensorBase.getToteTriggerUltraSonic());
    	SmartDashboard.putNumber("Ultra Sonic", sensorBase.getToteTriggerUltraSonic());

    	SmartDashboard.putNumber("Ultra Sonic 2", sensorBase.getToteDistanceSonic());
    	
    }

    // runs forever!
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
