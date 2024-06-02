/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package schedulerComponents;

/**
 *
 * @author LENOVO
 */
public class navigationPanel extends javax.swing.JPanel {

    /**
     * Creates new form navigationPanel
     */
    public navigationPanel() {
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

                jToggleButton1 = new javax.swing.JToggleButton();
                speed = new javax.swing.JComboBox<>();
                jToggleButton2 = new javax.swing.JToggleButton();
                jToggleButton3 = new javax.swing.JToggleButton();
                jSeparator2 = new javax.swing.JSeparator();
                jSeparator3 = new javax.swing.JSeparator();

                jToggleButton1.setText("jToggleButton1");

                speed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10ms", "50ms", "100ms", "1s" }));

                jToggleButton2.setText("Start Simulation");
                jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jToggleButton2ActionPerformed(evt);
                        }
                });

                jToggleButton3.setText("STOP");
                jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jToggleButton3ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(speed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jToggleButton2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jToggleButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(speed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                speed.getAccessibleContext().setAccessibleName("");
                jToggleButton2.getAccessibleContext().setAccessibleName("startSimulationButton");
                jToggleButton3.getAccessibleContext().setAccessibleName("stop button");
        }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO handling code when user presses 'start simulation' button
    	
    	ganttChart.showGanttChart();
		
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    	System.out.println(mlfqConfig.getPriorityPolicy());
    }//GEN-LAST:event_jToggleButton3ActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JSeparator jSeparator3;
        private javax.swing.JToggleButton jToggleButton1;
        private javax.swing.JToggleButton jToggleButton2;
        private javax.swing.JToggleButton jToggleButton3;
        private javax.swing.JComboBox<String> speed;
        // End of variables declaration//GEN-END:variables
}
