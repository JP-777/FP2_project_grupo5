
package com.LevelTwo;

import com.LevelOne.NextFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.Clip;


public class cartVoltAveriguarTwo extends javax.swing.JFrame {

    //agregando
    private static final int DELAY = 15000; // Duración en milisegundos 
    private Timer timer;
    
    private Clip clip; // Variable para el audio
    
    // Variable para el temporizador del tiempo restante
    private Timer countdownTimer;
    private int remainingTime = DELAY / 1000; // Tiempo restante en segundos
    
    // para jugabilidad de adivinar
    private JButton[] cartas;
    private JButton cartaAleatoria;   
    private boolean cartaSeleccionada = false; // Para verificar si se ha seleccionado una carta
    
    public cartVoltAveriguarTwo() {
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
        // arreglo de botones de animales
        cartas = new JButton[]{botCardPerro, botCardGato, botCardCerdo, botCardLeon};
        for (JButton carta : cartas) {
            carta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cartaSeleccionada = true; // una carta ha sido escogida
                    stopSound();
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
        String[] animales = {"Perro", "Gato", "Cerdo", "Leon"};
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/com/images/bot" + animales[indiceAleatorio] + ".png")));
    }
    
    // verificar si se escogio el animal correcto
    private void verificarAdivinanza(JButton carta) {
        if (carta == cartaAleatoria) {
            new com.LevelTwo.AnterisTwo.CorrectoAnimals(cartaAleatoria, botCardPerro, botCardGato, botCardCerdo, botCardLeon).setVisible(true); // Abre el frame de carta correcta
        } else {
            new com.LevelTwo.AnterisTwo.ErrorAnimals(cartaAleatoria, botCardPerro, botCardGato, botCardCerdo, botCardLeon).setVisible(true); // Abre el frame de carta incorrecta
        }
        dispose(); // Cierra la ventana actual
    }
    
    private void moveToNextFrame() {
        stopSound(); // Detiene el audio antes de cerrar la ventana
        dispose(); // Cierra la ventana actual
        new com.LevelTwo.AnterisTwo.TimeAgotadoAnimals(cartaAleatoria, botCardPerro, botCardGato, botCardCerdo, botCardLeon).setVisible(true); // Abre la siguiente ventana (asegúrate de reemplazar NextFrame con el nombre de tu siguiente JFrame)
    }

    private void playSound() {
            try {
                URL soundURL = getClass().getResource("../audios/LevelsSuspenso.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
                clip = AudioSystem.getClip();
                clip.open(audioStream);

                // Reducir el volumen a la mitad
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-15.0f); // Ajusta el valor según tus necesidades

                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }

        private void stopSound() {
            if (clip != null) {
            clip.stop();
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botCardPerro = new javax.swing.JButton();
        botCardCerdo = new javax.swing.JButton();
        botCardGato = new javax.swing.JButton();
        botCardLeon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 113));
        jPanel1.setForeground(new java.awt.Color(255, 213, 129));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 550));
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

        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 190, 260));

        jPanel2.setBackground(new java.awt.Color(255, 213, 129));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 81, 3), 2, true));

        botCardPerro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCardPerro.setBorder(null);
        botCardPerro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botCardPerro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCardPerroActionPerformed(evt);
            }
        });

        botCardCerdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCardCerdo.setBorder(null);
        botCardCerdo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botCardGato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCardGato.setBorder(null);
        botCardGato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        botCardLeon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/reversoCartas.png"))); // NOI18N
        botCardLeon.setBorder(null);
        botCardLeon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botCardLeon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCardLeonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(botCardPerro, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botCardGato, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botCardCerdo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botCardLeon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botCardPerro, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCardCerdo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCardGato, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botCardLeon, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 108, 890, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/BarraProgeso2.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 70));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botCardLeonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCardLeonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botCardLeonActionPerformed

    private void botCardPerroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCardPerroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botCardPerroActionPerformed

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
            java.util.logging.Logger.getLogger(cartVoltAveriguarTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cartVoltAveriguarTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cartVoltAveriguarTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cartVoltAveriguarTwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cartVoltAveriguarTwo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InfTime;
    private javax.swing.JPanel InfTimeCuestios;
    private javax.swing.JButton botCardCerdo;
    private javax.swing.JButton botCardGato;
    private javax.swing.JButton botCardLeon;
    private javax.swing.JButton botCardPerro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
