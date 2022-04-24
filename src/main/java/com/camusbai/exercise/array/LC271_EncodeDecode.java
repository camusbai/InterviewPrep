package com.camusbai.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC271_EncodeDecode {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("lin\\t|", "|code", "l\\\\ove", "you");
        String encode = encode(input);
        List<String> decode = decode(encode);
        System.out.println(decode);
    }

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str:strs){
            for (char c : str.toCharArray()) {
                if (c == '|') {
                    builder.append('\\').append(c);
                } else if (c == '\\') {
                    builder.append('\\').append(c);
                } else {
                    builder.append(c);
                }
            }
            builder.append("|");
        }
        return builder.substring(0, builder.length() - 1);
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();
        for (String segment : str.split("\\|")) {
            boolean escaperSignFound = false;
            for (char c : segment.toCharArray()) {
                if (c == '\\') {
                    if (!escaperSignFound) {
                        escaperSignFound = true;
                    } else {
                        escaperSignFound = false;
                        continue;
                    }
                }
                wordBuilder.append(c);
            }

            if (escaperSignFound) {
                wordBuilder.replace(wordBuilder.length()-1, wordBuilder.length(), "|");
            } else {
                result.add(wordBuilder.toString());
                wordBuilder = new StringBuilder();
            }
        }
        return result;
    }

    public static String encode2(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append("#").append(str);
        }
        return builder.toString();
    }

    public static List<String> decode2(String str) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        int length = 0;
        while (idx < str.length()) {
            char c = str.charAt(idx);
            if (c >= '0' && c <= '9') {
                length = length * 10 + (c - '0');
                idx++;
            } else {
                result.add(str.substring(idx + 1, idx + 1 + length));
                idx = idx + 1 + length;
                length = 0;
            }
        }
        return result;
    }
}
