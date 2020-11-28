/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author pc-standard
 */
public class Resource {
    
    public static JLabel CreateImageLabel(){
         Icon image = new ImageIcon("/home/pc-standard/Descargas/logo-tienda.png");
         JLabel label = new JLabel();
         label.setIcon(image);
         return label;
    }
}
