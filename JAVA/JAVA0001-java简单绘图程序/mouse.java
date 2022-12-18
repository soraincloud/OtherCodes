package middleproblems;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouse implements MouseListener,MouseMotionListener
{
    Graphics g;
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;
    int nowX = 0;
    int nowY = 0;
    int DrawThings = drawPanel.getDrawThings();
    int DrawWay = drawPanel.getDrawWay();
    int colorR = drawPanel.getColorR();
    int colorG = drawPanel.getColorG();
    int colorB = drawPanel.getColorB();
    int strX[] = new int[100];
    int strY[] = new int[100];
    int length = 0;
    int drawThings = DrawThings;
    int drawWay = DrawWay;
    int time = 0;
    int R5 = 0;
    public mouse(Graphics gr)
    {
        g = gr;
    }

    public void mouseDragged(MouseEvent e)
    {
        switch (DrawThings)
        {
            case 0:
            {
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1,y1,x2,y2);
                x1 = x2;
                y1 = y2;
                break;
            }
            case 5:
            {
                if(time != 0)
                {
                    int xx = e.getX();
                    if(DrawWay == 0)
                    {
                        g.drawArc(x1-R5,y1-R5,R5*2,R5*2,0,-(xx - x2)/2);
                    }
                    else
                    {
                        g.fillArc(x1-R5,y1-R5,R5*2,R5*2,0,-(xx - x2)/2);
                    }
                }
                break;
            }
        }
    }
    public void mouseMoved(MouseEvent e)
    {
        refresh();
        nowX = e.getX();
        nowY = e.getY();
    }
    public void mousePressed(MouseEvent e)
    {
        if(time != 0)return;
        x1 = nowX;
        y1 = nowY;
        g.drawLine(x1,y1,x1,y1);
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e)
    {
        switch (DrawThings)
        {
            case 0:
                break;
            case 1:
            {
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1,y1,x2,y2);
                break;
            }
            case 2:
            {
                if(DrawWay == 0)
                {
                    x2 = e.getX();
                    y2 = e.getY();
                    g.drawLine(x1,y1,x2,y1);
                    g.drawLine(x2,y1,x2,y2);
                    g.drawLine(x2,y2,x1,y2);
                    g.drawLine(x1,y2,x1,y1);
                }
                else
                {
                    x2 = e.getX();
                    y2 = e.getY();
                    int x[] = {x1,x2,x2,x1};
                    int y[] = {y1,y1,y2,y2};
                    g.fillPolygon(x,y,4);
                }
                break;
            }
            case 3:
            {
                x2 = e.getX();
                y2 = e.getY();
                strX[length] = x2;
                strY[length] = y2;
                length++;
                if(DrawWay == 0)
                {
                    int last = 0;
                    for(int i = 0;i < length - 1;i++)
                    {
                        g.drawLine(strX[i],strY[i],strX[i+1],strY[i+1]);
                        last = i+1;
                    }
                    //g.drawLine(strX[last],strY[last],strX[0],strY[0]);
                }
                else
                {
                    g.fillPolygon(strX,strY,length);
                }
                break;
            }
            case 4:
            {
                x2 = e.getX();
                y2 = e.getY();
                int R = (int)Math.sqrt( Math.abs( (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1) ) );
                if(DrawWay == 0)
                {
                    g.drawOval(x1-R,y1-R,R*2,R*2);
                }
                else
                {
                    g.fillOval(x1-R,y1-R,R*2,R*2);
                }
                break;
            }
            case 5:
            {
                if(time == 0)
                {
                    x2 = e.getX();
                    y2 = e.getY();
                    time++;
                    R5 = (int)Math.sqrt( Math.abs( (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1) ) );
                    g.drawLine(x2,y2,x2,y2);
                }
                else
                {
                    time = 0;
                }
                break;
            }
        }
    }
    public void mouseExited(MouseEvent e)
    {

    }
    public void refresh()
    {
        colorR = drawPanel.getColorR();
        colorG = drawPanel.getColorG();
        colorB = drawPanel.getColorB();
        DrawThings = drawPanel.getDrawThings();
        if(drawThings != DrawThings)
        {
            drawThings = DrawThings;
            length = 0;
        }
        DrawWay = drawPanel.getDrawWay();
        if(drawWay != DrawWay)
        {
            drawWay = DrawWay;
            length = 0;
        }
        g.setColor(new Color(colorR,colorG,colorB));
    }
}
