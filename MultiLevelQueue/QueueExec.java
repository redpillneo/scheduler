/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiLevelQueue;

import Processes.*;

/**
 *
 * @author HP
 */
public class QueueExec {
    
    public static void queueExec(MultiQueueSystem system, int entryPolicy, int prioPolocy){
        AlgoPicker a = new AlgoPicker();
        // perform the algo at index0
        system.sortQueues();
        
        do {
            for(int i = 0; i < system.getNumber(); i++){
                SchedulerQueue currentQueue = system.queues.get(i);
                a.algoPicker(currentQueue);
            }
        } while(!SchedulerQueue.queue.isEmpty());
        
        
        
        
        // sort the queues based on priority
        system.sortQueues();       
        
    }
}
