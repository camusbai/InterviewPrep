package com.camusbai.exercise;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test1 {
    static class Filter {
        static Predicate<String> nameStartingWithPrefix(String prefix) {
            return str -> str.startsWith(prefix);
        }
    }

    public static void main(String[] args) {
        String prefix = "sdf";
        Predicate<String> x = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
    }

    public static Function<String, CharactersCount> getDistinctCharactersCount() {
        return (String str) -> {
            Set<Character> set = new HashSet<>();
            for(char c: str.toCharArray()) {
                set.add(c);
            }
            return new CharactersCount(str, set.size());
        };
    }

    static class CharactersCount {
        private final String name;
        private final Integer distinctCharacterCount;

        public CharactersCount(String name, Integer distinctCharacterCount) {
            this.name = name;
            this.distinctCharacterCount = distinctCharacterCount;
        }

        @Override
        public String toString() {
            return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
        }
    }
}
