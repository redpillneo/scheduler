package MultiLevelQueue;

import java.util.ArrayList;

public class SchedulerQueue {
    private int algorithm;
    private int priority;
    private int index;
    private int allocation;
    
    public static ArrayList<Processes.Process> queue;


    public SchedulerQueue(int index, int algorithm, int priority, int allocation) {
        this.index = index;
        this.algorithm = algorithm;
        this.priority = priority;
        this.allocation = allocation;
        this.queue = new ArrayList<>();
    }

    public int getAlgorithm() {
        return algorithm;
    }
    
    public int getPriority() {
        return priority;
    }

    public int getIndex() {
        return index;
    }

    public int getAllocation() {
        return allocation;
    }
    
    public void setAllocation(int allocation) {
        this.allocation = allocation;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public boolean addProcess(Processes.Process p) {
        p.setArrivalTime(0);
        return queue.add(p);
    }

    public ArrayList<Processes.Process> getQueue() {
        return queue;
    }
    
    public Processes.Process pollProcess() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            return null;
        }
    }

    public Processes.Process peekProcess() {
        if (!queue.isEmpty()) {
            return queue.get(0);
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}