package cucumberTest;

import java.util.Random;

//User

public class Prep extends Config {

//	Selenium sel = new Selenium();

	Random rm = new Random();
	int n = rm.nextInt(500) + 1;
	String rand;
	String rest;
	String io;
	String ii;

	StringBuffer sBuffer = new StringBuffer(15);

	public String readUserName() throws Exception {

		rest = getNewUserName() + Selenium.generateTimeStamp();
		//
		// io = getNewUserName();
		// rand = Integer.toString(n);
		// rest = io + rand;
		return rest;

	}

	public String readFirstName() throws Exception {

		// io = getFirstName();
		// rand = Integer.toString(n);
		// rest = io + rand;
		// return rest;
		rest = getFirstName() + Selenium.generateTimeStamp();

		return rest;

	}

	public String readLastName() throws Exception {

//		io = getLastName();
//		rand = Integer.toString(n);
//		rest = io + rand;
//		return rest;
		
		rest = getLastName() + Selenium.generateTimeStamp();

		return rest;

	}

	public String readEmailId() throws Exception {

//		ii = getFirstName();
//		io = getLastName();
//		rand = Integer.toString(n);
//		rest = ii + io + rand;
		rest = getFirstName() + getLastName() + Selenium.generateTimeStamp();
		sBuffer.append(rest).append("@hpe.com");
		return (sBuffer.toString());
		

	}

	public String readDeviceName() throws Exception {

//		io = getResourceName();
//		rand = Integer.toString(n);
//		rest = io + rand;
//		return rest;
		
		rest = getResourceName() + Selenium.generateTimeStamp();

		return rest;

	}
	
	public String readAppEUI() throws Exception {

		rest = getAppEUI() + Selenium.generateTimeStamp();
		return rest;
		

	}
	
	public String readMachineId() throws Exception {

		rest = getMachineId() + Selenium.generateTimeStamp();
		return rest;
		

	}
	
	

}
