package com.zwj;

import javax.swing.*;

public class magicJLabel extends JLabel {
    public magicJLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public magicJLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public magicJLabel(String text) {
        super(text);
    }

    public magicJLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public magicJLabel(Icon image) {
        super(image);
    }

    public magicJLabel() {
    }
}
