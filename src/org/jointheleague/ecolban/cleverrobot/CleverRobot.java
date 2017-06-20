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
	Sonar sonar = new Sonar();
<<<<<<< HEAD
=======
	private boolean tailLight;
	Camera cam;
>>>>>>> jointheleague/master

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
<<<<<<< HEAD
//		for (int i = 0; i < 4; i++) {
//			driveDirect(1000, 1000);
//			Thread.sleep(1000);
//			driveDirect(1000, -1000);
//			Thread.sleep(377);
//		}
		// driveDirect(1000, 1000);
		// Thread.sleep(1000);
		// driveDirect(100, -150);
		// Thread.sleep(1000);
		// driveDirect(100, 100);
		// Thread.sleep(1000);
		/// driveDirect(100, -150);
		// Thread.sleep(1000);
		// driveDirect(100, 100);
		// Thread.sleep(1000);
		// driveDirect(100, -150);
		// Thread.sleep(1000);
		 driveDirect(120, 120);
		 Thread.sleep(1000);
		
		
		 } 

	private boolean loop() throws Exception {
		 if(isLightBump()){
				isBumpLeft();
					 Thread.sleep(666);
					driveDirect(155,155);
					 }
=======
		driveDirect(100, 100);
		/*
		 * Example Camera Code cam = new Camera(100,100); cam.takeRGBPicture();
		 * System.out.println(cam.getRedPercentage(15,true)); System.out.println(cam.getBluePercentage(15,false));
		 * System.out.println(cam.getGreenPercentage(15,false));
		 */
	}

	private boolean loop() throws Exception {
		System.out.println("LEFT SONAR: " + sonar.readSonar("left"));
		Thread.sleep(1000);
		// setTailLight(tailLight = !tailLight);
		System.out.println("RIGHT SONAR: " + sonar.readSonar("right"));
		System.out.println("CENTER SONAR: " + sonar.readSonar("center"));

>>>>>>> jointheleague/master
		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}
