package Goon;

import java.util.HashSet;
import java.util.Set;

public class SetInteger {


    public static Set<Integer> unionOfSets(final Set set1, final Set set2) {
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        return result;
    }//Укажите, что будет выведено на консоль в результате выполнения метода

    public static void main(String[] args) {

        Set<Integer> intSet1 = Set.of(1, 3, 5, 12, 45);
        Set<Integer> intSet2 = Set.of(12, 44, 2, 1, 4);
        Set<Integer> unionSet = unionOfSets(intSet1, intSet2);

        System.out.println(intSet1);
        System.out.println(intSet2);
        System.out.println(unionSet);
        System.out.println(unionSet.size());
    }
}
