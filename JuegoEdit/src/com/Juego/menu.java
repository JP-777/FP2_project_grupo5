
package com.Juego;

import java.applet.AudioClip;
    //agragdo 
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.Timer;

/**
 *
 * @author Daniuws
 */
public class menu extends javax.swing.JFrame {

        private AudioClip sound;
        //agregado
                private Timer timerListo;
    private Timer timerPrinMenuAcceder;
    private int labelXListo = 90; // Posición inicial en X para Listo
    private int directionListo = 1; // Dirección inicial (1 = derecha, -1 = izquierda) para Listo
    private int labelXPrinMenuAcceder = 140; // Posición inicial en X para prinMenuAcceder
    private int directionPrinMenuAcceder = 1; // Dirección inicial (1 = derecha, -1 = izquierda) para prinMenuAcceder
    private final int SPEED_LISTO = 4; // Velocidad del movimiento para Listo
    private final int SPEED_PRINMENUACCEDER = 3; // Velocidad del movimiento para prinMenuAcceder
    private final int LEFT_BOUND_LISTO = 50; // Límite izquierdo para Listo
    private final int RIGHT_BOUND_LISTO = 100; // Límite derecho para Listo
    private final int LEFT_BOUND_PRINMENUACCEDER = 140; // Límite izquierdo para prinMenuAcceder
    private final int RIGHT_BOUND_PRINMENUACCEDER = 170; // Límite derecho para prinMenuAcceder
    
    
    private Timer timerJLabel7;
    private int labelYJLabel7 = 90; // Posición inicial en Y para jLabel7
    private int directionJLabel7 = 1; // Dirección inicial (1 = abajo, -1 = arriba) para jLabel7
    private final int SPEED_JLABEL7 = 1; // Velocidad del movimiento para jLabel7
    private final int TOP_BOUND_JLABEL7 = 90; // Límite superior para jLabel7
    private final int BOTTOM_BOUND_JLABEL7 = 130; // Límite inferior para jLabel7
    
    private Timer timerJLabel5; // Timer para el movimiento vertical de jLabel5
    private int labelYJLabel5 = 130; // Posición inicial en Y para jLabel5
    private int directionJLabel5 = 1; // Dirección inicial (1 = abajo, -1 = arriba) para jLabel5
    private final int SPEED_JLABEL5 = 1; // Velocidad del movimiento para jLabel5
    private final int TOP_BOUND_JLABEL5 = 100; // Límite superior para jLabel5
    private final int BOTTOM_BOUND_JLABEL5 = 140; // Límite inferior para jLabel5
    
    private Timer timerJLabel3; // Timer para el movimiento de agrandar y achicar de jLabel3
    private int labelWidthJLabel3 = 94; // Ancho inicial de jLabel3
    private int labelHeightJLabel3 = 166; // Altura inicial de jLabel3
    private int scaleDirectionJLabel3 = 1; // Dirección de escala (1 = agrandar, -1 = achicar) para jLabel3
    private final int SCALE_AMOUNT_JLABEL3 = 1; // Cantidad de cambio en tamaño para jLabel3
    private final int MIN_WIDTH_JLABEL3 = 94; // Ancho mínimo para jLabel3
    private final int MAX_WIDTH_JLABEL3 = 104; // Ancho máximo para jLabel3
    private final int MIN_HEIGHT_JLABEL3 = 166; // Altura mínima para jLabel3
    private final int MAX_HEIGHT_JLABEL3 = 176; // Altura máxima para jLabel3
    
    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        playSound();
        //nuevo
        startMovingLabels();

    }
    
    private void playSound() {
        sound = java.applet.Applet.newAudioClip(getClass().getResource("../audios/MenuMusica.wav"));
        sound.play();
    }
    private void stopSound() {
        if (sound != null) {
        sound.stop();
        }
    }   
    
    //nuevo metodo
         private void startMovingLabels() {
        // Timer para mover el JLabel Listo
        timerListo = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelXListo += SPEED_LISTO * directionListo;
                if (labelXListo >= RIGHT_BOUND_LISTO || labelXListo <= LEFT_BOUND_LISTO) {
                    directionListo *= -1;
                }
                Listo.setLocation(labelXListo, Listo.getY());
            }
        });
        timerListo.start();

        
        // Timer para mover el JLabel prinMenuAcceder
        timerPrinMenuAcceder = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelXPrinMenuAcceder += SPEED_PRINMENUACCEDER * directionPrinMenuAcceder;
                if (labelXPrinMenuAcceder >= RIGHT_BOUND_PRINMENUACCEDER || labelXPrinMenuAcceder <= LEFT_BOUND_PRINMENUACCEDER) {
                    directionPrinMenuAcceder *= -1;
                }
                prinMenuAcceder.setLocation(labelXPrinMenuAcceder, prinMenuAcceder.getY());
            }
        });
        timerPrinMenuAcceder.start();
        
        
        // Timer para mover el JLabel jLabel7 verticalmente
        timerJLabel7 = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelYJLabel7 += SPEED_JLABEL7 * directionJLabel7;
                if (labelYJLabel7 >= BOTTOM_BOUND_JLABEL7 || labelYJLabel7 <= TOP_BOUND_JLABEL7) {
                    directionJLabel7 *= -1;
                }
                jLabel7.setLocation(jLabel7.getX(), labelYJLabel7);
            }
        });
        timerJLabel7.start();
        
        
        // Timer para mover el JLabel jLabel5 verticalmente
        timerJLabel5 = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelYJLabel5 += SPEED_JLABEL5 * directionJLabel5;
                if (labelYJLabel5 >= BOTTOM_BOUND_JLABEL5 || labelYJLabel5 <= TOP_BOUND_JLABEL5) {
                    directionJLabel5 *= -1;
                }
                jLabel5.setLocation(jLabel5.getX(), labelYJLabel5);
            }
        });
        timerJLabel5.start();
        
        
        // Timer para agrandar y achicar el JLabel jLabel3
        timerJLabel3 = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelWidthJLabel3 += SCALE_AMOUNT_JLABEL3 * scaleDirectionJLabel3;
                labelHeightJLabel3 += SCALE_AMOUNT_JLABEL3 * scaleDirectionJLabel3;
                if (labelWidthJLabel3 >= MAX_WIDTH_JLABEL3 || labelWidthJLabel3 <= MIN_WIDTH_JLABEL3) {
                    scaleDirectionJLabel3 *= -1;
                }
                jLabel3.setSize(labelWidthJLabel3, labelHeightJLabel3);
            }
        });
        timerJLabel3.start();
        
    }

    @Override
    public void dispose() {
        stopSound();
        if (timerListo != null) {
            timerListo.stop();
        }
        if (timerPrinMenuAcceder != null) {
            timerPrinMenuAcceder.stop();
        }
        if (timerJLabel7 != null) {
            timerJLabel7.stop();
        }
        if (timerJLabel5 != null) {
            timerJLabel5.stop();
        }
         if (timerJLabel3 != null) {
            timerJLabel3.stop();
        }
        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        prinMenuAcceder = new javax.swing.JLabel();
        Listo = new javax.swing.JLabel();
        menuIngresar = new javax.swing.JButton();
        menubotPrinCrearAccount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botLogros = new javax.swing.JButton();
        botDudas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 213, 129));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prinMenuAcceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/menuPrinCrearAccount.png"))); // NOI18N
        jPanel1.add(prinMenuAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 240, 74));

        Listo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/menuPrinAcceder.png"))); // NOI18N
        Listo.setPreferredSize(new java.awt.Dimension(298, 101));
        jPanel1.add(Listo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, 100));

        menuIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/menuPrintbotJUgar.png"))); // NOI18N
        menuIngresar.setBorder(null);
        menuIngresar.setContentAreaFilled(false);
        menuIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(menuIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 242, 83));

        menubotPrinCrearAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/menuBotPrinCrearAccount).png"))); // NOI18N
        menubotPrinCrearAccount.setBorder(null);
        menubotPrinCrearAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menubotPrinCrearAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubotPrinCrearAccountActionPerformed(evt);
            }
        });
        jPanel1.add(menubotPrinCrearAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 259, 55));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/menuPersonita.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(95, 168));
        jLabel3.setMinimumSize(new java.awt.Dimension(95, 168));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 120, 140));

        botLogros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/RECUERDAME (13).png"))); // NOI18N
        botLogros.setBorder(null);
        botLogros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botLogros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLogrosActionPerformed(evt);
            }
        });
        jPanel1.add(botLogros, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 190, 100));

        botDudas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/RECUERDAME (14).png"))); // NOI18N
        botDudas.setBorder(null);
        botDudas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botDudas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botDudasActionPerformed(evt);
            }
        });
        jPanel1.add(botDudas, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 191, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/logo1Menu.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 100));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/RECUERDAME (7).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 695, 195));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/RECUERDAME (8).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 192, 183));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/RECUERDAME (5).png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, -1, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menubotPrinCrearAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubotPrinCrearAccountActionPerformed
        stopSound();
        com.Login.Login newAccount = new com.Login.Login();
        newAccount.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menubotPrinCrearAccountActionPerformed

    private void menuIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIngresarActionPerformed
        stopSound();
        com.ingreso.ingresar newPlay = new com.ingreso.ingresar();
        newPlay.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuIngresarActionPerformed

    private void botLogrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLogrosActionPerformed
        stopSound();
        com.Logros.Logros newLogros = new com.Logros.Logros();
        newLogros.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botLogrosActionPerformed

    private void botDudasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botDudasActionPerformed
        stopSound();
        com.Dudas.Dudas newDudas = new com.Dudas.Dudas();
        newDudas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botDudasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Listo;
    private javax.swing.JButton botDudas;
    private javax.swing.JButton botLogros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton menuIngresar;
    private javax.swing.JButton menubotPrinCrearAccount;
    private javax.swing.JLabel prinMenuAcceder;
    // End of variables declaration//GEN-END:variables
}
