
package com.LevelTwo.AnterisTwo;

import com.LevelOne.LevelOne;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.Timer;


/**
 *
 * @author Daniusw, Dieguito, Denilson, El nero
 */
public class CorrectoAnimals extends javax.swing.JFrame {

     private static final int DELAY = 7000; // Duración en milisegundos 
    private Timer timer;
    
    private Clip audioClip; // Variable para el audio
    
    private JButton cartaAleatoria; // Variable para almacenar la carta aleatoria de cartVoltAveriguar 
    private JButton perro;
    private JButton gato;
    private JButton cerdo;
    private JButton leon;
    
    public CorrectoAnimals(JButton cartaAleatoria, JButton p, JButton g, JButton c, JButton l) {
        this.cartaAleatoria = cartaAleatoria;
        perro = p;
        gato = g;
        cerdo = c;
        leon = l;
        
        initComponents();
        startTimer();
        //playSound(); // Reproduce el audio al iniciar
        playSoundWithReducedVolume(); // Reproduce el audio al iniciar con volumen reducido
    }
    
    //metodos control
    //agregado
    private void startTimer() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Detiene el temporizador
                stopSound(); // Detiene el audio
                ensenarAnimalEnIngles(); // Llama al método para mover a la siguiente ventana
            }
        });
        timer.setRepeats(false); // El temporizador no se repite
        timer.start(); // Inicia el temporizador
    }
   
    // 
    private void ensenarAnimalEnIngles() {
        stopSound();
        if (cartaAleatoria == perro)
            new com.LevelTwo.Respuestas_Animals.Perro_english().setVisible(true);
        if (cartaAleatoria == gato) 
            new com.LevelTwo.Respuestas_Animals.Gato_english().setVisible(true);
        if (cartaAleatoria == cerdo) 
            new com.LevelTwo.Respuestas_Animals.Cerdo_english().setVisible(true);
        if (cartaAleatoria == leon) 
            new com.LevelTwo.Respuestas_Animals.Leon_english().setVisible(true);
        dispose();
    }

    /*private void playSound() {
        sound = java.applet.Applet.newAudioClip(getClass().getResource("audiosAnterisOne/AudioFelicitacionAcierto.wav"));
        sound.play();
    }*/

    private void stopSound() {
        if (audioClip != null) {
            audioClip.stop();
        }
    }
    
    
    //metodo para reducir el sonido
    private void playSoundWithReducedVolume() {
        try {
            File audioFile = new File(getClass().getResource("audiosAnterisTwo/AudioFelicitacionAcierto.wav").getFile());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);

            // Reduce el volumen al 75% del original
            FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
            float min = volumeControl.getMinimum();
            float max = volumeControl.getMaximum();
            float volume = (max - min) * 0.75f + min;
            volumeControl.setValue(volume);

            audioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 113));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 113));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 550));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/MENSAJEALIENTOCORRECTO.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 350));

        jPanel3.setBackground(new java.awt.Color(255, 204, 113));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 180, 550));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gifs/GIF_LOGRO.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 440, 310));

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
