package problem5;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class feeProgram
{
    public static JFrame f = new JFrame("动感地带 - 您身边的智能话费管家 - v0.0.1");    //create a JFrame
    public static void main(String[] args)
    {
        f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);    //shut when close
        f.setSize(1280,720);    //set the size of frame
        f.setVisible(true);    //let frame could be display

        feePanel fp = new feePanel();
        f.getContentPane().add(fp);

        JFrame start = new JFrame();
        start.setSize(1280,720);    //set the size of frame
        start.setVisible(true);    //let frame could be display

        startAction(start);
    }
    public static void startAction(JFrame f)
    {
        Graphics g = f.getGraphics();    //get a graphics
        g.setFont(new Font("微软雅黑",Font.BOLD,100));    //set the font
        Timer t = new Timer();    //add a timer
        t.schedule(new TimerTask()
        {
            private int RGB = 255;
            public void run()
            {
                if(RGB <= 0)
                {
                    t.cancel();
                    try{Thread.sleep(1000);}
                    catch(Exception e){}
                    f.dispose();
                }//if color is black,end the timer
                g.setColor(new Color(RGB,RGB,RGB));    //set the color to the graphics
                g.drawString("SRIC",530,400);    //draw the word
                RGB--;    //change the color to black
            }
        },0,5);    //wait for 0s and paint once when 5ms
    }
}
