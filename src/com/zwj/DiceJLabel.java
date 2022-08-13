package com.zwj;

import javax.swing.*;

public class DiceJLabel extends JLabel {
    public DiceJLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public DiceJLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public DiceJLabel(String text) {
        super(text);
    }

    public DiceJLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public DiceJLabel(Icon image) {
        super(image);
    }

    public DiceJLabel() {
    }
}
