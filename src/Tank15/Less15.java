package Tank15;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
    static void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value){
        //System.out.println("\nkey=" + key);
        if (map.containsKey(key) || map == null || map.size() < 2) return;
        Integer first = map.firstKey();
        System.out.println("first=" + first);
        if (key < first) return;
        Integer last = map.lastKey();
        System.out.println("last=" + last);
        if (key > last) return;
        map.put(key, value);
        System.out.println("TreeMap:");
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

            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(1, "Один");
            treeMap.put(9, "Девять");
            checkAndAdd(treeMap, 0, "Ноль");
            checkAndAdd(treeMap, 3, "Три");
            checkAndAdd(treeMap, 2, "Два");
            checkAndAdd(treeMap, 3, "Three");
            checkAndAdd(treeMap, 10, "Ten");
            System.out.println(treeMap);

            TreeMap<Integer, String> map = new TreeMap<>();
            checkAndAdd(map, 0, "Zero");
            checkAndAdd(map, 0, "Zero");
            System.out.println(map);
        }


}

