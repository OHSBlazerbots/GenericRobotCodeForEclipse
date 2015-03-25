/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team3807.robot;

import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.autonomous.Autonomous;
import org.usfirst.frc.team3807.robot.commands.autonomous.DoNothingAuto;
import org.usfirst.frc.team3807.robot.commands.autonomous.DriveForwardAuto;
import org.usfirst.frc.team3807.robot.commands.autonomous.SingleToteAuto;
import org.usfirst.frc.team3807.robot.commands.autonomous.ThreeToteAuto;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Autonomous autoCommand; // The command for autonomous
	boolean cancelAuto;
	BuiltInAccelerometer bia = new BuiltInAccelerometer();
	public static Robot robot;
	
	double velocityX, velocityY, positionX, positionY;
	long lastTime = -1;
	
	public void positionThisThing(){
		if(lastTime == -1){
			lastTime = System.nanoTime();
			return;
		}
		long time = System.nanoTime();
		double x = bia.getX();
		double y = bia.getZ();
		velocityX += x * (time - lastTime) * 1000000000;
		velocityY += y * (time - lastTime) * 1000000000;
		positionX += velocityX * (time - lastTime) * 1000000000;
		positionY += velocityY * (time - lastTime) * 1000000000;
	}
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		
		System.out.println("ROBOT!!!!!!!!!!");
		CommandBase.init();

		SmartDashboard.putBoolean("DoNothingAuto", false);
		SmartDashboard.putBoolean("DriveForwardAuto", false);
		SmartDashboard.putBoolean("SingleToteAuto", false);
		SmartDashboard.putBoolean("ThreeToteAuto", false);

		robot = this;
	}

	public void autonomousInit() {
		if (SmartDashboard.getBoolean("DoNothingAuto")) {
			autoCommand = new DoNothingAuto();
		}

		else if (SmartDashboard.getBoolean("DriveForwardAuto")) {
			autoCommand = new DriveForwardAuto();
		}

		else if (SmartDashboard.getBoolean("SingleToteAuto")) {
			autoCommand = new SingleToteAuto();
		}

		else if (SmartDashboard.getBoolean("ThreeToteAuto")) {
			autoCommand = new ThreeToteAuto();
		}

		Scheduler.getInstance().add(autoCommand);
		cancelAuto = false;
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		if (!cancelAuto) {
			Scheduler.getInstance().run();
		}
		positionThisThing();
	}

	public void cancelAuto() {
		cancelAuto = true;
		autoCommand.cancel();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		try {
			autoCommand.cancel();
		} catch (NullPointerException e) {

		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		positionThisThing();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
