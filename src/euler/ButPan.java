/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class ButPan extends JPanel implements ActionListener
{
 private JButton jbt1,jbt2;
 PaintGraph pg;
 public void actionPerformed(ActionEvent e)
 {
  if (e.getSource().equals(jbt1))
  {
   if( pg.getNy()== 5 ) jbt2.setEnabled( true );
   pg.setNy(pg.getNy() + 5);
   pg.repaint();
  }
  if (e.getSource().equals(jbt2))
  {
   pg.setNy(pg.getNy() - 5);
   pg.repaint();
   if(pg.getNy() == 5) jbt2.setEnabled(false);
  }
 }
 public ButPan(PaintGraph p)
 {
  setLayout(new GridLayout(8,1));// Установка табличного менеджера размещения
  pg=p ;
  jbt1 = new JButton("Scale -");
  jbt2 = new JButton("Scale +");
  jbt1.addActionListener(this);
  jbt2.addActionListener(this);
  add(jbt1);
  add(jbt2);
 }
}

