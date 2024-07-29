/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.LevelThree;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Daniusw
 */
public class LevelThree extends javax.swing.JFrame {

    //agregando
    private static final int DELAY = 7000; // Duración en milisegundos 
    private Timer timer;
    
    private AudioClip sound; // Variable para el audio
    
    // Variables para el movimiento del jLabel Title
    private Timer moveTimerTitleNumbers;
    private int moveDirectionTitleNumbers = 1;
    private static final int MOVE_AMOUNT_TITLE_NUMBERS = 4; // Cantidad de movimiento en píxeles
    private static final int MOVE_DELAY_TITLE_NUMBERS = 50; // Retardo en milisegundos para el movimiento suave
    private static final int MOVE_LIMIT_TITLE_NUMBERS = 140; // Límite de movimiento desde el borde del jPanel2
    
    // Variables para el movimiento de los TarColor
    private Timer moveTimerNumber;
    private int moveDirectionOne = -1;
    private int moveDirectionTwo = -1;
    private int moveDirectionThree = 1;
    private int moveDirectionFour= 1;
    private static final int MOVE_AMOUNT = 4; // Cantidad de movimiento en píxeles
    private static final int MOVE_DELAY = 50; // Retardo en milisegundos para el movimiento suave
    private static final int MOVE_LIMIT = 38; // Límite de movimiento desde el borde del jPanel2
    
    
    public LevelThree() {
        initComponents();
        playSound();
        startTimer();
        startMoveTimerNumber();
        startMoveTimerTitleNumber();
    }
    

    /// Movimiento de jLabel Title
    private void startMoveTimerTitleNumber() {
        moveTimerTitleNumbers = new Timer(MOVE_DELAY_TITLE_NUMBERS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = TitleNumbers.getLocation().x;
                int y = TitleNumbers.getLocation().y;
                x += MOVE_AMOUNT_TITLE_NUMBERS * moveDirectionTitleNumbers;

                // Cambia la dirección si alcanza los límites
                if (x < MOVE_LIMIT_TITLE_NUMBERS || x + TitleNumbers.getWidth() > jPanel2.getWidth() - MOVE_LIMIT_TITLE_NUMBERS) {
                    moveDirectionTitleNumbers *= -1;
                    x += MOVE_AMOUNT_TITLE_NUMBERS * moveDirectionTitleNumbers;
                }
                TitleNumbers.setLocation(x, y);
            }
        });
        moveTimerTitleNumbers.start(); // Inicia el temporizador de movimiento
    }

    // Movimiento de los TarNumber
    private void startMoveTimerNumber() {
        moveTimerNumber = new Timer(MOVE_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLabel(TarNumberOne, moveDirectionOne);
                moveLabel(TarNumberTwo, moveDirectionTwo);
                moveLabel(TarNumberThree, moveDirectionThree);
                moveLabel(TarNumberFour, moveDirectionFour);
            }
        });
        moveTimerNumber.start(); // Inicia el temporizador de movimiento
    }

    private void moveLabel(javax.swing.JLabel label, int direction) {
        int x = label.getLocation().x;
        int y = label.getLocation().y;
        y += MOVE_AMOUNT * direction;

        // Cambia la dirección si alcanza los límites
        if (y < MOVE_LIMIT || y + label.getHeight() > jPanel2.getHeight() - MOVE_LIMIT) {
            if (label == TarNumberOne) {
                moveDirectionOne *= -1;
            } else if (label == TarNumberTwo) {
                moveDirectionTwo *= -1;
            } else if (label == TarNumberThree) {
                moveDirectionThree *= -1;
            } else if (label == TarNumberFour) {
                moveDirectionFour *= -1;
            }
        }
        label.setLocation(x, y);
    }

    // Inicializar el temporizador principal
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

    // Mover a la siguiente ventana
    private void moveToNextFrame() {
        stopSound(); // Detiene el audio antes de cerrar la ventana
        dispose(); // Cierra la ventana actual
        new cartVoltAveriguarThree().setVisible(true); // Abre la siguiente ventana
    }

    // Reproducir sonido
    private void playSound() {
        sound = java.applet.Applet.newAudioClip(getClass().getResource("../audios/LevelsSuspenso.wav"));
        sound.play();
    }

    // Detener sonido
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
        InfTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TitleNumbers = new javax.swing.JLabel();
        TarNumberOne = new javax.swing.JLabel();
        TarNumberTwo = new javax.swing.JLabel();
        TarNumberThree = new javax.swing.JLabel();
        TarNumberFour = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 550));
        setMinimumSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 204, 113));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(200, 81, 3));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        InfTime.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        InfTime.setForeground(new java.awt.Color(255, 255, 255));
        InfTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/Video Cuenta atrás Moderno Animado Negro (1).gif"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(InfTime)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(InfTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 360, 90));

        jPanel2.setBackground(new java.awt.Color(255, 213, 129));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 81, 3), 3, true));

        TitleNumbers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/TtitleLevelThree.png"))); // NOI18N
        TitleNumbers.setPreferredSize(new java.awt.Dimension(520, 52));

        TarNumberOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botOne.png"))); // NOI18N

        TarNumberTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botFour.png"))); // NOI18N

        TarNumberThree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botTwo.png"))); // NOI18N

        TarNumberFour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/botThree.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(TitleNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TarNumberOne, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TarNumberThree, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TarNumberFour, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TarNumberTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(TitleNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TarNumberOne, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TarNumberFour, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TarNumberTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TarNumberThree, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 880, 370));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/BarraProgreso3 (1).gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(LevelThree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LevelThree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LevelThree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LevelThree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LevelThree().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InfTime;
    private javax.swing.JLabel TarNumberFour;
    private javax.swing.JLabel TarNumberOne;
    private javax.swing.JLabel TarNumberThree;
    private javax.swing.JLabel TarNumberTwo;
    private javax.swing.JLabel TitleNumbers;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
