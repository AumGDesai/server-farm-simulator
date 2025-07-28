/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * LeastWorkDispatcher.java
 * 
 * A Dispatcher of jobs
 */


public class LeastWorkDispatcher extends JobDispatcher {

    // define the constructor for the LeastWorkDispatcher class, which simply calls the constructor of the superclass
    public LeastWorkDispatcher(int servers) {
        super(servers);
    }

    // define the pickServer method, which selects the Server with the least remaining processing time in its queue
    public Server pickServer(Job job) {
        // initialize a variable to keep track of the minimum remaining work found so far, and set it to a very large number initially
        
        // initialize a variable to store the Server with the least remaining work found so far, and set it to null initially
        Server serverWithLeastWork = servers.get(0);
        // iterate through the servers and update the minRemainingWork and serverWithLeastWork variables as necessary
        for (Server server : servers) {
            double remainingWork = server.remainingWorkInQueue();
            if (remainingWork < serverWithLeastWork.remainingWorkInQueue()) {
                serverWithLeastWork = server;
            }
        }
        // return the Server with the least remaining work
        return serverWithLeastWork;
    }
}
