package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.OI;
import org.usfirst.frc.team3807.robot.RobotMap;
import org.usfirst.frc.team3807.robot.subsystems.Camera;
import org.usfirst.frc.team3807.robot.subsystems.Chassis;
import org.usfirst.frc.team3807.robot.subsystems.Elevator;
import org.usfirst.frc.team3807.robot.subsystems.IntakeMechanism;
import org.usfirst.frc.team3807.robot.subsystems.Network;
import org.usfirst.frc.team3807.robot.subsystems.SensorBase;

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
    public static Chassis chassis = new Chassis(RobotMap.FRONT_LEFT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR, RobotMap.REAR_LEFT_MOTOR, RobotMap.REAR_RIGHT_MOTOR);
    //public static Network network = new Network();
    public static Camera camera = new Camera(RobotMap.CAM_PAN1, RobotMap.CAM_TILT1, RobotMap.CAM_PAN2, RobotMap.CAM_TILT2);
    public static SensorBase sensorBase = new SensorBase(RobotMap.TOP_HALL_PORT,RobotMap.BOTTOM_HALL_PORT,RobotMap.REED1_PORT,RobotMap.REED2_PORT,RobotMap.LINEAR_ENCODER_PORT1, RobotMap.LINEAR_ENCODER_PORT2, RobotMap.TOTE_LIMIT_SWITCH,RobotMap.GYRO_PORT,RobotMap.ULTRA_SONIC_PORT1,RobotMap.ULTRA_SONIC_PORT2);
    public static Elevator elevator = new Elevator(RobotMap.ELEVATOR1, RobotMap.ELEVATOR2);
    public static IntakeMechanism intake = new IntakeMechanism(RobotMap.INTAKE_LEFT,RobotMap.INTAKE_RIGHT);

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
