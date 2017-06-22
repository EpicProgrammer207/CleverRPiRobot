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
		System.out.println("HELLO: Try event listner, rev Monday 2030");
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
		int current = getCurrent();
		System.out.println(current);
		int[] light = getLightBumps();
		// Maze/goldrush Code VV
		int infra = getInfraredByte();
		System.out.println(infra);

		if (infra == 244 || infra == 246) {
			driveDirect(200, 175);
		} else if (infra == 248 || infra == 250) {
			driveDirect(175, 200);
		} else if (infra == 252 || infra == 254) {
			driveDirect(300, 300);
		}
		if (light[5] > 0) {
			driveDirect(-400, 400);
			Thread.sleep(160);
		} else {
			driveDirect(500, 350);
		}
		if (light[3] > 0 && light[2] > 0) {
			driveDirect(-500, -500);
			Thread.sleep(500);
			driveDirect(-500, 500);
			Thread.sleep(500);
		}
		if (isBumpLeft() || isBumpRight()) {
			driveDirect(-500, -500);
			Thread.sleep(500);
		}

		// Drag Race Code VV
		/* driveDirect(550, 550);
		if (light[0] > 0 && light[1] > 0) {
			driveDirect(200, 90);
			Thread.sleep(750);
		} else if (light[2] > 0 && light[3] > 0) {
			driveDirect(200, -200);
			Thread.sleep(750);
		} else if (light[4] > 0 && light[5] > 0) {
			driveDirect(-200, 200);
			Thread.sleep(750);
		}*/
		return true;
	}

	void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}