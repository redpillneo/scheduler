/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiQueueFinal;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class IndividualQueue {
    private int index;
    private int algorithm;
    private int allocatedTime;
    public static int ccTime = 0;
    public int entryQueue = 0;
    
    public static ArrayList<Processes.Process> queue = new ArrayList<>();

    public IndividualQueue(int index, int algorithm, int allocatedTime) {
        this.index = index;
        this.algorithm = algorithm;
        this.allocatedTime = allocatedTime;
        
    }

    public int getIndex() {
        return index;
    }

    public int getAlgorithm() {
        return algorithm;
    }
    
    public int getAllocatedTime(){
        return allocatedTime;
    }

    public int getEntryQueue(){
        return entryQueue;
    }
    
    public void setEntryQueue(int entryQueue){
        this.entryQueue = entryQueue;
    }
    public ArrayList<Processes.Process> getQueue() {
        return queue;
    }

    public boolean addProcess(Processes.Process p) {
            return queue.add(p);
    }

    public boolean removeObject(Processes.Process p) {
        return queue.remove(p);
    }
    
    public void setAllocatedTime(int allocatedTime){
        this.allocatedTime = allocatedTime;
    }

    public Processes.Process poll() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public Processes.Process peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    public boolean removeProcess(Processes.Process p) {
        return queue.remove(p);
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "CustomQueue{" +
                "index='" + index + '\'' +
                ", algorithm=" + algorithm +
                ", allocation=" + allocatedTime +
                '}';
    }
}