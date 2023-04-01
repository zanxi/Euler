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
public class SwingWorkerCounterIntermediateResult extends JPanel {
   // For counter
   private JTextField tfCount;
   private int count = 0;
   // For SwingWorker
   JButton btnStartWorker;   // to start the worker
   private JLabel lblWorker; // for displaying the result
 
   /** Constructor to setup the GUI components */
   public SwingWorkerCounterIntermediateResult () {
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
 
      /** Create a SwingWorker instance to run a compute-intensive task */
      final SwingWorker<String, String> worker = new SwingWorker<String, String>() {
 
         /** Schedule a compute-intensive task in a background thread */
         @Override
         protected String doInBackground() throws Exception {
            long sum = 0;
            for (int number = 0; number < 10000000; ++number) {
               sum += number;
               publish(sum + ""); // Send "every" intermediate result to process()
                                  // You might not publish every intermediate result
            }
            return sum + "";
         }
 
         /** Run in event-dispatching thread after doInBackground() completes */
         @Override
         protected void done() {
            try {
               // Use get() to get the result of doInBackground()
               String finalResult = get();
               // Display the result in the label (run in EDT)
               lblWorker.setText("Final Result is " + finalResult);
            } catch (InterruptedException e) {
               e.printStackTrace();
            } catch (ExecutionException e) {
               e.printStackTrace();
            }
         }
 
         /** Run in event-dispatching thread to process intermediate results
              send from publish(). */
         @Override
         protected void process(java.util.List<String> chunks) {
            // Get the latest result from the list
            String latestResult = chunks.get(chunks.size() - 1);
            lblWorker.setText("Result is " + latestResult);
         }
      };
 
      btnStartWorker = new JButton("Start Worker");
      add(btnStartWorker);
      btnStartWorker.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            worker.execute();  // start the worker thread
            lblWorker.setText("  Running...");
            btnStartWorker.setEnabled(false);  // SwingWorker can only run once
         }
      });
      lblWorker = new JLabel("  Not started...");
      add(lblWorker);
      
      
 
   }
}