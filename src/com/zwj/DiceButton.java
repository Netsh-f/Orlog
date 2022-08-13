package com.zwj;

import javax.swing.*;

public class DiceButton extends JButton {
    public DiceButton() {
    }

    public DiceButton(Icon icon) {
        super(icon);
    }

    public DiceButton(String text) {
        super(text);
    }

    public DiceButton(Action a) {
        super(a);
    }

    public DiceButton(String text, Icon icon) {
        super(text, icon);
    }
}
