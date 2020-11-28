/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pc-standard
 */
public class LoginView extends JFrame{
    
    private String password;
    private String username;
    private JLabel labelUser;
    private JLabel labelPass;
    private JLabel labelRol;
    private JTextField fieldUser;
    private JPasswordField fieldPass;
    private Container content;
    private JPanel mainPanel;
    private JButton buttonSubmit;
    private JComboBox fieldRol;
    private JLabel labelError;
    private JLabel logoType;
    private JLabel title;
    

    public LoginView(){
        
        
        logoType = Resource.CreateImageLabel();
        title = new JLabel("Mini Market - Inicio de sesion");
        title.setForeground(Color.BLUE);
        title.setSize(30, 400);
        content = getContentPane();
        
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        labelRol = new JLabel("Rol");
        fieldRol = new JComboBox();
	fieldRol.addItem("Seleccionar rol");
	fieldRol.addItem("Administrador");
	fieldRol.addItem("Vendedor");
        fieldRol.addItem("Cliente");
        
        labelError = new JLabel();
        
        buttonSubmit = new JButton("Iniciar sesion");
        labelUser = new JLabel("Nombre de usuario");
        fieldUser = new JTextField(10);
  
        labelPass = new JLabel("Contraseña");
        fieldPass= new JPasswordField(10);

        mainPanel.add(logoType);
        mainPanel.add(title);
        mainPanel.add(labelUser);
        mainPanel.add(fieldUser);

        mainPanel.add(labelPass);
        mainPanel.add(fieldPass);
        
        mainPanel.add(labelRol);
        mainPanel.add(fieldRol);
        mainPanel.add(buttonSubmit);
        mainPanel.add(labelError);
        labelError.setForeground(Color.red);

        
        content.add(mainPanel);
        setLocationRelativeTo(null);
        setTitle("Mini Market - Inicio de sesion");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setLabelError(String labelError) {
        this.labelError.setText(labelError);
    }

    public JTextField getFieldUser() {
        return fieldUser;
    }

    public JPasswordField getFieldPass() {
        return fieldPass;
    }

    public JComboBox getFieldRol() {
        return fieldRol;
    }
    
      public JButton getButtonSubmit(){
        return buttonSubmit;
    }
    
    
}


