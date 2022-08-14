package com.zwj;

import javax.swing.*;
import java.awt.*;

public class MainGamePanel extends JPanel {

    static ImageIcon backgroundImage = new ImageIcon(test.class.getClassLoader().getResource("image/background_868_488.png"));

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage.getImage(), 0, -20, 1500, 844, null);
        super.paintChildren(g);
    }
}
