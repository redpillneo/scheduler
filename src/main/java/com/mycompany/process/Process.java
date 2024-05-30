package com.mycompany.process;


public class Process {
    private int id;
    private int burstTime;
    private int arrivalTime;
    private int priority;

    public Process(int id, int burstTime, int arrivalTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Process ID: " + id + ", Burst Time: " + burstTime + ", Arrival Time: " + arrivalTime + ", Priority: " + priority;
    }
}


