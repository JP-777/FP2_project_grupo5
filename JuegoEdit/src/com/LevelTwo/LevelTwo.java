/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.LevelTwo;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Daniusw
 */
public class LevelTwo extends javax.swing.JFrame {
    
    //agregando
    private static final int DELAY = 7000; // Duración en milisegundos 
    private Timer timer;
    
    private AudioClip sound; // Variable para el audio
    
    // Variables para el movimiento del jLabel Title
    private Timer moveTimerTitle;
    private int moveDirectionTitle = 1;
    private static final int MOVE_AMOUNT_TITLE = 4; // Cantidad de movimiento en píxeles
    private static final int MOVE_DELAY_TITLE = 50; // Retardo en milisegundos para el movimiento suave
    private static final int MOVE_LIMIT_TITLE = 140; // Límite de movimiento desde el borde del jPanel2
    
    // Variables para el movimiento de los TarColor
    private Timer moveTimerAnimals;
    private int moveDirectionPerro = 1;
    private int moveDirectionGato = -1;
    private int moveDirectionCerdo = 1;
    private int moveDirectionLeon= -1;
    private static final int MOVE_AMOUNT = 4; // Cantidad de movimiento en píxeles
    private static final int MOVE_DELAY = 50; // Retardo en milisegundos para el movimiento suave
    private static final int MOVE_LIMIT = 45; // Límite de movimiento desde el borde del jPanel2
    
    
    public LevelTwo() {
        initComponents();
        playSound();
        startTimer();
        startMoveTimerTitle();
        startMoveTimerAnimals();
    }
    
    
        // Movimiento de jLabel Title
        private void startMoveTimerTitle() {
            moveTimerTitle = new Timer(MOVE_DELAY_TITLE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int x = Title.getLocation().x;
                    int y = Title.getLocation().y;
                    x += MOVE_AMOUNT_TITLE * moveDirectionTitle;

                    // Cambia la dirección si alcanza los límites
                    if (x < MOVE_LIMIT_TITLE || x + Title.getWidth() > jPanel2.getWidth() - MOVE_LIMIT_TITLE) {
                        moveDirectionTitle *= -1;
                        x += MOVE_AMOUNT_TITLE * moveDirectionTitle;
                    }
                    Title.setLocation(x, y);
                }
            });
            moveTimerTitle.start(); // Inicia el temporizador de movimiento
        }
        
        // Movimiento de los TarColor
        private void startMoveTimerAnimals() {
            moveTimerAnimals = new Timer(MOVE_DELAY, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moveLabel(TarAnimPerro, moveDirectionPerro);
                    moveLabel(TarAnimGato, moveDirectionGato);
                    moveLabel(TarAnimCerdo, moveDirectionCerdo);
                    moveLabel(TarAnimLeon, moveDirectionLeon);
                }
            });
            moveTimerAnimals.start(); // Inicia el temporizador de movimiento
        }

            private void moveLabel(javax.swing.JLabel label, int direction) {
            int x = label.getLocation().x;
            int y = label.getLocation().y;
            y += MOVE_AMOUNT * direction;

            // Cambia la dirección si alcanza los límites
            if (y < MOVE_LIMIT || y + label.getHeight() > jPanel2.getHeight() - MOVE_LIMIT) {
                if (label == TarAnimPerro) {
                    moveDirectionPerro *= -1;
                } else if (label == TarAnimGato) {
                    moveDirectionGato *= -1;
                } else if (label == TarAnimCerdo) {
                    moveDirectionCerdo *= -1;
                } else if (label == TarAnimLeon) {
                    moveDirectionLeon *= -1;
                }
            }
            label.setLocation(x, y);
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
        
        
        private void moveToNextFrame() {
            stopSound(); // Detiene el audio antes de cerrar la ventana
            dispose(); // Cierra la ventana actual
            new cartVoltAveriguarTwo().setVisible(true); // Abre la siguiente ventana (asegúrate de reemplazar NextFrame con el nombre de tu siguiente JFrame)
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

        jPanel4 = new javax.swing.JPanel();
        InfTime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        InfTime1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        TarAnimPerro = new javax.swing.JLabel();
        TarAnimGato = new javax.swing.JLabel();
        TarAnimCerdo = new javax.swing.JLabel();
        TarAnimLeon = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(200, 81, 3));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        InfTime.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        InfTime.setForeground(new java.awt.Color(255, 255, 255));
        InfTime.setText("00:07");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(InfTime)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfTime, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 550));
        setMinimumSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 213, 129));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/BarraProgeso2.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 70));

        jPanel6.setBackground(new java.awt.Color(200, 81, 3));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        InfTime1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        InfTime1.setForeground(new java.awt.Color(255, 255, 255));
        InfTime1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/Video Cuenta atrás Moderno Animado Negro (1).gif"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(InfTime1)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(InfTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 360, 90));

        jPanel2.setBackground(new java.awt.Color(255, 213, 129));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 81, 3), 2, true));

        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/TitleLevelTwo.png"))); // NOI18N

        TarAnimPerro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botPerro.png"))); // NOI18N

        TarAnimGato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botGato.png"))); // NOI18N

        TarAnimCerdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botCerdo.png"))); // NOI18N

        TarAnimLeon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botLeon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(TarAnimPerro)
                        .addGap(18, 18, 18)
                        .addComponent(TarAnimGato, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TarAnimCerdo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TarAnimLeon, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TarAnimGato, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TarAnimLeon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(TarAnimCerdo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(TarAnimPerro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 96, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(LevelTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LevelTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LevelTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LevelTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LevelTwo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InfTime;
    private javax.swing.JLabel InfTime1;
    private javax.swing.JLabel TarAnimCerdo;
    private javax.swing.JLabel TarAnimGato;
    private javax.swing.JLabel TarAnimLeon;
    private javax.swing.JLabel TarAnimPerro;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
