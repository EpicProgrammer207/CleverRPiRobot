package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class ApplePieRoomba extends IRobotAdapter {
	// Sonar sonar = new Sonar();

	private boolean tailLight;
	// Camera cam;

	public ApplePieRoomba(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Ello: Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		ApplePieRoomba rob = new ApplePieRoomba(base);
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

	int	infraleft = getInfraredByteLeft();
		int infraright= getInfraredByteRight();
	
System.out.println(infraleft);
System.out.println(infraright);
		// Maze
		if (infraleft==0&&infraright==0) {
			if (light[5] > 0) {
				driveDirect(-400, 400);
				Thread.sleep(100);
			} else {
				driveDirect(500, 200);
			}
			if (light[3] > 0 || light[2] > 0) {
				driveDirect(-400, -400);
				Thread.sleep(250);
				driveDirect(-400, 400);
				Thread.sleep(250);
			}
		}

		// Drag Race
		/*
		 * driveDirect(550, 550); if (light[0] > 0 && light[1] > 0) {
		 * driveDirect(200, 90); Thread.sleep(750); } else if (light[2] > 0 &&
		 * light[3] > 0) { driveDirect(200, -200); Thread.sleep(750); } else if
		 * (light[4] > 0 && light[5] > 0) { driveDirect(-200, 200);
		 * Thread.sleep(750); }
		 */
if(infraleft!=0&&infraright==0){
	driveDirect(-400,400);
	Thread.sleep(200);
	driveDirect(500,500);
}
else if(infraright!=0&&infraleft==0)	{
		driveDirect(400,-400);
		Thread.sleep(200);
		driveDirect(500,500);
	}
else if(infraright!=0&&infraleft!=0){
	driveDirect(500,500);
}
return true;
	}

	void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}