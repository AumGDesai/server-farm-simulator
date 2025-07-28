/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * RandomDispatcher.java
 * 
 * A random dispatcher of jobs
 */


import java.util.Random;

public class RandomDispatcher extends JobDispatcher {
    // declare a private field for the RandomDispatcher class
    private Random rand;

    // define the constructor for the RandomDispatcher class
    public RandomDispatcher(int servers) {
        // call the constructor of the JobDispatcher superclass
        super(servers);
        rand = new Random();
    }

    // override the pickServer method, which selects a Server for a Job at random
    @Override
    public Server pickServer(Job job) {
        // get the List of Servers from the JobDispatcher superclass
        // get a random index into the List of Servers
        int randomPick = rand.nextInt(0, servers.size());
        // return the selected Server
        return servers.get(randomPick);
    }

}

