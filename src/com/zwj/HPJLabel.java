package com.zwj;

import javax.swing.*;

public class HPJLabel extends JLabel {
    public HPJLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public HPJLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public HPJLabel(String text) {
        super(text);
    }

    public HPJLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public HPJLabel(Icon image) {
        super(image);
    }

    public HPJLabel() {
    }
}
