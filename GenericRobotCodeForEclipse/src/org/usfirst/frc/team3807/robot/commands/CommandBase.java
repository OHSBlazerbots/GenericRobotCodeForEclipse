package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.OI;
import org.usfirst.frc.team3807.robot.RobotMap;
import org.usfirst.frc.team3807.robot.subsystems.Camera;
import org.usfirst.frc.team3807.robot.subsystems.Chassis;
import org.usfirst.frc.team3807.robot.subsystems.Network;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Chassis chassis = new Chassis(RobotMap.FRONT_LEFT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR);
    public static Network network = new Network();
    //public static Picker picker = new Picker(RobotMap.PICKER_SPIKE, RobotMap.SOLENOID_FORWARD, RobotMap.SOLENOID_BACK, RobotMap.SOLENOID2_FORWARD, RobotMap.SOLENOID2_BACK, RobotMap.COMPRESSOR_SENSOR, RobotMap.COMPRESSOR);
    //public static Shooter shooter = new Shooter(RobotMap.SHOOTER_SPIKE, RobotMap.SERVO_PORT);
    public static Camera camera = new Camera(RobotMap.CAM_PAN, RobotMap.CAM_TILT);

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
