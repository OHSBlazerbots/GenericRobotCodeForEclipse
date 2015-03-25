package org.usfirst.frc.team3807.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //PWM
    public static int FRONT_LEFT_MOTOR = 1;
    public static int FRONT_RIGHT_MOTOR = 2;
    public static int REAR_LEFT_MOTOR = 3;
    public static int REAR_RIGHT_MOTOR = 4;
    public static final int ELEVATOR1 = 10;
    public static final int ELEVATOR2 = 11;
    public static final int INTAKE_LEFT = 12;
    public static final int INTAKE_RIGHT = 13;
    public static final int CAM_PAN1 = 5;
    public static final int CAM_TILT1 = 6;
    public static final int CAM_PAN2 = 7;
    public static final int CAM_TILT2 = 9;
    
    // Joysticks
    public static final int JOYSTICK_PORT = 0;
    public static final int JOYSTICK2_PORT = 1;
	public static final int JOYSTICK3_PORT = 2;
    
    // Analog
    public static int ACCELEROMETER_PORT = -1;
    public static int GYRO_PORT = 0;
    public static int SONAR_PORT = -1; 
    
    //Digital
    public static int TOP_HALL_PORT = 0;
    public static int BOTTOM_HALL_PORT = 3;
    public static int LINEAR_ENCODER_PORT1 = 7;
    public static int LINEAR_ENCODER_PORT2 = 8;
    public static int REED1_PORT = 1;
    public static int REED2_PORT = 2;
    public static int REED3_PORT = -1;
    public static int REED4_PORT = -1;
    public static int TOTE_LIMIT_SWITCH = 4;
    public static int ULTRA_SONIC_PORT1 = 2;
    public static int ULTRA_SONIC_PORT2 = 3;
    
}
