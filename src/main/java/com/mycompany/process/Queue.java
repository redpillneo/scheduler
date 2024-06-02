/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Queue {
	private int quantum;
	private int index;
    private int algorithm;
    private int allocatedTime;	
	
    public static ArrayList<Process> processes = new ArrayList<>();
    
	public Queue(int index, int algorithm, int quantum){
		this.index = index;
		this.algorithm = algorithm;
		this.quantum = quantum;
	}
	
	public Queue(int index, int algorithm, int quantum, int allocatedTime){
		this.index = index;
		this.algorithm = algorithm;
		this.quantum = quantum;
		this.allocatedTime = allocatedTime;
	}

	//Setters and Getters
	public int getQuantum() {
		return quantum;
	}


	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public int getAlgorithm() {
		return algorithm;
	}


	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}


	public int getAllocatedTime() {
		return allocatedTime;
	}


	public void setAllocatedTime(int allocatedTime) {
		this.allocatedTime = allocatedTime;
	}
	
	public boolean addProcess(Process p) {
		return processes.add(p);
	}
	
	public boolean removeProcess(Process p) {
		return processes.remove(p);
	}
	
	public boolean isEmpty() {
		return processes.isEmpty();
	}
	
	public Process poll() {
        if (processes.isEmpty()) {
            return null;
        }
        return processes.remove(0);
    }
	
	public Process peek() {
        if (processes.isEmpty()) {
            return null;
        }
        return processes.get(0);
    }
	
	public ArrayList<Process> getQueueProcesses() {
		return processes;
	}
	
	public String toString(){
		return "Queue ID:" + index + ", Algorithm: " + algorithm + ", Quantum: " + quantum;
	}
	
}
