package org.usfirst.frc.team1256.robot.commands;

import org.usfirst.frc.team1256.robot.Debug;
import org.usfirst.frc.team1256.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenClaw extends Command {
	
	double startTime;
	double setTime = 2;

    public OpenClaw() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    	Robot.claw.openClaw();
    	if (Debug.ON) {
    		Debug.writeLog(this, "Initializing Command: "+ this);
    	}

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (Timer.getFPGATimestamp() - startTime > setTime) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.claw.stop();
    	if (Debug.ON) {
    		Debug.writeLog(this, "Ending Command: "+ this);
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
