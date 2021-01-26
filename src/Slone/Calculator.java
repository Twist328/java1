package Slone;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}

class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator 2.5");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();

    }

    private static String start(String strInn) throws Exception {
        StringBuilder sbStack = new StringBuilder(""), sbOut = new StringBuilder("");
        char charInn, charTmp;

        for (int i = 0; i < strInn.length(); i++) {
            charInn = strInn.charAt(i);
            if (isOperate(charInn)) {
                while (sbStack.length() > 0) {
                    charTmp = sbStack.substring(sbStack.length() - 1).charAt(0);
                    if (isOperate(charTmp) && (operPrior(charInn) <= operPrior(charTmp))) {
                        sbOut.append(" ").append(charTmp).append(" ");
                        sbStack.setLength(sbStack.length() - 1);
                    } else {
                        sbOut.append(" ");
                        break;
                    }
                }
                sbOut.append(" ");
                sbStack.append(charInn);
            } else if ('(' == charInn) {
                sbStack.append(charInn);
            } else if (')' == charInn) {
                charTmp = sbStack.substring(sbStack.length() - 1).charAt(0);
                while ('(' != charTmp) {
                    if (sbStack.length() < 1) {
                        throw new Exception("Ошибка разбора скобок. Проверьте правильность выражения.");
                    }
                    sbOut.append(" ").append(charTmp);
                    sbStack.setLength(sbStack.length() - 1);
                    charTmp = sbStack.substring(sbStack.length() - 1).charAt(0);
                }
                sbStack.setLength(sbStack.length() - 1);
            } else {
                // Если символ не оператор - добавляем в выходную последовательность
                sbOut.append(charInn);
            }
        }

        // Если в стеке остались операторы, добавляем их в входную строку
        while (sbStack.length() > 0) {
            sbOut.append(" ").append(sbStack.substring(sbStack.length() - 1));
            sbStack.setLength(sbStack.length() - 1);
        }

        return sbOut.toString();
    }

    /**
     * Функция проверяет, является ли текущий символ оператором
     */
    private static boolean isOperate(char c) {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
            case '%':
            case '^':
                return true;
        }
        return false;
    }

    /**
     * Возвращает приоритет операции
     *
     * @param oper char
     * @return byte
     */
    private static byte operPrior(char oper) {
        switch (oper) {
            case '^':
            case '=':
                return 3;
            case '*':
            case '%':
            case '/':
                return 2;
        }
        return 1; // Тут остается + и -
    }

    /**
     * Считает выражение, записанное в обратной польской нотации
     *
     * @param
     * @return double result
     */
    class CalculatorPanel extends JPanel {
        public CalculatorPanel() {
            setLayout(new BorderLayout());

            result = 0;
            lastCommand = "=";
            start = true;

            display = new JButton("0");
            display.setEnabled(false);
            add(display, BorderLayout.NORTH);

            ActionListener insert = new InsertAction();
            ActionListener command = new CommandAction();

            panel = new JPanel();
            panel.setLayout(new GridLayout(6, 5));

            addButton("tan", command);
            addButton("", insert);
            addButton("", insert);
            addButton("", insert);
            addButton("", insert);

            addButton("√", command);
            addButton("√3", command);
            addButton("sin", command);
            addButton("cos", command);
            addButton("0000", insert);

            addButton("%", command);
            addButton("7", insert);
            addButton("8", insert);
            addButton("9", insert);
            addButton("/", command);

            addButton("%mod", command);
            addButton("4", insert);
            addButton("5", insert);
            addButton("6", insert);
            addButton("*", command);

            addButton("pow", command);
            addButton("1", insert);
            addButton("2", insert);
            addButton("3", insert);
            addButton("-", command);

            addButton("Cl", command);
            addButton("0", insert);
            addButton(".", insert);
            addButton("=", command);
            addButton("+", command);

            add(panel, BorderLayout.CENTER);

        }

        private void addButton(String label, ActionListener listener) {
            JButton button = new JButton(label);
            button.addActionListener(listener);
            panel.add(button);
        }

        private class InsertAction implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                String input = event.getActionCommand();
                if (start) {
                    display.setText("");
                    start = false;
                }
                display.setText(display.getText() + input);

            }

        }

        private class CommandAction implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                String command = event.getActionCommand();
                if (start) {
                    if (command.equals("Cl")) {
                        display.setText(command);
                        display.setText("");
                        start = false;
                    } else lastCommand = command;
                } else {
                    try {
                        calculate((Double.parseDouble(display.getText())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    lastCommand = command;
                    start = true;
                }
            }
        }

        public void calculate(double x) {

            switch (lastCommand) {
                case "+":
                    result = Math.rint((result + x) * 100) / 100;
                    break;
                case "-":
                    result = Math.rint((result - x) * 100) / 100;
                    break;
                case "*":
                    result = Math.rint((result * x) * 100) / 100;
                    break;
                case "/":
                    result = Math.rint((result / x) * 100) / 100;
                    break;
                case "%mod":
                    result %= x;
                    break;
                case "pow":
                    result = Math.pow(result, x);
                    break;
                case "%":
                    result = (result * x) / 100;
                    break;
                case "√":
                    result = Math.sqrt(result);
                    break;
                case "√3":
                    result = Math.cbrt(result);
                    break;
                case "sin":
                    result = Math.sin(result);
                    break;
                case "cos":
                    result = Math.cos(result);
                    break;
                case "tan":
                    result = Math.tan(result);
                    break;
                case "=":
                    result = x;//Math.sin
                    break;

            }
            display.setText("" + result);
        }

        private JButton display;
        private JPanel panel;
        private double result;
        private String lastCommand;
        private boolean start;
    }
}

