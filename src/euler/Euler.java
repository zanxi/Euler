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
PaintGraph pg_init; // класс вывода графика функции
JavaPostgreSql jPgSql;
Pan pan; // класс управляющих масштабом кнопок
            public Euler()
            {
            super("Построение графика функции");
            Container c = getContentPane();
            c.setLayout(new BorderLayout()); // установка менеджера размещения
            
//            pg = new PaintGraph(); // инициализация класса построения графика функции
//            pg.sw=1;
//            pg.setSize(300,630); // задание размеров            
//            c.add(pg,BorderLayout.CENTER); // задание размещения
            
            pg_init = new PaintGraph(); // инициализация класса построения графика функции
            pg_init.sw=5;
            pg_init.setSize(300,630); // задание размеров
            c.add(pg_init,BorderLayout.CENTER); // задание размещения
            
            
            //pan = new Pan(pg); // инициализация класса кнопок масштаба
            //c.add(pan,BorderLayout.WEST);
            setSize(1200,830); // задание размеров
                      
            // read db postgresql      
            //jPgSql = new JavaPostgreSql();
            //jPgSql.mainTest();
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задание параметров
                                                            // главного окна при закрытии
            setVisible(true);
            }
  public static void main(String[] args)
 {
      new Euler();
     
     
     // -------------------------------------------------
     /*
     SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new UnresponsiveUI();  // Let the constructor do the job
         }
      });
     
     
     // -------------------------------------------------
     javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new UnresponsiveUIwThread();  // Let the constructor do the job
         }
      });
     /**/
     
     // -------------------------------------------------
     /*
     javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new UnresponsiveUIwThreadSleep();  // Let the constructor do the job
         }
      });
     /**/
     
     
     // -------------------------------------------------
     // consumer && producer
     //TestMessageBox tb = new TestMessageBox();
     //tb.run();
     
     
     // -------------------------------------------------
     /*
     SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            JFrame frame = new JFrame("SwingWorker Test");
            frame.setContentPane(new SwingWorkerCounter());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setVisible(true);
         }
      });
     /**/
     
     // --------------------------------------------------
     /*
     SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            JFrame frame = new JFrame("SwingWorker Test");
            frame.setContentPane(new SwingWorkerCounterIntermediateResult());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setVisible(true);
         }
      });
     /**/
     
     // ------------------------------------------------
     //ThreadPoolTest tp = new ThreadPoolTest();
     //tp.test();
     
     
     // -------------------------------------------
     DynamicW dw = new DynamicW();
     
     
     
 }
}


