package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.FindElevator;
import org.usfirst.frc.team3807.robot.commands.SendSensorValues;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorBase extends Subsystem {
	
	
	BuiltInAccelerometer builtInAccelerometer; //accelerometer built into the RoboRIO
	
	DigitalInput limitLeft, limitRight, topHall, bottomHall, reed1, reed2, limitTote;
	//topHall and bottomHall are sensors at the upper and lower limits of the elevator
	//reed1 and reed2 are reed sensors spaced appropriately between top and bottom hall sensors
	//limitTote is a "button" that is pressed if a tote is fully loaded and ready to be lifted
	
	AnalogInput toteTriggerSonic, toteDistanceSonic;
	//toteTriggerSonic is an ultra sonic sensor for detecting if a tote is loaded
	//toteDistanceSonic is an ultra sonic sensor for detecting the distance away from a tote (ex) slower speed when closer to robot
	
	Encoder linearEncoder, rotaryEncoder;
	//detect length or position using magnetic strips
	
	Gyro gyro;
	//determines angle
    
	
	public SensorBase(int topHallPort, int bottomHallPort, int reed1Port, int reed2Port, int linearEncoderPort1, int linearEncoderPort2, int toteLimitPort, int gyroPort, int ultraSonicPort, int toteDistanceSonicPort)
	{
		builtInAccelerometer = new BuiltInAccelerometer();
		//limitLeft = new DigitalInput(leftLimitPort);
		//limitRight = new DigitalInput(rightLimitPort);
		topHall = new DigitalInput(topHallPort);
		bottomHall = new DigitalInput(bottomHallPort);
		reed1 = new DigitalInput(reed1Port);
		reed2 = new DigitalInput(reed2Port);
		limitTote = new DigitalInput(toteLimitPort);
		//4142/104
		linearEncoder = new Encoder(linearEncoderPort1, linearEncoderPort2);
		//linearEncoder.setDistancePerPulse(4/(4142.0/104) / .0393); //Millimeters
		//rotaryEncoder = new Encoder(rotaryEncoderA, rotaryEncoderB);
		//rotaryEncoder.setDistancePerPulse(.00277777778);
		
		toteTriggerSonic = new AnalogInput(ultraSonicPort);
		toteDistanceSonic = new AnalogInput(toteDistanceSonicPort);
		gyro = new Gyro(gyroPort);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new FindElevator());
    }
    
    public boolean getLimitTote() {
		return limitTote.get();
	}
    
    //returns ~52 at the closest distance
    public double getToteTriggerUltraSonic()
    {
    	return toteTriggerSonic.getValue();
    }
    
    //return ~52 at the closest distance
    public double getToteDistanceSonic(){
    	return this.toteDistanceSonic.getValue();
    }
    
    public double getInternalAccelerometerX(){
    	return builtInAccelerometer.getX();
    }
    
    public double getInternalAccelerometerY(){
    	return builtInAccelerometer.getY();
    }
    
    //converts and returns value to inches
    public double getLinearEncoderDistance(){
    	return linearEncoder.getDistance() / 247.3636364;
    }
    
    public double getRotaryEncoderDistance(){
    	return rotaryEncoder.getDistance();
    }
    
    public boolean getLimitLeft()
    {
      return limitLeft.get();	
    }
    
    public boolean getLimitRight()
    {
      return limitRight.get();	
    }
    
    //returns true normally
    public boolean getTopHall()
    {
      return topHall.get();
    }
    
  //returns true normally
    public boolean getBottomHall()
    {
      return bottomHall.get();
    }
    
  //returns true normally
    public boolean getReed1()
    {
      return reed1.get();
    }
    
  //returns true normally
    public boolean getReed2()
    {
      return reed2.get();
    }
    
    public double getAngle(){
    	return gyro.getAngle();
    }
    
  //Converts the raw gyro angle to degrees and returns it
    public double getGyroAngle() {
        double angle = gyro.getAngle() % (360);
        if (angle < 0.0) {
            angle += 360;
        }
        return angle;
    }
    
    public double getGryoRate(){
    	return gyro.getRate();
    }
}

