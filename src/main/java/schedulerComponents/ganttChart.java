/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package schedulerComponents;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.IntervalCategoryDataset;  
import org.jfree.data.gantt.Task;  
import org.jfree.data.gantt.TaskSeries;  
import org.jfree.data.gantt.TaskSeriesCollection;  

/**
 *
 * @author LENOVO
 */
public class ganttChart extends javax.swing.JPanel {

    /**
     * Creates new form ganttChart
     */
    public ganttChart() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

		    	
    	
                mlfqConfig1 = new schedulerComponents.mlfqConfig();
                mlfqConfig2 = new schedulerComponents.mlfqConfig();
                jLabel1 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane(); //Create blank scrollpane
                
                ganttChartPane = new javax.swing.JScrollPane();
                proceesBlockPanel = new javax.swing.JPanel();

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
                jLabel1.setText("Gantt Chart");

                proceesBlockPanel.setLayout(new javax.swing.BoxLayout(proceesBlockPanel, javax.swing.BoxLayout.X_AXIS));
                ganttChartPane.setViewportView(proceesBlockPanel);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 805, Short.MAX_VALUE))
                                        .addComponent(ganttChartPane))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ganttChartPane, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addContainerGap())
                );

                jScrollPane1.getAccessibleContext().setAccessibleName("gantChartPane");
                jScrollPane1.getAccessibleContext().setAccessibleDescription("");
                
                ganttChartPane.getAccessibleContext().setAccessibleName("gantChartPane");
                ganttChartPane.getAccessibleContext().setAccessibleDescription("");
        }// </editor-fold>//GEN-END:initComponents

    public static void showGanttChart() {
    	//Gantt Chart objects
        ProcessGanttChart chart = new ProcessGanttChart();
        
    	jScrollPane1.setViewportView(chart.getChartPanel()); //Set the contents of jScrollPane1 to the gantt chart
        chart.setSize(jScrollPane1.getViewport().getWidth(), jScrollPane1.getViewport().getHeight()); //Set the width of the gantt chart to the width of the scrollpane
    }
    
    
        // Variables declaration - do not modify//GEN-BEGIN:variables
        public javax.swing.JScrollPane ganttChartPane;
        private javax.swing.JLabel jLabel1;
        private static javax.swing.JScrollPane jScrollPane1;
        private schedulerComponents.mlfqConfig mlfqConfig1;
        private schedulerComponents.mlfqConfig mlfqConfig2;
        public javax.swing.JPanel proceesBlockPanel;
        // End of variables declaration//GEN-END:variables
}
