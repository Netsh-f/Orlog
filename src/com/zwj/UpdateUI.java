package com.zwj;

public class UpdateUI implements Runnable{
    public void work(){
        while (true) {
            MainFrame.mainFrame.playerStateLabel1.setText("<html><body>" + Player.player1.name + "<br>HP:" + Player.player1.hp +
                    "<br>magic:" + Player.player1.magic + "<body></html>");
            MainFrame.mainFrame.playerStateLabel2.setText("<html><body>" + Player.player2.name + "<br>HP:" + Player.player2.hp +
                    "<br>magic:" + Player.player2.magic + "<body></html>");
        }
    }

    @Override
    public void run() {
        work();
    }
}
