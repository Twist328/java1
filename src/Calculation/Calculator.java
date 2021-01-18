package Calculation;

import java.io.*;
import java.util.*;

public class Calculator {


    /**
     * Преобразовать строку в обратную польскую нотацию
     *
     * @param strInn Входная строка
     * @return Выходная строка в обратной польской нотации
     */
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
     * @param op char
     * @return byte
     */
    private static byte operPrior(char oper) {
        switch (oper) {
            case '^':
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
     * @param strInn
     * @return double result
     */
    private static double calculate(String strInn) throws Exception {
        double result = 0, x = 0;
        String strTmp;
        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer tokenizer = new StringTokenizer(strInn);
        while (tokenizer.hasMoreTokens()) {
            try {
                strTmp = tokenizer.nextToken().trim();
                if (strTmp.length() == 1 && isOperate(strTmp.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Неверное количество данных в стеке для операции " + strTmp);
                    }
                    x = stack.pop();
                    result = stack.pop();
                    switch (strTmp.charAt(0)) {
                        case '+':
                            result = Math.rint(result + x);
                            break;
                        case '-':
                            result = Math.rint(result - x);
                            break;
                        case '/':
                            result = Math.rint(result / x);
                            break;
                        case '*':
                            result = Math.rint(result * x);
                            break;
                        case '%':
                            result %= x;
                            break;
                        case '^':
                            result = Math.pow(result, x);
                            break;
                        default:
                            throw new Exception("Недопустимая операция " + strTmp);
                    }
                    stack.push(result);
                } else {
                    result = Double.parseDouble(strTmp);
                    stack.push(result);
                }
            } catch (Exception e) {
                throw new Exception("Недопустимый символ в выражении");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("Количество операторов не соответствует количеству операндов");
        }

        return stack.pop();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strInn;

        try {
            System.out.println("Введите выражение для расчета. Поддерживаются цифры, операции +,-,*,/,^,% и приоритеты в виде скобок ( и ):");
            strInn = br.readLine();
            strInn = start(strInn);
            System.out.println(calculate(strInn));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

