/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.DriveCamWithJoystick;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *
 * @author blazerbots
 */
public class Camera extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Servo tilt;
    Servo pan;
    Servo pan2;
    Servo tilt2;
    
    private static AxisCamera cam;
    
    public Camera(int pan_port1, int tilt_port1, int pan_port2, int tilt_port2)
    {
    	//    	CameraServer server = CameraServer.getInstance();
    	//    	server.startAutomaticCapture("cam1");
        tilt = new Servo(tilt_port1);
        pan = new Servo(pan_port1);
        tilt2 = new Servo(tilt_port2);
        pan2 = new Servo(pan_port2);
        
        tilt.setAngle(150);
        pan.setAngle(105);
        tilt2.setAngle(90);
        pan2.setAngle(90);
        
        //cam = new AxisCamera("10.38.7.11");
        //snapShot();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCamWithJoystick());
    }
    
    public void snapShot()
    {
        try {
            cam.getImage().write("/tmp/snapShot.jpg");
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
    }
    
    

    public void driveCam1WithJoyStick(Joystick joy) {
    	//System.out.print("Driving Cam...");
        double x = RobotValues.PAN_CONSTANT * joy.getX();
        double y = RobotValues.TILT_CONSTANT * joy.getY();
        //System.out.println(" X: " + x + " Y: " + y);
        //System.out.println(RobotValues.PAN_CONSTANT);
        //System.out.println("DWJ: (" + x + "," + y + ")");
        pan.setAngle(pan.getAngle() + x);
        tilt.setAngle(tilt.getAngle() + y);
    }
    
    public void driveCam2WithJoystick(Joystick joy){
        double x = RobotValues.PAN_CONSTANT * joy.getX();
        double y = RobotValues.TILT_CONSTANT * joy.getY();
        //System.out.println(" X: " + x + " Y: " + y);
        //System.out.println(RobotValues.PAN_CONSTANT);
        //System.out.println("DWJ: (" + x + "," + y + ")");
        pan2.setAngle(pan2.getAngle() + x);
        tilt2.setAngle(tilt2.getAngle() + y);
    }
}
