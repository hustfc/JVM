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
    private JFrame randomFrame = new JFrame("元宵节活动");
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
    private String[] name = {"1-潘雨馨",
            "2-茹昊轩",
            "3-杨凌光",
            "4-张锦松",
            "5-张新昊",
            "6-黑帅龙",
            "7-唐喆雨",
            "8-苏涵轩",
            "9-李运浩",
            "10-张星亮",
            "11-张晓峰",
            "12-荆世泽",
            "13-胡洧",
            "14-曾一栩",
            "15-李金燕",
            "16-邹全德",
            "17-蔡旭航",
            "18-龚亨翔",
            "19-何人可",
            "20-张敏",
            "21-陈雨桐",
            "22-李凯凯",
            "23-丽江",
            "24-柯程扬",
            "25-李东升",
            "26-朴凡凡",
            "27-沈博垚",
            "28-王京",
            "29-小支",
            "30-杨镇瑜",
            "31-胡宇航",
            "32-tsm",
            "33-张思旭",
            "34-黄俊贤",
            "35-黄逸欣",
            "36-苏金章",
            "37-黄胜利",
            "38-张淑昊",
            "39-小耳朵",
            "40-盛依梵",
            "41-郭欣宜",
            "42-袁鑫浩",
            "43-邓宇城",
            "44-李宝宝",
            "45-张锋杨",
            "46-许志鸿",
            "47-李震",
            "48-吴宪",
            "49-方小梅",
            "50-徐鹏",
            "51-祁延明",
            "52-张登明",
            "53-李欣宇",
            "54-林仲奇",
            "55-吕经纬",
            "56-董雯",
            "57-魏天赐",
            "58-zwt",
            "59-祁浩南",
            "60-卿松",
            "61-郑卓",
            "62-王靓",
            "63-杨金致",
            "64-李淳风",
            "65-熊勉之",
            "66-李小龙",
            "67-陈付恩",
            "68-蒙大拿",
            "69-弯儿",
            "70-陈奇",
            "71-曾肖枫",
            "72-陈逸远",
            "73-林诗莹",
            "74-赵紫昱",
            "75-李子天",
            "76-王靓",
            "77-刘林",
            "78-夏豪云",
            "79-刘航",
            "80-宋祉浓",
            "81-陈凯铭",
            "82-夏豪云",
            "83-董雯",
            "84-王志鸿",
            "85-胡梦杰",
            "86-王雪晴",
            "87-吴军忠",
            "88-邓鸿升",
            "89-肖晗",
            "90-李杉梓",
            "91-陈吕泉",
            "92-晏楷畴",
            "93-敬明洋",
            "94-曾庆发",
            "95-魏港庆",
            "96-沈志伟",
            "97-邵吉威",
            "98-陈虹羽",
            "99-黄佳铭",
            "100-张彬隆",
            "101-徐杨洋",
            "102-陆旭峰",
            "103-刘煌铭",
            "104-王勇超",
            "105-樊筑荥",
            "106-张雨阳",
            "107-银联波",
            "108-林昶",
            "109-舒雷",
            "110-李宜检",
            "111-卢立达",
            "112-邱鹏旗",
            "113-魏自宁",
            "114-税康吉",
            "115-陈绍凯",
            "116-丁宇",
            "117-王梓洋",
            "118-张玉成",
            "119-许屹昂",
            "120-任淑一",
            "121-王云龙",
            "122-张博涵",
            "123-张飞",
            "124-张俊",
            "125-余金阳",
            "126-邹量",
            "127-陈郑萸",
            "128-王茜",
            "129-陆佳怡",
            "130-唐柳",
            "131-王喆",
            "132-周杰青",
            "133-王香港",
            "134-西瓜子",
            "135-我想念研究生",
            "136-徐姚明",
            "137-邱超",
            "138-董荣君",
            "139-石晟铭",
            "140-江雨昶",
            "141-陈建宇",
            "142-许先静",
            "143-徐强",
            "144-陈云鹤",
            "145-杨凌光",
            "146-李晨",
            "147-李佳锋",
            "148-赵永康",
            "149-王要东",
            "150-杨博闻",
            "151-陈力萌",
            "152-高圣奇",
            "153-余泳江",
            "154-彭程",
            "155-杜金蔓",
            "156-刘玉秋",
            "157-刘黎",
            "158-唐晟",
            "159-李晓彤",
            "160-李存凯",
            "161-刘育君",
            "162-程康"};

    public List<String> resultNames  = new LinkedList<>();
    int length = name.length;
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
