/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revised_movielist;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Ed
 */
public class Revised_MovieList 
{
    /**
     * @param args the command line arguments
     */
    
    private JFrame f;
    private JPanel p;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JLabel lab;
    
    public Revised_MovieList()
    {
        gui();
    }
    
    public void gui()
    {
        f = new JFrame("Your Movie List");
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel(new GridBagLayout());
        //p.setBackground(Color.YELLOW);
        
        b1 = new JButton("Button No.1");
        b2 = new JButton("Button No.2");
        b3 = new JButton("Button No.3");
        b4 = new JButton("Button No.4");
        b5 = new JButton("Button No.5");
        //lab = new JLabel("This is test label");
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        p.add(b1,c);
        //p.add(lab);
        c.gridx = 0;
        c.gridy = 2;
        p.add(b2,c);
        c.gridx = 0;
        c.gridy = 3;
        p.add(b3,c);
        c.gridx = 0;
        c.gridy = 4;
        p.add(b4,c);
        c.gridx = 0;
        c.gridy = 5;
        p.add(b5,c);
        
        //f.add(p, BorderLayout.NORTH);
        f.add(p, BorderLayout.WEST);
    }
    
    public static void main(String[] args) 
    {
        new Revised_MovieList();
    }
    
}
