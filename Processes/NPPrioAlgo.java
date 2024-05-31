package Processes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */

public class NPPrioAlgo {
    public void nppAlgo() {
        int cycleCounter = 0;
        ArrayList<Process> processes = new ArrayList<>();
        Collections.addAll(processes, Process.process);
        
        // sort by arrival time
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));

        while (!processes.isEmpty() || !InitiateProcess.list.isEmpty()) {
            // add all processes that have arrived
            while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= cycleCounter) {
                addProcess(processes.remove(0));
            }
            
            if (!InitiateProcess.list.isEmpty()) {
                Process currentProcess = InitiateProcess.list.pop();
                System.out.println("Program Executing: Process " + currentProcess.getProcessId() +
                        " with " + currentProcess.getBurstTime() + " Burst Time");

                int innerCounter = currentProcess.getBurstTime();
                while (innerCounter != 0) {
                    System.out.print("Performing at Cycle Time " + cycleCounter + " : ");
                    System.out.println("Process " + currentProcess.getProcessId());
                    cycleCounter++;
                    innerCounter--;

                    // add processes that arrive while running
                    while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= cycleCounter) {
                        addProcess(processes.remove(0));
                    }
                }
                System.out.println("Process Done!");
            } else {
                //do nothing if none arrived
                System.out.println("Performing at Cycle Time " + cycleCounter + " : ");
                cycleCounter++;
            }
        }
    }
    public void addProcess(Process p) {
        int index = 0;
        while (index < InitiateProcess.list.size() && 
               (InitiateProcess.list.get(index).getPriority() < p.getPriority() || 
               (InitiateProcess.list.get(index).getPriority() == p.getPriority() && 
                InitiateProcess.list.get(index).getArrivalTime() <= p.getArrivalTime()))) {
            index++;
        }
        InitiateProcess.list.add(index, p);
    }
}