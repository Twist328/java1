package ru.progwards.java1.lessons.sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {     //объединение множеств

        /*HashSet<Integer> res = new HashSet(set1);
        res.addAll(set2);*/
        HashSet<Integer>res=new HashSet<Integer>(set1);
        res.addAll(set2);
        return res;
    }
//_____________________________________________________________//

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {   //пересечение множеств

        /*if (set1 == null || set2 == null) return new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>(set1);
        res.retainAll(set2);*/
        if (set1 == null || set2 == null) return new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>(set1);
        res.retainAll(set2);
        return res;
    }

    //________________________________________________________________________//
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {   //разница множеств

        /*if (set1 == null) return new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>(set1);
        if (set2 != null) res.removeAll(set2);*/
        if(set1==null)return new HashSet<Integer>();
        HashSet<Integer>res=new HashSet<Integer>(set1);
        if(set2!=null)res.removeAll(set2);

        return res;
    }

    //_______________________________________________________________________________________________________//
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {   //Симметрическая разница

        /*Set<Integer> res1 = set1 != null ? new HashSet<Integer>(set1) : new HashSet<Integer>();
        Set<Integer> res2 = set2 != null ? new HashSet<Integer>(set2) : new HashSet<Integer>();
        res1.removeAll(set2);
        res2.removeAll(set1);
        res1.addAll(res2);*/
        Set<Integer>res1=set1!=null?new HashSet<Integer>(set1) : new HashSet<Integer>();
        Set<Integer>res2=set2!=null?new HashSet<Integer>(set2) : new HashSet<Integer>();
        res1.removeAll(set2);
        res2.removeAll(set1);
        res1.addAll(res2);

        return res1;
    }

    public static void main(String[] args) {

        Set<Integer> intSet1 = Set.of(0, 1, 2, 4, 5, 6, 9);
        Set<Integer> intSet2 = Set.of(0, 2, 3, 4, 6, 7, 9, 10);
        Set<Integer> union = union(intSet1, intSet2);
        Set<Integer> intersection = intersection(intSet1, intSet2);
        Set<Integer> difference = difference(intSet1, intSet2);
        Set<Integer> symDifference = symDifference(intSet1, intSet2);

        System.out.println(intSet1);
        System.out.println(intSet2);
        System.out.println(union);
        System.out.println(union.size());

        System.out.println(intersection);
        System.out.println(intersection.size());

        System.out.println(difference);
        System.out.println(difference.size());

        System.out.println(symDifference);
        System.out.println(symDifference.size());
    }

}





