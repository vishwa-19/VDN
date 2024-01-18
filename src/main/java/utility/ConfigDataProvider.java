package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.markuputils.ExtentColor;

public class ConfigDataProvider extends BaseClass {

	Properties pro;
	String env = "";
	public ConfigDataProvider() throws Exception {

		String path = System.getProperty("user.dir") + "\\Config\\Config.Properties";

		FileInputStream fis = new FileInputStream(path);
		pro = new Properties();
		pro.load(fis);

	}
	public void uploadParticularFile() throws IOException {
		String path = System.getProperty("user.dir") + "\\Config\\Config.Properties";

//		FileInputStream fis = new FileInputStream(path);
//		pro = new Properties();
//		pro.load(fis);
	}

	public String get_Env() {
		
		env= pro.getProperty("Env");
		String url="";	
		
		if(env.equalsIgnoreCase("PreProd")) {
			
		url= config.get_PreProd_app_url();
			
		}
		else if(env.equalsIgnoreCase("Prod")) {
			
			url=config.get_Prod_app_url();
		}
		return url;	
		
		
	 
	}
	
	
public String get_Env_Sourcing() {
		
		env= pro.getProperty("Env");
		String url="";	
		
		if(env.equalsIgnoreCase("PreProd")) {
			
		url= config.get_PreProd_app_url();
			
		}
		else if(env.equalsIgnoreCase("Prod")) {
			
			url=config.get_Prod_app_url();
		}
		return url;	
		
	 
	}

public String get_Env_Contribute() {
	
	env= pro.getProperty("Env");
	String url="";	
	
	if(env.equalsIgnoreCase("PreProd")) {
		
	url= config.get_PreProd_app_url();
		
	}
	else if(env.equalsIgnoreCase("Prod")) {
		
		url=config.get_Prod_app_url();
	}
	return url;	
	
 
}

	public String get_PreProd_app_url() {

		return pro.getProperty("PreProd_app_url");

	}

	public String get_Prod_app_url() {

		return pro.getProperty("Prod_app_url");

	}

	public String get_PreProd_test_data() {

		return pro.getProperty("PreProd_test_data");
	}

	public String get_Prod_test_data() {

		return pro.getProperty("Prod_test_data");
	}
	
	public String get_yopmail_test_data() {

		return pro.getProperty("fakeEmailGenerator");
	}

	
	 public void validateDropdownOptions() {
	        Properties properties = new Properties();
	        try {
	            FileInputStream file = new FileInputStream("config.properties");
	            properties.load(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        String AndamanAndNicobarIslands = properties.getProperty("Andaman & Nicobar Islands");
	        String option2 = properties.getProperty("option2");
	        String option3 = properties.getProperty("option3");
	
	      
	 }
	 
	 public String get_Org() {
			
			env= pro.getProperty("Org");
			String org="";	
			
			if(env.equalsIgnoreCase("PreProd")) {
				
			org= config.get_Org();
				
			}
			else if(env.equalsIgnoreCase("Prod")) {
				
				org= config.get_Org();
			}
			System.out.print(org);
			return org;	
			
		}
		
	
}


