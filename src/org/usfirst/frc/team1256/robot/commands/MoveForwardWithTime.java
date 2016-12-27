package org.usfirst.frc.team1256.robot.commands;

import org.usfirst.frc.team1256.robot.Debug;
import org.usfirst.frc.team1256.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.internal.HardwareTimer;

/**
 *
 */
public class MoveForwardWithTime extends Command {

	double startTime;
	double setTime;
	
    public MoveForwardWithTime(double setSeconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.leg);
    	setTime = setSeconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    	
    	Robot.leg.leftForward();
    	Robot.leg.rightForward();
       	if (Debug.ON) {
    		Debug.writeLog(this, "Running Command: "+ this);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (Timer.getFPGATimestamp()-startTime >= setTime) {
    		return true;
    	}
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
