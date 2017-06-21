package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227 *Psst, its me, Dong! Roblox is ____.
 *if u are reading this, then you like roblox! :DDD
 *^^ L0OK UPP 0R UR D3D
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class CleverRobot extends IRobotAdapter {
	// Sonar sonar = new Sonar();

	private boolean tailLight;
	// Camera cam;

	public CleverRobot(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		CleverRobot rob = new CleverRobot(base);
		rob.setup();
		while (rob.loop()) {
		}
		rob.shutDown();

	}

	void setup() throws Exception {

	}

	boolean loop() throws Exception {
		readSensors(100);
		int[] light = getLightBumps();

/*		 if (light[5] > 0) { 
			 driveDirect(-301, 301); 
			 Thread.sleep(250); 
		 } 
		 else {
			 driveDirect(300, 150);
		 }
		 if (light[3] > 0 && light[2] > 0) {
			 driveDirect(-300, -300); 
			 Thread.sleep(500); 
			 driveDirect(-300, 300);
			 Thread.sleep(300);
		 }*/

		driveDirect(550, 550);
		if (light[0] > 0 && light[1] > 0) {
			driveDirect(200, 90);
			Thread.sleep(750);
		} else if (light[2] > 0 && light[3] > 0) {
			driveDirect(200, -200);
			Thread.sleep(750);
		} else if (light[4] > 0 && light[5] > 0) {
			driveDirect(-200, 200);
			Thread.sleep(750);
		} 
		return true;
	}

	void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}