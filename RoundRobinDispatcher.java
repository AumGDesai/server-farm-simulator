/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * RoundRobinDispatcher.java
 * 
 * A round robin dispatcher of jobs
 */


public class RoundRobinDispatcher extends JobDispatcher {
    // declare a private field for the RoundRobinDispatcher class
    private int nextServerIndex;

    // define the constructor for the RoundRobinDispatcher class
    public RoundRobinDispatcher(int servers) {
        // call the constructor of the JobDispatcher superclass
        super(servers);
        // initialize the nextServerIndex to 0
        nextServerIndex = 0;
    }

    // override the pickServer method, which selects a Server for a Job using a round-robin process
    @Override
    public Server pickServer(Job job) {
       if(nextServerIndex == servers.size()){
        nextServerIndex = 0;
       } return servers.get(nextServerIndex++);
    }
}
