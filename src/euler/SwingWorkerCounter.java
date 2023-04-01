/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package euler;

/**
 *
 * @author zanxi
 */
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutionException;
import javax.swing.*;
 
/** Test SwingWorker on the counter application with a compute-intensive task */
@SuppressWarnings("serial")
public class SwingWorkerCounter extends JPanel {
   // For counter
   private JTextField tfCount;
   private int count = 0;
   // For SwingWorker
   JButton btnStartWorker;   // to start the worker
   private JLabel lblWorker; // for displaying the result
 
   /** Constructor to setup the GUI components */
   public SwingWorkerCounter () {
      setLayout(new FlowLayout());
 
      add(new JLabel("Counter"));
      tfCount = new JTextField("0", 10);
      tfCount.setEditable(false);
      add(tfCount);
 
      JButton btnCount = new JButton("Count");
      add(btnCount);
      btnCount.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ++count;
            tfCount.setText(count + "");
         }
      });
 
      /** Create a SwingWorker instance to run a compute-intensive task 
          Final result is String, no intermediate result (Void) */
      final SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
         /** Schedule a compute-intensive task in a background thread */
         @Override
         protected String doInBackground() throws Exception {
            // Sum from 1 to a large n
            long sum = 0;
            for (int number = 1; number < 1000000000; ++number) {
               sum += number;
            }
            return sum + "";
         }
 
         /** Run in event-dispatching thread after doInBackground() completes */
         @Override
         protected void done() {
            try {
               // Use get() to get the result of doInBackground()
               String result = get();
               // Display the result in the label (run in EDT)
               lblWorker.setText("Result is " + result);
            } catch (InterruptedException e) {
               e.printStackTrace();
            } catch (ExecutionException e) {
               e.printStackTrace();
            }
         }
      };
 
      btnStartWorker = new JButton("Start Worker");
      add(btnStartWorker);
      btnStartWorker.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            worker.execute();                 // start the worker thread
            lblWorker.setText("  Running...");
            btnStartWorker.setEnabled(false); // Each instance of SwingWorker run once
         }
      });
      lblWorker = new JLabel("  Not started...");
      add(lblWorker);
 
   }
} 