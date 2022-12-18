package middleproblems;

import midproblems.birdPanel;

import javax.swing.*;
import java.awt.*;

public class draw
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("draw draw draw Σ(っ °Д °;)っ");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
;
        frame.setSize(1280,720);
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        drawPanel d = new drawPanel();
        frame.getContentPane().add(d);
        mouse m = new mouse(g);
        frame.addMouseListener(m);
        frame.addMouseMotionListener(m);
        frame.pack();
        frame.setVisible(true);
    }

}
