package Get_properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

public class Get_property {


	public String credentials() {
		
			File file = new File(System.getProperty("user.dir")+"\\properties\\file.properties");
			
			FileInputStream fileInput = null;
			
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			}
			Properties prop = new Properties();
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}

					String user = prop.getProperty("username");
					String password = prop.getProperty("password");
					String browser = prop.getProperty("browser");
					String url = prop.getProperty("url");
					String name = prop.getProperty("name");
					String phone = prop.getProperty("phone");
					String email = prop.getProperty("email");
					String country = prop.getProperty("country");
					String city = prop.getProperty("city");
					String all_info=browser+","+url+","+name+","+phone+","+email+","+country+","+city+","+user+","+password;
				
			return all_info;
				
				
			}
	
}