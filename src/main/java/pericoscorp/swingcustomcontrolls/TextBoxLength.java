/* 
     * TextBoxLength
     * Created on 05-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.swingcustomcontrolls;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author Arturo E. Salinas
 */
public class TextBoxLength extends JTextField {
    private int length=Integer.MAX_VALUE;

    public TextBoxLength() {
        this.addKeyListener(new KeyListener() { 
            @Override
            public void keyTyped(KeyEvent event) {                 
                if(getText().length()+1 > length) 
                    event.consume();
            }

            @Override
            public void keyReleased(KeyEvent event) {
                
            }

            @Override
            public void keyPressed(KeyEvent event) {
               
                
            }
        });
        
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().length()>length)                                    
                    setText(getText().substring(0, length));
            }
        });
    }
    
    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }
}
