/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * JobDispatcher.java
 * 
 * An abstract class that manages a collection of Servers and tracks the system time.
 */


import java.util.LinkedList;
import java.util.Queue;

public abstract class JobDispatcher {

    // declare fields for the JobDispatcher class
    protected LinkedList<Server> servers;
    protected double systemTime;
    LinkedList<Job> jobList;

    // define the constructor for the JobDispatcher class
    public JobDispatcher(int servers2) {
        // initialize the servers list to be a new LinkedList of Servers with size k
        servers = new LinkedList<>();
        jobList = new LinkedList<>();
        for (int i = 0; i < servers2; i++) {
            servers.offer(new Server());
        }
        // initialize the systemTime to 0
        systemTime = 0;
    }

    // define the advanceTimeTo method, which updates the current time to the specified time and calls the processTo method for each Server
    public void advanceTimeTo(double time) {
        // iterate through the servers and call processTo for each one, with the specified time
        for (Server server : servers) {
            server.processTo(time);
        }
        // update the systemTime to the specified time
        systemTime = time;
    }

    // define the finishUp method, which advances the time to the earliest point when all jobs will have completed
    public void finishUp() {
        // initialize a variable to store the time when all jobs will have completed, and set it to a very large number initially
        double timeAllJobsDone = Double.NEGATIVE_INFINITY;
        // iterate through the servers and update the timeAllJobsDone variable to be the minimum of the current timeAllJobsDone and the finish time of the next job in the server's jobQueue
        for (Server server : servers) {
            if (server.remainingWorkInQueue() > timeAllJobsDone) {
                timeAllJobsDone = server.remainingWorkInQueue();
            }
        }
        // call advanceTimeTo with the timeAllJobsDone variable to update the systemTime
        advanceTimeTo(timeAllJobsDone + systemTime);
    }

    // define the handleJob method, which advances the time to job's arrival time, picks the Server appropriate for job, and adds job to the chosen Server
    public void handleJob(Job job) {
        // advance the system time to the job's arrival time
        advanceTimeTo(job.getArrivalTime());
        // pick the appropriate server for the job using the pickServer method, and add the job to that server
        Server appropriateServer = pickServer(job);
        appropriateServer.addJob(job);
    }

    // define the handleJobs method, which polls each Job from the specified queue of Jobs and calls handleJob on them. After all the Jobs have been handled, calls finishUp()
    public void handleJobs(Queue<Job> jobs) {
        // iterate through the Jobs in the specified queue and call handleJob on each one
        while (!jobs.isEmpty()) {
            Job currentJob = jobs.poll();
            jobList.addFirst(currentJob);
            handleJob(currentJob);
        }
        // call finishUp after all the Jobs have been handled
        finishUp();
    }


    // define the abstract pickServer method, which selects the appropriate Server for a given Job based on the specific algorithm we're implementing
    public abstract Server pickServer(Job j);
}
