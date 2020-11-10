import java.io.*;
//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
import java.util.*;
//import java.util.Scanner;

public class naive
{
	public static void main(String[] args)
	{ 
		Vector<Character> list = new Vector<Character>();

		File f = new File("pi.txt");
			try
		{
			list=readLines(f);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("\n\t       Naive Algorithum\n");
		String fileName="results.txt";
		    	String d = new String();
		    	//input string want to search
		    	Scanner su = new Scanner(System.in);
				System.out.println("Enter your string: ");
				d = su.nextLine();

				try
				{    
		           BufferedWriter results=new BufferedWriter(new FileWriter(fileName,true));
		           results.write("\n\t       Naive Algorithum");
		           results.write("\nSearch results of : "+d+"\n");
		           results.close();    
		        }
		        catch(Exception e1)
		        {	
		        	System.out.println(e1);
		        }   

				int searchStringCount = 0;
				for (int q  = 0; q < d.length(); q++) {
					searchStringCount++;
				}
				
				//get numbers of vector elements
				int y;
				int countNaiveMatching = 0;
				y = list.size();
                
                for (int h = 0; h < y-searchStringCount; h++) {
                	int r = 0;
                	while(r < searchStringCount &&  list.get( h + r ) == d.charAt(r) ) {
                		r++;
                	}
                	if(r == searchStringCount) {
                		countNaiveMatching++;
                		System.out.println("Matching substring found, starting at :"+h);
                		try
			        	{ 
	   
			            	BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true)); 
			            	out.write("Matching substring found, starting at : "+h+"\n"); 
			            	out.close(); 
			        	} 
			        	catch(IOException e2)
			        	{	 
			            	System.out.println("exception occoured" + e2); 
			        	}
                	}	
                }
                System.out.println("Numbers of matching pattern: "+countNaiveMatching);
	}
	
	public static Vector readLines(File f) throws IOException
	{
		Vector<Character> vectorlist = new Vector<Character>();
		try
		{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int numberOfLines = 0;
			int n,i,k;
			int charCount = 0;
		
			while((line = br.readLine()) != null)
			{
				numberOfLines++;
				n = numberOfLines;
				if (n >= 22)
				{
					if (!line.isEmpty())
					{
						char[] sChars = line.toCharArray();
						
						for(int l = 0; l < 54; l++)
						{
							if(sChars[l] != ' ')
							{
								vectorlist.add(sChars[l]); 
								charCount += line.length();
							    charCount = 0;
							} 	
						}		
					}			
				}	
			}
			br.close();
			fr.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return vectorlist;
	}
}