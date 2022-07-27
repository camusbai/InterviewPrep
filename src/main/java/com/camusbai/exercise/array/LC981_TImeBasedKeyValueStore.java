package com.camusbai.exercise.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC981_TImeBasedKeyValueStore {
    Map<String, List<Object[]>> data;

    public static void main(String[] args) {
        LC981_TImeBasedKeyValueStore map = new LC981_TImeBasedKeyValueStore();
        map.set("foo", "bar", 1);
        map.set("foo", "bar2", 4);
    }

    public LC981_TImeBasedKeyValueStore() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Object[] valueAndTime = new Object[2];
        valueAndTime[0] = value;
        valueAndTime[1] = timestamp;
        List<Object[]> values;
        if (data.containsKey(key)) {
            values = data.get(key);
        } else {
            values = new ArrayList<>();
            data.put(key, values);
        }
        values.add(valueAndTime);
    }

    public String get(String key, int timestamp) {
        List<Object[]> values = data.get(key);
        if (values == null) {
            return "";
        }
        Integer firstEntryTs = (Integer) values.get(0)[1];
        if (firstEntryTs > timestamp) {
            return "";
        }

        int left = 0, right = values.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int midTs = (Integer) values.get(mid)[1];
            if (midTs < timestamp) {
                left = mid + 1;
            } else if (midTs > timestamp) {
                right = mid - 1;
            } else {
                return (String) values.get(mid)[0];
            }
        }
        Integer resultEntryTs = (Integer) values.get(left)[1];
        if (resultEntryTs <= timestamp) {
            return (String) values.get(left)[0];
        } else {
            return (String) values.get(left - 1)[0];
        }
    }
}