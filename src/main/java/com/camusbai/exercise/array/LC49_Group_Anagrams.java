package com.camusbai.exercise.array;

import java.util.*;

public class LC49_Group_Anagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams_hashMap(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for(String str:strs) {
            int[] count = new int[26];
            for(char c: str.toCharArray()){
                int idx = c-'a';
                count[idx]+=1;
            }
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<count.length; i++){
                if(count[i]>0){
                    builder.append('a'+i).append(count[i]);
                }
            }
            String key = builder.toString();
            if(group.containsKey(key)){
                group.get(key).add(str);
            } else{
                group.put(key, new ArrayList<>(Collections.singletonList(str)));
            }
        }
        return new ArrayList<>(group.values());
    }

    public List<List<String>> groupAnagrams_sorting(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            if(group.containsKey(key)){
                group.get(key).add(str);
            } else{
                group.put(key, new ArrayList<>(Collections.singletonList(str)));
            }
        }
        return new ArrayList<>(group.values());
    }
}