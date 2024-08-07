/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.LevelOne.Anteris;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author Daniusw, Dieguito, Denilson, El nero
 */
public class ErrorColors extends javax.swing.JFrame {

    //agregando
    private static final int DELAY = 7000; // Duración en milisegundos 
    private Timer timer;
    
    private AudioClip sound; // Variable para el audio
    
    private JButton cartaAleatoria; // Variable para almacenar la carta aleatoria de cartVoltAveriguar 
    private JButton yellow;
    private JButton blue;
    private JButton red;
    private JButton green;
    
    public ErrorColors(JButton cartaAleatoria, JButton y, JButton b, JButton r, JButton g) {
        this.cartaAleatoria = cartaAleatoria;
        yellow = y;
        blue = b;
        red = r;
        green = g;
        
        initComponents();
        
        MostrarCartaCorrecta.setIcon(cartaAleatoria.getIcon());
                
        startTimer();
        playSound(); // Reproduce el audio al iniciar
    }
    
    //metodos
    //agregado
    private void startTimer() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Detiene el temporizador
                ensenarColorEnIngles(); // Llama al método para mover a la siguiente ventana
            }
        });
        timer.setRepeats(false); // El temporizador no se repite
        timer.start(); // Inicia el temporizador
    }
        
        
    // 
    private void ensenarColorEnIngles() {
        stopSound();
        if (cartaAleatoria == yellow)
            new com.LevelOne.Respuestas.Yellow_english().setVisible(true);
        if (cartaAleatoria == blue) 
            new com.LevelOne.Respuestas.Blue_english().setVisible(true);
        if (cartaAleatoria == red) 
            new com.LevelOne.Respuestas.Red_english().setVisible(true);
        if (cartaAleatoria == green) 
            new com.LevelOne.Respuestas.Green_english().setVisible(true);
        dispose();
    }

    private void playSound() {
        sound = java.applet.Applet.newAudioClip(getClass().getResource("audiosAnterisOne/AudioErrorAcierto.wav"));
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
        MostrarCartaCorrecta = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 113));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MostrarCartaCorrecta.setToolTipText("");
        MostrarCartaCorrecta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        jPanel1.add(MostrarCartaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 185, 263));

        jPanel3.setBackground(new java.awt.Color(255, 204, 113));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        jPanel2.setBackground(new java.awt.Color(200, 81, 3));

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("\"ESTA ERA LA CARTA CORRECTA\"");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 490, 80));

        jLabel6.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/Alentando_uffError.gif"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 350));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MostrarCartaCorrecta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
