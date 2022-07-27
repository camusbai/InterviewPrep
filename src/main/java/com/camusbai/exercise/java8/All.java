package com.camusbai.exercise.java8;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Double.NaN;

public class All {
    private static Logger log = LoggerFactory.getLogger(All.class);

    public static void main(String[] args) {
        testAccessModifierPrivate();

        canYouUseArrayAsMapKey();

        double x = NaN;

        testForLoop();

        new Animal().getBehavior()
                .stream().filter(String::isEmpty).collect(Collectors.toList());

        System.out.println(null==null);

        canNullBePushedToStack();

        canNullBeAddedToList();
//        doesBigDecimalSubtractMutateCaller();

        sthGetsException();

        //Testing Optional map chain call that's null safe
        Animal monkey = new Animal();
        String subCategory = Optional.of(monkey).map(Animal::getCategory).map(Category::getSubCategory).orElse("Default");
        System.out.println(subCategory);
        monkey.getCategory().getSubCategory();
    }

    private static void testAccessModifierPrivate() {
        ClassWithPrivateField obj = new ClassWithPrivateField();
//        obj.intField;   // cannot access
    }

    private static void canYouUseArrayAsMapKey() {
        Map<Integer[], Integer> map = new HashMap<>();
        map.put(new Integer[]{1, 2}, 1);
        System.out.println(map.containsKey(new Integer[]{1, 2}));
    }

    private static void doesBigDecimalSubtractMutateCaller() {
        BigDecimal number1 = new BigDecimal(3);
        BigDecimal number2 = new BigDecimal(5);
        BigDecimal number3 = number1.subtract(number2);
        System.out.println(number1);
        System.out.println(number3);

        final String summary = "Summary: calling 'number1.subtract(number2)' won't change number1 value";
        System.out.println(summary);
    }

    private static  void canNullBePushedToStack(){
        Stack<Integer> s = new Stack<>();
        s.push(null);
        System.out.println("Yes, no exception thrown");
    }

    private static void canNullBeAddedToList() {
        List<String> list = new ArrayList<>();
        list.add(null);
        Assert.assertEquals(1, list.size());

        try {
            Optional<String> result = list.stream()
                    .filter(s -> s.equals("X"))
                    .findAny();
        } catch (NullPointerException npe) {
            final String summary = "Summary: 'null' can be added to a list; but if you get it from the list, be careful of NPE";
            System.out.println(summary);
        }
    }

    private static void sthGetsException() {
        try {
            sthThrowsException();
        } catch (Exception ex) {
            log.warn("my message", ex);
        }
    }

    private static void sthThrowsException(){
        throw new RuntimeException("This is message in exception");
    }

    private static void testForLoop() {
        for (int i = 1; i < 1; i++) {
            System.out.println("loop run");
        }
    }

    private static void arrayList() {
        List<Integer> list = new ArrayList<>();
        list.set(0, 1);
    }
}
