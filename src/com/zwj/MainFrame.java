package com.zwj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainFrame extends JFrame {

    public static MainFrame mainFrame = new MainFrame();

    public MainGamePanel mainGamePanel = new MainGamePanel();

    public DiceJLabel[] diceLabels1 = new DiceJLabel[6];
    public DiceJLabel[] diceLabels2 = new DiceJLabel[6];
    public HPJLabel[] hpLabels1 = new HPJLabel[15];
    public HPJLabel[] hpLabels2 = new HPJLabel[15];
    public GodsJLabel[] godsLabels1 = new GodsJLabel[2];
    public GodsJLabel[] godsLabels2 = new GodsJLabel[2];

    public DiceButton[] diceButtons1 = new DiceButton[6];
    public DiceButton[] diceButtons2 = new DiceButton[6];
    public JButton okButton = new JButton("确定");
    public JButton godsGraceBtn1 = new JButton("是");
    public JButton godsGraceBtn2 = new JButton("否");
    public JButton p1GodsBtn1 = new JButton("p1Thor");
    public JButton p1GodsBtn2 = new JButton("p1Heimdallr");
    public JButton p2GodsBtn1 = new JButton("p2Thor");
    public JButton p2GodsBtn2 = new JButton("p2Heimdallr");
    public JButton[] levelBtns = new JButton[3];
    public JButton startBtn = new JButton("Play");
    public JButton coinBtn1 = new JButton("正面");
    public JButton coinBtn2 = new JButton("反面");


    public JTextArea textArea = new JTextArea();
    public JLabel playerStateLabel1 = new JLabel(
            "<html><body>" + Player.player1.name + "<br>HP:" + Player.player1.hp +
                    "<br>magic:" + Player.player1.magic + "<body></html>", JLabel.CENTER);
    public JLabel playerStateLabel2 = new JLabel(
            "<html><body>" + Player.player2.name + "<br>HP:" + Player.player2.hp +
                    "<br>magic:" + Player.player2.magic + "<body></html>", JLabel.CENTER);

    public void init() {

//        JLabel imageLabelTest = new JLabel(new ImageIcon(test.class.getClassLoader().getResource("image/test1.png")));
//        imageLabelTest.setBounds(200, 100, 100, 100);
//        imageLabelTest.setOpaque(true);
//        mainGamePanel.add(imageLabelTest);

        Action myListener = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command) {
                    case "Play" -> {
                        ButtonAction.startBtnAction();
                    }
                    case "正面" -> {
                        ButtonAction.coinBtn1Action();
                    }
                    case "反面" -> {
                        ButtonAction.coinBtn2Action();
                    }
                    case "确定" -> {
                        ButtonAction.okBtnAction();
                    }
                    case "是" -> {
                        ButtonAction.godsGraceAction1();
                    }
                    case "否" -> {
                        ButtonAction.godsGraceAction2();
                    }
                    case "p1Thor" -> {
                        ButtonAction.godsGraceNum1();
                    }
                    case "p1Heimdallr" -> {
                        ButtonAction.godsGraceNum2();
                    }
                    case "p2Thor" -> {
                        ButtonAction.godsGraceNum1();
                    }
                    case "p2Heimdallr" -> {
                        ButtonAction.godsGraceNum2();
                    }
                    case "level1" -> {
                        ButtonAction.levelAction(1);
                    }
                    case "level2" -> {
                        ButtonAction.levelAction(2);
                    }
                    case "level3" -> {
                        ButtonAction.levelAction(3);
                    }
                    case "100" -> {
                        ButtonAction.diceSelectdAction(Player.player1, 0);
                    }
                    case "101" -> {
                        ButtonAction.diceSelectdAction(Player.player1, 1);
                    }
                    case "102" -> {
                        ButtonAction.diceSelectdAction(Player.player1, 2);
                    }
                    case "103" -> {
                        ButtonAction.diceSelectdAction(Player.player1, 3);
                    }
                    case "104" -> {
                        ButtonAction.diceSelectdAction(Player.player1, 4);
                    }
                    case "105" -> {
                        ButtonAction.diceSelectdAction(Player.player1, 5);
                    }
                    case "200" -> {
                        ButtonAction.diceSelectdAction(Player.player2, 0);
                    }
                    case "201" -> {
                        ButtonAction.diceSelectdAction(Player.player2, 1);
                    }
                    case "202" -> {
                        ButtonAction.diceSelectdAction(Player.player2, 2);
                    }
                    case "203" -> {
                        ButtonAction.diceSelectdAction(Player.player2, 3);
                    }
                    case "204" -> {
                        ButtonAction.diceSelectdAction(Player.player2, 4);
                    }
                    case "205" -> {
                        ButtonAction.diceSelectdAction(Player.player2, 5);
                    }
                }
            }
        };

        mainGamePanel.setLayout(null);
        for (int i = 0; i < 6; i++) {
            diceLabels1[i] = new DiceJLabel("label" + i, JLabel.CENTER);
            diceLabels1[i].setOpaque(true);
            diceLabels1[i].setFont(new Font("黑体", Font.PLAIN, 20));
            diceLabels1[i].setBackground(Color.CYAN);
            diceLabels1[i].setBounds(350 + 100 * i, 50, 75, 75);//玩家1的骰子
            mainGamePanel.add(diceLabels1[i]);
        }
        for (int i = 0; i < 6; i++) {
            diceLabels2[i] = new DiceJLabel("Label" + i, JLabel.CENTER);
            diceLabels2[i].setOpaque(true);
            diceLabels2[i].setFont(new Font("黑体", Font.PLAIN, 20));
            diceLabels2[i].setBackground(Color.CYAN);
            diceLabels2[i].setBounds(350 + 100 * i, 600, 75, 75);//玩家2的骰子
            mainGamePanel.add(diceLabels2[i]);
        }//骰子dice

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int k = i * 5 + j;
                ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stone" + k + ".png"));
                stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                hpLabels1[k] = new HPJLabel(stoneImageIcon);
                hpLabels1[k].setOpaque(false);
//                hpLabels1[k].setFont(new Font("黑体", Font.PLAIN, 12));
//                hpLabels1[k].setBackground(Color.RED);
                hpLabels1[k].setBounds(50 + 50 * j, 30 + 50 * i, 40, 50);
                mainGamePanel.add(hpLabels1[k]);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int k = i * 5 + j;
                ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stone" + k + ".png"));
                stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                hpLabels2[k] = new HPJLabel(stoneImageIcon);
                hpLabels2[k].setOpaque(false);
//                hpLabels2[k].setFont(new Font("黑体", Font.PLAIN, 12));
//                hpLabels2[k].setBackground(Color.RED);
                hpLabels2[k].setBounds(50 + 50 * j, 580 + 50 * i, 40, 50);
                mainGamePanel.add(hpLabels2[k]);
            }
        }//hp

        for (int i = 0; i < 2; i++) {
//            godsLabels1[i] = new GodsJLabel("Gods" + i, JLabel.CENTER);
            ImageIcon godsImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/gods" + (i + 1) + ".png"));
            godsImageIcon.setImage(godsImageIcon.getImage().getScaledInstance(100, 175, Image.SCALE_DEFAULT));
            godsLabels1[i] = new GodsJLabel(godsImageIcon);
            godsLabels1[i].setOpaque(false);
            godsLabels1[i].setFont(new Font("黑体", Font.PLAIN, 30));
            godsLabels1[i].setBackground(Color.GRAY);
            godsLabels1[i].setBounds(960 + 100 * i, 20, 100, 170);
//            godsLabels1[i].setLocation(970 + 100 * i, 20);
            mainGamePanel.add(godsLabels1[i]);
        }
        for (int i = 0; i < 2; i++) {
            ImageIcon godsImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/gods" + (i + 1) + ".png"));
            godsImageIcon.setImage(godsImageIcon.getImage().getScaledInstance(100, 175, Image.SCALE_DEFAULT));
            godsLabels2[i] = new GodsJLabel(godsImageIcon);
            godsLabels2[i].setOpaque(false);
            godsLabels2[i].setFont(new Font("黑体", Font.PLAIN, 30));
            godsLabels2[i].setBackground(Color.GRAY);
            godsLabels2[i].setBounds(960 + 100 * i, 525, 100, 170);
            mainGamePanel.add(godsLabels2[i]);
        }//gods

        startBtn.setBounds(1270, 420, 90, 50);
        mainGamePanel.add(startBtn);
        coinBtn1.setBounds(1270, 480, 90, 50);
        mainGamePanel.add(coinBtn1);
        coinBtn2.setBounds(1270, 540, 90, 50);
        mainGamePanel.add(coinBtn2);
        okButton.setBounds(1270, 600, 90, 50);
        mainGamePanel.add(okButton);
        godsGraceBtn1.setBounds(1370, 420, 90, 50);
        mainGamePanel.add(godsGraceBtn1);
        godsGraceBtn2.setBounds(1370, 480, 90, 50);
        mainGamePanel.add(godsGraceBtn2);
        p1GodsBtn1.setBounds(970 + 0, 200, 80, 40);
        mainGamePanel.add(p1GodsBtn1);
        p1GodsBtn2.setBounds(970 + 100, 200, 80, 40);
        mainGamePanel.add(p1GodsBtn2);
        p2GodsBtn1.setBounds(970 + 0, 705, 80, 40);
        mainGamePanel.add(p2GodsBtn1);
        p2GodsBtn2.setBounds(970 + 100, 705, 80, 40);
        mainGamePanel.add(p2GodsBtn2);

        playerStateLabel1.setBounds(30, 150, 100, 100);
        playerStateLabel1.setFont(new Font("黑体", Font.PLAIN, 20));
        mainGamePanel.add(playerStateLabel1);
        playerStateLabel2.setBounds(30, 380, 100, 100);
        playerStateLabel2.setFont(new Font("黑体", Font.PLAIN, 20));
        mainGamePanel.add(playerStateLabel2);

        for (int i = 0; i < 3; i++) {
            levelBtns[i] = new JButton("level" + (i + 1));
            levelBtns[i].setBounds(1170, 20 + 50 * i, 80, 40);
            mainGamePanel.add(levelBtns[i]);
            levelBtns[i].addActionListener(myListener);
        }//levelBtn

        startBtn.addActionListener(myListener);
        coinBtn1.addActionListener(myListener);
        coinBtn2.addActionListener(myListener);
        okButton.addActionListener(myListener);
        godsGraceBtn1.addActionListener(myListener);
        godsGraceBtn2.addActionListener(myListener);
        p1GodsBtn1.addActionListener(myListener);
        p1GodsBtn2.addActionListener(myListener);
        p2GodsBtn1.addActionListener(myListener);
        p2GodsBtn2.addActionListener(myListener);

        for (int i = 0; i < 6; i++) {
            diceButtons1[i] = new DiceButton("10" + i);
            diceButtons1[i].setBounds(353 + 100 * i, 138, 70, 40);
            mainGamePanel.add(diceButtons1[i]);
            diceButtons1[i].addActionListener(myListener);
        }
        for (int i = 0; i < 6; i++) {
            diceButtons2[i] = new DiceButton("20" + i);
            diceButtons2[i].setBounds(353 + 100 * i, 686, 70, 40);
            mainGamePanel.add(diceButtons2[i]);
            diceButtons2[i].addActionListener(myListener);
        }//diceButton

        textArea.setBounds(1270, 0, 200, 400);
        textArea.setLineWrap(true);//设置自动换行
        mainGamePanel.add(textArea);

        this.add(mainGamePanel);
        this.setBounds(100, 100, 1500, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public MainFrame() {
    }
}
