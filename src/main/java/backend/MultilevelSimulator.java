package backend;

import schedulerComponents.*;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.process.Process;

public class MultilevelSimulator {
	private int clockCycle;
	private List<Process> processes;
	
	public MultilevelSimulator() {
		this.clockCycle = 0;
		this.processes = processConfig.processes;
	}
	
	public void simulate() {
		List<Process> arrivedProcesses;
		
		while(!allProcessesFinished()) {
			clockCycle++;
			
			arrivedProcesses = checkArrival(clockCycle);
			
			
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
