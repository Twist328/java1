package Goon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DQtest {

    static int sumLastAndFirst(ArrayDeque<Integer> deque) {
        if (deque.isEmpty())
            return 0;
        int sum = deque.peekLast() + deque.peekFirst();
        return sum;
    }

    //______________________________________________________________//
    static String swapWords(String sentance) {
        boolean initWord = true;
        int i = 0;
        String insert = "";
        StringBuilder sb = new StringBuilder(sentance.length());
        StringTokenizer tokenizer = new StringTokenizer(sentance, " .,-!\n");
        while (tokenizer.hasMoreTokens()) {
            if (i++ % 2 == 1 ) {
                if (!initWord) sb.append(" ");
                else initWord = false;
                sb.append(tokenizer.nextToken() + " " + insert);
                insert = "";
            } else insert = tokenizer.nextToken();
        }
        if (!insert.isEmpty()) sb.append(" " + insert);
        return sb.toString();
    }

    public static void main(String[] args) {

        Integer a[] = {889, 19, 22, 19};
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(Arrays.asList(a));
        int res = sumLastAndFirst(deque);
        System.out.println(sumLastAndFirst(deque));

        String txt =
                "StringTokenizer - этот класс, " +
                        "нам строку разобьёт на раз.\n";
        StringTokenizer tokenizer = new StringTokenizer(txt, " .,");
        while (tokenizer.hasMoreTokens())
            System.out.print(tokenizer.nextToken());

        System.out.println(swapWords("\n" + "Слово - серебро, молчание - золото!"));
        System.out.println(swapWords("Тех слов, где есть хоть капля яда\n" +
                "И в шутку говорить не надо.\n" +
                "(c) Абу Шукур Балхи"));
        System.out.println(swapWords("Убитых словом, добивают молчанием. (c) Уильям Шекспир."));
    }
}


