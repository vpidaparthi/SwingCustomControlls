/*
 * DateTextBox
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

/**
 *
 * @author Arturo E. Salinas
 */
public class DateTextBox extends BaseTextBoxValidated {

    public DateTextBox() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
//                if(getText().length()+1 > getLength()) 
//                    e.consume();
                String regex = "^[0-9/]*$";
                if (!String.valueOf(e.getKeyChar()).matches(regex)) {
                    e.consume();
                }
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
//                if(isIsRequired() && getText().isEmpty())
//                {
//                    requestFocus();
//                    JOptionPane.showMessageDialog(getParent(), "Campo requerido!");                
//                }
                String regex = "(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[012])\\/(19|20)\\d\\d";
                if (getText().length() > getLength()) {
                    JOptionPane.showMessageDialog(getParent(), "Formato de fecha invalido!");
                    requestFocus();
                }

//                if(!getText().isEmpty() && !getText().matches(regex))
//                {
//                    JOptionPane.showMessageDialog(getParent(), "Formato de fecha invalido!");                
//                    requestFocus();
//                }
            }
        });
    }
}
