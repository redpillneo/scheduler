package MultiLevelQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MultiQueueSystem {
    public static ArrayList<SchedulerQueue> queues;
    private static int numberOfQueues;

    public int getNumber(){
        return numberOfQueues;
    }
    public MultiQueueSystem(int numberOfQueues, int entryPolicy, int prioPolicy){
        this.numberOfQueues = numberOfQueues;
        queues = new ArrayList<>(numberOfQueues);
        // Initialize the list with null values
        for (int i = 0; i < numberOfQueues; i++) {
            queues.add(null);
        }
    }

    public void initializeQueue(int index, int algorithm, int priority, int allocation) {
        if (index >= 0 && index < numberOfQueues) {
            queues.set(index, new SchedulerQueue(index, algorithm, priority, allocation));
        } else {
            System.out.println("Invalid queue index.");
        }
    }

    public void addProcess(int queueIndex, Processes.Process p) {
        if (queueIndex >= 0 && queueIndex < numberOfQueues) {
            SchedulerQueue queue = queues.get(queueIndex);
            if (queue != null) {
                if (!queue.addProcess(p)) {
                    System.out.println("Failed to add object to queue " + queueIndex);
                }
            } else {
                System.out.println("Queue " + queueIndex + " is not initialized.");
            }
        } else {
            System.out.println("Invalid queue index.");
        }
    }

    public static boolean transferToNext(int queueIndex, boolean isLowest) {
        if (queueIndex == numberOfQueues-1) {
            isLowest = true;
        }
        if (queueIndex >= 0 && queueIndex < numberOfQueues - 1) {
            SchedulerQueue currentQueue = queues.get(queueIndex);
            SchedulerQueue nextQueue = queues.get(queueIndex + 1);
            if (currentQueue != null && nextQueue != null) {
                if (!currentQueue.isEmpty()) {
                    Processes.Process p = currentQueue.pollProcess();
                    nextQueue.addProcess(p);
                } else {
                    System.out.println("The current queue is empty.");
                }
            } else {
                System.out.println("One of the queues is not initialized.");
            }
        } else {
            System.out.println("Invalid queue index or no next queue available.");
        }
        return isLowest;
    }

    public static boolean transferToPrevious(int queueIndex, boolean isHighest) {
        if (queueIndex == 0) {
            isHighest = true;
        }
        
        if (queueIndex > 0 && queueIndex < numberOfQueues) {
            SchedulerQueue currentQueue = queues.get(queueIndex);
            SchedulerQueue previousQueue = queues.get(queueIndex - 1);
            if (currentQueue != null && previousQueue != null) {
                if (!currentQueue.isEmpty()) {
                    Processes.Process p = currentQueue.pollProcess();
                    previousQueue.addProcess(p);
                } else {
                    System.out.println("The current queue is empty.");
                }
            } else {
                System.out.println("One of the queues is not initialized.");
            }
        } else {
            System.out.println("Invalid queue index or no previous queue available.");
        }
        return isHighest;
    }

    public boolean checkIfEmpty() {
        boolean empty = false;
        for(int i = 0; i < numberOfQueues; i++){
            if(queues.get(i).isEmpty()){
                empty = true;
            }
        }
        return empty;
    }
    public void displayQueues() {
        for (int i = 0; i < numberOfQueues; i++) {
            System.out.println("Queue " + i + ": " + queues.get(i));
        }
    }
    
    public void sortQueues() {
        Collections.sort(queues, Comparator.comparingInt(SchedulerQueue::getPriority));
        for(int i = 0; i < numberOfQueues; i++){
            switch (i) {
                case 0 -> {
                    queues.get(i).setAllocation(4);
                    queues.get(i).setIndex(i);
                }
                case 1 -> {
                    queues.get(i).setAllocation(8);
                    queues.get(i).setIndex(i);
                }
                case 2 -> {
                    queues.get(i).setAllocation(16);
                    queues.get(i).setIndex(i);
                }
                default -> {
                }
            }
        }
    }
}
