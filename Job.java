/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * Job.java
 * 
 * Creates a job class
 */

public class Job {
    // Fields to store the arrival time and processing time of the job
    private double arrivalTime;
    private double processingTime;
    private double timeProcessed;
    private double finishTime;
    private double remainingTime = 0.0;

    // Constructor to create a new job object with the given arrival time and processing time
    public Job(double arrivalTime, double processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.timeProcessed = 0;
        this.finishTime = -1;
    }

    // Getter method to retrieve the arrival time of the job
    public double getArrivalTime() {
        return arrivalTime;
    }

    // Getter method to retrieve the total processing time of the job
    public double getTotalProcessingTime() {
        return processingTime;
    }

    // Getter method to retrieve the time spent working on this job so far
    public double getTimeProcessed() {
        return timeProcessed;
    }

    // Getter method to retrieve the necessary time remaining to spend working on this job
    public double getTimeRemaining() {
        remainingTime = processingTime - timeProcessed;
        return remainingTime;
    }

    // Returns true if this job has been run to completion
    public boolean isFinished() {
        return remainingTime == 0.0;
    }

    // Sets the time when the job completed
    public void setFinishTime(double time) {
        finishTime = time;
    }

    // Getter method to retrieve the time when the job was completed
    public double getFinishTime() {
        return finishTime;
    }

    // Returns the difference in time between the arrival and finish times of this job
    public double timeInQueue() {
        return finishTime - arrivalTime;
    }

    // Processes this job for the specified time units of time
    public void process(double time) {
        if (time >= this.getTimeRemaining()) {
            finishTime = arrivalTime + processingTime;
            remainingTime = 0.0;
        }else{
            timeProcessed += time;
            remainingTime -= time;
        }
    }

}

