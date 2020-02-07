package com.fanc.jvm;

/**
 * @Author : fanc
 * @Date : 2020/2/7 8:19 下午
 */

import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;


public class RandomName implements ActionListener, Runnable {
    // 設置一個標記
    private boolean flag = false;
    private JFrame randomFrame = new JFrame("元宵节活动");
    // 创建一个Panel对象。
    private JPanel randomPanel = new JPanel();
    private TextField tf1 = new TextField(30);
    private TextField tf2 = new TextField(30);
    //private TextField tf3 = new TextField(10);
    private JButton randomButton1 = new JButton("开始抽奖");
    private JButton randomButton2 = new JButton("停");
    private String[] name = { "1-雅雅", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "1-雅雅", "2two", "3three", "4four", "5five", "6six", "7seven"};
    public List<String> resultNames  = new LinkedList<>();
    int length = name.length;

    public RandomName() {
        // 向JPanel容器中添加三个组件
        randomPanel.add(tf1);
        randomPanel.add(tf2);
        randomPanel.add(randomButton1);
        randomPanel.add(randomButton2);
        randomFrame.add(randomPanel);
        // 取得屏幕的宽度
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        // 取得屏幕的高度
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        // 设置组件不可改变大小
        randomFrame.setResizable(false);
        // 设置关闭窗体时结束程序
        randomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置组件大小
        randomFrame.setSize(250, 120);
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
                    tf1.setText(name[RN]);
                }
                String resultName = tf1.getText();
                resultNames.add(resultName);
                System.out.println(resultName);
                while (resultNames.contains(tf2.getText())) {
                    Random myRandomName = new Random();
                    int RN = myRandomName.nextInt(length);
                    tf2.setText(name[RN]);
                }
                resultName = tf2.getText();
                resultNames.add(resultName);
                System.out.println(resultName);
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
                tf1.setText(name[RN]);
                Random myRandomName2 = new Random();
                RN = myRandomName2.nextInt(length);
                tf2.setText(name[RN]);
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
