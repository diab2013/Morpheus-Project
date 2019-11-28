/*
 * Project Miroir Magique
 * Projet qui contrôle le miroir magique
 * 2018 Étudiants de Collège de Bois-de-Boulogne
 */
package MiroirMagique;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.font.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore.Entry.Attribute;
import java.util.HashMap;

public class EcranDebut extends javax.swing.JFrame {

    //ArrayList des JLabels qui vont flasher
    private ArrayList<JLabel> listLabel = new ArrayList<>();
    
    //Variables pour la police spéciale (tailles différents)
    private Font fontSpecial32pt;
    private Font fontSpecial40pt;
    
    //Thread pour animer le texte

    private Thread flashText = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                for (int j = 0; j < listLabel.size(); j++) {
                    listLabel.get(j).setForeground(new Color(255, 0, 0));
                }
                try {
                    revalidate();
                    repaint();
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }
                try {
                    Thread.sleep(2200);
                } catch (InterruptedException ex) {
                }
                
                for (int j = 0; j < listLabel.size(); j++) {
                    listLabel.get(j).setForeground(new Color(0, 0, 0));
                }
                try {
                    revalidate();
                    repaint();
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }
                try {
                    Thread.sleep(1700);
                } catch (InterruptedException ex) {
                }
            }
        }
    });

    //Constructeur de l'écran
    public EcranDebut() throws FileNotFoundException, FontFormatException, IOException {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.requestFocus();

        //Création/Initialisation de la police spéciale (de tailles différents)
        File f = new File("C:/Users/Utilisateur/Documents/NetBeansProjects/MiroirMagique/special.ttf");
        FileInputStream is = new FileInputStream(f);
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, -0.2);
        Font fontSpecial = font.deriveFont(attributes);
        fontSpecial40pt = fontSpecial.deriveFont(40f);
        fontSpecial32pt = fontSpecial.deriveFont(32f);

        //Rendre la souris invisible
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0, 0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
        this.setCursor(invisibleCursor);

        initComponents();

        listLabel.add(jLabel1);
        listLabel.add(jLabel2);
        listLabel.add(jLabel3);
        listLabel.add(jLabel5);
        listLabel.add(jLabel6);

        //Mettre l'écran à taille plein pour couvrir l'écran au complet
        int xsize = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int ysize = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize(xsize, ysize);

        //Commence le thread pour animer le texte
        flashText.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 32767));
        jLabel6 = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 1600));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 1600));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(fontSpecial40pt);
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Accès au système de sécurité de détonateur");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(fontSpecial40pt);
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Access to the detonator security system");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(fontSpecial32pt);
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TEXT DE VOTRE CHOIX TEXTE DE VOTRE CHOIX");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(fontSpecial32pt);
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Avertissement - Warning");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(fontSpecial32pt);
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("121645615665.....1.5.1.651.6515165.1561");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(943, 943, 943)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(518, 518, 518)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGap(113, 113, 113)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(864, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Affiche le JFrame
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EcranDebut().setVisible(true);
                } catch (Exception ex) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
