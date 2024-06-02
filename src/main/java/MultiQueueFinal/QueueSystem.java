    package MultiQueueFinal;

    import java.util.ArrayList;
    import java.util.Comparator;
    import com.mycompany.process.*;
    import com.mycompany.process.Process;


    public class QueueSystem {
        public static ArrayList<Queue> queues;

        public QueueSystem(ArrayList<Queue> queues) {
            this.queues = queues;
        }

        public static void addProcess(int queueIndex, Process p) {
            if (queueIndex >= 0 && queueIndex < queues.size()) {
                Queue queue = queues.get(queueIndex);
                if (queue != null) {
                    if (!queue.addProcess(p)) {
                        System.out.println("Failed to add object to queue " + queueIndex);
                    }
                } else {
                    System.out.println("Queue " + queueIndex + " does not exist.");
                }
            } else {
                System.out.println("Invalid queue index.");
            }
        }

        public static void removeProcess(int queueIndex, Process p) {
        if (queueIndex >= 0 && queueIndex < queues.size()) {
            Queue queue = queues.get(queueIndex);
            if (queue != null) {
                if (!queue.removeProcess(p)) {
                    System.out.println("Failed to remove object from queue " + queueIndex);
                }
            } else {
                System.out.println("Queue " + queueIndex + " does not exist.");
            }
        } else {
            System.out.println("Invalid queue index.");
        }
    }


        public static boolean transferToNext(int queueIndex, boolean isLowest) {
            if (queueIndex == queues.size()-1) {
                isLowest = true;
            }
            if (queueIndex >= 0 && queueIndex < queues.size() - 1) {
                Queue currentQueue = queues.get(queueIndex);
                if (!currentQueue.isEmpty()) {
                    Process p = currentQueue.poll();
                    Queue nextQueue = queues.get(queueIndex + 1);
                    nextQueue.addProcess(p);
                } else {
                    System.out.println("Queue " + queueIndex + " is empty.");
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
            if (queueIndex > 0 && queueIndex < queues.size()) {
                Queue currentQueue = queues.get(queueIndex);
                if (!currentQueue.isEmpty()) {
                    Process p = currentQueue.poll();
                    IndividualQueue prevQueue = queues.get(queueIndex - 1);
                    prevQueue.addProcess(p);
                } else {
                    System.out.println("Queue " + queueIndex + " is empty.");
                }
            } else {
                System.out.println("Invalid queue index or no previous queue available.");
            }
            return isHighest;
        }

        public void sortQueuesByIndex() {
            queues.sort(Comparator.comparingInt(IndividualQueue::getIndex));
        }

        public static void displayQueues() {
            for (int i = 0; i < queues.size(); i++) {
                System.out.println("Queue " + i + ": " + queues.get(i));
            }
        }

        public static void displayQueueAttributes(int index) {
            if (index >= 0 && index < queues.size()) {
                Queue queue = queues.get(index);
                System.out.println("Attributes of queue at index " + index + ":");
                System.out.println("Index: " + queue.getIndex());
                System.out.println("Algorithm: " + queue.getAlgorithm());
                System.out.println("Allocation: " + queue.getAllocatedTime());
                System.out.println("Current objects: " + queue.getQueue());
            } else {
                System.out.println("Invalid queue index.");
            }
        }

        public int getTopQueueIndex() {
            if (!queues.isEmpty()) {
                Queue topQueue = queues.get(0);
                for (int i = 0; i < queues.size(); i++) {
                    if (queues.get(i) == topQueue) {
                        return i;
                    }
                }
            }
            return -1; // No queues or top queue not found
        }

        public int getTopQueueAlgorithm() {
            int topQueueIndex = getTopQueueIndex();
            if (topQueueIndex != -1) {
                Queue topQueue = queues.get(topQueueIndex);
                return topQueue.getAlgorithm();
            }
            return -1; // No top queue found or empty queue system
        }

        public int getTopQueueAllocation() {
            int topQueueIndex = getTopQueueIndex();
            if (topQueueIndex != -1) {
                Queue topQueue = queues.get(topQueueIndex);
                return topQueue.getAllocatedTime();
            }
            return -1; // No top queue found or empty queue system
        }

        public int getTopQueueIndexOriginal() {
            int topQueueIndex = getTopQueueIndex();
            if (topQueueIndex != -1) {
                Queue topQueue = queues.get(topQueueIndex);
                return topQueue.getIndex();
            }
            return -1; // No top queue found or empty queue system
        }

        public static void displayFirstProcess(int index) {
            if (index >= 0 && index < queues.size()) {
                Queue queue = queues.get(index);
                Process firstProcess = queue.peek();
                System.out.println("First object in queue at index " + index + ": " + firstProcess);
            } else {
                System.out.println("Invalid queue index.");
            }
        }

        public void cycleQueuesForward() {
            if (queues.size() > 1) {
                Queue lastQueue = queues.remove(queues.size() - 1);
                queues.add(0, lastQueue);
            }
        }

        public void cycleQueuesBackward() {
            if (queues.size() > 1) {
                Queue firstQueue = queues.remove(0);
                queues.add(firstQueue);
            }
        }

        public static boolean areAllQueuesEmpty() {
            for (IndividualQueue queue : queues) {
                if (!queue.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

    }
