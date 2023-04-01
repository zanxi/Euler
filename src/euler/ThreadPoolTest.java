/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package euler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author zanxi
 */
public class ThreadPoolTest {
   public void test() {
      int numWorkers = 4;// Integer.parseInt(args[0]);
      int threadPoolSize =  4;// Integer.parseInt(args[1]);

      ExecutorService pool = 
            Executors.newFixedThreadPool(threadPoolSize);
      WorkerThread[] workers = new WorkerThread[numWorkers];
      for (int i = 0; i < numWorkers; ++i) {
         workers[i] = new WorkerThread(i+1);
         pool.execute(workers[i]);
      }
      pool.shutdown();
   }
}
