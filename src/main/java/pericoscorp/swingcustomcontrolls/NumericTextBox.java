/* 
     * NumericTextBox
     * Created on 05-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.swingcustomcontrolls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Arturo E. Salinas
 * @see This control allow only numeric, "." and "," chars
 */
public class NumericTextBox extends JFormattedTextField{
    public NumericTextBox()
    {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {                
                String regex ="^[0-9.]*$";
                if(!String.valueOf(e.getKeyChar()).matches(regex) || (".".equals(String.valueOf(e.getKeyChar())) &&  getText().indexOf(".")>0))
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });        
    }
    
}
