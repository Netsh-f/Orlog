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
    public magicJLabel[] magicLabels1 = new magicJLabel[30];
    public magicJLabel[] magicLabels2 = new magicJLabel[30];
    public DiceJLabel[] settleLabels1 = new DiceJLabel[12];
    public DiceJLabel[] settleLabels2 = new DiceJLabel[12];

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
                    case "Play":
                        ButtonAction.startBtnAction();
                        break;
                    case "正面":
                        ButtonAction.coinBtn1Action();
                        break;
                    case "反面":
                        ButtonAction.coinBtn2Action();
                        break;
                    case "确定":
                        ButtonAction.okBtnAction();
                        break;
                    case "是":
                        ButtonAction.godsGraceAction1();
                        break;
                    case "否":
                        ButtonAction.godsGraceAction2();
                        break;
                    case "p1Thor":
                        ButtonAction.godsGraceNum1();
                        break;
                    case "p1Heimdallr":
                        ButtonAction.godsGraceNum2();
                        break;
                    case "p2Thor":
                        ButtonAction.godsGraceNum1();
                        break;
                    case "p2Heimdallr":
                        ButtonAction.godsGraceNum2();
                        break;
                    case "level1":
                        ButtonAction.levelAction(1);
                        break;
                    case "level2":
                        ButtonAction.levelAction(2);
                        break;
                    case "level3":
                        ButtonAction.levelAction(3);
                        break;
                    case "100":
                        ButtonAction.diceSelectdAction(Player.player1, 0);
                        break;
                    case "101":
                        ButtonAction.diceSelectdAction(Player.player1, 1);
                        break;
                    case "102":
                        ButtonAction.diceSelectdAction(Player.player1, 2);
                        break;
                    case "103":
                        ButtonAction.diceSelectdAction(Player.player1, 3);
                        break;
                    case "104":
                        ButtonAction.diceSelectdAction(Player.player1, 4);
                        break;
                    case "105":
                        ButtonAction.diceSelectdAction(Player.player1, 5);
                        break;
                    case "200":
                        ButtonAction.diceSelectdAction(Player.player2, 0);
                        break;
                    case "201":
                        ButtonAction.diceSelectdAction(Player.player2, 1);
                        break;
                    case "202":
                        ButtonAction.diceSelectdAction(Player.player2, 2);
                        break;
                    case "203":
                        ButtonAction.diceSelectdAction(Player.player2, 3);
                        break;
                    case "204":
                        ButtonAction.diceSelectdAction(Player.player2, 4);
                        break;
                    case "205":
                        ButtonAction.diceSelectdAction(Player.player2, 5);
                        break;
                }
            }
        };

        mainGamePanel.setLayout(null);
        for (
                int i = 0;
                i < 6; i++) {
            diceLabels1[i] = new DiceJLabel("label" + i, JLabel.CENTER);
            diceLabels1[i].setOpaque(false);
            diceLabels1[i].setFont(new Font("黑体", Font.PLAIN, 20));
            diceLabels1[i].setBackground(Color.CYAN);
            diceLabels1[i].setBounds(350 + 100 * i, 50, 120, 75);//玩家1的骰子
            diceLabels1[i].setVisible(false);
            mainGamePanel.add(diceLabels1[i]);
        }
        for (
                int i = 0;
                i < 6; i++) {
            diceLabels2[i] = new DiceJLabel("Label" + i, JLabel.CENTER);
            diceLabels2[i].setOpaque(false);
            diceLabels2[i].setFont(new Font("黑体", Font.PLAIN, 20));
            diceLabels2[i].setBackground(Color.CYAN);
            diceLabels2[i].setBounds(350 + 100 * i, 600, 120, 75);//玩家2的骰子
            diceLabels2[i].setVisible(false);
            mainGamePanel.add(diceLabels2[i]);
        }//骰子diceLabels

        for (
                int i = 0;
                i < 12; i++) {
            ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/none.png"));
            diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
            settleLabels1[i] = new DiceJLabel(diceImageIcon);

            settleLabels1[i].setOpaque(false);
            settleLabels1[i].setVisible(false);
            settleLabels1[i].setBounds(150 + 80 * i, 270, 120, 75);
            mainGamePanel.add(settleLabels1[i]);
        }
        for (
                int i = 0;
                i < 12; i++) {
            ImageIcon diceImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/none.png"));
            diceImageIcon.setImage(diceImageIcon.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
            settleLabels2[i] = new DiceJLabel(diceImageIcon);

            settleLabels2[i].setOpaque(false);
            settleLabels2[i].setVisible(false);
            settleLabels2[i].setBounds(150 + 80 * i, 400, 120, 75);
            mainGamePanel.add(settleLabels2[i]);
        }//settleLabels

        for (
                int i = 0;
                i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int k = i * 5 + j;
                ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stone" + k + ".png"));
                stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                hpLabels1[k] = new HPJLabel(stoneImageIcon);
                hpLabels1[k].setOpaque(false);
//                hpLabels1[k].setFont(new Font("黑体", Font.PLAIN, 12));
//                hpLabels1[k].setBackground(Color.RED);
                hpLabels1[k].setVisible(false);
                hpLabels1[k].setBounds(50 + 50 * j, 30 + 50 * i, 40, 50);
                mainGamePanel.add(hpLabels1[k]);
            }
        }
        for (
                int i = 0;
                i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int k = i * 5 + j;
                ImageIcon stoneImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/stone" + k + ".png"));
                stoneImageIcon.setImage(stoneImageIcon.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT));
                hpLabels2[k] = new HPJLabel(stoneImageIcon);
                hpLabels2[k].setOpaque(false);
//                hpLabels2[k].setFont(new Font("黑体", Font.PLAIN, 12));
//                hpLabels2[k].setBackground(Color.RED);
                hpLabels2[k].setVisible(false);
                hpLabels2[k].setBounds(50 + 50 * j, 580 + 50 * i, 40, 50);
                mainGamePanel.add(hpLabels2[k]);
            }
        }//hp

        for (
                int i = 0;
                i < 2; i++) {
//            godsLabels1[i] = new GodsJLabel("Gods" + i, JLabel.CENTER);
            ImageIcon godsImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/gods" + (i + 1) + ".png"));
            godsImageIcon.setImage(godsImageIcon.getImage().getScaledInstance(100, 175, Image.SCALE_DEFAULT));
            godsLabels1[i] = new GodsJLabel(godsImageIcon);
            godsLabels1[i].setOpaque(false);
            godsLabels1[i].setFont(new Font("黑体", Font.PLAIN, 30));
            godsLabels1[i].setBackground(Color.GRAY);
            godsLabels1[i].setBounds(1200 + 100 * i, 20, 100, 170);
            godsLabels1[i].setVisible(false);
            mainGamePanel.add(godsLabels1[i]);
        }
        for (
                int i = 0;
                i < 2; i++) {
            ImageIcon godsImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/gods" + (i + 1) + ".png"));
            godsImageIcon.setImage(godsImageIcon.getImage().getScaledInstance(100, 175, Image.SCALE_DEFAULT));
            godsLabels2[i] = new GodsJLabel(godsImageIcon);
            godsLabels2[i].setOpaque(false);
            godsLabels2[i].setFont(new Font("黑体", Font.PLAIN, 30));
            godsLabels2[i].setBackground(Color.GRAY);
            godsLabels2[i].setBounds(1200 + 100 * i, 525, 100, 170);
            godsLabels2[i].setVisible(false);
            mainGamePanel.add(godsLabels2[i]);
        }//godsLabels

        for (
                int i = 0;
                i < 6; i++) {
            for (int j = 4; j >= 0; j--) {
                int k = i * 5 + j;
                ImageIcon magicImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/magic.png"));
                magicImageIcon.setImage(magicImageIcon.getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT));
                magicLabels1[k] = new magicJLabel(magicImageIcon);
                magicLabels1[k].setVisible(false);
                magicLabels1[k].setOpaque(false);
                magicLabels1[k].setBounds(930 + 4 * j + 67 * i - 198 * (i / 3), 30 - 6 * j + 100 * (i / 3), 100, 100);
                mainGamePanel.add(magicLabels1[k]);
            }
        }
        for (
                int i = 0;
                i < 6; i++) {
            for (int j = 4; j >= 0; j--) {
                int k = i * 5 + j;
                ImageIcon magicImageIcon = new ImageIcon(test.class.getClassLoader().getResource("image/magic.png"));
                magicImageIcon.setImage(magicImageIcon.getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT));
                magicLabels2[k] = new magicJLabel(magicImageIcon);
                magicLabels2[k].setVisible(false);
                magicLabels2[k].setOpaque(false);
                magicLabels2[k].setBounds(930 + (4 * j) + (67 * i) - (198 * (i / 3)), 570 - (6 * j) + (100 * (i / 3)), 100, 100);
                mainGamePanel.add(magicLabels2[k]);
            }
        }//magicLabels

        startBtn.setBounds(80, 50, 230, 70);
        startBtn.setFont(new

                Font("黑体", Font.PLAIN, 40));
        startBtn.setContentAreaFilled(false);//透明
//        startBtn.setBorderPainted(false);//去边框
        startBtn.setFocusPainted(false);//去焦点
        startBtn.setForeground(Color.GRAY);
        mainGamePanel.add(startBtn);
        coinBtn1.setBounds(1480, 480, 90, 50);
        mainGamePanel.add(coinBtn1);
        coinBtn2.setBounds(1480, 540, 90, 50);
        mainGamePanel.add(coinBtn2);
        okButton.setBounds(1480, 600, 90, 50);
        mainGamePanel.add(okButton);


        godsGraceBtn1.setBounds(1580, 420, 90, 50);
        mainGamePanel.add(godsGraceBtn1);
        godsGraceBtn2.setBounds(1580, 480, 90, 50);
        mainGamePanel.add(godsGraceBtn2);

        p1GodsBtn1.setBounds(1210, 25, 80, 160);
        p1GodsBtn1.setContentAreaFilled(false);
        p1GodsBtn1.setBorderPainted(false);
        p1GodsBtn1.setFocusPainted(false);
        mainGamePanel.add(p1GodsBtn1);

        p1GodsBtn2.setBounds(1210 + 100, 25, 80, 160);
        p1GodsBtn2.setContentAreaFilled(false);
        p1GodsBtn2.setBorderPainted(false);
        p1GodsBtn2.setFocusPainted(false);
        mainGamePanel.add(p1GodsBtn2);

        p2GodsBtn1.setBounds(1210, 530, 80, 160);
        p2GodsBtn1.setContentAreaFilled(false);
        p2GodsBtn1.setBorderPainted(false);
        p2GodsBtn1.setFocusPainted(false);
        mainGamePanel.add(p2GodsBtn1);

        p2GodsBtn2.setBounds(1210 + 100, 530, 80, 160);
        p2GodsBtn2.setContentAreaFilled(false);
        p2GodsBtn2.setBorderPainted(false);
        p2GodsBtn2.setFocusPainted(false);
        mainGamePanel.add(p2GodsBtn2);

        playerStateLabel1.setBounds(30, 170, 100, 100);
        playerStateLabel1.setFont(new

                Font("黑体", Font.PLAIN, 20));
        playerStateLabel1.setVisible(false);
        mainGamePanel.add(playerStateLabel1);
        playerStateLabel2.setBounds(30, 480, 100, 100);
        playerStateLabel2.setFont(new

                Font("黑体", Font.PLAIN, 20));
        playerStateLabel2.setVisible(false);
        mainGamePanel.add(playerStateLabel2);

        for (
                int i = 0;
                i < 3; i++) {
            levelBtns[i] = new JButton("level" + (i + 1));
            levelBtns[i].setBounds(1580, 550 + 50 * i, 80, 40);
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

        for (
                int i = 0;
                i < 6; i++) {
            diceButtons1[i] = new DiceButton("10" + i);
//            diceButtons1[i].setBounds(353 + 100 * i, 138, 70, 40);
            diceButtons1[i].setBounds(351 + 100 * i, 50, 75, 75);

            diceButtons1[i].setContentAreaFilled(false);//透明
            diceButtons1[i].setBorderPainted(false);//去边框
            diceButtons1[i].setFocusPainted(false);//去焦点

            mainGamePanel.add(diceButtons1[i]);
            diceButtons1[i].addActionListener(myListener);
        }
        for (
                int i = 0;
                i < 6; i++) {
            diceButtons2[i] = new DiceButton("20" + i);
            diceButtons2[i].setBounds(351 + 100 * i, 600, 75, 75);

            diceButtons2[i].setContentAreaFilled(false);
            diceButtons2[i].setBorderPainted(false);
            diceButtons2[i].setFocusPainted(false);

            mainGamePanel.add(diceButtons2[i]);
            diceButtons2[i].addActionListener(myListener);
        }//diceButton

        textArea.setBounds(1520, 0, 150, 400);
        textArea.setLineWrap(true);//设置自动换行
        mainGamePanel.add(textArea);

        this.

                add(mainGamePanel);
        this.

                setBounds(100, 100, 1700, 800);
        this.

                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.

                setVisible(true);

    }

    public MainFrame() {
    }
}
