/**
 * 
 * Aum Desai
 * CS 231
 * 
 * Mar 5,2023
 * 
 * Project 4
 * ShortestQueueDispatcher.java
 * 
 * A Dispatcher of jobs
 */




public class ShortestQueueDispatcher extends JobDispatcher {
    Server shortestserver;

    // define the constructor for the ShortestQueueDispatcher class, which simply calls the constructor of the superclass
    public ShortestQueueDispatcher(int servers) {
        super(servers);
        shortestserver = null;
    }

    // define the pickServer method, which selects the Server with the shortest queue
    public Server pickServer(Job j) {
        if (servers.size() > 0){
            shortestserver = servers.get(0);

        }else{
            return null;

        }

        for(Server server : servers){
            if(server.size() < shortestserver.size()){
                shortestserver = server;
            }

        } return shortestserver;
    }
}
