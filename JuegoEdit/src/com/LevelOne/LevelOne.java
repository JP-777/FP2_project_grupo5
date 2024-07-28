
package com.LevelOne;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class LevelOne extends javax.swing.JFrame {

    private static final int DELAY = 7000; // Duración en milisegundos 
    private Timer timer;
    
    private AudioClip sound; // Variable para el audio
    
    // Variables para el movimiento del jLabel7
    private Timer moveTimer7;
    private int moveDirection7 = 1;
    private static final int MOVE_AMOUNT7 = 5; // Cantidad de movimiento en píxeles
    private static final int MOVE_DELAY7 = 50; // Retardo en milisegundos para el movimiento suave
    private static final int MOVE_LIMIT7 = 140; // Límite de movimiento desde el borde del jPanel2
    
    // Variables para el movimiento de los TarColor
    private Timer moveTimerColors;
    private int moveDirectionYellow = 1;
    private int moveDirectionBlue = -1;
    private int moveDirectionRed = 1;
    private int moveDirectionGreen = -1;
    private static final int MOVE_AMOUNT = 4; // Cantidad de movimiento en píxeles
    private static final int MOVE_DELAY = 50; // Retardo en milisegundos para el movimiento suave
    private static final int MOVE_LIMIT = 53; // Límite de movimiento desde el borde del jPanel2
    
    
    
    public LevelOne() {
        initComponents();
        startTimer();
        playSound(); // Reproduce el audio al iniciar
        startMoveTimer7(); // Inicia el temporizador para mover el jLabel7
        startMoveTimerColors(); // Inicia el temporizador para mover los TarColor
    }
    
    //agregado
        private void startTimer() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Detiene el temporizador
                moveToNextFrame(); // Llama al método para mover a la siguiente ventana
            }
        });
        timer.setRepeats(false); // El temporizador no se repite
        timer.start(); // Inicia el temporizador
        }
        
        
       // Movimiento de jLabel7
    private void startMoveTimer7() {
        moveTimer7 = new Timer(MOVE_DELAY7, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = jLabel7.getLocation().x;
                int y = jLabel7.getLocation().y;
                x += MOVE_AMOUNT7 * moveDirection7;
                
                // Cambia la dirección si alcanza los límites
                if (x < MOVE_LIMIT7 || x + jLabel7.getWidth() > jPanel2.getWidth() - MOVE_LIMIT7) {
                    moveDirection7 *= -1;
                    x += MOVE_AMOUNT7 * moveDirection7;
                }
                jLabel7.setLocation(x, y);
            }
        });
        moveTimer7.start(); // Inicia el temporizador de movimiento
    }
    
        // Movimiento de los TarColor
        private void startMoveTimerColors() {
            moveTimerColors = new Timer(MOVE_DELAY, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moveLabel(TarColorYellow, moveDirectionYellow);
                    moveLabel(TarColorBlue, moveDirectionBlue);
                    moveLabel(TraColorRed, moveDirectionRed);
                    moveLabel(TarColorGreen, moveDirectionGreen);
                }
            });
            moveTimerColors.start(); // Inicia el temporizador de movimiento
        }

        private void moveLabel(javax.swing.JLabel label, int direction) {
            int x = label.getLocation().x;
            int y = label.getLocation().y;
            y += MOVE_AMOUNT * direction;

            // Cambia la dirección si alcanza los límites
            if (y < MOVE_LIMIT || y + label.getHeight() > jPanel2.getHeight() - MOVE_LIMIT) {
                if (label == TarColorYellow) {
                    moveDirectionYellow *= -1;
                } else if (label == TarColorBlue) {
                    moveDirectionBlue *= -1;
                } else if (label == TraColorRed) {
                    moveDirectionRed *= -1;
                } else if (label == TarColorGreen) {
                    moveDirectionGreen *= -1;
                }
            }
            label.setLocation(x, y);
        }
        
       
    
        
        
        private void moveToNextFrame() {
            stopSound(); // Detiene el audio antes de cerrar la ventana
            dispose(); // Cierra la ventana actual
            new cartVoltAveriguar().setVisible(true); // Abre la siguiente ventana (asegúrate de reemplazar NextFrame con el nombre de tu siguiente JFrame)
        }

        private void playSound() {
            sound = java.applet.Applet.newAudioClip(getClass().getResource("../audios/LevelsSuspenso.wav"));
            sound.play();
        }

        private void stopSound() {
            if (sound != null) {
                sound.stop();
            }
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
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TarColorYellow = new javax.swing.JLabel();
        TarColorBlue = new javax.swing.JLabel();
        TraColorRed = new javax.swing.JLabel();
        TarColorGreen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 213, 129));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 350, -1));

        jPanel2.setBackground(new java.awt.Color(255, 213, 129));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 81, 3), 2, true));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/RECUERDAME (18).png"))); // NOI18N

        TarColorYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/colorYellow.png"))); // NOI18N

        TarColorBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/colorBlue.png"))); // NOI18N

        TraColorRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/colorRed.png"))); // NOI18N

        TarColorGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/colorGreen.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(TarColorYellow)
                        .addGap(18, 18, 18)
                        .addComponent(TarColorBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TraColorRed, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TarColorGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TarColorBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TarColorGreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(TraColorRed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(TarColorYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 96, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 410, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/AdornitosMascotas2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 140, 84));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LevelOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LevelOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LevelOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LevelOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LevelOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TarColorBlue;
    private javax.swing.JLabel TarColorGreen;
    private javax.swing.JLabel TarColorYellow;
    private javax.swing.JLabel TraColorRed;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
