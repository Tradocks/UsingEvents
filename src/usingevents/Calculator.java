package usingevents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author oop
 */
public class Calculator extends JFrame 
{
    //--------------------------------------------------------------------------    
    public static int NUMBER=1;
    public static int OPERATOR=2;
    //--------------------------------------------------------------------------    
    private JLabel display;
    private JButton operator[];
    private JButton numbers[];   
    private JButton clear;
    private int previews;
    
    //--------------------------------------------------------------------------
    
    public Calculator()
    {
        super("Calculator");
        setSize(300,300);
        widgets();
        events();
        setVisible(true);                
    }
    
    //--------------------------------------------------------------------------
    
    private void widgets()
    {
        JPanel p = new JPanel(new GridLayout(4,4));
        display = new JLabel("0",JLabel.RIGHT);
        numbers = new JButton[10];
        for(int i=0; i<10; i++)
        {
            numbers[i]= new JButton(""+i);
        }
        operator = new JButton[5];
        String op[] = {"=","+","-","x","/"};
        for(int i=0; i<5; i++)
        {
            operator[i]= new JButton(op[i]);            
        }
        clear = new JButton("C");
        
        add(display,BorderLayout.NORTH);
        add(p,BorderLayout.CENTER);
        
        p.add(numbers[7]); p.add(numbers[8]); p.add(numbers[9]); p.add(operator[1]);
        p.add(numbers[4]); p.add(numbers[5]); p.add(numbers[6]); p.add(operator[2]);
        p.add(numbers[1]); p.add(numbers[2]); p.add(numbers[3]); p.add(operator[3]);
        p.add(numbers[0]); p.add(clear); p.add(operator[0]); p.add(operator[4]);
    }
    
    //--------------------------------------------------------------------------
    
    private void events()
    {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);               
            }
        });
        //----------------------------------------------------------------------
        for(int i=0; i<10; i++)
        {
            numbers[i].addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   if(previews==NUMBER)
                   {
                       display.setText(display.getText()+e.getActionCommand());
                   }
                   else
                   {
                       display.setText(e.getActionCommand());
                       previews=NUMBER;
                   }
               }
            });            
        }
        //----------------------------------------------------------------------
        for(int i=0; i<5; i++)
        {
            operator[i].addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   previews=OPERATOR;
               }
            });            
        }
    }
    
    //--------------------------------------------------------------------------
    
    public static void main(String[] args) 
    {
        new Calculator();
    }
}
