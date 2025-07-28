/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * Server.java
 * 
 * Creates a server class
 */

// import the necessary libraries
import java.util.LinkedList;
import java.util.Queue;

// define the Server class
public class Server {

    // declare private fields for the Server class
    Queue<Job> jobQueue;
    private double systemTime;
    double remainingWork;

    // define the constructor for the Server class
    public Server() {
        // initialize the jobQueue to be a new LinkedList of Jobs
        jobQueue = new LinkedList<>();
        // initialize the systemTime to 0
        systemTime = 0;
        remainingWork = 0;
    }

    // define the addJob method, which adds a Job to the jobQueue
    public void addJob(Job job) {
        // add the Job to the jobQueue
        jobQueue.offer(job);
        remainingWork += job.getTotalProcessingTime();
    }

    // define the processTo method, which advances the system time to the specified time
    public void processTo(double time) {

        double myTimeRemaining = time - systemTime;
        // process jobs in the jobQueue until it is empty or the first job has an arrival time after the specified time
        while (!jobQueue.isEmpty() && systemTime < time) {
            Job next = jobQueue.peek();

            // check if there is enough time to finish the job
            if (myTimeRemaining >= next.getTimeRemaining()){
                double processTime = next.getTimeRemaining(); // calculate the time needed to finish the job
                next.process(next.getTimeRemaining()); // process the job for the calculated time
                remainingWork -= processTime; // update the remaining work
                myTimeRemaining -= processTime; // decrease the remaining time
                systemTime += processTime; // update the system time
                next.setFinishTime(systemTime); // set the finish time to the current system time
                jobQueue.poll(); // remove the job from the queue since it is finished
            } else{ // if there is not enough time to finish the job
                next.process(myTimeRemaining); // process the job for the remaining time
                remainingWork -= myTimeRemaining; // update the remaining work
                systemTime += myTimeRemaining; // update the system time
                myTimeRemaining = 0.0; // set remaining time to 0 since there is no time left to finish the job
            }

        } 
        // update the system time to the specified time
        systemTime = time;
    }

    // define the remainingWorkInQueue method, which calculates the total remaining processing time in the jobQueue
    public double remainingWorkInQueue() {
        return remainingWork;
    }

    // define the size method, which returns the number of Jobs in the jobQueue
    public int size() {
        // return the size of the jobQueue
        return jobQueue.size();
    }
}

