package com.mycompany.process;


public class Process {
    private int id;
    private int burstTime;
    private int arrivalTime;
    private int priority;
    private boolean finished;

    public Process(int id, int burstTime, int arrivalTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.finished = false;
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
    public boolean isFinished() {
    	return finished;
    }
}


