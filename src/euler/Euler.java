/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

/**
 *
 * @author andre
 */



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;








public class Euler extends JFrame
{
PaintGraph pg; // класс вывода графика функции
Pan pan; // класс управляющих масштабом кнопок
            public Euler()
            {
            super("Построение графика функции");
            Container c = getContentPane();
            c.setLayout(new BorderLayout()); // установка менеджера размещения
            pg = new PaintGraph(); // инициализация класса построения графика функции
            pg.setSize(300,630); // задание размеров
            c.add(pg,BorderLayout.CENTER); // задание размещения
            //pan = new Pan(pg); // инициализация класса кнопок масштаба
            //c.add(pan,BorderLayout.WEST);
            setSize(1200,830); // задание размеров
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задание параметров
                                                            // главного окна при закрытии
            setVisible(true);
            }
  public static void main(String[] args)
 {
  new Euler();
 }
}


