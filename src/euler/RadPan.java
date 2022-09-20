/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author andre {

 */

public class RadPan extends JPanel implements ActionListener
{

 private final JRadioButton jrb4,jrb5;
 private ButtonGroup bg;
 PaintGraph pg;
 public void actionPerformed(ActionEvent e){
// Проверяется источник генерации события, и в зависимости от него задается вид 
// графика функции
  
  if (e.getSource()==jrb4) {
   pg.setSw(4);
   pg.repaint();
  }
  
  if (e.getSource()==jrb5) {
   pg.setSw(5);
   pg.repaint();
  }
  
 }
 public RadPan(PaintGraph p)
 {
  setLayout(new FlowLayout());
  pg=p ;
 jrb4 = new JRadioButton("Прямая Эйлера",false);
  jrb5 = new JRadioButton("Прямая Эйлера2",false);
  jrb4.addActionListener(this);
  jrb5.addActionListener(this);
  bg = new ButtonGroup();
  bg.add(jrb4); bg.add(jrb5);
 add(jrb4); add(jrb5);
 }
}

