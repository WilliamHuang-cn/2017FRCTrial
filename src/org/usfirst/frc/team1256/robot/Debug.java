package org.usfirst.frc.team1256.robot;

import edu.wpi.first.wpilibj.Timer;

public final class Debug {
	public final static boolean ON = false;
	public static long iterationCounter; 
	
	public static void writeLog(Object sender,String message) {
		System.out.println("["+Timer.getFPGATimestamp()+"]"+sender+"("+sender.getClass()+"): "+message);
	}
}
