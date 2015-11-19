/*
 * BaseTextBox
 * Created on 17-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.swingcustomcontrolls;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Arturo E. Salinas
 */
public class BaseTextBoxValidated  extends JTextField{
    public int Length = Integer.MAX_VALUE;
    public String Regex="";
    public boolean IsRequired=false;    
    
    public BaseTextBoxValidated()
    {
         this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {  
                if(getText().length()+1 > getLength()) 
                    e.consume();                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });       
        
        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {                
                if(getText().length() > getLength()) 
                { 
                    JOptionPane.showMessageDialog(getParent(), "Formato invalido!");                
                    requestFocus();
                }
                 
                if(!Regex.isEmpty() &&  !getText().isEmpty() && !getText().matches(Regex) )
                {
                    JOptionPane.showMessageDialog(getParent(), "Formato invalido!");                
                    requestFocus();
                }   
                
                if(isIsRequired() && getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(getParent(), "Este campo es obligatorio, no puede estar vacio!");                
                    requestFocus();
                }                       
            }
        });
    }

    /**
     * @return the Length
     */
    public int getLength() {
        return Length;
    }

    /**
     * @param Length the Length to set
     */
    public void setLength(int Length) {
        this.Length = Length;
    }

    /**
     * @return the Regex
     */
    public String getRegex() {
        return Regex;
    }

    /**
     * @param Regex the Regex to set
     */
    public void setRegex(String Regex) {
        this.Regex = Regex;
    }

    /**
     * @return the IsRequired
     */
    public boolean isIsRequired() {
        return IsRequired;
    }

    /**
     * @param IsRequired the IsRequired to set
     */
    public void setIsRequired(boolean IsRequired) {
        this.IsRequired = IsRequired;
    }
   
}
