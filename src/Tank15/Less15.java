package Tank15;

import java.util.HashMap;

public class Less15 {
    static HashMap<Integer, String> a2map(int[] akey, String[] aval) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for (int i = 0; i < akey.length; i++) {

            map.put(akey[i], aval[i]);
        }
        return map;
    }


    public static void main(String[] args) {

        System.out.println(a2map(new int[]{12, 7, 10, 5}, new String[]{"Cow", "Sheep", "Pig", "Goat"}));
        int akey1[] = {9, 7, 5};
        String aval1[] = {"Вася", "Петя", "Даша"};
        System.out.println(a2map(akey1, aval1));
        int akey3[] = {};
        String aval3[] = {};
        System.out.println(a2map(akey3, aval3));
    }
}

