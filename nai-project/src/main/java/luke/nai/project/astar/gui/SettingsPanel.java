package luke.nai.project.astar.gui;

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;

/**
 *
 * @author LukaszDrapala
 */
public class SettingsPanel extends javax.swing.JPanel {
    
    private GamePanel gamePanel;
    /**
     * Creates new form SettingPanel
     */
    public SettingsPanel() {
        initComponents();
        setBorder(BorderFactory.createLineBorder(Color.black));
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);
        jLabel3.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Fields in row");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 24));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 24));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 24));
        add(jLabel1, new java.awt.GridBagConstraints());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "20", "25" }));
        jComboBox1.setMaximumSize(new java.awt.Dimension(150, 24));
        jComboBox1.setMinimumSize(new java.awt.Dimension(150, 24));
        jComboBox1.setPreferredSize(new java.awt.Dimension(150, 24));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new java.awt.GridBagConstraints());

        jButton1.setText("Start");
        jButton1.setMaximumSize(new java.awt.Dimension(150, 24));
        jButton1.setMinimumSize(new java.awt.Dimension(150, 24));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 24));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        add(jButton1, gridBagConstraints);

        jRadioButton1.setText("Select start");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        add(jRadioButton1, gridBagConstraints);

        jRadioButton2.setText("Select end");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        add(jRadioButton2, gridBagConstraints);

        jRadioButton3.setText("Select wall");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        add(jRadioButton3, gridBagConstraints);

        jLabel2.setText("jLabel2");
        add(jLabel2, new java.awt.GridBagConstraints());

        jLabel3.setText("jLabel3");
        add(jLabel3, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            List<Point>start = gamePanel.start();
            if(start.isEmpty()){
                jLabel3.setText("Invalid settings or game.");
            }
        } catch (Exception ex) {
                jLabel3.setText("Invalid settings or game.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jLabel3.setText("");
        String selectedItem = jComboBox1.getSelectedItem().toString();
        int fieldsInRow = Integer.parseInt(selectedItem);
        gamePanel.setFieldsInRow(fieldsInRow);
        jRadioButton1.setSelected(true);
        gamePanel.setContext(Context.CHOOSE_START);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        gamePanel.setContext(Context.CHOOSE_START);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        gamePanel.setContext(Context.CHOOSE_END);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        gamePanel.setContext(Context.CHOOSE_WALL);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        jComboBox1.setSelectedIndex(0);
        jRadioButton1.setSelected(true);
        gamePanel.setContext(Context.CHOOSE_START);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
}
