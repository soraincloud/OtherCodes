package problem5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class feePanel extends JPanel
{
    //fonts
    Font f1 = new Font("微软雅黑",Font.BOLD,30);
    Font f2 = new Font("微软雅黑",0,25);
    Font f3 = new Font("微软雅黑",0,20);
    Font f4 = new Font("微软雅黑",Font.BOLD,20);

    public static user[] userList;
    public static int userNum = 0;

    //panels
    private JPanel header;
    private JPanel headerWest;
    private JPanel headerEast;
    private JPanel ender;
    private JPanel enderWest;
    public static JPanel mid = new JPanel();

    //labels
    private JLabel SRIC = new JLabel("  SRIC  -");
    private JLabel network = new JLabel("  NETWORK");
    private JLabel admin = new JLabel("admin  ");
    private JLabel space = new JLabel("  ");

    //buttons
    private JButton head = new JButton();
    private JButton add = new JButton("+");
    private JButton question = new JButton("?");

    //inputs
    public static String phoneNumber;
    public static double internetNum;
    public static double callNum;
    public static int messageNum;
    public static int vipNum;
    public static int packageNum;
    public feePanel()
    {
        userList = new user[10];    //create the user list
        this.setLayout(new BorderLayout());    //set layout for JFrame
        header = new JPanel();    //create a header panel
        header.setBackground(Color.pink);    //set a background color for header
        header.setLayout(new BorderLayout());    //set a layout for header

        SRIC.setFont(f1);    //set font for SRIC
        network.setFont(f2);    //set font for network

        headerWest = new JPanel();    //create headerWest panel
        headerWest.setBackground(Color.pink);
        headerWest.add(SRIC);    //add SRIC to headerWest
        headerWest.add(network);    //add network to headerWest
        header.add(headerWest,BorderLayout.WEST);    //add headerWest to header

        admin.setFont(f3);    //set font for admin
        space.setFont(f2);    //set font for space

        head.setBackground(Color.white);    //set color for head
        head.setPreferredSize(new Dimension(35,35));    //set size for head
        head.addActionListener(new clearListener());    //add a listener

        headerEast = new JPanel();    //create headerEast panel
        headerEast.setBackground(Color.pink);    //set background color for headerEast
        headerEast.add(admin);    //add admin to headerEast
        headerEast.add(head);    //add head to headerEast
        headerEast.add(space);    //add space to headerEast
        header.add(headerEast,BorderLayout.EAST);    //add headerEast to header

        ender = new JPanel();    //create ender panel
        ender.setBackground(Color.gray);    //set a background color for header
        ender.setLayout(new BorderLayout());    //set a layout for header

        add.setBackground(Color.pink);    //set color for add
        add.setPreferredSize(new Dimension(50,50));    //set size for add
        add.setFont(f4);    //set font for add
        add.addActionListener(new addListener());

        question.setBackground(Color.pink);    //set color for question
        question.setPreferredSize(new Dimension(50,50));    //set size for question
        question.setFont(f4);    //set font for question
        question.addActionListener(new questionListener());

        enderWest = new JPanel();
        enderWest.setBackground(Color.gray);    //set color for enderWest
        enderWest.add(add);    //add add to enderWest
        enderWest.add(question);    //add question to enderWest

        ender.add(enderWest,BorderLayout.WEST);    //add enderWest to ender
        add(ender,BorderLayout.SOUTH);

        add(header,BorderLayout.NORTH);    //add header to frame

        mid.setLayout(new GridLayout(10,1));
        //for(int i = 0;i < userNum;i++)
        //{
        //    mid.add(userList[i].toPanel());
        //}
        add(mid,BorderLayout.CENTER);
    }
    private class addListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            userAdd ua = new userAdd();
        }
    }
    private class questionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            question que = new question();
        }
    }
    public static void changeMsg(String s,double i,double c,int m,int v,int p)
    {
        phoneNumber = s;
        internetNum = i;
        callNum = c;
        messageNum = m;
        vipNum = v;
        packageNum = p;

        if(userNum >= 10)return;

        if(vipNum == 1)    //sliver
        {
            if(packageNum == 1)    //package1
            {
                userList[userNum] = new userSliverPackage1(phoneNumber,internetNum,callNum,messageNum);
            }
            else if(packageNum == 2)    //package2
            {
                userList[userNum] = new userSliverPackage2(phoneNumber,internetNum,callNum,messageNum);
            }
            else     //none
            {
                userList[userNum] = new userSliver(phoneNumber,internetNum,callNum,messageNum);
            }
        }
        else if (vipNum == 2)    //gold
        {
            if(packageNum == 1)    //package1
            {
                userList[userNum] = new userGoldPackage1(phoneNumber,internetNum,callNum,messageNum);
            }
            else if(packageNum == 2)    //package2
            {
                userList[userNum] = new userGoldPackage2(phoneNumber,internetNum,callNum,messageNum);
            }
            else     //none
            {
                userList[userNum] = new userGold(phoneNumber,internetNum,callNum,messageNum);
            }
        }
        else    //normal
        {
            if(packageNum == 1)    //package1
            {
                userList[userNum] = new userNormalPackage1(phoneNumber,internetNum,callNum,messageNum);
            }
            else if(packageNum == 2)    //package2
            {
                userList[userNum] = new userNormalPackage2(phoneNumber,internetNum,callNum,messageNum);
            }
            else     //none
            {
                userList[userNum] = new userNormal(phoneNumber,internetNum,callNum,messageNum);
            }
        }
        mid.add(userList[userNum].toPanel());
        mid.repaint();
        mid.updateUI();
        userNum++;
    }
    private class clearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            userList = new user[10];
            userNum = 0;
            mid.removeAll();
            mid.repaint();
            mid.updateUI();
        }
    }
}
