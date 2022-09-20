/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author andre
 */
public class Pan extends JPanel implements ActionListener
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
 public Pan(PaintGraph p)
 {
  setLayout(new GridLayout(8,1));// Установка табличного менеджера размещения
  pg=p ;
  jbt1 = new JButton("Scale -");
  jbt2 = new JButton("Scale +");
  jbt1.addActionListener(this);
  jbt2.addActionListener(this);
  add(jbt1);
  add(jbt2);

  setLayout(new FlowLayout());
  pg=p ;
 jrb4 = new JRadioButton("Прямая Эйлера",false);
  jrb5 = new JRadioButton("Окружность 9 точек",false);
  jrb4.addActionListener(this);
  jrb5.addActionListener(this);
  bg = new ButtonGroup();
  bg.add(jrb4); bg.add(jrb5);
 add(jrb4); add(jrb5);
  
  
 }
 
 private JRadioButton jrb4,jrb5;
 private ButtonGroup bg;
 

 public void actionPerformed2(ActionEvent e){
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

    /**
     *
     * @param p
     */
    public void RadPan(PaintGraph p)
 {
 }
 
 
 
}

