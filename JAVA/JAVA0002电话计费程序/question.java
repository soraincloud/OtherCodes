package problem5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class question
{
    JFrame q = new JFrame("how much");

    JPanel cardPanel = new JPanel();

    Font f1 = new Font("微软雅黑",Font.BOLD,30);
    Font f2 = new Font("微软雅黑",Font.BOLD,20);

    CardLayout c = new CardLayout();

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel n = new JPanel();
    JPanel s = new JPanel();
    JPanel g = new JPanel();

    JLabel package1 = new JLabel("PACKAGE 1",JLabel.CENTER);
    JLabel internet1 = new JLabel("internet : 10 Gib",JLabel.CENTER);
    JLabel call1 = new JLabel("call : 100 min",JLabel.CENTER);
    JLabel message1 = new JLabel("message : 100 text",JLabel.CENTER);
    JLabel payment1 = new JLabel("30 $",JLabel.CENTER);
    JLabel package2 = new JLabel("PACKAGE 2",JLabel.CENTER);
    JLabel internet2 = new JLabel("internet : 20 Gib",JLabel.CENTER);
    JLabel call2 = new JLabel("call : 200 min",JLabel.CENTER);
    JLabel message2 = new JLabel("message : 200 text",JLabel.CENTER);
    JLabel payment2 = new JLabel("50 $",JLabel.CENTER);
    JLabel normal = new JLabel("NORMAL user",JLabel.CENTER);
    JLabel internetN = new JLabel("internet : 1$ / Gib",JLabel.CENTER);
    JLabel callN = new JLabel("call : 0.5$ / min",JLabel.CENTER);
    JLabel messageN = new JLabel("message : 0.3$ / text",JLabel.CENTER);
    JLabel packageN = new JLabel("package pay for 100%",JLabel.CENTER);
    JLabel sliver = new JLabel("SLIVER user",JLabel.CENTER);
    JLabel internetS = new JLabel("internet : 0.6$ / Gib",JLabel.CENTER);
    JLabel callS = new JLabel("call : 0.3$ / min",JLabel.CENTER);
    JLabel messageS = new JLabel("message : 0.2$ / text",JLabel.CENTER);
    JLabel packageS = new JLabel("package pay for 90%",JLabel.CENTER);
    JLabel gold = new JLabel("GOLD user",JLabel.CENTER);
    JLabel internetG = new JLabel("internet : 0.4$ / Gib",JLabel.CENTER);
    JLabel callG = new JLabel("call : 0.2$ / min",JLabel.CENTER);
    JLabel messageG = new JLabel("message : 0.1$ / text",JLabel.CENTER);
    JLabel packageG = new JLabel("package pay for 80%",JLabel.CENTER);

    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");

    JPanel BG = new JPanel();

    public question()
    {
        q.setLayout(new BorderLayout());
        q.setDefaultCloseOperation (2);    //shut when close
        q.setVisible(true);    //let frame could be display

        cardPanel.setLayout(c);

        b1.setBackground(Color.pink);
        b1.setPreferredSize(new Dimension(50,50));
        b1.addActionListener(new Listener1());
        b2.setBackground(Color.cyan);
        b2.setPreferredSize(new Dimension(50,50));
        b2.addActionListener(new Listener2());
        b3.setBackground(Color.white);
        b3.setPreferredSize(new Dimension(50,50));
        b3.addActionListener(new Listener3());
        b4.setBackground(new Color(192,192,192));
        b4.setPreferredSize(new Dimension(50,50));
        b4.addActionListener(new Listener4());
        b5.setBackground(new Color(255,215,0));
        b5.setPreferredSize(new Dimension(50,50));
        b5.addActionListener(new Listener5());

        BG.setBackground(Color.pink);
        BG.add(b1);
        BG.add(b2);
        BG.add(b3);
        BG.add(b4);
        BG.add(b5);

        package1.setFont(f1);
        internet1.setFont(f2);
        call1.setFont(f2);
        message1.setFont(f2);
        payment1.setFont(f1);
        package2.setFont(f1);
        internet2.setFont(f2);
        call2.setFont(f2);
        message2.setFont(f2);
        payment2.setFont(f1);
        normal.setFont(f1);
        internetN.setFont(f2);
        callN.setFont(f2);
        messageN.setFont(f2);
        packageN.setFont(f2);
        sliver.setFont(f1);
        internetS.setFont(f2);
        callS.setFont(f2);
        messageS.setFont(f2);
        packageS.setFont(f2);
        gold.setFont(f1);
        internetG.setFont(f2);
        callG.setFont(f2);
        messageG.setFont(f2);
        packageG.setFont(f2);

        p1.setLayout(new GridLayout(6,1));
        p1.setBackground(Color.pink);
        p1.add(package1);
        p1.add(internet1);
        p1.add(call1);
        p1.add(message1);
        p1.add(payment1);
        cardPanel.add(p1,"c1");

        p2.setLayout(new GridLayout(6,1));
        p2.setBackground(Color.cyan);
        p2.add(package2);
        p2.add(internet2);
        p2.add(call2);
        p2.add(message2);
        p2.add(payment2);
        cardPanel.add(p2,"c2");

        n.setLayout(new GridLayout(6,1));
        n.setBackground(Color.white);
        n.add(normal);
        n.add(internetN);
        n.add(callN);
        n.add(messageN);
        n.add(packageN);
        cardPanel.add(n,"c3");

        s.setLayout(new GridLayout(6,1));
        s.setBackground(new Color(192,192,192));
        s.add(sliver);
        s.add(internetS);
        s.add(callS);
        s.add(messageS);
        s.add(packageS);
        cardPanel.add(s,"c4");

        g.setLayout(new GridLayout(6,1));
        g.setBackground(new Color(255,215,0));
        g.add(gold);
        g.add(internetG);
        g.add(callG);
        g.add(messageG);
        g.add(packageG);
        cardPanel.add(g,"c5");

        q.add(cardPanel,BorderLayout.CENTER);
        q.add(BG,BorderLayout.SOUTH);

        q.pack();
    }
    private class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BG.setBackground(Color.pink);
            c.show(cardPanel,"c1");
        }
    }
    private class Listener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BG.setBackground(Color.cyan);
            c.show(cardPanel,"c2");
        }
    }
    private class Listener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BG.setBackground(Color.white);
            c.show(cardPanel,"c3");
        }
    }
    private class Listener4 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BG.setBackground(new Color(192,192,192));
            c.show(cardPanel,"c4");
        }
    }
    private class Listener5 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BG.setBackground(new Color(255,215,0));
            c.show(cardPanel,"c5");
        }
    }
}
