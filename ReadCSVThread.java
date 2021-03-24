package flightsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;



public class ReadCSVThread extends Thread
{
	private static final String src_dir="src/main/resources";
	private static ArrayList<String> list_of_file = new ArrayList<String>();
	
	static public ArrayList<String> getAllFiles()
	{
		 try 
		 {
	            File folder = new File(src_dir);
	            for (File file : folder.listFiles()) 
	            {
	                String name = file.getName();
	                if (!list_of_file.contains(name)) 
	                {
	                	list_of_file.add(name);
	                }
	            }
	     } 
		 catch (Exception e) 
		 {
	            e.printStackTrace();
	     }
	        return list_of_file;
	}
	
	static ArrayList<String> csv_data=new ArrayList<String>();
	static public ArrayList<String> readCSV()
	{
		if (list_of_file.size() > 0)
		{
			//create BufferedReader to read csv file
			for (int i = 0; i < list_of_file.size(); i++ )
			{
				try {					
					BufferedReader br = new BufferedReader(new FileReader(src_dir+"/"+list_of_file.get(i)));
					
					String str_line ="";
					br.readLine();
					while((str_line = br.readLine()) != null) {
						
						if (!csv_data.contains(str_line)) 
		                {
							csv_data.add(str_line);
		                }
						}
				}
				catch(Exception e)
				{
					System.out.println("Error occurs");
				}		
			}	
		}
		return csv_data;
	}
	
	public static ArrayList<String> getCSVData()
	{
		return csv_data;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			getAllFiles();
			readCSV();
			try
			{
				Thread.sleep(10000);//sleep for 10 second
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}	
}
	
	
	


