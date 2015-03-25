package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.DriveIntakeWithJoystick;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeMechanism extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor jaguarLeft, jaguarRight;
	
	public IntakeMechanism(int jagL, int jagR)
	{
		System.out.println("IM - con");
		jaguarLeft = new Victor(jagL);
		jaguarRight = new Victor(jagR);
	}
	
	public void setIntake(double speed)
	{
		jaguarLeft.set(-speed);
		jaguarRight.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	System.out.println("IM - iDC");
        setDefaultCommand(new DriveIntakeWithJoystick());
    }
}

