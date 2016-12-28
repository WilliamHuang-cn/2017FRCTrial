package org.usfirst.frc.team1256.robot.commands;

import org.usfirst.frc.team1256.robot.Debug;
import org.usfirst.frc.team1256.robot.Robot;
import org.usfirst.frc.team1256.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick.AxisType;

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
    		Debug.writeLog(this, "Initializing Command: "+ this);
    		int axisCount = OI.stick.getAxisCount();
			Debug.writeLog(this, "Joystick has number of axis"+axisCount);
			if (axisCount >= 0){
				Debug.writeLog(this,"Joystick has x-axis at channel"+OI.stick.getAxisChannel(AxisType.kX));
			}
    		if (axisCount >= 1) {
    			Debug.writeLog(this,"Joystick has y-axis at channel"+OI.stick.getAxisChannel(AxisType.kY));
    		}
    		if (axisCount >= 2) {
    			Debug.writeLog(this,"Joystick has z-axis at channel"+OI.stick.getAxisChannel(AxisType.kZ));
    		}
    	}

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Debug.ON && (Debug.iterationCounter % 10 == 0)) {
    		int axisCount = OI.stick.getAxisCount();
    		if (axisCount >= 0){
        		Debug.writeLog(OI.stick, "X Value: "+OI.stick.getAxis(AxisType.kX));
			}
    		if (axisCount >= 1) {
        		Debug.writeLog(OI.stick, "Y Value: "+OI.stick.getAxis(AxisType.kY));
    		}
    		if (axisCount >= 2) {
        		Debug.writeLog(OI.stick, "Z Value: "+OI.stick.getAxis(AxisType.kZ));
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.leg.stop();
    	if (Debug.ON) {
    		Debug.writeLog(this, "Ending Command: "+ this);
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
