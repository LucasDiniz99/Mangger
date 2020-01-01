/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public interface Gerenciavel {
    public void viewSetVisibility(boolean value);
    public JPanel getView();
    public void viewSetSize(Dimension d);
    public void viewRestart();
    public Dimension viewGetSize();
}
