package problem5;

import javax.swing.*;
import java.awt.*;

abstract public class user
{
    //0 for normal
    //internet : 1$/Gib
    //call : 0.5$/min
    //message : 0.3$/text
    //package * 100%

    //1 for silver
    //internet : 0.6$/Gib
    //call : 0.3$/min
    //message : 0.2$/text
    //package * 90%

    //2 for gold
    //internet : 0.4$/Gib
    //call : 0.2$/min
    //message : 0.1$/text
    //package * 80%

    //package1
    //internet : 10Gib
    //call : 100min
    //message : 100text
    //payment : 30$

    //package2
    //internet : 20Gib
    //call : 200min
    //message : 200text
    //payment : 50$
    protected String phone;
    protected double internet;
    protected double call;
    protected int message;
    protected double pay;
    public user(String p,double i,double c,int m)
    {
        phone = p;
        internet = i;
        call = c;
        message = m;
        pay = 0;
    }
    public double payment()
    {
        return pay;
    }
    public JPanel toPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,8));
        Font f = new Font("微软雅黑",Font.BOLD,20);

        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();

        JLabel vip;
        JButton head = new JButton();
        if(feePanel.vipNum == 1)
        {
            vip = new JLabel("SLIVER");
            head.setBackground(new Color(192,192,192));
        }
        else if(feePanel.vipNum == 2)
        {
            vip = new JLabel("GOLD");
            head.setBackground(new Color(255,215,0));
        }
        else
        {
            vip = new JLabel("NORMAL");
            head.setBackground(Color.white);
        }
        JLabel phone = new JLabel(feePanel.phoneNumber);
        JLabel packages = new JLabel("package" + feePanel.packageNum);
        if(feePanel.packageNum == 0)
        {
            packages = new JLabel("no package");
        }
        JLabel internet = new JLabel(feePanel.internetNum + " Gib");
        JLabel call = new JLabel(feePanel.callNum + " min");
        JLabel message = new JLabel(feePanel.messageNum + " text");
        JLabel pay = new JLabel(payment() + " $");

        vip.setFont(f);
        phone.setFont(f);
        packages.setFont(f);
        internet.setFont(f);
        call.setFont(f);
        message.setFont(f);
        pay.setFont(f);

        head.setPreferredSize(new Dimension(30,30));

        p0.add(head);
        panel.add(p0);

        p1.add(vip);
        panel.add(p1);

        p2.add(phone);
        panel.add(p2);

        p3.add(packages);
        panel.add(p3);

        p4.add(internet);
        panel.add(p4);

        p5.add(call);
        panel.add(p5);

        p6.add(message);
        panel.add(p6);


        p7.add(pay);
        panel.add(p7);

        return panel;
    }
}
