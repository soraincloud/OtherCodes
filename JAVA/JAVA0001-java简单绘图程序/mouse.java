package middleproblems;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouse implements MouseListener,MouseMotionListener
{
    Graphics g;
    int x1 = 0;    //鼠标按下初始x值
    int y1 = 0;    //鼠标按下初始y值
    int x2 = 0;    //鼠标弹起时x值
    int y2 = 0;    //鼠标弹起时y值
    int nowX = 0;    //鼠标移动时当前x值
    int nowY = 0;    //鼠标移动时当前y值
    int DrawThings = drawPanel.getDrawThings();    //获取绘图样式的值
    int DrawWay = drawPanel.getDrawWay();    //获取绘图方式的值
    int colorR = drawPanel.getColorR();    //三个颜色值
    int colorG = drawPanel.getColorG();
    int colorB = drawPanel.getColorB();
    int strX[] = new int[100];    //绘制多边形时储存x值的数组
    int strY[] = new int[100];    //绘制多边形时储存y值的数组
    int length = 0;    //多边形当前节点数量
    int drawThings = DrawThings;    //用于检测是否改变绘图样式的值
    int drawWay = DrawWay;    //用于检测是否改变绘图方式的值
    int time = 0;    //用于扇形绘制判断点击时间的值
    int R5 = 0;    //扇形半径
    public mouse(Graphics gr)
    {
        g = gr;
    }    //初始化graphics

    public void mouseDragged(MouseEvent e)    //鼠标拖动
    {
        switch (DrawThings)
        {
            case 0:    //选项为铅笔
            {
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1,y1,x2,y2);
                x1 = x2;
                y1 = y2;
                break;
            }
            case 5:    //选项为扇形
            {
                if(time != 0)    //第一次按下拖动
                {
                    int xx = e.getX();
                    if(DrawWay == 0)    //划线
                    {
                        g.drawArc(x1-R5,y1-R5,R5*2,R5*2,0,-(xx - x2)/2);
                        //根据x坐标拖动画扇形
                    }
                    else    //填充
                    {
                        g.fillArc(x1-R5,y1-R5,R5*2,R5*2,0,-(xx - x2)/2);
                        //根据x坐标拖动画扇形
                    }
                }
                break;
            }
        }
    }
    public void mouseMoved(MouseEvent e)    //鼠标移动 更新坐标值
    {
        refresh();    //检测是否改变颜色 样式等
        nowX = e.getX();
        nowY = e.getY();
    }
    public void mousePressed(MouseEvent e)    //鼠标按下 记录按下时的坐标
    {
        if(time != 0)return;    //绘制扇形时 第二次按下不需要记录坐标 使用第一次记录的坐标
        x1 = nowX;
        y1 = nowY;
        g.drawLine(x1,y1,x1,y1);
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e)    //鼠标弹起
    {
        switch (DrawThings)
        {
            case 0:
                break;
            case 1:    //直线 获取弹起时的坐标 绘制按下到弹起坐标的直线
            {
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1,y1,x2,y2);
                break;
            }
            case 2:    //矩形
            {
                if(DrawWay == 0)    //划线
                {
                    x2 = e.getX();
                    y2 = e.getY();
                    g.drawLine(x1,y1,x2,y1);
                    g.drawLine(x2,y1,x2,y2);
                    g.drawLine(x2,y2,x1,y2);
                    g.drawLine(x1,y2,x1,y1);
                }
                else    //填充
                {
                    x2 = e.getX();
                    y2 = e.getY();
                    int x[] = {x1,x2,x2,x1};
                    int y[] = {y1,y1,y2,y2};
                    g.fillPolygon(x,y,4);
                }
                break;
            }
            case 3:    //多边形 每次鼠标弹起记录一次坐标
            {
                x2 = e.getX();
                y2 = e.getY();
                strX[length] = x2;
                strY[length] = y2;
                length++;
                if(DrawWay == 0)    //划线
                {
                    int last = 0;
                    for(int i = 0;i < length - 1;i++)    //每次增加一个点 将所有点相连
                    {
                        g.drawLine(strX[i],strY[i],strX[i+1],strY[i+1]);
                        last = i+1;
                    }
                    //g.drawLine(strX[last],strY[last],strX[0],strY[0]);
                }
                else    //填充
                {
                    g.fillPolygon(strX,strY,length);
                }
                break;
            }
            case 4:    //圆形
            {
                x2 = e.getX();
                y2 = e.getY();
                int R = (int)Math.sqrt( Math.abs( (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1) ) );    //计算半径
                if(DrawWay == 0)    //画圆
                {
                    g.drawOval(x1-R,y1-R,R*2,R*2);
                }
                else    //填充
                {
                    g.fillOval(x1-R,y1-R,R*2,R*2);
                }
                break;
            }
            case 5:    //扇形
            {
                if(time == 0)    //第一次弹起
                {
                    x2 = e.getX();
                    y2 = e.getY();
                    time++;    //计时器向后
                    R5 = (int)Math.sqrt( Math.abs( (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1) ) );    //计算半径
                    g.drawLine(x2,y2,x2,y2);
                }
                else    //第二次弹起
                {
                    time = 0;    //重置计时器
                }
                break;
            }
        }
    }
    public void mouseExited(MouseEvent e) {}
    public void refresh()    //重置 检测值是否有改变
    {
        colorR = drawPanel.getColorR();    //颜色
        colorG = drawPanel.getColorG();
        colorB = drawPanel.getColorB();
        DrawThings = drawPanel.getDrawThings();    //绘制样式
        if(drawThings != DrawThings)    //检测样式是否改变
        {
            drawThings = DrawThings;
            length = 0;    //重置多边形的节点数
        }
        DrawWay = drawPanel.getDrawWay();    //绘制方式
        if(drawWay != DrawWay)     //检测绘制方式是否改变
        {
            drawWay = DrawWay;
            length = 0;    //重置多边形的节点数
        }
        g.setColor(new Color(colorR,colorG,colorB));    //设置颜色
    }
}
