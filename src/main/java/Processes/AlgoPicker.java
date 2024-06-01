package Processes;

import MultiLevelQueue.SchedulerQueue;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class AlgoPicker {
    Scanner scanner = new Scanner(System.in);
    FCFSAlgo fcfs = new FCFSAlgo();
    SJFAlgo sjf = new SJFAlgo();
    SJRFAlgo sjrf = new SJRFAlgo();
    NPPrioAlgo npp = new NPPrioAlgo();
    PPrioAlgo pp = new PPrioAlgo();
    RoundRobinAlgo rr = new RoundRobinAlgo();
    
    
    public void algoPicker(SchedulerQueue currentQueue){
        
    /*    System.out.println("Choose Scheduling Algorithm: ");
        System.out.println("1 - FCFS");
        System.out.println("2 - SJF");
        System.out.println("3 - SJRF");
        System.out.println("4 - Nonpreemptive Priority Scheduling");
        System.out.println("5 - Preemptive Priority Scheduling");
        System.out.println("6 - Round Robin");
    */    
        int algo = currentQueue.getAlgorithm();
        switch(algo){
            case 1 -> fcfs.fcfsAlgo(currentQueue);
            case 2 -> sjf.sjfAlgo(currentQueue);
            case 3 -> sjrf.sjrfAlgo(currentQueue);
            case 4 -> npp.nppAlgo(currentQueue);
            case 5 -> pp.ppAlgo(currentQueue);
            case 6 -> rr.setQuantum();
            default -> System.out.println("Invalid Input!");
        }
    }
}
