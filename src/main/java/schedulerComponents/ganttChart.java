/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package schedulerComponents;

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
                jScrollPane1 = new javax.swing.JScrollPane();

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
                jLabel1.setText("Gantt Chart");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 694, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jScrollPane1.getAccessibleContext().setAccessibleName("gantChartPane");
                jScrollPane1.getAccessibleContext().setAccessibleDescription("");
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JScrollPane jScrollPane1;
        private schedulerComponents.mlfqConfig mlfqConfig1;
        private schedulerComponents.mlfqConfig mlfqConfig2;
        // End of variables declaration//GEN-END:variables
}