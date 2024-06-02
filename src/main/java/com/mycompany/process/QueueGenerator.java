/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class QueueGenerator {
	public List<Queue> generateQueues(int numberOfQueue){
		List<Queue> queues = new ArrayList<>();
		for (int i = 0; i < numberOfQueue; i++){
			int id = i +1;
			Queue queue = new Queue(id, 0, 0); //TODO make sure na depende sa algorithm yung second parameter (algorithm)
			queues.add(queue);
		}
		return queues;
	}
}
