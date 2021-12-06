package com.AutoHero.Assignment.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Utils {
	
	public static void zoomOut() throws Exception {
		 Robot robot = new Robot();
		  
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_MINUS);
		
		  robot.keyRelease(KeyEvent.VK_MINUS);
		  
		  robot.keyPress(KeyEvent.VK_MINUS);
		 // robot.keyRelease(KeyEvent.VK_CONTROL); 
		  robot.keyRelease(KeyEvent.VK_MINUS);
		 // robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_MINUS);
		  //robot.keyRelease(KeyEvent.VK_CONTROL); 
		  robot.keyRelease(KeyEvent.VK_MINUS);
	}

}
