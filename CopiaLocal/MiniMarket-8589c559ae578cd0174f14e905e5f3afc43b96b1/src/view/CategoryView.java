/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pc-standard
 */
public class CategoryView extends JFrame{
    
    private JTextField fieldName;
    private JTextField  fieldIva;
    private JLabel labelName;
    private JLabel labelIva;
    private Container content;
    private JPanel mainPanel;
    private JButton buttonCreateCategory;
    public static void main(String[] args) {
        CategoryView init = new CategoryView();
    }
    
    public CategoryView(){
        
        
        content = getContentPane();
        mainPanel = new JPanel();
        
        buttonCreateCategory = new JButton("Crear Categoria");
        labelName = new JLabel("Nombre de la categoria");
        labelIva = new JLabel("Iva");
        fieldName = new JTextField(10);
        fieldIva = new JTextField(10);
        
        mainPanel.add(labelName);
        mainPanel.add(fieldName);
        mainPanel.add(labelIva); 
        mainPanel.add(fieldIva);
        mainPanel.add(buttonCreateCategory);
        content.add(mainPanel);
        setLocationRelativeTo(null);
        setTitle("Mini Market - Categoria de Producto");
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}


