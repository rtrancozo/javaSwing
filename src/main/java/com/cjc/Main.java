package com.cjc;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }

}
