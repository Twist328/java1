package ru.progwards.java1.lessons.sets;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//Укажите, что будет выведено на консоль в результате выполнения метода:

public class UnionOFset {
    public void unionOfSets() {
        HashSet set1 = new HashSet(Set.of(1, 3, 5, 12, 45));
        HashSet set2 = new HashSet(Set.of(12, 44, 2, 1, 4));
        set1.addAll(set2);
        System.out.println(set1.size());
    }
    public static void main(String[] args) {
        new UnionOFset().unionOfSets();
    }
    }



