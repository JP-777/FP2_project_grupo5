
package com.LevelOne;

import com.LevelOne.Anteris.TimeAgotadoColors;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class cartVoltAveriguar extends javax.swing.JFrame {

    //agregando
    private static final int DELAY = 15000; // Duración en milisegundos 
    private Timer timer;
    
    private AudioClip sound; // Variable para el audio
    
    // Variable para el temporizador del tiempo restante
    private Timer countdownTimer;
    private int remainingTime = DELAY / 1000; // Tiempo restante en segundos
    
    // para jugabilidad de adivinar
    private JButton[] cartas;
    private JButton cartaAleatoria;   
    private boolean cartaSeleccionada = false; // Para verificar si se ha seleccionado una carta
    
    
    public cartVoltAveriguar() {
        initComponents();
        startTimer();
        playSound(); // Reproduce el audio al iniciar
        startCountdownTimer(); // Inicia el temporizador para la cuenta regresiva
        configurarCartas(); // acciones de eventos de las cartas (para adivinar)
    }
    
    private void startCountdownTimer() {
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (remainingTime > 0) {
                    remainingTime--;
                    int minutes = remainingTime / 60;
                    int seconds = remainingTime % 60;
                    InfTime.setText(String.format("%02d:%02d", minutes, seconds));
                } else {
                    countdownTimer.stop();
                    /*evitar doble frame
                    if (!cartaSeleccionada){
                        moveToNextFrame(); // Mueve al frame de tiempo agotado si no se ha seleccionado ninguna carta
                    }
                    */
                }
            }
        });
        countdownTimer.start();
    }
    
    //agregado
    private void startTimer() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Detiene el temporizador
                if (!cartaSeleccionada) {
                    moveToNextFrame(); // Mueve al frame de tiempo agotado si no se ha seleccionado ninguna carta
                }
            }
        });
        timer.setRepeats(false); // El temporizador no se repite
        timer.start(); // Inicia el temporizador
    }
        
    // añadido sistema de juego adivinar
    private void configurarCartas() {
        // arreglo de botones de colores
        cartas = new JButton[]{botCartBlue, botCartGreen, botCartYellow, botCartRed};
        for (JButton carta : cartas) {
            carta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cartaSeleccionada = true; // una carta ha sido escogida
                    // cada carta(boton) se verificará al ser presionada
                    verificarAdivinanza(carta);
                }
            });
        }
        mostrarCartaAleatoria(); 
    }
    
    // oculta las cartas
    private void voltearCartas() { 
        for (JButton carta : cartas) {
            carta.setIcon(new ImageIcon(getClass().getResource("/com/images/reversoCartas.png")));
        }
    }
    
    // carta aleatorio para ser adivinada
    private void mostrarCartaAleatoria() {
        int indiceAleatorio = new Random().nextInt(cartas.length);
        cartaAleatoria = cartas[indiceAleatorio];
        
        // jLabel carta para adivinar
        String[] colores = {"Blue", "Green", "Yellow", "Red"};
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/images/color" + colores[indiceAleatorio] + ".png")));
    }
    
    // verificar si se escogio el color correcto
    private void verificarAdivinanza(JButton carta) {
        if (carta == cartaAleatoria) {
            new com.LevelOne.Anteris.CorrectoColor().setVisible(true); // Abre el frame de carta correcta
            enseñarColorEnIngles(carta);
        } else {
            new com.LevelOne.Anteris.ErrorColors().setVisible(true); // Abre el frame de carta incorrecta
            enseñarColorEnIngles(carta);
        }
        dispose(); // Cierra la ventana actual
    }
    
    // ejecutar frame de color correcto (enseñar en ingles)
    private void enseñarColorEnIngles(JButton carta) {
        if (carta == botCartBlue)
            new com.LevelOne.Respuestas.Blue_english().setVisible(true);
        if (carta == botCartGreen) 
            new com.LevelOne.Respuestas.Green_english().setVisible(true);
        if (carta == botCartYellow) 
            new com.LevelOne.Respuestas.Red_english().setVisible(true);
        if (carta == botCartRed) 
            new com.LevelOne.Respuestas.Yellow_english().setVisible(true);
        dispose();
    }
    
    private void moveToNextFrame() {
        stopSound(); // Detiene el audio antes de cerrar la ventana
        dispose(); // Cierra la ventana actual
        new TimeAgotadoColors().setVisible(true); // Abre la siguiente ventana
    }

    private void playSound() {
        sound = java.applet.Applet.newAudioClip(getClass().getResource("../audios/EsperaMusica_1.wav"));
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
        InfTimeCuestios = new javax.swing.JPanel();
        InfTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botCartYellow = new javax.swing.JButton();
        botCartRed = new javax.swing.JButton();
        botCartBlue = new javax.swing.JButton();
        botCartGreen = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 113));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfTimeCuestios.setBackground(new java.awt.Color(200, 81, 3));
        InfTimeCuestios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        InfTimeCuestios.setForeground(new java.awt.Color(255, 255, 255));

        InfTime.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        InfTime.setForeground(new java.awt.Color(255, 255, 255));
        InfTime.setText("00:15");

        javax.swing.GroupLayout InfTimeCuestiosLayout = new javax.swing.GroupLayout(InfTimeCuestios);
        InfTimeCuestios.setLayout(InfTimeCuestiosLayout);
        InfTimeCuestiosLayout.setHorizontalGroup(
            InfTimeCuestiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfTimeCuestiosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(InfTime)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        InfTimeCuestiosLayout.setVerticalGroup(
            InfTimeCuestiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfTimeCuestiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfTime, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(InfTimeCuestios, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 51, 0), 1, true));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 190, 240));

        jPanel2.setBackground(new java.awt.Color(255, 213, 129));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 81, 3), 2, true));

        botCartYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCartYellow.setBorder(null);
        botCartYellow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botCartYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCartYellowActionPerformed(evt);
            }
        });

        botCartRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCartRed.setBorder(null);
        botCartRed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botCartRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCartRedActionPerformed(evt);
            }
        });

        botCartBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCartBlue.setBorder(null);
        botCartBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botCartBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCartBlueActionPerformed(evt);
            }
        });

        botCartGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCartGreen.setBorder(null);
        botCartGreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botCartGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCartGreenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botCartYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botCartBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botCartRed, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botCartGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botCartYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCartBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCartRed, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCartGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 108, 890, 390));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/NewBarraProgres (2).gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 70));

        jPanel3.setBackground(new java.awt.Color(200, 81, 3));

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¿DÓNDE ESTABA ESTA FIGURITA?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 400, 70));

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

    private void botCartGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCartGreenActionPerformed
        stopSound();
    }//GEN-LAST:event_botCartGreenActionPerformed

    private void botCartYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCartYellowActionPerformed
        stopSound();
    }//GEN-LAST:event_botCartYellowActionPerformed

    private void botCartRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCartRedActionPerformed
        stopSound();    
    }//GEN-LAST:event_botCartRedActionPerformed

    private void botCartBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCartBlueActionPerformed
        stopSound();
    }//GEN-LAST:event_botCartBlueActionPerformed

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
            java.util.logging.Logger.getLogger(cartVoltAveriguar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cartVoltAveriguar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cartVoltAveriguar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cartVoltAveriguar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cartVoltAveriguar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InfTime;
    private javax.swing.JPanel InfTimeCuestios;
    private javax.swing.JButton botCartBlue;
    private javax.swing.JButton botCartGreen;
    private javax.swing.JButton botCartRed;
    private javax.swing.JButton botCartYellow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
