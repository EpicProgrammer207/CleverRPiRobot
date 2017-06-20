package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227 *Psst, its me, Dong! Roblox is ____.
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

	private void setup() throws Exception {

	}

	private boolean loop() throws Exception {
		readSensors(100);

		int[] light = getLightBumps();

		if (light[5] > 0) {
			driveDirect(-301, 301);
			Thread.sleep(250);
		} else {
			driveDirect(300, 150);
		}
		if (light[3] > 0 && light[2] > 0) {
			driveDirect(-300, -300);
			Thread.sleep(500);
			driveDirect(-300, 300);
			Thread.sleep(300);
		}
		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}
