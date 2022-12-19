package middleproblems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class changeColor
{
    JFrame colorChange = new JFrame("选颜色");    //创建页面
    JPanel inputPanel = new JPanel();    //输入的panel
    JLabel labelR = new JLabel("R :");    //文字
    JTextField textR = new JTextField(10);
    JLabel labelG = new JLabel("G :");    //文字
    JTextField textG = new JTextField(10);
    JLabel labelB = new JLabel("B :");    //文字
    JTextField textB = new JTextField(10);

    private int r = drawPanel.getColorR();
    private int g = drawPanel.getColorG();
    private int b = drawPanel.getColorB();
    private String str;

    JPanel colorExample = new JPanel();    //示例颜色
    JButton colorExampleRed = new JButton();
    JButton colorExampleOrange = new JButton();
    JButton colorExampleYellow = new JButton();
    JButton colorExampleGreen = new JButton();
    JButton colorExampleBlue = new JButton();
    JButton colorExamplePurple = new JButton();
    JButton colorExamplePink = new JButton();
    JButton colorExampleWhite = new JButton();
    JButton colorExampleBlack = new JButton();

    JPanel submit = new JPanel();    //提交的panel
    JLabel choose = new JLabel("你选了 :");    //文字
    JButton chooseColor = new JButton();    //按钮
    JButton chooseButton = new JButton("试试");    //按钮
    JButton submitButton = new JButton("就他了");    //按钮
    public changeColor()
    {
        colorChange.setDefaultCloseOperation(2);    //关闭时释放自我
        colorChange.setLocationRelativeTo(null);    //放在屏幕中央
        colorChange.setLayout(new BorderLayout());    //设置布局
        colorChange.add(inputPanel,BorderLayout.NORTH);    //输入放在北

        textR.addKeyListener(new ControlTheInput());    //设置不能输入数字以外的字符
        textG.addKeyListener(new ControlTheInput());
        textB.addKeyListener(new ControlTheInput());

        inputPanel.add(labelR);    //添加rgb输入
        inputPanel.add(textR);
        inputPanel.add(labelG);
        inputPanel.add(textG);
        inputPanel.add(labelB);
        inputPanel.add(textB);

        chooseButton.setBackground(Color.white);    //设置试试按钮颜色为白色
        chooseButton.addActionListener(new chooseListener());    //添加监听
        inputPanel.add(chooseButton);    //添加试试按钮

        colorChange.add(colorExample,BorderLayout.CENTER);    //颜色示例放在中
        colorExampleRed.addActionListener(new colorListenerRed());    //添加监听
        colorExampleRed.setBackground(new Color(255,0,0));    //设置颜色
        colorExampleRed.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExampleRed);    //添加
        colorExampleOrange.addActionListener(new colorListenerOrange());    //添加监听
        colorExampleOrange.setBackground(new Color(255,153,0));    //设置颜色
        colorExampleOrange.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExampleOrange);    //添加
        colorExampleYellow.addActionListener(new colorListenerYellow());    //添加监听
        colorExampleYellow.setBackground(new Color(255,255,0));    //设置颜色
        colorExampleYellow.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExampleYellow);    //添加
        colorExampleGreen.addActionListener(new colorListenerGreen());    //添加监听
        colorExampleGreen.setBackground(new Color(0,255,0));    //设置颜色
        colorExampleGreen.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExampleGreen);    //添加
        colorExampleBlue.addActionListener(new colorListenerBlue());    //添加监听
        colorExampleBlue.setBackground(new Color(0,0,255));    //设置颜色
        colorExampleBlue.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExampleBlue);    //添加
        colorExamplePurple.addActionListener(new colorListenerPurple());    //添加监听
        colorExamplePurple.setBackground(new Color(204,0,255));    //设置颜色
        colorExamplePurple.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExamplePurple);    //添加
        colorExamplePink.addActionListener(new colorListenerPink());    //添加监听
        colorExamplePink.setBackground(new Color(255,153,255));    //设置颜色
        colorExamplePink.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExamplePink);    //添加
        colorExampleWhite.addActionListener(new colorListenerWhite());    //添加监听
        colorExampleWhite.setBackground(new Color(255,255,255));    //设置颜色
        colorExampleWhite.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExampleWhite);    //添加
        colorExampleBlack.addActionListener(new colorListenerBlack());    //添加监听
        colorExampleBlack.setBackground(new Color(0,0,0));    //设置颜色
        colorExampleBlack.setPreferredSize(new Dimension(25,25));    //设置按钮的大小
        colorExample.add(colorExampleBlack);    //添加

        colorChange.add(submit,BorderLayout.SOUTH);    //确认放在南
        submit.add(choose);    //添加文字
        chooseColor.setPreferredSize(new Dimension(25,25));    //设置当前颜色的按钮的大小
        chooseColor.setBackground(new Color(r,g,b));    //设置当前颜色的按钮的颜色
        submit.add(chooseColor);    //添加当前颜色按钮
        submitButton.setBackground(Color.white);    //设置确认按钮颜色为白色
        submitButton.addActionListener(new submitListener());    //添加监听
        submit.add(submitButton);    //添加确认按钮

        colorChange.pack();
        colorChange.setVisible(true);
    }
    private class chooseListener implements ActionListener    //选择颜色将颜色显示并判断输入值是否超过可用值
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            str = textR.getText();
            if(str.length() != 0)
            {
                r = Integer.parseInt(str);
                if(r > 255){r = 255;}
                if(r < 0){r = 0;}
            }
            str = textG.getText();
            if(str.length() != 0)
            {
                g = Integer.parseInt(str);
                if(g > 255){g = 255;}
                if(g < 0){g = 0;}
            }
            str = textB.getText();
            if(str.length() != 0)
            {
                b = Integer.parseInt(str);
                if(b > 255){b = 255;}
                if(b < 0){b = 0;}
            }
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class submitListener implements ActionListener    //提交颜色 改变界面颜色
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPanel.changeColor(r,g,b);
            chooseColor.setBackground(new Color(r,g,b));
            colorChange.dispose();
        }
    }
    private class colorListenerRed implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 255;
            g = 0;
            b = 0;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerOrange implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 255;
            g = 153;
            b = 0;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerYellow implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 255;
            g = 255;
            b = 0;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerGreen implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 0;
            g = 255;
            b = 0;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerBlue implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 0;
            g = 0;
            b = 255;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerPurple implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 204;
            g = 0;
            b = 255;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerPink implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 255;
            g = 153;
            b = 255;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerWhite implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 255;
            g = 255;
            b = 255;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    private class colorListenerBlack implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            r = 0;
            g = 0;
            b = 0;
            chooseColor.setBackground(new Color(r,g,b));
        }
    }
    public class ControlTheInput extends KeyAdapter    //设置不能输入数字以外的字符
    {
        public void keyTyped(KeyEvent e)
        {
            String key="0123456789"+(char)8;
            if(key.indexOf(e.getKeyChar())<0)
            {
                e.consume();//如果不是数字则取消
            }
        }
    }
}
