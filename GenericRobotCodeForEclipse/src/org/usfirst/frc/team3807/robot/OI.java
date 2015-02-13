package org.usfirst.frc.team3807.robot;

import org.usfirst.frc.team3807.robot.commands.DriveElevatorWithJoystick;
import org.usfirst.frc.team3807.robot.commands.GoToAnalogPoint;
import org.usfirst.frc.team3807.robot.commands.GoToPosition;
import org.usfirst.frc.team3807.robot.commands.PrintSensorValue;
import org.usfirst.frc.team3807.robot.commands.ReverseIntake;
import org.usfirst.frc.team3807.robot.commands.RumbleMaker;
import org.usfirst.frc.team3807.robot.commands.StartIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //The robot controllers
    Joystick joystick = new Joystick(RobotMap.JOYSTICK_PORT), // Driver
            joystick2 = new Joystick(RobotMap.JOYSTICK2_PORT),
            joystick3 = new Joystick(RobotMap.JOYSTICK3_PORT); //Co-Driver

    private final JoystickButton setPos0, setPos1, setPos2, setPos4, coDriverOverride, intake, reverseIntake, goToAnalog;
    /**
     *
     */
    public OI() {
    	//rumble = new JoystickButton(joystick, 1);
    	//rumble.toggleWhenPressed(new RumbleMaker());
    	
    	//getHall = new JoystickButton(joystick2, 1);
    	//getHall.toggleWhenPressed(new PrintSensorValue());
    	
    	setPos0 = new JoystickButton(joystick2, 3);
    	setPos1 = new JoystickButton(joystick2, 4);
    	setPos2 = new JoystickButton(joystick2, 5);
    	setPos4 = new JoystickButton(joystick2, 2);
    	coDriverOverride = new JoystickButton(joystick2, 1);
    	intake = new JoystickButton(joystick, 1);
    	reverseIntake = new JoystickButton(joystick, 2);
    	goToAnalog = new JoystickButton(joystick2, 9);
    	
    	setPos0.whenPressed(new GoToPosition(0));
    	setPos1.whenPressed(new GoToPosition(1));
    	setPos2.whenPressed(new GoToPosition(2));
    	setPos4.whenPressed(new GoToPosition(3));
    	coDriverOverride.whileHeld(new DriveElevatorWithJoystick());
    	intake.whileHeld(new StartIntake());
    	reverseIntake.whileHeld(new ReverseIntake());
    	goToAnalog.whileHeld(new GoToAnalogPoint());
    }

    //Returns the joystick that controls driving
    public Joystick getJoystick() {
        return joystick; //Driver
    }
    
    public Joystick getCoDriverJoystick(){
        return joystick2;
    }
    
    public Joystick getCoDriverJoystick2(){
    	return joystick3;
    }
}
