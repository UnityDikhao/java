import java.awt.*;
import java.awt.event.*;

class BlinkingText extends Frame implements Runnable, WindowListener {
    Thread t;
    Label l1;
    int f;
    
    BlinkingText() {
        t = new Thread(this);
        t.start();
        setLayout(null);
        l1 = new Label("Hello JAVA");
        l1.setBounds(100, 100, 100, 40);
        add(l1);
        setSize(300, 300);
        
        addWindowListener(this); 
        
        setVisible(true);
        
        f = 0;
    }
    
    public void run() {
        try {
            if (f == 0) {
                t.sleep(200);
                l1.setText("");
                f = 1;
            }
            if (f == 1) {
                t.sleep(200);
                l1.setText("Hello Java");
                f = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        run();
    }

    public static void main(String a[]) {
        new BlinkingText();
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
}

