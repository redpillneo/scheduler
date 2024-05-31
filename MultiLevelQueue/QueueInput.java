/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiLevelQueue;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class QueueInput {
    
    public void getQueueInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of queues (1-3):");
        int numberOfQueues = scanner.nextInt();
        if (numberOfQueues < 1 || numberOfQueues > 3) {
            System.out.println("Invalid number of queues. Please enter a number between 1 and 3.");
            return;
        }
        
        System.out.println("Where Processes will Enter (0, 1, 2)");
        int entryPolicy = scanner.nextInt();
        
        System.out.println("Priority Policy: ");
        System.out.println("1 - Higher Before Lower: ");
        System.out.println("2 - Fixed Time Slots: ");
        int prioPolicy = scanner.nextInt();

        MultiQueueSystem system = new MultiQueueSystem(numberOfQueues,entryPolicy , prioPolicy);

        System.out.println("1 - FCFS");
        System.out.println("2 - SJF");
        System.out.println("3 - SJRF");
        System.out.println("4 - Nonpreemptive Priority Scheduling");
        System.out.println("5 - Preemptive Priority Scheduling");
        System.out.println("6 - Round Robin");
        
        for (int i = 0; i < numberOfQueues; i++) {
            System.out.println("Enter Algorithm for queue " + i + ":");
            int algorithm = scanner.nextInt();
            System.out.println("Enter Priority for queue " + i + ":");
            int priority = scanner.nextInt();
            
            system.initializeQueue(i, algorithm, priority);
            
            System.out.println("QUEUE ADDED WITH ID, ALGO, PRIO: " +i +" " +algorithm +" " +priority);
        }
        
        QueueExec.queueExec(system, entryPolicy, prioPolicy);
        
        scanner.close();
        
    }
}
