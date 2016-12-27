package org.usfirst.frc.team1256.robot.commands;

import org.usfirst.frc.team1256.robot.Debug;
import org.usfirst.frc.team1256.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveForwardWithJoystick extends Command {

    public MoveForwardWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.leg);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
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
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
