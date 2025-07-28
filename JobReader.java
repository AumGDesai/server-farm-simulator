/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * JobReader.java
 * 
 * Creates a job read class that reads txt files
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class JobReader {
    
    public Queue<Job> readJobFile(String filename){
    
        try {
            // Assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
            FileReader fr = new FileReader(filename);
            // Assign to a variable of type BufferedReader a new BufferedReader, passing fr to the constructor
            BufferedReader br = new BufferedReader(fr);
            // Assign to a variable of type Queue<Job> a new LinkedList.
            Queue<Job> jobSequence = new LinkedList<Job>();
      
            // Assign to a variable of type String line the result of calling the readLine method of the BufferedReader.
            String line = br.readLine();
            // Every time we call br.readLine(), we advance to the next line of the file we are reading. 
            // Since the first line of the job files are just the headers, 
            // Let's skip the first line by calling br.readLine again: 
            line = br.readLine();
            // Start a while loop that loops while line isn't null
            while(line != null){
                // Assign to an array of type String the result of calling split on the line with the argument ","
                String[] arr = line.split(",");
                // Using this String array arr, make a new Job object and offer it into jobSequence:
                Job newJob = new Job(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
                jobSequence.offer(newJob);
                line = br.readLine();
            }
            // Call the close method of the BufferedReader:
            br.close();
            return jobSequence;
        }
        catch(FileNotFoundException ex) {
            System.out.println("JobReader.readJobFile():: unable to open file " + filename + ": file not found");
        }
        catch(IOException ex) {
            System.out.println("JobReader.readJobFile():: error reading file " + filename);
        }
  
        return null;
    }
}

