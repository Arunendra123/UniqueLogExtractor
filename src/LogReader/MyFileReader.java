package LogReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MyFileReader 
{
	static int flags=1;
	public static void myReader(String input,String output,String pattern) 
	{	   
		    FileReader reader;
		    FileWriter writer;
		    pattern=LogExtractorViewer.t2.getText();
			try {
				writer=new FileWriter(output); 
				reader=new FileReader(input);
				BufferedReader readme =new BufferedReader(reader);
				BufferedWriter writeme =new BufferedWriter(writer);
				String line = readme.readLine();
				while (line != null)
				{
					if(LogProccessor.checkLine(pattern, line))
					{
						writeme.write(line);
						writeme.newLine();
					}
					line = readme.readLine();
				}
				readme.close();
				writeme.close();
				reader.close();
				writer.close();
				flags=1;
			}
			catch (IOException e) 
			{
				flags=0;	
				System.err.print("ERROR: File containing _______ information not found:\n");
			    e.printStackTrace();
			}	
	}

}
