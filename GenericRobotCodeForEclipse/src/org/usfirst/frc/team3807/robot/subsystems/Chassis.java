package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Deals with drive train and sensor assets.
 *
 * @author sgoldman
 */
public class Chassis extends Subsystem {

    //Our drive code
    public static RobotDrive drive;
    public boolean followingFrisbee;
    private double lastAngle;

    /**
     * Create an instance of the chassis class with the appropriate motors.
     * motors
     *
     * @param frontLeftMotor
     * @param rearLeftMotor
     * @param frontRightMotor
     * @param rearRightMotor
     */
    public Chassis(int frontLeftMotor, int frontRightMotor, int rearLeftMotor, int rearRightMotor) {
        //Create new robot drive class with pin values for the two motors
        if (frontLeftMotor != -1 && frontRightMotor != -1 && rearLeftMotor != -1 && rearRightMotor != -1) {
            drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
            //Disables safety so we can drive
            drive.setSafetyEnabled(false);
        } else {
            //System.out.println("FAILURE: Chassis not created due to port value as -1.");
        }
        this.followingFrisbee = false;
    }

    /**
     * Create an instance of the chassis class with the appropriate motors.
     * motors
     *
     * @param frontLeftMotor
     * @param rearLeftMotor
     */
    public Chassis(int leftMotor, int rightMotor) {
    	//System.out.println("Construct Chassis");
        //Create new robot drive class with pin values for the two motors
        if (leftMotor != -1 && rightMotor != -1) {
            drive = new RobotDrive(leftMotor, rightMotor);
            //Disables safety so we can drive
            drive.setSafetyEnabled(false);
        } else {
            //System.out.println("FAILURE: Chassis not created due to port value as -1.");
        }
        this.followingFrisbee = false;
        lastAngle = CommandBase.sensorBase.getAngle();
    }

    /**
     * Starts drive with joystick as the default command l
     */
    protected void initDefaultCommand() {
        //Starts driving the robot with this non terminating command
    	//System.out.println("iDC");
        setDefaultCommand(new DriveWithJoystick());
    }

    /**
     * Command the chassis to drive with the joystick.
     *
     * @param joystick
     */
    public void driveWithJoyStick(Joystick joystick) {
        
        double turn = joystick.getZ();
        //Drive is the y
        double move = joystick.getY();
        if (drive != null) {
            drive(-move, -turn);
        }
    }

    public void drive(double move, double turn) {
    	//System.out.println(move + " : " + turn);
        drive.arcadeDrive(move * .5, turn * .5);
    }

    public boolean isFollowingFrisbee() {
        return followingFrisbee;
    }

    public void setFollowingFrisbee(boolean followingFrisbee) {
        this.followingFrisbee = followingFrisbee;
    }
}
