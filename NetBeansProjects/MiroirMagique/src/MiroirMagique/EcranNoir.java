/*
 * Project Miroir Magique
 * Projet qui contrôle le miroir magique
 * 2018 Étudiants de Collège de Bois-de-Boulogne
 */
package MiroirMagique;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * Cette classe crée un JFrame tout noir pour le début du jeu
 */
public class EcranNoir extends JFrame{

    public EcranNoir() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.requestFocus();
        
        //Initialise le JPanel noir qui est affiché
        JPanel jPanel1 = new JPanel();
        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 1600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 1600));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 1600));
        
        //Rendre la souris invisible
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0, 0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
        this.setCursor(invisibleCursor);
        
        //Mettre l'écran à taille plein pour couvrir l'écran au complet
        int xsize = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int ysize = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        this.add(jPanel1);
    }
}
