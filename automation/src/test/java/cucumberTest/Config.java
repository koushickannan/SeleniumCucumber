package cucumberTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	Properties p = new Properties();
	FileInputStream fi;
	
	public String getUserName() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("UserName");

	} 
	
	public String getBaseUrl() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("baseUrl");

	} 
	
	public String getPassword() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("Password");

	} 
	
	public String getEmail() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("Email");

	} 
	
	public String getPhoneNumber() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("Phone");

	} 
	
	public String getTenant() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("Tenant");

	} 
	
	public String getRoles() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("Role");

	} 
	
	public String getNewUserName() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("NewUserName");

	} 
	
	public String getNewPassword() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("NewPassword");

	} 
	
	public String getNewConfirmPassword() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("NewConfirmPassword");

	} 
	
	public String getFirstName() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("FirstName");

	} 
	
	public String getLastName() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("LastName");

	} 
	
	public String getPartnerManagement() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("PartnerManagement");

	} 
	
	public String getBrowserName() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("BrowserName");

	} 
	
	public String getResourceName() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("deviceName");

	} 
	
	public String getResourceType() throws IOException{

		fi= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(fi);
		return p.getProperty("resourceType");

	} 


}
