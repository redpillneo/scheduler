/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiQueueFinal;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class AskQueue {
    public void askQueue() {
        Scanner scanner = new Scanner(System.in);

        QueueSystem system = new QueueSystem();

        System.out.println("Enter the number of queues:");
        int numberOfQueues = scanner.nextInt();
        scanner.nextLine();

        System.out.println("1 - FCFS");
        System.out.println("2 - SJF");
        System.out.println("3 - SJRF");
        System.out.println("4 - Nonpreemptive Priority Scheduling");
        System.out.println("5 - Preemptive Priority Scheduling");
        System.out.println("6 - Round Robin");
        
        for (int i = 1; i < numberOfQueues+1; i++) {
            System.out.println("INPUTTING FOR QUEUE AT INDEX: " +i);
            
            System.out.println("Enter Algorithm for queue " + i + ":");
            int algorithm = scanner.nextInt();
            
            int allocatedTime = 0;
            switch (i) {
                case 1 -> allocatedTime = 5;
                case 2 -> allocatedTime = 10;
                case 3 -> allocatedTime = 15;
                default -> {
                }
            }
            
            system.addQueue(i-1, algorithm, allocatedTime);
            system.displayQueueAttributes(i-1);
            
        }
        System.out.println("WHERE PROCESSES WILL ENTER (1-3): ");
        int entryPolicy = scanner.nextInt();
                    
        ExecQueue.execQueue(system, entryPolicy);


    /*    // Example usage:
        //system.addProcess(0, "Object1");
        //system.addProcess(1, "Object2");
        //system.addProcess(2, "Object3");
        //system.displayQueues();

        // Display attributes of the queue at index 0
        system.displayQueueAttributes(0);

        // Display the first object in the queue at index 0
        system.displayFirstProcess(0);

        // Sort queues by priority
        system.sortQueuesByIndex();
        System.out.println("After sorting by index:");
        system.displayQueues();

        // Display attributes of the queue at index 0 after sorting
        system.displayQueueAttributes(0);

        // Display the first object in the queue at index 0 after sorting
        system.displayFirstProcess(0);

    */    scanner.close();
    }
}
