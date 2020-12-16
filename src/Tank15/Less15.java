package Tank15;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Less15 {
    static HashMap<Integer, String> a2map(int[] akey, String[] aval) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for (int i = 0; i < akey.length; i++) {

            map.put(akey[i], aval[i]);
        }
        return map;
    }

    static int fillHoles(Map<Integer, String> map, int size) {

            int temp = 0;
            for (int i = 1; i <= size; i++) {
                String oldValue = map.putIfAbsent(i, "number" + i);
                if (oldValue == null) temp++;


            }
            return temp;
        }

        public static void main (String[]args){

            System.out.println(a2map(new int[]{12, 7, 10, 5}, new String[]{"Cow", "Sheep", "Pig", "Goat"}));

            int akey1[] = {9, 7, 5};
            String aval1[] = {"Вася", "Петя", "Даша"};
            System.out.println(a2map(akey1, aval1));

            int akey3[] = {};
            String aval3[] = {};
            System.out.println(a2map(akey3, aval3));


            Map<Integer, String> map1 = new HashMap<>();
            System.out.println(fillHoles(map1, 4)+":");
            System.out.print(map1);

            int akey2[] = {8, 3, 4};
            String aval2[] = {"num 8", "num 3", "num 4"};
            Map<Integer, String> map2 = a2map(akey1, aval1);
            System.out.println(fillHoles(map2, 5)+":");
            System.out.println(map2);

            int akey4[] = {1, 3, 4};
            String aval4[] = {"num 1", "num 1", "num 4"};
            Map<Integer, String> map3 = a2map(akey2, aval2);
            System.out.println(fillHoles(map3, 5)+":");
            System.out.println(map3);

        }
    }

