/*
 * BaseListBoxValidated
 * Created on 23-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.swingcustomcontrolls;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Arturo E. Salinas
 */
public class BaseListBoxValidated extends JList<Object> {
    public boolean isRequired;

    /**
     * @return the isRequired
     */
    public boolean isIsRequired() {
        return isRequired;
    }

    /**
     * @param isRequired the isRequired to set
     */
    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }
    
    public BaseListBoxValidated()
    {
        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {                
                if(getSelectedIndex()==-1) 
                { 
                    JOptionPane.showMessageDialog(getParent(), "Este campo es obligatorio, no puede estar vacio!");                
                    requestFocus();
                }
            }
        });
    }
}
