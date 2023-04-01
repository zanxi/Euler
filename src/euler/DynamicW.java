/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package euler;

/**
 *
 * @author zanxi
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class DynamicW {    
    public DynamicW() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Car> cars = new ArrayList<>(32);
        private JTextArea ta = new JTextArea(10, 20);

        private Random rnd = new Random();

        private NumberFormat format = NumberFormat.getNumberInstance();

        public TestPane() {
            for (int index = 0; index < 32; index++) {
                Car car = new Car("Car " + index, 40.0 + (rnd.nextDouble() * 180.0));
                cars.add(car);
            }

            setLayout(new BorderLayout());
            add(new JScrollPane(ta));

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Car car : cars) {
                        ta.append(car.getName() + " @ " + format.format(car.getSpeedKPH()) + " ~ " + format.format(car.getLocation()) + "km\n");
                        if (!car.isRunning() && rnd.nextBoolean()) {
                            car.start();
                            ta.append(car.getName() + " got started\n");
                        }
                    }
                }
            });
            timer.start();
        }

    }

    public class Car {
        private String name;
        private double speedKPH;
        private Instant timeStartedAt;

        public Car(String name, double kmp) {
            this.speedKPH = kmp;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getSpeedKPH() {
            return speedKPH;
        }

        public Instant getTimeStartedAt() {
            return timeStartedAt;
        }

        public boolean isRunning() {
            return timeStartedAt != null;
        }

        public void start() {
            timeStartedAt = Instant.now();
        }

        protected double distanceTravelledByMillis(long millis) {
            double time = millis / 1000d / 60d / 60d;
            return getSpeedKPH() * time;
        }

        public double getLocation() {
            Instant timeStartedAt = getTimeStartedAt();
            if (timeStartedAt == null) {
                return 0;
            }
            //Thread::sleep(500);
            Duration time = Duration.between(timeStartedAt, Instant.now());
            return distanceTravelledByMillis(time.toMillis());            
        }
    }
}
