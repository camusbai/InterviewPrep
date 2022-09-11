package com.camusbai.exercise.OA;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Owl {
    public static void main(String[] args) {
//        String[] input = new String[]{"ZBCWG", "ZC", "CDY", "ZCDY", "BCWG", "ZCDYH"};
//        int[] sizes = new int[]{2, 3, 4};
        String[] input = new String[]{"WBCKE", "WB", "CK", "WKE", "QYZ", "QYZ", "WCK"};
        int[] sizes = new int[]{2, 3, 5};
        String[] result = new Owl().findAllBundles(input, sizes);
        for (String s : result) {
            System.out.print(s+", ");
        }
        System.out.println();
    }

    public String[] findAllBundles(String[] products, int[] bundleSizes) {
        List<String> finalResult = new ArrayList<>();
        boolean[][] boolArrayOfProducts = new boolean[products.length][];
        for(int i=0;i<products.length;i++) {
            boolArrayOfProducts[i] = convertWordToBoolArray(products[i]);
        }

        for(int bundleSize: bundleSizes) {
            Map<String, Integer> bundleToCount = new HashMap<>();
            for(int i=0;i<boolArrayOfProducts.length-1;i++){
                for(int j=i+1;j<boolArrayOfProducts.length;j++) {
                    findBundle(boolArrayOfProducts[i], boolArrayOfProducts[j], bundleSize, bundleToCount);
                }
            }
            TreeMap<Integer, List<String>> sorted = new TreeMap<>((a,b)-> b-a);
            for(String key : bundleToCount.keySet()) {
                Integer count = bundleToCount.get(key);
                if(sorted.containsKey(count)){
                    sorted.get(count).add(key);
                }else{
                    List<String> list = new ArrayList<>();
                    list.add(key);
                    sorted.put(count, list);
                }
            }
            if(!sorted.isEmpty()) {
                finalResult.addAll(sorted.get(sorted.firstKey()));
            }

        }
        String[] arrayResult = new String[finalResult.size()];
        finalResult.toArray(arrayResult);
        Arrays.sort(arrayResult);
        return arrayResult;
    }

    // word consists of only unique uppercase letters
    private boolean[] convertWordToBoolArray(String word) {
        if(word==null || word.length()<1) return null;
        boolean[] boolArray = new boolean[26];
        for(int i=0;i<word.length();i++) {
            int pos = word.charAt(i) - 'A';
            boolArray[pos] = true;
        }
        return boolArray;
    }

    private void findBundle(boolean[] word1, boolean[] word2, int size, Map<String, Integer> bundleToCount) {
        boolean[] overlapChar = new boolean[26];
        int overlapSize = 0;
        for(int i=0;i<26;i++) {
            if(word1[i] && word2[i]) {
                overlapChar[i]=true;
                overlapSize++;
            }
        }
        if(overlapSize<size)  return;

        List<Character> chars = new ArrayList<>();
        for(int i=0;i<26;i++) {
            if(overlapChar[i]) {
                chars.add((char) ('A'+i));
            }
        }
        List<String> result = new ArrayList<>();
        generateCombs(chars, 0, size, "", result);
        for(String combo: result) {
            bundleToCount.put(combo, bundleToCount.getOrDefault(combo, 0)+1);
        }
    }

    private void generateCombs(List<Character> chars, int start, int size, String combo, List<String> result) {
        if(combo.length()==size) {
            result.add(combo);
            return;
        }
        for(int i=start; i<chars.size(); i++) {
            generateCombs(chars, i+1, size, combo+chars.get(i), result);
        }
    }
}



