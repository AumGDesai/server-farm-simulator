# Java Server Farm Simulation

This project simulates a **server farm** that processes incoming jobs using various **dispatching strategies**. It showcases the use of custom data structures like queues and linked lists to model load balancing and job distribution among multiple servers.

## Features

- Models servers, jobs, and queues
- Multiple dispatcher strategies:
  - `RoundRobinDispatcher`
  - `RandomDispatcher`
  - `ShortestQueueDispatcher`
  - `LeastWorkDispatcher`
- Object-oriented design using inheritance and polymorphism
- Custom implementations of:
  - `LinkedList`
  - `Queue`
