/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Processes;

import MultiQueueFinal.IndividualQueue;
import MultiQueueFinal.QueueSystem;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author HP
 */
public class FCFSFinal {
    public static void main(String[] args){
        IndividualQueue q = new IndividualQueue(1, 1, 5);
        QueueSystem system = new QueueSystem();
        
        Process.process = new Process[4];
        
        Process.process[0] = new Process(0, 2, 1, 1); //bTime, aTime, priority
        Process.process[1] = new Process(1, 3, 1, 1); //bTime, aTime, priority
        Process.process[2] = new Process(2, 4, 2, 1); //bTime, aTime, priority
        Process.process[3] = new Process(3, 6, 7, 1); //bTime, aTime, priority
        
        system.addQueue(1, 4, 6);
        system.addQueue(2, 4, 6);
        system.addQueue(3, 6, 9);
        IndividualQueue currentQueue = system.queues.get(0);
        FCFS(currentQueue);
    }
    public static void FCFS(IndividualQueue currentQueue){
        int cycleCounter = 0;
        int allocationCounter = 1;
        boolean isLowest = false;
        ArrayList<Processes.Process> p = new ArrayList<>(currentQueue.getQueue());
        Collections.addAll(p, Process.process);
        
        
        System.out.println(currentQueue.getAlgorithm());
                           //to change to currentQueue
        while(cycleCounter <= 20 || !p.isEmpty()){
            
            // arrived before the loop
            // to be changed to the entry Queue!
            while(!p.isEmpty() && p.get(0).getArrivalTime() <= cycleCounter){
                if(!p.isEmpty()){
                    System.out.print("PROCESS ARRIVED: " +p.get(0).getProcessId());
                    currentQueue.addProcess(p.get(0));
                    p.remove(0);
                }
            }
            
            
            if(!currentQueue.isEmpty()){
                //out of burst time
                while(currentQueue.peek().getBurstTime() > 0){
                    System.out.print("EXECUTING AT CLOCK TIME " +cycleCounter +": ");
                    System.out.println(" PROCESS: " +currentQueue.peek().getProcessId());
                    
                    //get that arrive
                    while(!p.isEmpty() && p.get(0).getArrivalTime() <= cycleCounter){
                        if(!p.isEmpty()){
                            System.out.print("PROCESS ARRIVED: " +p.get(0).getProcessId());
                            System.out.println();
                            currentQueue.addProcess(p.get(0));
                            p.remove(0);
                        }
                    }
                    
                    //check for the process allocation
                    int allocated = currentQueue.getAllocatedTime();
                    
                    if(allocationCounter == allocated){
                        System.out.println("PROCESS DEMOTED!");
                        System.out.println("CURRENT QUEUE: " +currentQueue.getIndex());
                        isLowest = QueueSystem.transferToNext(currentQueue.getIndex(), isLowest);
                        
                        if(isLowest){
                            //add to back
                        }
                        else {
                            System.out.println("ADDED TO NEXT!");
                            QueueSystem.displayQueueAttributes(currentQueue.getIndex());
                        }
                        
                    }
                    currentQueue.peek().setBurstTime(currentQueue.peek().getBurstTime()-1); //decrement burst time
                    cycleCounter++; //increment cyclecounter
                    allocationCounter++;
                    
                }
                allocationCounter = 1;
                System.out.println("PROCESS DONE!");
                currentQueue.poll(); //remove from queue
                if(!p.isEmpty() && p.get(0).getBurstTime() == 0){
                    p.remove(0); //remove from process list
                }
                //p is cleared 
            }
            else {
                System.out.println("EXECUTING AT CLOCK TIME " +cycleCounter +": ");
                cycleCounter++;
            }
  
        }
        System.out.println("QUEUE IS " +currentQueue.isEmpty());
        QueueSystem.areAllQueuesEmpty();
    }
}
