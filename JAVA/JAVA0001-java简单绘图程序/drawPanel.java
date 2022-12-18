package middleproblems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class drawPanel extends JPanel
{
    //font
    private Font fonts = new Font("微软雅黑", Font.BOLD, 24);

    //buttongroup for up there
    private ButtonGroup BG;
    private static JRadioButton pencil;    //笔
    private static JRadioButton line;    //直线
    private static JRadioButton rectangle;    //矩形
    private static JRadioButton polygon;    //多边形
    private static JRadioButton circle;    //圆形
    private static JRadioButton sector;    //扇形

    //button for color
    private JButton color;

    //button for delete
    private JButton delete;

    //buttongroup for down there
    private ButtonGroup BGC;
    private static JRadioButton lined;
    private static JRadioButton filled;

    //the place of mouse when draw started
    private int x;
    private int y;

    private static int colorR = 0;
    private static int colorG = 0;
    private static int colorB = 0;
    public drawPanel()
    {
        JPanel pRadioButton = new JPanel();    //按钮组的panel
        JPanel pColorButton = new JPanel();    //颜色按钮的panel
        JPanel pDown = new JPanel();    //底下的panel
        JPanel pFilled = new JPanel();    //是不是填充的按钮的panel
        setPreferredSize(new Dimension(1280,720));    //设置初始窗口大小
        this.setLayout (new BorderLayout());    //给JFrame布局
        pDown.setLayout(new BorderLayout());    //给pDown的JPanel布局

        pencil = new JRadioButton("画笔",true);    //创建按钮
        line = new JRadioButton("直线");
        rectangle = new JRadioButton("矩形");
        polygon = new JRadioButton(" 多边形");
        circle = new JRadioButton("圆形");
        sector = new JRadioButton("扇形");

        pencil.setFont(fonts);    //设置大小
        line.setFont(fonts);
        rectangle.setFont(fonts);
        polygon.setFont(fonts);
        circle.setFont(fonts);
        sector.setFont(fonts);

        BG = new ButtonGroup();    //创建按钮组
        BG.add(pencil);    //添加按钮到组
        BG.add(line);
        BG.add(rectangle);
        BG.add(polygon);
        BG.add(circle);
        BG.add(sector);

        pRadioButton.add(pencil);    //添加按钮到panel
        pRadioButton.add(line);
        pRadioButton.add(rectangle);
        pRadioButton.add(polygon);
        pRadioButton.add(circle);
        pRadioButton.add(sector);

        add(pRadioButton,BorderLayout.WEST);    //按钮组放到西

        delete = new JButton("清空");

        delete.addActionListener(new deleteListener());

        delete.setBackground(Color.white);

        delete.setFont(fonts);

        pColorButton.add(delete);    //按钮添加panel

        color = new JButton("点我选颜色");    //创建按钮

        color.addActionListener(new colorListener());

        color.setBackground(Color.white);

        color.setFont(fonts);    //设置大小

        pColorButton.add(color);    //按钮添加panel

        add(pColorButton,BorderLayout.EAST);    //panel放到东

        lined = new JRadioButton("划线",true);    //创建按钮
        filled = new JRadioButton("填充");

        lined.setFont(fonts);    //设置大小
        filled.setFont(fonts);

        BGC = new ButtonGroup();    //创建按钮组
        BGC.add(lined);    //添加按钮到组
        BGC.add(filled);

        pFilled.add(lined);    //添加按钮到pFilled
        pFilled.add(filled);

        pDown.add(pFilled,BorderLayout.EAST);    //pFilled放到pDown的东

        add(pDown,BorderLayout.SOUTH);    //pDown放到JFrame的南
    }
    private class deleteListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            repaint();
        }
    }
    private class colorListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            new changeColor();
        }
    }
    public static void changeColor(int r,int g,int b)
    {
        colorR = r;
        colorG = g;
        colorB = b;
    }
    public static int getColorR(){return colorR;}
    public static int getColorG(){return colorG;}
    public static int getColorB(){return colorB;}
    public static int getDrawThings()
    {
        if(pencil.isSelected()) {return 0;}
        if(line.isSelected()) {return 1;}
        if(rectangle.isSelected()) {return 2;}
        if(polygon.isSelected()) {return 3;}
        if(circle.isSelected()) {return 4;}
        if(sector.isSelected()) {return 5;}
        else return 0;
    }
    public static int getDrawWay()
    {
        if(lined.isSelected()){return 0;}
        if(filled.isSelected()){return 1;}
        else return 0;
    }
}
