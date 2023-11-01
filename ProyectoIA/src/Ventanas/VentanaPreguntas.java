
package Ventanas;

import MAIN.FuzzyLogic;
import Reader.Pregunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;
import javax.swing.Timer;

public class VentanaPreguntas extends javax.swing.JFrame {
    
    int posicionPregunta = 0;
    String respuestaCorrecta;
    String respuesta;
    Timer timer;
    int second, minutes, hours;
    int contadorError = 0;
    int contadorAyuda = 0;
    Pregunta p = new Pregunta();
    ArrayList<String[]> pregunta = new ArrayList<String[]>();
    FuzzyLogic ff = new FuzzyLogic();
    public VentanaPreguntas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelpregunta = new javax.swing.JLabel();
        botonSiguiente = new javax.swing.JButton();
        botonAyuda = new javax.swing.JButton();
        tiempo = new javax.swing.JLabel();
        respuesta1 = new javax.swing.JRadioButton();
        respuesta2 = new javax.swing.JRadioButton();
        respuesta3 = new javax.swing.JRadioButton();
        respuesta4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonSiguiente.setText("SIGUIENTE");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonAyuda.setText("AYUDA");
        botonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaActionPerformed(evt);
            }
        });

        respuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta1ActionPerformed(evt);
            }
        });

        respuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta2ActionPerformed(evt);
            }
        });

        respuesta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta3ActionPerformed(evt);
            }
        });

        respuesta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(530, 530, 530)
                        .addComponent(botonSiguiente))
                    .addComponent(labelpregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(respuesta2)
                    .addComponent(respuesta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(respuesta3)
                        .addGap(442, 442, 442))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(respuesta4)
                        .addGap(452, 452, 452))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(labelpregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(respuesta1)
                    .addComponent(respuesta3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(respuesta2)
                    .addComponent(respuesta4))
                .addGap(69, 69, 69)
                .addComponent(botonAyuda)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(botonSiguiente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        try{
                second = 0;
                minutes = 0;
                hours = 0;
                respuesta1.setSelected(false);
                respuesta2.setSelected(false);
                respuesta3.setSelected(false);
                respuesta4.setSelected(false);
                
                System.out.println(pregunta.size());
                respuestaCorrecta = pregunta.get(posicionPregunta)[5];
                if(!(respuestaCorrecta.equals(respuesta))){
                    contadorError++;
                }
                else{
                    ArrayList<String[]> pC = ff.revisarNivel(p, minutes*60+second, contadorAyuda, contadorError);
                    pregunta.clear();
                    for(int i = 0; i<pC.size(); i++){
                        pregunta.add(pC.get(i));
                        
                    }
                        posicionPregunta++;
                        
                        setLabelText(pregunta.get(posicionPregunta)[0]); 
                        String r1 = pregunta.get(posicionPregunta)[1];
                        String r2 = pregunta.get(posicionPregunta)[2];
                        String r3 = pregunta.get(posicionPregunta)[3];
                        String r4 = pregunta.get(posicionPregunta)[4];
                        
                         
                        setCheckText(r1,r2,r3,r4);
                        
                        contadorAyuda = 0;
                        contadorError =0;
                        
                respuesta1.setVisible(true);
                respuesta2.setVisible(true);
                respuesta3.setVisible(true);
                respuesta4.setVisible(true);
                }
                
                
                
                
        }
        catch(IndexOutOfBoundsException x){
            posicionPregunta = 0;
            setLabelText(pregunta.get(posicionPregunta)[0]); 
                        String r1 = pregunta.get(posicionPregunta)[1];
                        String r2 = pregunta.get(posicionPregunta)[2];
                        String r3 = pregunta.get(posicionPregunta)[3];
                        String r4 = pregunta.get(posicionPregunta)[4];
                                
                        setCheckText(r1,r2,r3,r4);
                        respuesta1.setVisible(true);
                        respuesta2.setVisible(true);
                        respuesta3.setVisible(true);
                        respuesta4.setVisible(true);
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed
    public void iniciarTimer(){
        timer.start();
        
    }
    public void insertarRespuestaInicio(String respuestaCorrecta){
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public void inyeccionDatos(ArrayList<String[]> datos){
        for(String[] datosT:datos){
            this.pregunta.add(datosT);
        }
    }
    
    private void botonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaActionPerformed
        respuestaCorrecta = pregunta.get(posicionPregunta)[5];
        contadorAyuda ++;
        System.out.println(respuestaCorrecta);
        if(contadorAyuda < 4){
                   boolean termo = true;
        while(termo){
            int randomNumber = ThreadLocalRandom.current().nextInt(1,5);
            switch (randomNumber){
            
                case 1:
                    if (!(respuestaCorrecta.equals(respuesta1.getText())) && respuesta1.isVisible()){
                        respuesta1.setVisible(false);
                        termo = false;
                    }
                    break;
                case 2:
                    if (!(respuestaCorrecta.equals(respuesta2.getText())) && respuesta2.isVisible()){
                        respuesta2.setVisible(false);
                        termo = false;
                    }
                    break;
                
                case 3:
                    if (!(respuestaCorrecta.equals(respuesta3.getText())) && respuesta3.isVisible()){
                        respuesta3.setVisible(false);
                        termo = false;
                    }
                    break;
                case 4:
                    if (!(respuestaCorrecta.equals(respuesta4.getText())) && respuesta4.isVisible()){
                        respuesta4.setVisible(false);
                        termo = false;
                    }
                    break;
            }
            
            
        
        } 
        }

    }//GEN-LAST:event_botonAyudaActionPerformed

    private void respuesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta1ActionPerformed
        respuesta = respuesta1.getText();
        System.out.println("prueba jalando");
    }//GEN-LAST:event_respuesta1ActionPerformed

    private void respuesta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta2ActionPerformed
        respuesta = respuesta2.getText();        // TODO add your handling code here:
    }//GEN-LAST:event_respuesta2ActionPerformed

    private void respuesta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta3ActionPerformed
        respuesta = respuesta3.getText();
    }//GEN-LAST:event_respuesta3ActionPerformed

    private void respuesta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta4ActionPerformed
        respuesta = respuesta4.getText();
    }//GEN-LAST:event_respuesta4ActionPerformed
    public void setLabelText(String text){
        labelpregunta.setText(text);
    }
    public void setCheckText(String text1, String text2,String text3, String text4){
        respuesta1.setText(text1);
        respuesta2.setText(text2);
        respuesta3.setText(text3);
        respuesta4.setText(text4);
    }
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPreguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAyuda;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JLabel labelpregunta;
    private javax.swing.JRadioButton respuesta1;
    private javax.swing.JRadioButton respuesta2;
    private javax.swing.JRadioButton respuesta3;
    private javax.swing.JRadioButton respuesta4;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables

    public void Timer() {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second++;
				
				tiempo.setText(minutes+":"+second);
				
				if(second==60) {
					second = 0;
					minutes++;
					tiempo.setText(minutes+":"+second);
				}
				
				if(minutes == 60) {
					minutes = 0;
					hours++;
					tiempo.setText(hours+":"+minutes+":"+second);
				}
			}
		}); 
	}
}

