package Processes;

import MultiLevelQueue.MultiQueueSystem;
import MultiLevelQueue.SchedulerQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class SJFAlgo {
    public void sjfAlgo(SchedulerQueue currentQueue) {
        int cycleCounter = 0;
        int allocationCounter = 1;
        boolean isLowest = false;
        ArrayList<Processes.Process> processes = currentQueue.getQueue();
        Collections.addAll(processes, Process.process);
        
        // Sort by arrival time
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));

        System.out.println("Queue: " +currentQueue.getIndex() +" " +currentQueue.getAllocation());
        while (!processes.isEmpty() || !InitiateProcess.list.isEmpty()) {
            
            while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= cycleCounter) {
                addProcess(processes.remove(0));
            }
            
            if (!InitiateProcess.list.isEmpty()) {
                Process currentProcess = InitiateProcess.list.getFirst();
                InitiateProcess.list.removeFirst();
                
                while (currentProcess.getBurstTime() > 0){
                    System.out.print("Performing at Cycle Time " + cycleCounter + " : ");
                    System.out.println("Process " + currentProcess.getProcessId() +" at Queue: " +currentQueue.getIndex());
                    cycleCounter++;
                    currentProcess.setBurstTime(currentProcess.getBurstTime() - 1); // Decrement burst time
                    
                    //add that have arrived
                    while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= cycleCounter) {
                        addProcess(processes.remove(0));
                    }
                    //do while constantly checking for the allocation
                    int innerCounter = currentProcess.getBurstTime();
                    int allocated = currentQueue.getAllocation();
                    
                    if(allocationCounter == allocated) {

                        // demote current process back to the list
                        isLowest = MultiQueueSystem.transferToNext(currentQueue.getIndex(), isLowest);
                        allocationCounter = 0;

                        //if lowest, push back to the queue
                        if(isLowest){
                            System.out.println("ADDED TO BACK!");
                            addProcess(currentProcess);
                        }
                            
                        System.out.println("PROCESS DEMOTED");

                        if (!InitiateProcess.list.isEmpty()){
                            currentProcess = InitiateProcess.list.getFirst();
                            InitiateProcess.list.removeFirst(); // Set the new current process
                        }
                        else {
                           break;
                         }
                    }   
                allocationCounter++;
                }
                System.out.println("Process Done!");
                allocationCounter = 1;
            } else {
                // do nothing
                System.out.println("Performing at Cycle Time " + cycleCounter + " : ");
                cycleCounter++;
            }
        }
         System.out.println("QUEUE DONE!");
    }

    public void addProcess(Process p) {
        int index = 0;
        while (index < InitiateProcess.list.size() && 
                InitiateProcess.list.get(index).getBurstTime() <= p.getBurstTime()) {
            index++;
        }
        InitiateProcess.list.add(index, p);
    }
}
