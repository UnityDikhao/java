
import java.awt.*;
import java.awt.event.*;

public class NumberDisplay extends Frame implements Runnable, WindowListener, ActionListener {
    Thread t;
    TextField t1;
    Button b1;

    NumberDisplay() {
        t = new Thread(this);
        t.start();
        setLayout(new FlowLayout());

        t1 = new TextField(20);
        add(t1);

        b1 = new Button("Start");
        add(b1);
        b1.addActionListener(this);

        setSize(300, 200);
        addWindowListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }

    class MyThread extends Thread {
        public void run() {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t1.setText(" "+ i);
            }
        }
    }

    public void run() {
        
    }

    public void windowClosing(WindowEvent e) {
        dispose();
    }

   
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String a[]) {
        new NumberDisplay();
    }
}
