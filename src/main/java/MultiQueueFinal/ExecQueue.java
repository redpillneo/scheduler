/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiQueueFinal;

import Processes.AlgoPicker;

/**
 *
 * @author HP
 */
public class ExecQueue {
    public static void execQueue(QueueSystem system, int entryPolicy){
        AlgoPicker a = new AlgoPicker();
        // perform the algo at entryPolicy
        
        int i = 1;
        while(i != entryPolicy){
            system.cycleQueuesBackward();
            i++;
        }
 
        int allocation = system.getTopQueueAllocation();
        int topQueueIndex = system.getTopQueueIndex();
        int topQueueIndexOriginal = system.getTopQueueIndexOriginal();
        
        IndividualQueue.setEntryQueue(topQueueIndexOriginal);
        
        System.out.println("Entry Queue is at index: " +IndividualQueue.entryQueue);
        
        for(i = 0; i <= allocation; i++){
            
        }
        do {
            IndividualQueue currentQueue = system.queues.get(topQueueIndex);
            a.algoPicker(currentQueue);
            System.out.println("ALLOC UP/Queue Done");
            
            system.cycleQueuesForward();
            system.displayQueueAttributes(topQueueIndex);
        } while(!system.areAllQueuesEmpty());
    }
}
