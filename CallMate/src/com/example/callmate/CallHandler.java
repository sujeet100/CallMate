package com.example.callmate;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.stericson.RootTools.RootTools;
import com.stericson.RootTools.exceptions.RootDeniedException;
import com.stericson.RootTools.execution.Command;

public class CallHandler {

	public void callNumber(String number) {
		System.out.println("Calling number: "+number);
		
		if(RootTools.isRootAvailable()){
			System.out.println("Root is available");
		}
		
		if(RootTools.isAccessGiven()){
			System.out.println("Root access is given");
		}
		
		Command command = new Command(0, "echo -e \"ATD"+number+";\\r\" > /dev/smd0")
		{
		        @Override
		        public void output(int id, String line)
		        {
		        	System.out.println(id+" : "+line);		        }
		};
		
		try {
			RootTools.getShell(true).add(command).waitForFinish();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RootDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
				String command="su -c echo -e \"ATD"+number+";\\r\" > /dev/smd0";
				System.out.println("Command: "+command);

		try {
			Process process = Runtime.getRuntime().exec(command);
			
			InputStream in = process.getInputStream();

			byte[] re = new byte[1];
			String result = "";
			while (in.read(re) != -1) {
				result = result + new String(re);
			}
			System.out.println(result);
			in.close();

		} catch (IOException ex) {

			ex.printStackTrace();
		} catch (Exception e) {

		}
*/
	}

}
