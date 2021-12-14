import org.w3c.dom.css.Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

public class ThreadPriorityTest {
    public static void main(String[] args) {

            MyFrame mf1 = new MyFrame(1000000,300,200,300,400,"Counter1");
            MyFrame mf2 = new MyFrame(1000000,300,300,400,400,"Counter2");
            MyFrame mf3 = new MyFrame(1000000,300,400,500,400,"Counter3");

            mf1.setVisible(true);
            mf2.setVisible(true);
            mf3.setVisible(true);

            Thread t1 = new Thread(mf1); //Its a child of Runnable, thats why the constructor is taking it as an argument
            Thread t2 = new Thread(mf2);
            Thread t3 = new Thread(mf3);

            t1.setPriority(Thread.MIN_PRIORITY); //1
            t2.setPriority(Thread.NORM_PRIORITY); //5 ie default
            t3.setPriority(Thread.MAX_PRIORITY); //10 max

            t1.run();
            t2.run();
            t3.run();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyFrame extends JFrame implements Runnable, WindowListener {
    int counter;
    final int MAX;

    JTextField jt = new JTextField(20);


    public void run() {
        counting();
    }
    MyFrame(int m, int w, int h, int x, int y, String title) {
        super(title);
        addWindowListener(this); //register your frame for event handling
        setLocation(x,y);
        setSize(w,h);
        MAX = m;
        setLayout(new FlowLayout()); //free flow in the center of the frame
        add(jt);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void counting() {
        for(int counter=1;counter<=MAX;counter++) {
            jt.setText("Counter : "+counter);
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window opened....");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window closing....");
        setVisible(false);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("window closed....");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("window maximized....");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("window minimized....");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("window activated....");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}