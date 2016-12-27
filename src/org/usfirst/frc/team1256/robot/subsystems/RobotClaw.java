package org.usfirst.frc.team1256.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1256.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
/**
 *
 */
public class RobotClaw extends Subsystem {
    
	VictorSP clawMotor = new VictorSP(RobotMap.ClawMotor);
	Encoder clawEncoder;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void openClaw() {
		clawMotor.set(1);
	}
	
	public void closeClaw() {
		clawMotor.set(-1);
	}
	
	public void stop() {
		clawMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

