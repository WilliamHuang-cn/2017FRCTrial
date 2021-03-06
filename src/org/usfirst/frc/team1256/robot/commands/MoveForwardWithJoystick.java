package org.usfirst.frc.team1256.robot.commands;

import org.usfirst.frc.team1256.robot.Debug;
import org.usfirst.frc.team1256.robot.Robot;
import org.usfirst.frc.team1256.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 *@warning 
 */
public class MoveForwardWithJoystick extends Command {

    public MoveForwardWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.leg);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if (Debug.ON) {
    		Debug.writeLog(this, "Initializing Command: "+ this);
    		/*
    		int axisCount = OI.stick.getAxisCount();
			Debug.writeLog(this, "Joystick has number of axis"+axisCount);
			if (axisCount > 0){
				Debug.writeLog(this,"Joystick has x-axis at channel"+OI.stick.getAxisChannel(AxisType.kX));
			}
    		if (axisCount > 1) {
    			Debug.writeLog(this,"Joystick has y-axis at channel"+OI.stick.getAxisChannel(AxisType.kY));
    		}
    		if (axisCount > 2) {
    			Debug.writeLog(this,"Joystick has z-axis at channel"+OI.stick.getAxisChannel(AxisType.kZ));
    		}
    		*/
    	}
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	if (Debug.ON && (Debug.iterationCounter % 25 == 0)) {
    		Debug.writeLog(this, "Executing command: "+this);
    		/*
    		int axisCount = OI.stick.getAxisCount();
    		if (axisCount > 0){
        		Debug.writeLog(OI.stick, "X Value: "+OI.stick.getAxis(AxisType.kX));
			}
    		if (axisCount > 1) {
        		Debug.writeLog(OI.stick, "Y Value: "+OI.stick.getAxis(AxisType.kY));
    		}
    		if (axisCount > 2) {
        		Debug.writeLog(OI.stick, "Z Value: "+OI.stick.getAxis(AxisType.kZ));
    		}
    		*/
    	}
    	
    	
    	double xValue = OI.stick.getAxis(AxisType.kX);
    	double yValue = OI.stick.getAxis(AxisType.kY);
    	
    	Robot.leg.setLeftSpeed((-yValue+xValue >1  ? 1 : -yValue+xValue) <-1 ? -1 : -yValue+xValue);
    	Robot.leg.setRightSpeed((-yValue-xValue > 1 ? 1 : -yValue-xValue) <-1 ? -1 : -yValue-xValue);
    	/*
    	if (Debug.ON && (Debug.iterationCounter % 50 == 0)) {
        	Debug.writeLog(this, "Left leg speed: "+Robot.leg.getLeftSpeed());
        	Debug.writeLog(this, "Right leg speed: "+Robot.leg.getRightSpeed());
    	}
    	*/
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
    	if (Debug.ON) {
    		Debug.writeLog(this, "Command interrupted: "+ this);
    	}
    	end();
    }
}
