package org.zimincredit.utils;

import java.io.IOException;
import java.util.Properties;

public class UploadFile {

	public void uploadFile(String fileName){
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/data/env.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath= properties.getProperty("filePath") + fileName;
	    String executeFile= properties.getProperty("executeFile");
	    String cmd= "\""+ executeFile+ "\"" + " " + "\""+ filePath+ "\"";
	    try{
	        Process p= Runtime.getRuntime().exec(cmd);
	        p.waitFor();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
