package Processes;

import MultiLevelQueue.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SJRFAlgo {

    public void sjrfAlgo(MultiLevelQueue.SchedulerQueue currentQueue) {
        int cycleCounter = 0;
        int allocationCounter = 1;
        boolean isHighest = false;
        boolean isLowest = false;

        //AlgoPicker a = new AlgoPicker();
        ArrayList<Processes.Process> processes = currentQueue.getQueue();

        Collections.addAll(processes, Process.process);

        // Sort by arrival time
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));

        System.out.println("Queue: " +currentQueue.getIndex() +" " +currentQueue.getAllocation() +" " +currentQueue.getAlgorithm());
        while (!processes.isEmpty() || !InitiateProcess.list.isEmpty()) {
            // Add processes that have arrived
            while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= cycleCounter) {
                addProcess(processes.remove(0));
            }

            if (!InitiateProcess.list.isEmpty()) {
                Process currentProcess = InitiateProcess.list.getFirst();
                InitiateProcess.list.removeFirst();

                while (currentProcess.getBurstTime() > 0) {
                    System.out.print("Performing at Cycle Time " + cycleCounter + " : ");
                    System.out.println("Process " + currentProcess.getProcessId() +" at Queue: " +currentQueue.getIndex());
                    cycleCounter++;
                    currentProcess.setBurstTime(currentProcess.getBurstTime() - 1); // Decrement burst time

                    // Add processes that arrive during this cycle
                    while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= cycleCounter) {
                        addProcess(processes.remove(0));
                    }

                    //check allocation
                    int allocated = currentQueue.getAllocation();
                    

                    System.out.println("Allocation, Allocated" + allocationCounter +" " +allocated);
                    if(allocationCounter == allocated){
                        isLowest = MultiQueueSystem.transferToNext(currentQueue.getIndex(), isLowest);
                        allocationCounter = 0;

                        //if lowest, push back to the queue
                        System.out.println(isLowest);
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
                    
                    // Check preemptive condition
                    if (!InitiateProcess.list.isEmpty() && 
                        InitiateProcess.list.getFirst().getBurstTime() < currentProcess.getBurstTime()) {

                        // promote current process back to the list
                        
                        isHighest = MultiQueueSystem.transferToPrevious(currentQueue.getIndex(), isHighest);                       
                        
                        //if highest, push back to the queue
                        System.out.println(isHighest);
                        if(isHighest){
                            System.out.println("ADDED TO BACK!");
                            addProcess(currentProcess);
                        }
                        System.out.println("Process Promoted!");
                        //MultiQueueSystem.transferToNext(currentQueue.getIndex());
                        
                        currentProcess = InitiateProcess.list.getFirst();
                        InitiateProcess.list.removeFirst(); // Set the new current process
                        allocationCounter = 0;
                    }
                    allocationCounter++;
                }
                System.out.println("PROCESS DONE!");
                allocationCounter = 1;
                // If the current process has finished execution, it will not be re-added to the list
                
            } else {
                // If no process is ready, just increment the cycle counter
                System.out.println("Performing at Cycle Time " + cycleCounter + " : ");
                cycleCounter++;
            }
        }

        System.out.println("QUEUE DONE!");
        //a.algoPicker(queue.get(0).getAlgorithm(), 0, queue);

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
