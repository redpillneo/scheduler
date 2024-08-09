/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.scheduler;
import schedulerComponents.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.process.Queue;
import com.mycompany.process.Process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Scheduler {
    public static void main(String[] args) {
	    FlatLightLaf.setup();
	    mainFrame mainFrame = new mainFrame();
	    mainFrame.setVisible(true);
			// set the process list
			// set the queues List
			// List<Process> processList = mainFrame.processConfig2.processes;
			// List<Queue> queueList = mainFrame.mlfqConfig1.queues;

	    // get first the data upon start simulation
			mainFrame.performanceAnalysis2.navigationPanel1.startSimulation.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt){    	
					List<Process> processList = mainFrame.processConfig2.processes;
					List<Queue> queueList = mainFrame.mlfqConfig1.queues;

					// scheduling algorithm
					startScheduler(processList, queueList);
				}
			});
		}

		public static void startScheduler(List<Process> proList, List<Queue> queList){
			// add the algorithm
			for(Process p: proList){
				System.out.println(p.toString());
			}
			for(Queue q: queList){
				System.out.println(q.toString());
			}
			System.out.println("whatchamakalit");

		}
}

