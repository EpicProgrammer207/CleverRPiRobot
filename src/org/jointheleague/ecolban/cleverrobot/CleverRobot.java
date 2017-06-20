package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227 *Psst, its me, Dong! Roblox is ____.
 *if u are reading this, then you like roblox! :DDD
 *^^ 1OOK UPP 0R UR D3D
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

		driveDirect(1000, 1000);
		int[] light = getLightBumps();
		if (light[0] < 0 && light[1] < 0) {
			driveDirect(200, 90);
			Thread.sleep(600);
		} else if (light[2] < 0 && light[3] < 0) {
			driveDirect(200, -200);
		Thread.sleep(600);
		}
			else if(light[4] < 0 && light[5]<0){
		driveDirect(-200, 200);
			Thread.sleep(600);
			}
		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}