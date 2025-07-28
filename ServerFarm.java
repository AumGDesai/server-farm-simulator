/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * ServerFarm.java
 * 
 * Creates a job class
 */



// This is the declaration of the ServerFarm class, which is the entry point for the program.
public class ServerFarm {
    // This is the main method of the ServerFarm class.
    public static void main(String[] args){

        // Initialize totalTimeInQueue to 0.
        double totalTimeInQueue = 0;

        // Create a new instance of the JobReader class.
        JobReader jobReader = new JobReader();

        // Create a new instance of the RandomDispatcher class with a queue size of 30.
        JobDispatcher dispatcher = new LeastWorkDispatcher(19);

        // Call the handleJobs method of the dispatcher object, passing in the job list read from the job file.
        dispatcher.handleJobs(jobReader.readJobFile("JobSequence_10_100.txt"));

        // Loop through each job in the dispatcher's job list and add its time in queue to totalTimeInQueue.
        for(Job job : dispatcher.jobList){
            totalTimeInQueue += job.timeInQueue();
        }

        // Print out the total time in queue.
        System.out.println(totalTimeInQueue);

        // Print out the number of jobs in the dispatcher's job list.
        System.out.println(dispatcher.jobList.size());

        // Calculate the average job arrival time by dividing totalTimeInQueue by the number of jobs in the dispatcher's job list.
        double averageJobArrival = totalTimeInQueue / dispatcher.jobList.size();

        // Print out the average waiting time for a job.
        System.out.println("Average Waiting Time For A Job Is: " + averageJobArrival);
  
    }
}


