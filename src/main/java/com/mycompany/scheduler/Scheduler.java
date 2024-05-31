/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.scheduler;
import schedulerComponents.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import com.formdev.flatlaf.FlatLightLaf;


public class Scheduler {
    public static void main(String[] args) {
	    FlatLightLaf.setup();
//		for(LookAndFeelInfo lafInfo:UIManager.getInstalledLookAndFeels()){
//			System.out.println(lafInfo.getClassName());
//		}

	    mainFrame mainFrame = new mainFrame();
	    mainFrame.setVisible(true);
    }
}

