package org.usfirst.frc.team1256.robot;

import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team1256.robot.commands.*;
import org.usfirst.frc.team1256.robot.triggers.JoystickTrigger;

import edu.wpi.first.wpilibj.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
//@SuppressWarnings("unused")

public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
     public final static Joystick stick = new Joystick(0);
     public final static JoystickButton button1 = new JoystickButton(stick, 1);
     public final static JoystickButton button2 = new JoystickButton(stick, 2);
     public final static JoystickButton button3 = new JoystickButton(stick, 3);
     
     public final JoystickTrigger trigger = new JoystickTrigger(stick);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
     
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
     
     OI () {
    	 button1.whenActive(new MoveForwardWithTime(3));
    	 button2.whenActive(new MoveBackwardWithTime(3));
    	 button3.whenActive(new AutoRun1());
    	 trigger.whenActive(new MoveForwardWithJoystick());
     }
}

