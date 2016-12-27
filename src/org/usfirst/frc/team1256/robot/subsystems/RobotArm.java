package org.usfirst.frc.team1256.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1256.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
/**
 *
 */
public class RobotArm extends Subsystem {
    
	VictorSP armMotor1 = new VictorSP(RobotMap.ArmMotor1); // Shoulder
	VictorSP armMotor2 = new VictorSP(RobotMap.ArmMotor2); // Elbow
	Encoder armEncoder1;
	Encoder armEncoder2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void forearmUp() {
		setForearm(1);
	}
	
	public void forearmDown() {
		setForearm(-1);
	}
	
	public void upperArmUp() {
		setUpperArm(1);
	}
	
	public void upperArmDown() {
		setUpperArm(-1);
	}
	
	public void stop() {
		setForearm(0);
		setUpperArm(0);
	}
	
	public void setUpperArm(double speed) {
		armMotor1.set(speed);
	}
	
	public void setForearm(double speed) {
		armMotor2.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

