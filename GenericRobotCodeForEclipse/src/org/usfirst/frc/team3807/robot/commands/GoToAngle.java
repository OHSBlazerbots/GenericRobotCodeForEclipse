package org.usfirst.frc.team3807.robot.commands;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Use the gyro to position the robot at a certain angle.
 * 
 * @author blazerbots
 */
public class GoToAngle extends CommandBase {

	int angle;
	boolean finished;

	public GoToAngle(int a) {
		// We need to move
		requires(chassis);
		angle = a;
		finished = false;
	}

	protected void initialize() {

	}

	protected void execute() {

		// Get the rate of error, default of 5
		double error = 5;

		// How much we need to turn
		double turn = sensorBase.getGyroAngle() - angle;

		// Get it into the range of 0-360
		if (turn < 0) {
			turn += 360;
		}
		// One boundry
		double bound1 = angle - error;
		// Get it into the range of 0-360
		if (bound1 < 0) {
			bound1 += 360;
		}
		// Sencond boundry
		double bound2 = angle + error;
		// Get it into the range of 0-360
		if (bound2 >= 360) {
			bound2 -= 360;
		}
		// Turn value
		double tv = 0.0;

		// If bound2 is the upper bound
		if (bound1 < bound2) {
			// If we are between both bounds, stop
			if (sensorBase.getGyroAngle() < bound2
					&& sensorBase.getGyroAngle() > bound1) {
				// No turn
				tv = 0;
				// Notify chassis
				finished = true;
			} else {
				// Turn the appropriate values
				if (turn <= 180) {
					tv = .7;
				} else {
					tv = -.7;
				}
			}
		} else {
			// If we are between both bounds, stop
			if (sensorBase.getGyroAngle() < bound2
					|| sensorBase.getGyroAngle() > bound1) {
				tv = 0;
				finished = true;
			} else {
				if (turn <= 180) {
					tv = .7;
				} else {
					tv = -.7;
				}
			}
		}
		// Drive at appropriate values
		chassis.drive(tv, 0);
	}

	protected boolean isFinished() {
		// Are we done
		return finished;
	}

	protected void end() {
		chassis.drive(0, 0);
	}

	protected void interrupted() {
		chassis.drive(0, 0);
	}

}
