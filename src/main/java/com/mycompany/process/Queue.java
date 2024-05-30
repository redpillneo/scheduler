/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.process;

/**
 *
 * @author LENOVO
 */
public class Queue {
	public int id;
	private String schedAlgo;
	private int quantum;

	public Queue(int id, String schedAlgo, int quantum){
		this.id = id;
		this.schedAlgo = schedAlgo;
		this.quantum = quantum;
	}
	// getters and setters
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getSchedAlgo(){
		return schedAlgo;
	}
	public void setSchedAlgo(){
		this.schedAlgo = schedAlgo;
	}
	public int getQuantum(){
		return quantum;
	}
	public void setQuantum(int quantum){
		this.quantum = quantum;
	}

	public String toString(){
		return "Queue ID:" + id + ", Algorithm: " + schedAlgo + ", Quantum: " + quantum;
	}
	
}
