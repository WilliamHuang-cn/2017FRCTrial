package org.usfirst.frc.team1256.robot.triggers;

import org.usfirst.frc.team1256.robot.Debug;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Trigger;
//import org.usfirst.frc.team1256.robot.OI;

/**
 *
 */
public class JoystickTrigger extends Trigger {
    
	private static final double defaultX = 0;
	private static final double defaultY = 0;
	private Joystick triggeringStick;
	
	public JoystickTrigger(Joystick stick) {
		super();
		triggeringStick = stick;
	}
	
    public boolean get() {
//    	if (OI.stick.getAxis(AxisType.kX) != defaultX && OI.stick.getAxis(AxisType.kY) != defaultY) {
    	if (Debug.ON && DriverStation.getInstance().isEnabled() && Debug.iterationCounter%25 == 0) {
    		Debug.writeLog(this, "Trigger queried: "+this);
    	}
    		return true;
//    	}
//        return false;
    }
}
