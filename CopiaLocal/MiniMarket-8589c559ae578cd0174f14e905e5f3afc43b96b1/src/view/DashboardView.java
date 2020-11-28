/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pc-standard
 */
public class DashboardView extends JFrame{
    
    
    private Container content;
    private JPanel mainPanel;
    private JPanel menuPanel;
    
    public DashboardView(){
        
        
        
        content = getContentPane();
        mainPanel = new JPanel();
        menuPanel = new JPanel();
        
        menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS));
        mainPanel.setLayout(new BorderLayout());
        
        menuPanel.add(new JLabel("0-"));
        menuPanel.add(new JLabel("Producto"));
        
        menuPanel.add(new JLabel("0-"));
        menuPanel.add(new JLabel("Producto"));
        
        menuPanel.setBackground(Color.red);
        mainPanel.add(menuPanel,BorderLayout.WEST);
        content.add(mainPanel);
        setTitle("Mini Market -");
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    
    public static void main(String[] args) {
        DashboardView app = new DashboardView();
    }
    
}
