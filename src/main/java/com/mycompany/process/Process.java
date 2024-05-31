package com.mycompany.process;


public class Process {
    public int id;
    public int burstTime;
    public int arrivalTime;
    public int priority;

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
    
    public void setBurstTime(int bTime){
        this.burstTime = bTime;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public int getProcessId(){
        return id;
    }
    public int getBurstTime(){
        return burstTime;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getPriority(){
        return priority;
    }
}


