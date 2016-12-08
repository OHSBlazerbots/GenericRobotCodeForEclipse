package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.DriveElevatorWithJoystick;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	Victor jaguar1, jaguar2;
	
	
	int currentPosition;

	public Elevator(int jagLeft, int jagRight) {
		jaguar1 = new Victor(jagLeft);
		jaguar2 = new Victor(jagRight);
		currentPosition = 5;
	}

	public void setElevatorSpeed(double speed) {
		if (CommandBase.sensorBase.getTopHall()
				&& CommandBase.sensorBase.getBottomHall()) {
			jaguar1.set(speed);
			jaguar2.set(speed);
		}
		//At top and going down
		else if(!CommandBase.sensorBase.getBottomHall() && speed < 0)
		{
			jaguar1.set(speed);
			jaguar2.set(speed);
		}
		//At bottom and going up
		else if(!CommandBase.sensorBase.getTopHall() && speed > 0)
		{
			jaguar1.set(speed);
			jaguar2.set(speed);
		}
		
		else{
			jaguar1.set(0);
			jaguar2.set(0);
		}

	}

	public double getElevatorSpeed() {
		return jaguar1.get();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveElevatorWithJoystick());
	}

	public void driveWithJoystick(Joystick stick) {
		this.setElevatorSpeed(stick.getY() * 1);
	}
	
	public int getCurrentPosition(){
		return this.currentPosition;
	}
	
	public void setCurrentPosition(int pos){
		this.currentPosition = pos;
	}
}
