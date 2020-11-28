/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pc-standard
 */
public class ProductView extends JFrame{
    
    private JTextField fieldStock;
    private JTextField fieldPrecio;
    private JTextField fieldName;
    private JTextField fieldFechaVencimiento;
    private JComboBox selectCategory;

    private JLabel labelName;
    private JLabel labelStock;
    private JLabel labelPrecio;
    private JLabel labelFechaVencimiento;

    private Container content;
    private JPanel mainPanel;
    private JButton buttonCreateProduct;
    
    public ProductView(){
        
        
        content = getContentPane();
        mainPanel = new JPanel(new GridLayout(5,2,3,3));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        buttonCreateProduct = new JButton("Crear Producto");
        labelName = new JLabel("Nombre del Producto");
        fieldName = new JTextField(10);
        
        labelPrecio = new JLabel("Precio");
        fieldPrecio = new JTextField(10);
        labelStock = new JLabel("Stock");
        fieldStock= new JTextField(10);
        
        
        labelFechaVencimiento = new JLabel("Fecha de Vencimiento");
        fieldFechaVencimiento = new JTextField(10);
        
        selectCategory = new JComboBox();
	selectCategory.addItem("Seleccionar Categoria");
	selectCategory.addItem("Categoria-1");
	selectCategory.addItem("Categoria-1");
        selectCategory.addItem("Categoria-3");
        

        
        mainPanel.add(labelName);
        mainPanel.add(fieldName);
        mainPanel.add(labelPrecio);
        mainPanel.add(fieldPrecio);
        
        mainPanel.add(labelStock);
        mainPanel.add(fieldStock);
        
               
        mainPanel.add(labelFechaVencimiento);
        mainPanel.add(fieldFechaVencimiento);
        
        
        mainPanel.add(buttonCreateProduct);
        content.add(mainPanel);
        setLocationRelativeTo(null);
        setTitle("Mini Market - Categoria de Producto");
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        ProductView app = new ProductView();
    }
    
}