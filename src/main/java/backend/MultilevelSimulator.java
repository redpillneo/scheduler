package backend;

import schedulerComponents.*;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.process.Process;
import com.mycompany.process.Queue;

import MultiQueueFinal.IndividualQueue;
import MultiQueueFinal.QueueSystem;

public class MultilevelSimulator {
	private int clockCycle;
	private List<Process> processes;
	private static List<Queue> queues;
	
	public MultilevelSimulator() {
		this.clockCycle = 0;
		this.processes = processConfig.processes;
		this.queues = mlfqConfig.queues;
	}
	
	public void simulate() {
		List<Process> arrivedProcesses;
		String priorityPolicy;
		
		while(!allProcessesFinished()) {
			clockCycle++;
			
			arrivedProcesses = checkArrival(clockCycle);
			for(Process p : arrivedProcesses) {
				int entryQueue = mlfqConfig.getEntryQueue();
				QueueSystem.addProcess(entryQueue, p);
			}
			
			//Check priority policy
			priorityPolicy = mlfqConfig.getPriorityPolicy();
			
			if(priorityPolicy.equals("Higher Before Lower")) {
				//TODO iterate through the queueList while queue is empty
				
				//TODO if the queue is not empty, getHead(schedAlgo) of the queue, display to ganttChart, and decrement its remaining time
			}
			else {
				//TODO check if there is promotion or demotion
			}
		}
	}
	
	public List<Process> checkArrival(int time) {
    	List<Process> arrivedProcesses = new ArrayList();
    	
    	for(int i = 0; i < processes.size(); i++) {
    		if(processes.get(i).getArrivalTime() == time) {
    			arrivedProcesses.add(processes.get(i));
    		}
    	}
    	return arrivedProcesses;
    }
    
    public Boolean allProcessesFinished() {
    	//Iterate through each process and check finished flag if all are true
    	for(int i = 0; i < processes.size(); i++) {
    		if(!processes.get(i).isFinished()) {
    			return false;
    		}
    	}
    	return true;
    }
}
