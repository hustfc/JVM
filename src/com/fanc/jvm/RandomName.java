package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2020/2/7 8:19 下午
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.*;

public class RandomName implements ActionListener, Runnable {
    // 設置一個標記
    private boolean flag = false;
    //private JFrame randomFrame = new JFrame("锦鲤奖-刺猬哥考研团队");
    private JFrame randomFrame = new JFrame("彩蛋-刺猬哥考研团队");
    //private JFrame randomFrame = new JFrame("花灯奖-刺猬哥考研团队");
    // 创建一个Panel对象。
    private JPanel randomPanel = new JPanel();
    private TextField tf1 = new TextField(30);
    private TextField tf2 = new TextField(30);
    private JTextArea ta = new JTextArea(30, 20);
    //private TextField tf3 = new TextField(10);
    private JButton randomButton1 = new JButton("开始抽奖");
    private JButton randomButton2 = new JButton("停");
    private JButton randomButton3 = new JButton("中奖名单↓");
    private List<String> names = new LinkedList<>();

    public List<String> resultNames  = new LinkedList<>();
    int length;
    public RandomName() {
        try {
            File filepath = new File("/Users/fanc/Documents/GitHub/JVM/src/com/fanc/jvm/名单.txt");
            String encoding = "UTF-8";
            InputStreamReader read = new InputStreamReader(new FileInputStream(filepath), encoding);// 考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                names.add(str);
            }
        } catch (Exception e) {

        }
        length = names.size();
        System.out.println(names);
        // 向JPanel容器中添加三个组件
        randomPanel.add(tf1);
        randomPanel.add(tf2);
        randomPanel.add(randomButton1);
        randomPanel.add(randomButton2);
        randomPanel.add(randomButton3);
        randomPanel.add(ta);
        randomFrame.add(randomPanel);
        ta.setLineWrap(true);
        // 取得屏幕的宽度
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        // 取得屏幕的高度
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        // 设置组件不可改变大小
        randomFrame.setResizable(false);
        // 设置关闭窗体时结束程序
        randomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置组件大小
        randomFrame.setSize(250, 500);
        // 设置组件位置
        randomFrame.setLocation((width - 250) / 2, (height - 120) / 2);
        // 设置组件大小和位置
        // randomFrame.setBounds(30, 30, 250, 120);
        // 设置组件可见
        randomFrame.setVisible(true);
        addListener();
    }

    private void addListener() {
        randomButton1.addActionListener(this);
        randomButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object obj = e.getSource();
        if (obj == randomButton1) {
            synchronized (this) {
                notify();
                flag = true;
            }
        }
        if (obj == randomButton2) {
            synchronized (this) {
                flag = false;
                while (resultNames.contains(tf1.getText())) {
                    Random myRandomName = new Random();
                    int RN = myRandomName.nextInt(length);
                    tf1.setText(names.get(RN));
                }
                String resultName = tf1.getText();
                resultNames.add(resultName);
                System.out.println(resultName);
                while (resultNames.contains(tf2.getText())) {
                    Random myRandomName = new Random();
                    int RN = myRandomName.nextInt(length);
                    tf2.setText(names.get(RN));
                }
                resultName = tf2.getText();
                resultNames.add(resultName);
                System.out.println(resultName);
                ta.setText(String.valueOf(resultNames));
                System.out.println("中奖名单" + resultNames);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!flag) {
                    synchronized (this) {
                        this.wait();
                    }
                }
                Random myRandomName1 = new Random();
                int RN = myRandomName1.nextInt(length);
                tf1.setText(names.get(RN));
                Random myRandomName2 = new Random();
                RN = myRandomName2.nextInt(length);
                tf2.setText(names.get(RN));
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RandomName rn = new RandomName();
        Thread t1 = new Thread(rn);
        t1.start();
    }
}
