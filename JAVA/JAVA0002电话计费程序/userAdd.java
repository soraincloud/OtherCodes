package problem5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class userAdd
{
    JFrame uAdd = new JFrame("add user");    //create a frame

    private JLabel phoneText = new JLabel("phone : ");
    private JLabel internetText = new JLabel("internet : ");
    private JLabel callText = new JLabel("call : ");
    private JLabel messageText = new JLabel("message : ");
    private JLabel vipText = new JLabel("vip : ");
    private JLabel packageText = new JLabel("package : ");

    private JTextField phone = new JTextField(10);
    private JTextField internet = new JTextField(10);
    private JTextField call = new JTextField(10);
    private JTextField message = new JTextField(10);

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();

    private ButtonGroup vip = new ButtonGroup();
    private JRadioButton normal = new JRadioButton("normal",true);
    private JRadioButton sliver = new JRadioButton("sliver vip");
    private JRadioButton gold = new JRadioButton("gold vip");

    private ButtonGroup packages = new ButtonGroup();
    private JRadioButton none = new JRadioButton("none",true);
    private JRadioButton package1 = new JRadioButton("package 1");
    private JRadioButton package2 = new JRadioButton("package 2");

    private JButton submit = new JButton("submit");
    public userAdd()
    {
        uAdd.setDefaultCloseOperation (2);    //shut when close
        uAdd.setLayout(new GridLayout(5,1));    //set a layout for frame
        uAdd.setVisible(true);    //let frame could be display

        phone.addKeyListener(new ControlTheInput());    //set just input number
        internet.addKeyListener(new ControlTheInput());
        call.addKeyListener(new ControlTheInput());
        message.addKeyListener(new ControlTheInput());

        vip.add(normal);    //add radiobutton to buttongroup
        vip.add(sliver);
        vip.add(gold);

        packages.add(none);    //add radiobutton to buttongroup
        packages.add(package1);
        packages.add(package2);

        p1.add(phoneText);
        p1.add(phone);
        uAdd.add(p1);

        p2.add(vipText);
        p2.add(normal);
        p2.add(sliver);
        p2.add(gold);
        uAdd.add(p2);

        p3.add(packageText);
        p3.add(none);
        p3.add(package1);
        p3.add(package2);
        uAdd.add(p3);

        p4.add(internetText);
        p4.add(internet);
        p4.add(callText);
        p4.add(call);
        p4.add(messageText);
        p4.add(message);
        uAdd.add(p4);

        submit.setBackground(Color.pink);    //set for submit button
        submit.addActionListener(new submitListener());

        p5.add(submit);
        uAdd.add(p5);

        uAdd.pack();    //set a good size
    }
    private class submitListener implements ActionListener    //do when button clicked
    {
        public void actionPerformed(ActionEvent e)
        {
            String s = phone.getText();    //get input
            String is = internet.getText();
            String cs = call.getText();
            String ms = message.getText();

            if(s.length() == 0){s = "null";}
            if(is.length() == 0){is = "0";}
            if(cs.length() == 0){cs = "0";}
            if(ms.length() == 0){ms = "0";}

            double i = Double.parseDouble(is);    //turn string to double and int
            double c = Double.parseDouble(cs);
            int m = Integer.parseInt(ms);

            int v = 0;    //get vip
            if(sliver.isSelected()){v = 1;}
            if(gold.isSelected()){v = 2;}

            int p = 0;   //get package
            if(package1.isSelected()){p = 1;}
            if(package2.isSelected()){p = 2;}


            feePanel.changeMsg(s,i,c,m,v,p);    //give the data to fee panel
            uAdd.dispose();
        }
    }
    public class ControlTheInput extends KeyAdapter    //could just input numbers
    {
        public void keyTyped(KeyEvent e)
        {
            String key="0123456789.";
            if(key.indexOf(e.getKeyChar())<0)
            {
                e.consume();//if not numbers then cancel
            }
        }
    }
}
