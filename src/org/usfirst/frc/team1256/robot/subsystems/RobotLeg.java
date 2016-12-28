package org.usfirst.frc.team1256.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1256.robot.*;
import org.usfirst.frc.team1256.robot.commands.MoveForwardWithJoystick;

import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class RobotLeg extends Subsystem {
    
//	VictorSP leftMotor = new VictorSP(RobotMap.leftMotor);
//	VictorSP rightMotor = new VictorSP(RobotMap.rightMotor);
	Servo leftMotor = new Servo(RobotMap.leftMotor);
	Servo rightMotor = new Servo(RobotMap.rightMotor);
	Encoder leftEncoder;
	Encoder rightEncoder;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void leftForward() {
		setLeftSpeed(1);
	}
	
	public void rightForward() {
		setRightSpeed(1);
	}
	
	public void leftBackward() {
		setLeftSpeed(-1);
	}
	
	public void rightBackward() {
		setRightSpeed(-1);
	}
	
	public void stop() {
		setLeftSpeed(0);
		setRightSpeed(0);
	}
	
	public void setLeftSpeed(double speed) {
//		leftMotor.set(speed);
		leftMotor.setAngle(leftMotor.getAngle()+3.6*speed);
//		System.out.println(leftMotor.getAngle());
	}
	
	public void setRightSpeed(double speed) {
//		rightMotor.set(speed);
		rightMotor.set(rightMotor.get()+3.6*speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new MoveForwardWithJoystick());
    }
}

